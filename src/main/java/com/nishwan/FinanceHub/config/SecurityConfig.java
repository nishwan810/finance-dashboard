package com.nishwan.FinanceHub.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/users/**").hasRole("ADMIN")

                        .requestMatchers("/finance/**").hasAnyRole("ADMIN", "ANALYST")

                        .requestMatchers("/dashboard/**").hasAnyRole("ADMIN", "ANALYST", "VIEWER")

                        .anyRequest().authenticated()
                )
                .httpBasic(basic -> {});

        return http.build();
    }
}