package io.project.studentdomainservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {


    @Bean
    InMemoryUserDetailsManager users(){
        return new InMemoryUserDetailsManager(
                User.withUsername("user1")
                        .password("{noop}password1")
                        .roles("ADMIN")
                        .build()
        );
    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

            return http.authorizeRequests(auth -> auth.anyRequest().authenticated())


                    .formLogin(withDefaults())
                    .build();


    }
}
