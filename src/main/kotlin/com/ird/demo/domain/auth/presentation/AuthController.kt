package com.ird.demo.domain.auth.presentation

import com.ird.demo.domain.auth.presentation.data.reponse.TokenResponseDto
import com.ird.demo.domain.auth.service.RedirectService
import com.ird.demo.domain.auth.service.LoginService
import com.ird.demo.domain.auth.util.AuthConverter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val loginService: RedirectService,
    private val redirectService: LoginService,
    private val authConverter: AuthConverter
) {

    @GetMapping("/login")
    fun login(): ResponseEntity<Void> {
        loginService.execute()
        return ResponseEntity.ok().build()
    }

    @GetMapping("/redirect")
    fun redirectUrl(@RequestParam(value = "code") code: String): ResponseEntity<TokenResponseDto?> {
        authConverter.toDto(code)
            .let { redirectService.execute(it) }
            .let { return ResponseEntity.ok(it) }
    }

}