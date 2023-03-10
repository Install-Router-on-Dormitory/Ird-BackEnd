package com.ird.demo.domain.auth.service

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.ird.demo.domain.auth.presentation.data.dto.LoginDto
import com.ird.demo.domain.auth.presentation.data.reponse.GAuthUserResponseDto
import com.ird.demo.domain.auth.presentation.data.reponse.LoginResponseDto
import com.ird.demo.domain.auth.presentation.data.reponse.TokenResponseDto
import com.ird.demo.domain.auth.util.AuthConverter
import com.ird.demo.domain.user.domain.entity.User
import com.ird.demo.domain.user.domain.repository.UserRepository
import com.ird.demo.global.security.jwt.JwtTokenProvider
import com.ird.demo.global.security.util.ConfigUtil
import org.springframework.http.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.client.RestTemplate
import java.time.ZonedDateTime
import java.util.*
import javax.validation.constraints.Null

@Service
class LoginService(
    private val configUtil: ConfigUtil,
    private val userRepository: UserRepository,
    private val jwtTokenProvider: JwtTokenProvider,
    private val authConverter: AuthConverter
) {

    @Transactional
    fun execute(loginDto: LoginDto): TokenResponseDto? {
        val restTemplate = RestTemplate()
        val headers = HttpHeaders()
        try {
            headers.contentType = MediaType.APPLICATION_JSON
            val httpEntity: HttpEntity<LoginDto> = authConverter.toHttpEntity(loginDto, headers)
            val apiResponse: ResponseEntity<String> =
                restTemplate.postForEntity(configUtil.gAuthInitUrl(), httpEntity, String::class.java)

            val objectMapper = ObjectMapper()
            objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE)
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
            val loginResponseDto: LoginResponseDto =
                objectMapper.readValue(apiResponse.body, object : TypeReference<LoginResponseDto>() {})
            val newHttpEntity: HttpEntity<Null> = authConverter.toHttpEntity(headers)

            headers.setBearerAuth(loginResponseDto.accessToken)

            val loginResponse: ResponseEntity<String?> = restTemplate.exchange(
                "https://open.gauth.co.kr/user",
                HttpMethod.GET,
                newHttpEntity,
                String::class.java
            )

            if (loginResponse.body == null) {
                return null
            }

            val gAuthUserResponseDto: GAuthUserResponseDto =
                objectMapper.readValue(loginResponse.body, object : TypeReference<GAuthUserResponseDto>() {})


            //????????? ?????? ?????? ??????????????? ????????? JWT ????????? ??????.
            val access: String = jwtTokenProvider.generateAccessToken(gAuthUserResponseDto.email)
            val refresh: String = jwtTokenProvider.generateRefreshToken(gAuthUserResponseDto.email)
            val accessExp: ZonedDateTime = jwtTokenProvider.accessExpiredTime

            val userInfo: Optional<User> = userRepository.findUserByEmail(gAuthUserResponseDto.email)

            if (userInfo.isPresent) {
                val updateUser: User = userInfo.orElseThrow { throw RuntimeException() }
                updateUser.updateRefresh(refresh)
            } else {
                val user: User = authConverter.toEntity(gAuthUserResponseDto, refresh)
                userRepository.save(user)
            }
            return authConverter.toDto(access, refresh, accessExp)

        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }

    }

}

