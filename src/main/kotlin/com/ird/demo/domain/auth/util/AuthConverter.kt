package com.ird.demo.domain.auth.util

import com.ird.demo.domain.auth.presentation.data.dto.LoginDto
import com.ird.demo.domain.auth.presentation.data.reponse.GAuthUserResponseDto
import com.ird.demo.domain.auth.presentation.data.reponse.TokenResponseDto
import com.ird.demo.domain.user.domain.entity.User
import com.ird.demo.global.security.util.ConfigUtil
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component
import java.time.ZonedDateTime
import javax.validation.constraints.Null

@Component
class AuthConverter(
    private val configUtil: ConfigUtil
) {

    fun toDto(code: String): LoginDto =
        LoginDto(
            code = code,
            clientId = configUtil.getGAuthClientId(),
            clientSecret = configUtil.getGAuthSecret()
        )

    fun toDto(accessToken: String, refreshToken: String, expiredTime: ZonedDateTime): TokenResponseDto =
        TokenResponseDto(
            accessToken = accessToken,
            refreshToken = refreshToken,
            expiredTime = expiredTime
        )

    fun toHttpEntity(loginDto: LoginDto, headers: HttpHeaders): HttpEntity<LoginDto> =
        HttpEntity(loginDto, headers)

    fun toHttpEntity(headers: HttpHeaders): HttpEntity<Null> =
        HttpEntity(null, headers)

    fun toEntity(gAuthUserResponseDto: GAuthUserResponseDto): User =
        User(
            email = gAuthUserResponseDto.email,
            name = gAuthUserResponseDto.name,
            grade = gAuthUserResponseDto.grade,
            profileUri = gAuthUserResponseDto.profileUrl,
            classNum = gAuthUserResponseDto.classNum,
            num = gAuthUserResponseDto.num,
            refresh = "",
        )

    fun toEntity(userInfo: User, refresh: String): User =
        User(
            email = userInfo.email,
            name = userInfo.name,
            grade = userInfo.grade,
            profileUri = userInfo.profileUri,
            classNum = userInfo.classNum,
            num = userInfo.num,
            refresh = refresh,
        )
}