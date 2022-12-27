package com.ird.demo.domain.user.domain.entity

import javax.persistence.*

@Entity
@Table
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    val email: String,

    val name: String,

    val profileUri: String?,

    val grade: Int,

    val classNum: Int,

    val number: Int,

    val refresh: String
) {
    fun updateRefresh(refresh: String): User {
        return User(
            id = id,
            email = email,
            name = name,
            profileUri = profileUri,
            grade = grade,
            classNum = classNum,
            number = number,
            refresh = refresh
        )
    }
}