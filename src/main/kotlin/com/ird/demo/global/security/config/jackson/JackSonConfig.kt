package com.ird.demo.global.security.config.jackson

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JackSonConfig {

    @Bean
    fun objectMapper(): ObjectMapper =
        jacksonObjectMapper().apply {
            this.registerModule(JavaTimeModule())
        }
}
