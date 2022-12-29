package com.ird.demo.domain.user.presentation.data.response

data class UserInfoResponseDto(
    val id: Long,
    val email: String,
    val name: String,
    val profileUri: String?,
    val grade: Long,
    val classNum: Long,
    val num: Long,
)