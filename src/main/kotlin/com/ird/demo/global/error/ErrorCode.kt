package com.ird.demo.global.error

enum class ErrorCode(
    val code: Int,
    val msg: String
) {
    UNAUTHORIZED(401, "인증되지 않았습니다"),
    EXPIRED_TOKEN(401, "만료된 토큰입니다"),

    INTERNAL_SERVER_ERROR(500, "알지못하는 에러입니다"),
}