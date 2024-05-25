package com.example.crud.config;

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

    // private String secretKey = "rzxlszyykpbgqcflzxsqcysyhljt";
    private String secretKey = "!@#$%^&*com.example.crud!@#$%^&*";

    // validity in milliseconds
    // 10 years
    // private long validityInMs = 315569260000L;

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

        Instant nowUtc = Instant.now();
        ZoneId asiaSingapore = ZoneId.of("Asia/Singapore");
        ZonedDateTime nowAsiaSingapore = ZonedDateTime.ofInstant(nowUtc, asiaSingapore);
        ZonedDateTime expiryDateTime = nowAsiaSingapore.with(LocalTime.of(23, 59));
        log.info("getValidityInMs - nowAsiaSingapore -> "+nowAsiaSingapore);
        log.info("getValidityInMs - expiryDateTime -> "+expiryDateTime);
        long validityInMs = expiryDateTime.toInstant().toEpochMilli();
        // System.out.println("test time in millis:: " + validityInMs);
        return validityInMs;
    }

}
