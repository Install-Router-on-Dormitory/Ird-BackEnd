package com.ird.demo.domain.user.util

import com.ird.demo.domain.user.presentation.data.dto.DeleteStudentDto
import org.springframework.stereotype.Component

@Component
class StudentConverter {
    fun toDto(studentId: Long): DeleteStudentDto =
        DeleteStudentDto(studentId = studentId)
}