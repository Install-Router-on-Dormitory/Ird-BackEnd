package com.ird.demo.domain.user.service

import com.ird.demo.domain.user.domain.entity.User
import com.ird.demo.domain.user.domain.repository.StudentRepository
import com.ird.demo.domain.user.util.UserUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CheckUserService(
    private val studentRepository: StudentRepository,
    private val userUtil: UserUtil
) {

    @Transactional
    fun execute(): Boolean {
        val userInfo: User = userUtil.fetchCurrentUser()
        return studentRepository.existsByUserId(userInfo.id)
    }

}