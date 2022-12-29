package com.ird.demo.domain.user.util

import com.example.helloworld.global.security.auth.AuthDetails
import com.ird.demo.domain.user.domain.entity.User
import com.ird.demo.domain.user.domain.repository.UserRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

@Component
class UserUtil(
    private val userRepository: UserRepository
) {
    fun fetchCurrentUser(): User {
        val principal = SecurityContextHolder.getContext().authentication.principal
        val email = if (principal is UserDetails) {
            (principal as AuthDetails).username
        } else {
            principal.toString()
        }
        return fetchUserByEmail(email)
    }

    private fun fetchUserByEmail(email: String): User =
        userRepository.findByEmail(email) ?: throw RuntimeException()
}