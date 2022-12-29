package com.ird.demo.domain.user.service

import com.ird.demo.domain.user.domain.entity.Student
import com.ird.demo.domain.user.domain.entity.User
import com.ird.demo.domain.user.domain.repository.StudentRepository
import com.ird.demo.domain.user.domain.repository.UserRepository
import com.ird.demo.domain.user.presentation.data.dto.AddStudentDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AddStudentService(
    private val userRepository: UserRepository,
    private val studentRepository: StudentRepository
) {

    @Transactional
    fun execute(addStudentDto: AddStudentDto) {
        val userInfo: User = userRepository.findByEmail(addStudentDto.email) ?: throw RuntimeException()
        val student: Student = Student(
            user = userInfo
        )
        studentRepository.save(student)
    }

}