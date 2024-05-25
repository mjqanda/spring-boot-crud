package com.example.crud.config;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    private String secretKey = "!@#$%^&*com.example.crud!@#$%^&*";

    public JwtProperties(String secretKey) {
        this.secretKey = secretKey;
    }

    public JwtProperties() {
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public long getValidityInMs() {
        ZonedDateTime nowAsiaSingapore = ZonedDateTime.now(ZoneId.of("Asia/Singapore"));
        ZonedDateTime expiryDateTime = nowAsiaSingapore.with(LocalTime.MAX);

        // Log current time and expiry time
        log.info("Current time in Asia/Singapore: {}", nowAsiaSingapore);
        log.info("Token expiry time in Asia/Singapore: {}", expiryDateTime);

        // Calculate duration until expiry in milliseconds
        Duration validityDuration = Duration.between(nowAsiaSingapore, expiryDateTime);

        return validityDuration.toMillis();
    }

}