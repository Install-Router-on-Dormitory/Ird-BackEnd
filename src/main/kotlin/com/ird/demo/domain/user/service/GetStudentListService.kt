package com.ird.demo.domain.user.service

import com.ird.demo.domain.user.domain.repository.StudentRepository
import com.ird.demo.domain.user.presentation.data.response.StudentResponseDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GetStudentListService(
    private val studentRepository: StudentRepository
) {

    @Transactional
    fun execute(): List<StudentResponseDto> =
        studentRepository.findAll()
            .map { StudentResponseDto(it) }


}