package com.example.project.config;


import com.example.project.auth.oauth.MyAccessDeniedHandler;
import com.example.project.auth.oauth.MyAuthenticationEntryPoint;
import com.example.project.auth.oauth.PrincipalOauth2UserService;
import com.example.project.domain.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PrincipalOauth2UserService principalOauth2UserService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/html/info").authenticated()

                .antMatchers("/admin/**").hasAuthority(UserRole.ADMIN.name())
                .anyRequest().permitAll()
                .and()

                //form Login 방식
                .formLogin()
                .usernameParameter("loginId")
                .passwordParameter("password")
                .loginPage("/html/login")
                .defaultSuccessUrl("/")
                .failureUrl("/html/login")
                .and()
                .logout()
                .logoutUrl("/html/logout")
                .invalidateHttpSession(true).deleteCookies("JSESSIONID")
                // OAuth 로그인
                .and()
                .oauth2Login()
                .loginPage("/html/login")
                .defaultSuccessUrl("/")
                .userInfoEndpoint()
                .userService(principalOauth2UserService)
        ;
        http
                .exceptionHandling()
                .authenticationEntryPoint(new MyAuthenticationEntryPoint())
                .accessDeniedHandler(new MyAccessDeniedHandler());
    }
}


