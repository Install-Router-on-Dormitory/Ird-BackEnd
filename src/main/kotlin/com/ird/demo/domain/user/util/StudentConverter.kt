package com.ird.demo.domain.user.util

import com.ird.demo.domain.user.presentation.data.dto.AddStudentDto
import com.ird.demo.domain.user.presentation.data.dto.DeleteStudentDto
import com.ird.demo.domain.user.presentation.data.request.AddStudentRequestDto
import org.springframework.stereotype.Component

@Component
class StudentConverter {

    fun toDto(studentId: Long): DeleteStudentDto =
        DeleteStudentDto(studentId = studentId)

    fun toDto(addStudentRequestDto: AddStudentRequestDto, authorization: String): AddStudentDto =
        AddStudentDto(addStudentRequestDto.email, authorization)

}