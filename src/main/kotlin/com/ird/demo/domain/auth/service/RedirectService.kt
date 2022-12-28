package com.ird.demo.domain.auth.service

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.net.URI
import java.net.URISyntaxException

@Service
class RedirectService {

    fun execute(): ResponseEntity<Void> {
        val baseUri: String = "https://gauth.co.kr/"
        val redirectUri: URI
        try {
            redirectUri = URI(baseUri+"login")
            val headers: HttpHeaders = HttpHeaders()
            headers.location = redirectUri
            return ResponseEntity(headers, HttpStatus.SEE_OTHER)
        } catch (e: URISyntaxException) {
            e.printStackTrace()
        }
        return ResponseEntity.badRequest().build();
    }

}