package com.mcu.backend.apirest.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mcu.backend.apirest.service.UserDelailsServiceImp;

public class JwtTokenFilter extends OncePerRequestFilter {
	private final static Logger logger = org.slf4j.LoggerFactory.getLogger(JwtTokenFilter.class);

	@Autowired
	private JwtProvider jwtProvider;
	
	@Autowired
	private UserDelailsServiceImp userDelailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String token = getToken(request);
			if(token != null && jwtProvider.validateToken(token)) {
				String nombre = jwtProvider.getUsernameFormToken(token);
				UserDetails userDetails = userDelailsService.loadUserByUsername(nombre);
				UsernamePasswordAuthenticationToken auth= 
						new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		} catch (Exception e) {
			logger.error("fallo el metodo doFilterInternal");
		}
		filterChain.doFilter(request, response);
		
	}
	
	private String getToken(HttpServletRequest request) {
		String header= request.getHeader("autorizado");
		if(header!=null && header.startsWith("Bearer")) {
			return header.replace("Bearer ","");
		} else {
			return null;
		}
		
		
	}

}
