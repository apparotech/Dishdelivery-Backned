package com.socialmore.dishdelivery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.socialmore.dishdelivery.security.JwtAuthenticationEntryPoint;
import com.socialmore.dishdelivery.security.JwtAuthenticationFilter;

import lombok.AllArgsConstructor;



@Configuration
@EnableWebSecurity
@EnableWebMvc
@AllArgsConstructor
public class SecurityConfiguration {
 
    /* 
     private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET).permitAll()
                .requestMatchers(AppConstants.PUBLIC_URLS).permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    */

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf()
        .disable()
        .authorizeHttpRequests()
        
        // Public URLs accessible without authentication
        .requestMatchers(HttpMethod.GET).permitAll()
        .requestMatchers(AppConstants.PUBLIC_URLS).permitAll()
        
        // Role-based access for different users
        .requestMatchers("/admin/**").hasRole("ADMIN")
        .requestMatchers("/customer/**").hasRole("CUSTOMER")
        .requestMatchers("/delivery/**").hasRole("DELIVERY_PERSON")
        
        // Any other request needs to be authenticated
        .anyRequest()
        .authenticated()
        
        // Exception handling
        .and()
        .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
        
        // Make session stateless
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        
        // Add JWT filter before UsernamePasswordAuthenticationFilter
        .and()
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
}
    
}
