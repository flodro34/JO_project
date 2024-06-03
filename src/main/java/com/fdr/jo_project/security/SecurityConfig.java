package com.fdr.jo_project.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //@Autowired
    //AuthenticationManager authMgr;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception
    {
        http.sessionManagement( session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .csrf( csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest
                                                                          request) {
                        CorsConfiguration cors = new CorsConfiguration();

                        cors.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                        cors.setAllowedMethods(Collections.singletonList("*"));
                        cors.setAllowedHeaders(Collections.singletonList("*"));
                        cors.setExposedHeaders(Collections.singletonList("Authorization"));
                        return cors;
                    }
                }))

                .authorizeHttpRequests( requests -> requests
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/all").permitAll()
                        .anyRequest().permitAll());

//                .addFilterBefore(new JWTAuthenticationFilter(authMgr),
//                        UsernamePasswordAuthenticationFilter.class)
//
//                .addFilterBefore(new JWTAuthorizationFilter(),
//                        UsernamePasswordAuthenticationFilter.class);



        return http.build();
    }

//                .authorizeHttpRequests( requests -> requests
//                        .requestMatchers("**").permitAll()
//                       .requestMatchers("/api/").hasAnyAuthority("ADMIN","USER")
//                        .requestMatchers(HttpMethod.GET,"/api/tickets/**").permitAll()
//                        .requestMatchers(HttpMethod.GET,"/api/offers/**").permitAll()
//                        .requestMatchers(HttpMethod.POST,"/api/tickets").permitAll()
//                        .requestMatchers(HttpMethod.PUT,"/api/offers/**").hasAuthority("ADMIN")
//                        .requestMatchers(HttpMethod.DELETE,"/api/offers/**").hasAuthority("ADMIN")
//                        .anyRequest().authenticated() )
//
//
//                .addFilterBefore(new JWTAuthenticationFilter(authMgr),
//                        UsernamePasswordAuthenticationFilter.class)
//
//                .addFilterBefore(new JWTAuthorizationFilter(),
//                        UsernamePasswordAuthenticationFilter.class);
//        return http.build();

    }

//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
//        configuration.setAllowedMethods(Collections.singletonList("*"));
//        configuration.setAllowCredentials(true);
//        configuration.setAllowedHeaders(Collections.singletonList("*"));
//        configuration.setExposedHeaders(Collections.singletonList("Authorization"));
//        configuration.setMaxAge(3600L);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//}
