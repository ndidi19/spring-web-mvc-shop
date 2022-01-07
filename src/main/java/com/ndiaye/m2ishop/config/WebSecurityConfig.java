package com.ndiaye.m2ishop.config;

import com.ndiaye.m2ishop.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/img/**", "/vendor/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                //.antMatchers("/products/**").permitAll()
                .antMatchers("/products/**").hasAuthority("ROLE_ADMIN").anyRequest()
                .authenticated().and()
                .formLogin().loginPage("/login").failureUrl("/login?error")
                    .usernameParameter("email").passwordParameter("password")
                .and().logout().invalidateHttpSession(true).clearAuthentication(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login?logout")
                    .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(mongoUserDetailsService());
        auth.setPasswordEncoder(passwordEncoder);
        return auth;
    }

    @Bean
    public UserDetailsService mongoUserDetailsService() {
        return new UserDetailsServiceImpl();
    }
}
