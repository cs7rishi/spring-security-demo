package com.example.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                (requests) -> requests.requestMatchers("/myAccount", "/myBalance", "/myLoans",
                    "/myCards").authenticated().requestMatchers("/notices", "/contact").permitAll())
            .formLogin(withDefaults()).httpBasic(withDefaults());
        return http.build();
    }

    //Configuration to deny all the request
    //Why application is asking for credential
    //Because for authentication passes(correct credentials), but authorization fails
    /*@Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests.anyRequest().denyAll())
            .formLogin(withDefaults()).httpBasic(withDefaults());
        return http.build();
    }*/

    //Configuration to authorize all the request
    /*@Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                (requests) -> requests.anyRequest().permitAll())
            .formLogin(withDefaults()).httpBasic(withDefaults());
        return http.build();
    }*/
}
