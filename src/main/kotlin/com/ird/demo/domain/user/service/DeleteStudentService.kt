package com.ird.demo.domain.user.service

import com.ird.demo.domain.user.domain.repository.StudentRepository
import com.ird.demo.domain.user.presentation.data.dto.DeleteStudentDto
import org.springframework.stereotype.Service

@Service
class DeleteStudentService(
    private val studentRepository: StudentRepository
) {

    fun execute(deleteStudentDto: DeleteStudentDto) {
        studentRepository.deleteById(deleteStudentDto.studentId)
    }

}