package com.example.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;

@Configuration
public class WebSecurityConfig {

        @Bean
        SecurityFilterChain springWebFilterChain(HttpSecurity http, JwtTokenProvider tokenProvider) throws Exception {
                return http.cors(withDefaults()).httpBasic(AbstractHttpConfigurer::disable)
                                .csrf(AbstractHttpConfigurer::disable)
                                .sessionManagement(c -> c.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .exceptionHandling(c -> c.authenticationEntryPoint(
                                                new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                                .authorizeHttpRequests(authConfig -> authConfig
                                                .requestMatchers("/signin").permitAll()
                                                // .requestMatchers("/employee").permitAll()
                                                // .requestMatchers("/employee/employees").permitAll()
                                                .anyRequest().authenticated())
                                .addFilterBefore(new JwtTokenAuthenticationFilter(tokenProvider),
                                                UsernamePasswordAuthenticationFilter.class)
                                .build();
        }

        @Bean
        CorsConfigurationSource corsConfigurationSource() {
                CorsConfiguration configuration = new CorsConfiguration();
                configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
                configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                configuration.setAllowedHeaders(
                                Arrays.asList("Accept", "Content-Type", "Authorization", "Token", "X-Apigw-Api-Id",
                                                "Host", "Content-Length"));
                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                source.registerCorsConfiguration("/**", configuration);
                return source;
        }
}