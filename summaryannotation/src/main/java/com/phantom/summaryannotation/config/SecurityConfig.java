package com.phantom.summaryannotation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/home").permitAll()
			.antMatchers("/order/**").access("hasRole('USER')")
			.antMatchers("/user/change-password").access("hasAnyRole('INACTIVE_USER', 'USER')")
			.antMatchers("/user/**").access("hasAnyRole('USER')")
			.antMatchers("/admin/**").access("hasRole('ADMIN')");
		
		http.formLogin().loginPage("/login").failureUrl("/login?error")
				.usernameParameter("email").passwordParameter("password");
		http.logout().logoutSuccessUrl("/login?logout").deleteCookies("JSESSIONID");
		http.csrf();
		http.exceptionHandling().accessDeniedPage("/403");
		http.sessionManagement().maximumSessions(2)
			.and().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
			.sessionFixation().migrateSession();
	}
}
