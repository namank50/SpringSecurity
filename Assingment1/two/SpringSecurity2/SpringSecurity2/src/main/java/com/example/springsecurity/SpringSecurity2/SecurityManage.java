package com.example.springsecurity.SpringSecurity2;



import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityManage extends WebSecurityConfigurerAdapter{
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Naman").password("password").roles("USER");
		
	}

	@Bean
	public PasswordEncoder encodePasswrd() {
		return NoOpPasswordEncoder.getInstance();
	}

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests().antMatchers("/admin").hasRole("Admin")
	 * .antMatchers("/user").hasAnyRole("User","Admin").antMatchers("/").permitAll()
	 * .and() .formLogin(); }
	 */
	
	
}
