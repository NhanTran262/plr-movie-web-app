package com.app.plrmoviewebservice.configuration;

import com.app.plrmoviewebservice.security.AuthenticationFilter;
import com.app.plrmoviewebservice.security.SecurityEntryPoint;
import com.app.plrmoviewebservice.service.IUserPrincipalService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = {
        SecurityEntryPoint.class,
        IUserPrincipalService.class
})
@AllArgsConstructor
public class SecurityConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfiguration.class);
    private final IUserPrincipalService userPrincipalService;
    private final SecurityEntryPoint securityEntryPoint;
    private final AuthenticationFilter authenticationFilter;

    @Autowired
    public void configuration(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(userPrincipalService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class).build();
    }

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        LOGGER.info("SecurityFilterChain -> security filter chain invoked!");
        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        httpSecurity.authorizeHttpRequests(req -> req.requestMatchers("/api/**").permitAll());

        httpSecurity.exceptionHandling(exception -> exception.authenticationEntryPoint(securityEntryPoint));

        httpSecurity.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);

        httpSecurity.rememberMe(req -> req.tokenRepository(new InMemoryTokenRepositoryImpl()));

        return httpSecurity.build();
    }
}
