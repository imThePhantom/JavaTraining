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
		getHttp().authorizeRequests().antMatchers("/", "/home").permitAll()
			.antMatchers("/order/**")
				.access("hasAnyRole('USER', 'GUEST', 'ADMIN')")
			.antMatchers("/user/**")
				.access("hasAnyRole('USER', 'ADMIN')")
			.antMatchers("/user/update-info")
				.access("hasAnyRole('INACTIVE_USER', 'USER', 'ADMIN')")
			.antMatchers("/admin/**")
				.access("hasRole('ADMIN')")
			.and().formLogin().loginPage("/login").failureUrl("/login?error")
				.usernameParameter("email").passwordParameter("password")
			.and().logout().logoutSuccessUrl("/login?logout")
			.and().csrf()
			.and().exceptionHandling().accessDeniedPage("/403")
			.and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
				.maximumSessions(2);
	}
}
