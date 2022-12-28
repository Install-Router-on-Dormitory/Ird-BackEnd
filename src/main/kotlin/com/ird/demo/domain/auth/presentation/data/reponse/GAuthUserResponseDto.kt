package com.ird.demo.domain.auth.presentation.data.reponse

data class GAuthUserResponseDto(
    val email: String = "",
    val name: String = "",
    val profileUrl: String? = "",
    val grade: Int = 0,
    val classNum: Int = 0,
    val num: Int = 0,
    val gender: String = "",
    val role: String = ""
)