package com.tscarff.smashgen.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.tscarff.smashgen.config.filters.JwtFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/**").permitAll();
		}
	
	@Bean
	public FilterRegistrationBean jwtFilter() {
		//Add the jwt filter to the filter chain for all secured urls (not login or signup)
		final FilterRegistrationBean filterBean = new FilterRegistrationBean();
		filterBean.setFilter(new JwtFilter());
		filterBean.addUrlPatterns("/api/*");
		filterBean.addUrlPatterns("/api/**");
		filterBean.setOrder(2);
		filterBean.setName("apiFilter");
		return filterBean;
	}
	
	
}
