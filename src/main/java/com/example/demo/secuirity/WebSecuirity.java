package com.example.demo.secuirity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.services.UserService;



@EnableWebSecurity
public class WebSecuirity extends WebSecurityConfigurerAdapter {
	
	private final UserService userDetailService;
	private final BCryptPasswordEncoder bCryptPasswordEncode;
	
	public WebSecuirity(UserService userDetailService, BCryptPasswordEncoder bCryptPasswordEncode) {
		super();
		this.userDetailService = userDetailService;
		this.bCryptPasswordEncode = bCryptPasswordEncode;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		

		http
		    .cors().and()
		    .csrf().disable()
		    .authorizeRequests()
		    .antMatchers(HttpMethod.POST, SecurityConstants.SING_UP_URL)
		    .permitAll()
			.anyRequest().authenticated() 
		    .and()
		    .addFilter(getAuthenticationFilter())
		    .addFilter(new AuthorizationFilter(authenticationManager()))
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			
			
	}
	
	protected AuthenticationFilter getAuthenticationFilter() throws Exception{
		
		final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
		filter.setFilterProcessesUrl("/users/login");
		return filter;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncode);
		
	}
    
	
	

}