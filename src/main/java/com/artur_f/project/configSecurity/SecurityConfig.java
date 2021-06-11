package com.artur_f.project.configSecurity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select name, password,enabled from employees " +
                                "where name=?")
                .authoritiesByUsernameQuery(
                        "select name, authority from employees " +
                                "where name=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/main","/").hasAnyRole("ADMIN","SALES", "MEASURER", "PRODUCTION")
                .antMatchers("/main/action_employee/**").hasAnyRole("ADMIN")
                .antMatchers("/main/action_customer/**").hasAnyRole("SALES", "ADMIN")
                .antMatchers("/main/action_order/**").hasAnyRole("SALES", "ADMIN")
                .antMatchers("/main/action_order/edit/**").hasAnyRole("MEASURER")
                .antMatchers("/main/action_customer/edit/**").hasAnyRole("MEASURER")
                .antMatchers("/main/production/**").hasAnyRole("PRODUCTION")
                .and()
                .formLogin()
                .usernameParameter("name")
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/main", true)
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and()
                .httpBasic()
                .and().csrf().disable();
//
    }
}
