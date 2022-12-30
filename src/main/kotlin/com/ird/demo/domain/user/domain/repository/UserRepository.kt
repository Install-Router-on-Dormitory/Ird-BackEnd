package com.ird.demo.domain.user.domain.repository

import com.ird.demo.domain.user.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
    fun findUserByEmail(email: String): Optional<User>
    fun existsByEmail(email: String): Boolean
}