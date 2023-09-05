package com.example.project.config;


import com.example.project.domain.UserRole;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/html/info").authenticated()

                .antMatchers("/admin/**").hasAuthority(UserRole.ADMIN.name())
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .usernameParameter("loginId")
                .passwordParameter("password")
                .loginPage("/html/login")
                .defaultSuccessUrl("/")
                .failureUrl("/html/login")
                .and()
                .logout()
                .logoutUrl("/html/logout")
                .invalidateHttpSession(true).deleteCookies("JSESSIONID");
    }
}