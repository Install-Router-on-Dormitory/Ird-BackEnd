package com.ird.demo.global.error

import com.ird.demo.global.error.ErrorCode

class ErrorResponse(errorCode: ErrorCode) {
    val msg: String
    val code: Int

    init {
        msg = errorCode.msg
        code = errorCode.code
    }
}