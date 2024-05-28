package com.example.crud.config;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    @Value("${jwt.secret.key}")
    private String secretKey;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    // Calculate and return token validity in milliseconds
    public long getValidityInMs() {
        ZonedDateTime nowAsiaSingapore = ZonedDateTime.now(ZoneId.of("Asia/Singapore"));
        ZonedDateTime expiryDateTime = nowAsiaSingapore.with(LocalTime.of(23, 59));

        // Log current time and expiry time
        log.info("Current time in Asia/Singapore: {}", nowAsiaSingapore);
        log.info("Token expiry time in Asia/Singapore: {}", expiryDateTime);

        return expiryDateTime.toInstant().toEpochMilli();
    }
}
