package com.ird.demo.domain.user.service

import com.ird.demo.domain.user.domain.repository.StudentRepository
import com.ird.demo.domain.user.domain.repository.UserRepository
import com.ird.demo.domain.user.presentation.data.dto.DeleteStudentDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeleteStudentService(
    private val studentRepository: StudentRepository,
    private val userRepository: UserRepository
) {

    @Transactional
    fun execute(deleteStudentDto: DeleteStudentDto) {
        val userInfo = userRepository.findById(deleteStudentDto.studentId).orElseThrow { throw RuntimeException() }
        studentRepository.deleteStudentByUser(userInfo)
    }

}