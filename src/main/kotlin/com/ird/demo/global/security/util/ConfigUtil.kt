package com.ird.demo.global.security.util

import com.ird.demo.global.security.gAuth.GAuthProperties
import org.springframework.stereotype.Component


@Component
class ConfigUtil(
    private val gAuthProperties: GAuthProperties
) {

    fun gAuthInitUrl(): String {
        return getGAuthUrl() + "/oauth" + "/token"
    }

    fun getGAuthUrl(): String =
        "https://server.gauth.co.kr"

    fun getGAuthSecret() =
        gAuthProperties.clientSecret

    fun getGAuthClientId() =
        gAuthProperties.clientId

}

