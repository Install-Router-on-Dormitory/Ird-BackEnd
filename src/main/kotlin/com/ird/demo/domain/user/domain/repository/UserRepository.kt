package com.ird.demo.domain.user.domain.repository

import com.ird.demo.domain.user.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
    fun existsUserByEmail(email: String): Boolean
}