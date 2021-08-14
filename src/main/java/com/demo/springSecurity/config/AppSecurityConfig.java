package com.demo.springSecurity.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailsService;

//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		// TODO Auto-generated method stub
//		List<UserDetails> users = new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder().username("sumit").roles("USER").password("sumit123").build());
//		users.add(User.withDefaultPasswordEncoder().username("abc").roles("USER").password("abc123").build());
//		return new InMemoryUserDetailsManager(users);
//	}
	
	@Bean
	public AuthenticationProvider authProvide() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		//provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
		
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/springsecurity/demo/welcome").hasAnyAuthority("USER", "DEVELOPER", "SALESMAN","INVESTOR", "ADMIN")
            .antMatchers("/springsecurity/demo/welcome/msg").hasAnyAuthority("ADMIN", "DEVELOPER")
            .antMatchers("/springsecurity/demo/welcome/seller").hasAnyAuthority("ADMIN", "SALESMAN")
            .antMatchers("/springsecurity/demo/welcome/investor").hasAnyAuthority("ADMIN","INVESTOR")
            .antMatchers("/springsecurity/demo/welcome/user").hasAnyAuthority("ADMIN","USER")
            .antMatchers("/springsecurity/demo/welcome/admin").hasAuthority("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll()
            .and()
            .logout().permitAll()
            .and()
            .exceptionHandling().accessDeniedPage("/403")
            ;
    }

	
	
}
