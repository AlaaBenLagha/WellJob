package com.pidev.config;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.pidev.security.JwtAuthenticationFilter;


@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
    	httpSecurity.cors().and()
        .csrf().disable()
        .authorizeHttpRequests(authorize -> authorize
                .antMatchers("/api/auth/**")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/posts/by-id/**")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/subreddit")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/subreddit/**")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/api/subreddit")
                .permitAll()         
                .antMatchers(HttpMethod.GET, "/api/posts/by-subreddit/**")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/posts/by-user/**")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/api/posts/search/*******")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/posts/")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/api/posts/")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/api/votes/")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/comments/by-post/**")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/comments/by-user/**")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/api/comments/")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/api/category/add-category/")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/category/getAllCategory")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/category/**")
                .permitAll()
                .antMatchers(HttpMethod.PUT, "/api/category/updateCategory")
                .permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/category/**")
                .permitAll()    
                .antMatchers(HttpMethod.POST, "/api/quiz/add")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/quiz/getAllQuiz")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/quiz/**")
                .permitAll()
                .antMatchers(HttpMethod.PUT, "/api/quiz/updateQuiz")
                .permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/quiz/**")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/quiz/active/*")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/quiz/active/")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/quiz/Bycategory/**")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/api/question/evaluate-quiz")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/api/question/add-questions")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/question/ById/**")
                .permitAll()
                .antMatchers(HttpMethod.PUT, "/api/question/update-questions")
                .permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/question/**")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/question/**")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/question/admin/**")
                .permitAll()
                
                .antMatchers("/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**")
                .permitAll()
                .anyRequest()
                .authenticated());
        
        
                
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    
}