package io.project.studentdomainservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.Collection;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {


   @Bean
    InMemoryUserDetailsManager users(){
       UserDetails user1= User.withUsername("user1")
               .password("{noop}password1")
               .roles("ADMIN").build();
       UserDetails user2= User.withUsername("user2")
               .password("{noop}password2")
               .roles()
                .build();

       Collection<UserDetails> usersList = new ArrayList<>();;
       usersList.add(user1);
       usersList.add(user2);
       return new InMemoryUserDetailsManager(usersList);
    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

            return http.authorizeRequests(auth -> auth.anyRequest().authenticated())


                    .formLogin(withDefaults())
                    .build();


    }
}
