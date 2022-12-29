package com.ird.demo.domain.user.domain.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Table
@Entity
class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User?
)