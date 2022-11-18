package com.example.quiz;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username, user_password, enabled from user where username=?")
		.authoritiesByUsernameQuery("select username, authority from authority where username = ?")
		.passwordEncoder(getPasswordEncoder())
		;
	}


	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.authorizeRequests()
		.antMatchers("/user/**").authenticated()
		.antMatchers("/**/admin/**").hasRole("ADMIN")
		.anyRequest().permitAll()
		.and().formLogin().loginPage("/login").permitAll().usernameParameter("username").passwordParameter("password")
		.and().logout().permitAll()
		.and().httpBasic()
		;
		
		httpSecurity.csrf().disable();
	}

}









