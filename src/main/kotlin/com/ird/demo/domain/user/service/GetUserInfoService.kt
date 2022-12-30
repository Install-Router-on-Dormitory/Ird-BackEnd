package com.ird.demo.domain.user.service

import com.ird.demo.domain.user.presentation.data.response.UserInfoResponseDto
import com.ird.demo.domain.user.util.UserConverter
import com.ird.demo.domain.user.util.UserUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GetUserInfoService(
    private val userConverter: UserConverter,
    private val userUtil: UserUtil
) {

    @Transactional
    fun execute(): UserInfoResponseDto =
        userConverter.toResponseDto(userUtil.fetchCurrentUser())

}