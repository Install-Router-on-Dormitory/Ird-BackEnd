package com.ird.demo.domain.user.util

import com.ird.demo.domain.user.domain.entity.User
import com.ird.demo.domain.user.presentation.data.response.UserInfoResponseDto
import org.springframework.stereotype.Component

@Component
class UserConverter {

    fun toResponseDto(user: User): UserInfoResponseDto =
        UserInfoResponseDto(
            id = user.id,
            email = user.email,
            profileUri = user.profileUri,
            name = user.name,
            grade = user.grade,
            classNum = user.classNum,
            num = user.num
        )

}