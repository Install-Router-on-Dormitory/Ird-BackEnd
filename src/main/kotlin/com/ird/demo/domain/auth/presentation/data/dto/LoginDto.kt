package com.ird.demo.domain.auth.presentation.data.dto

data class LoginDto (
    val code: String,
    val clientId: String,
    val clientSecret: String
)