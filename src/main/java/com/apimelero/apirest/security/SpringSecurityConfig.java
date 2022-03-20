package com.apimelero.apirest.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.*;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Encode Password and load Users from Databse to be implemented
        UserBuilder users = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(users.username("admin").password("123").roles("admin"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http
                .authorizeRequests()
                    .antMatchers(HttpMethod.DELETE,"/**").authenticated()
                    .antMatchers(HttpMethod.POST,"/**").authenticated()
                    .anyRequest().permitAll();

        //Allow Post and Deletes
        http.csrf().disable();

        //Login mehtod
        http.httpBasic();

    }
}
