package com.ird.demo.domain.auth.presentation.data.reponse

data class LoginResponseDto(
    val accessToken: String = "",
    val refreshToken: String = ""
)