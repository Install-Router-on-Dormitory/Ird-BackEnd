package com.ird.demo.domain.user.exception

import com.ird.demo.global.error.ErrorCode
import com.ird.demo.global.error.exception.BasicException

class StudentNotFoundException : BasicException(ErrorCode.STUDENT_NOT_FOUND) {
}