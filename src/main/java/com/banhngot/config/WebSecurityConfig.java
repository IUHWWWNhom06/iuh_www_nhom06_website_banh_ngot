package com.banhngot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.banhngot.service.NguoiDungService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private NguoiDungService nguoiDungService;
	
   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
		.authorizeRequests()
			.antMatchers("/resources/**").permitAll()
			.antMatchers("/user/showFormNguoiNhan").permitAll()		
			.and()
			.formLogin()
				.loginPage("/user/formDangNhap")
				.loginProcessingUrl("/dangNhap")
				.usernameParameter("tenDangNhap")
				.passwordParameter("matKhau")
				.defaultSuccessUrl("/")
				.permitAll()
			.and()
			.logout().permitAll()
			.and()
				.exceptionHandling()
				.accessDeniedPage("/access-denied");
	}

	/*
	 * @Override public void configure(WebSecurity web) {
	 * web.ignoring().antMatchers("/resources/**"); }
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(nguoiDungService);
		auth.setPasswordEncoder(passwordEncoder()); 
		return auth;
	}
	
}






