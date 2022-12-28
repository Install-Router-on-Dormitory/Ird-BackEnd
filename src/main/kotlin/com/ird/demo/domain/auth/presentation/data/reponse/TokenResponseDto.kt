package com.ird.demo.domain.auth.presentation.data.reponse

import java.time.ZonedDateTime

data class TokenResponseDto(
    val accessToken: String,
    val refreshToken: String,
    val expiredTime: ZonedDateTime
)
