package com.ird.demo.domain.user.presentation.data.response

import com.ird.demo.domain.user.domain.entity.User

data class StudentListResponseDto(
    val list: List<StudentResponseDto>
)
