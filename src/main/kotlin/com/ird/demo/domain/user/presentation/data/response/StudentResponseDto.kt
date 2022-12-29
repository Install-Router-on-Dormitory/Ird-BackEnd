package com.ird.demo.domain.user.presentation.data.response

import com.ird.demo.domain.user.domain.entity.Student

class StudentResponseDto(
    val id: Long,
    val email: String,
    val name: String,
    val profileUri: String?,
    val grade: Long,
    val classNum: Long,
    val num: Long,
) {
    constructor(student: Student) : this(
        id = student.user!!.id,
        email = student.user.email,
        name = student.user.name,
        profileUri = student.user.profileUri,
        grade = student.user.grade,
        classNum = student.user.classNum,
        num = student.user.num
    )
}