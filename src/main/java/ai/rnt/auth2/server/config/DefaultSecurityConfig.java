package ai.rnt.auth2.server.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import ai.rnt.auth2.server.service.CustomAuthenticationProvider;

@EnableWebSecurity
public class DefaultSecurityConfig {

   @Autowired
   private CustomAuthenticationProvider customAuthenticationProvider;

    
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests ->
                 authorizeRequests.antMatchers("/api/**").permitAll()
                 .anyRequest().authenticated()
                )
				.formLogin(login -> login.loginPage("/login").permitAll());
        return http.build();
    }

    @Autowired
    public void bindAuthenticationProvider(AuthenticationManagerBuilder authenticationManagerBuilder) {
       authenticationManagerBuilder
                .authenticationProvider(customAuthenticationProvider);
    }
}
