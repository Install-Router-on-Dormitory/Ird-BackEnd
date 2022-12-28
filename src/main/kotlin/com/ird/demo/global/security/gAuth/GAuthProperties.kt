package com.ird.demo.global.security.gAuth

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "gauth")
class GAuthProperties(
    clientId: String,
    clientSecret: String
) {
    val clientId: String
    val clientSecret: String

    init {
        this.clientId = clientId
        this.clientSecret = clientSecret
    }
}