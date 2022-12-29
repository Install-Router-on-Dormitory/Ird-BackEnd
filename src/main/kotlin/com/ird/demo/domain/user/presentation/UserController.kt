package com.ird.demo.domain.user.presentation

import com.ird.demo.domain.user.presentation.data.response.UserInfoResponseDto
import com.ird.demo.domain.user.service.GetUserInfoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
    private val getUserInfoService: GetUserInfoService
) {

    @GetMapping
    fun getUserInfo(): ResponseEntity<UserInfoResponseDto> =
        ResponseEntity.ok(getUserInfoService.execute())

}