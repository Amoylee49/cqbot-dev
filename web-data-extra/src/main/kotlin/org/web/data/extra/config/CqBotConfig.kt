package org.web.data.extra.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "cqbot")
class CqBotConfig {
    lateinit var filePath: String
}