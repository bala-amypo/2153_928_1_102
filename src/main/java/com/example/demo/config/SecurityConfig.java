package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity  // Enables Spring Security’s web security support
public class SecurityConfig {

    /**
     * Configure the SecurityFilterChain for HTTP security.
     * This replaces the older WebSecurityConfigurerAdapter approach.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // Disable CSRF since this is a REST API
            .csrf(csrf -> csrf.disable())

            // Stateless session management because JWT is used
            .sessionManagement(session ->
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            // Permit all requests (useful during development and for testing)
            .authorizeHttpRequests(auth ->
                    auth.anyRequest().permitAll()
            )

            // Allow H2 database console frames
            .headers(headers ->
                    headers.frameOptions(frame -> frame.disable())
            )

            // Disable default login form
            .formLogin(form -> form.disable())

            // Disable HTTP Basic authentication
            .httpBasic(basic -> basic.disable());

        return http.build();
    }

    /**
     * Bean for password encoding.
     * BCrypt is the recommended encoder for storing passwords securely.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Bean to provide AuthenticationManager.
     * Needed if you plan to authenticate users manually (e.g., in a login service).
     */
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
