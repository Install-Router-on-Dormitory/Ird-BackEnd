package com.ird.demo.global.security.exception

import com.ird.demo.global.error.ErrorCode
import com.ird.demo.global.error.exception.BasicException

class ExpiredTokenException : BasicException(ErrorCode.EXPIRED_TOKEN) {
}