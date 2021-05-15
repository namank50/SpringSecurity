package com.example.security.demoSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.security.demoSecurity.service.UserDetailsServiceCust;

@EnableWebSecurity
public class SecurityManager extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsServiceCust user;
	
	@Override
	  protected void configure(HttpSecurity http) throws Exception {
			/*
			 * http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN").
			 * antMatchers("/user").hasAnyRole("USER","ADMIN").antMatchers("/").permitAll().
			 * and().formLogin();
			 */
		http.csrf().disable().authorizeRequests().antMatchers("/auth").permitAll().anyRequest().authenticated();
		
	}
	 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(user);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
