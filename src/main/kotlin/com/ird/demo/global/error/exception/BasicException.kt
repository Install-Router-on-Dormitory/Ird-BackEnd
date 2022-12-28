package com.ird.demo.global.error.exception

import com.ird.demo.global.error.ErrorCode

open class BasicException(val errorCode: ErrorCode) : RuntimeException() {
}