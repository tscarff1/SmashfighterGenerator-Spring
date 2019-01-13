package com.tscarff.smashgen.config.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

public class JwtFilter extends GenericFilterBean {
	public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain) throws IOException, ServletException{
		final HttpServletRequest httpRequest = (HttpServletRequest) req;
		final HttpServletResponse httpResponse = (HttpServletResponse) res;
		
		//OPTIONS request type is a pre-CORS request. We just return a successful response and don't do any processing for it
		if(httpRequest.getMethod().equalsIgnoreCase("OPTIONS")) {
			httpResponse.setStatus(HttpServletResponse.SC_OK);
			chain.doFilter(req, res);
		} else {
			//TODO: processing if we want to implement login
			chain.doFilter(req, res);
		}
	}
}
