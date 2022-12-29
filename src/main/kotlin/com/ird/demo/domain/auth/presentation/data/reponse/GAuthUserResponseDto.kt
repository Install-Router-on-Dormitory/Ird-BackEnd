package com.ird.demo.domain.auth.presentation.data.reponse

data class GAuthUserResponseDto(
    val id: Long = 0,
    val email: String = "",
    val name: String = "",
    val profileUrl: String? = "",
    val grade: Long = 0,
    val classNum: Long = 0,
    val num: Long = 0,
    val gender: String = "",
    val role: String = ""
)