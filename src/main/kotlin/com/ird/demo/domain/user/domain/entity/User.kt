package com.ird.demo.domain.user.domain.entity

import com.fasterxml.jackson.annotation.JsonIgnore
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

    val grade: Long,

    val classNum: Long,

    val num: Long,

    val refresh: String,

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    val student: Student? = null

) {
    fun updateRefresh(refresh: String): User {
        return User(
            id = id,
            email = email,
            name = name,
            profileUri = profileUri,
            grade = grade,
            classNum = classNum,
            num = num,
            refresh = refresh,
            student = student
        )
    }
}