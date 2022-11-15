package com.greatlearning.employeemanagementservice.configuration;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.employeemanagementservice.service.DomainUserDetailsService;

@EnableWebSecurity
@SuppressWarnings("deprecation")
@Configuration
public class SecurityConiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private DomainUserDetailsService userDetailsService;


	@Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        //configure users
        authenticationManagerBuilder
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(bcryptPasswordEncoder());
    }

   
    @Primary
    @Bean
    public PasswordEncoder bcryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception{
		
		httpSecurity.cors().disable();
		httpSecurity.csrf().disable();
		httpSecurity
		.authorizeRequests()
		.antMatchers("/security/save/**")
		.permitAll()
		.and()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET,"/api/employee/**")
			.hasAnyRole("USER","ADMIN")
			.and()
			.authorizeRequests()
			.antMatchers(HttpMethod.POST,"/api/employee/**")
			.hasRole("ADMIN")			
			.antMatchers(HttpMethod.PUT,"/api/employee/**")
			.hasRole("ADMIN")		
			.antMatchers(HttpMethod.DELETE,"/api/employee/**")
			.hasRole("ADMIN")
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.and()
			.httpBasic();
			
	}

}
