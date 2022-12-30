package com.ird.demo.domain.user.domain.repository

import com.ird.demo.domain.user.domain.entity.Student
import com.ird.demo.domain.user.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, Long> {
    override fun findAll(): List<Student>
    fun deleteStudentByUser(user: User)
    fun existsByUserId(userId: Long): Boolean
}