package com.ripley.ws.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ripley.ws.service.MyUserDetailsService;

/**
 * @author oquerevalu
 * Jan 16, 2018
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private AccessDeniedHandler accessDeniedHandler;
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	private static String REALM="MY_TEST_REALM";
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeRequests()
			.antMatchers("/api/adminvaltok/**").hasAnyRole("ADMIN") //Only admin user can login 
			.antMatchers("/api/auth**").hasAnyRole("USER") //Only normal user can login
			.anyRequest().authenticated() //Rest of all request need authentication			 
        .and()
        .httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint())
		.and()
        .logout().invalidateHttpSession(true).clearAuthentication(true).permitAll();
	}
	
	@Bean
	public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
		return new CustomBasicAuthenticationEntryPoint();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
		auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder);;
    }
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**","/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**");
    }
	
	
}
