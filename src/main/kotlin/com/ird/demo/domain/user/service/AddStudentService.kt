package com.ird.demo.domain.user.service

import com.ird.demo.domain.user.domain.entity.Student
import com.ird.demo.domain.user.domain.entity.User
import com.ird.demo.domain.user.domain.repository.StudentRepository
import com.ird.demo.domain.user.util.UserUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AddStudentService(
    private val userUtil: UserUtil,
    private val studentRepository: StudentRepository
) {

    @Transactional
    fun execute() {
        val userInfo: User = userUtil.fetchCurrentUser()
        val student: Student = Student(
            user = userInfo
        )
        studentRepository.save(student)
    }

}