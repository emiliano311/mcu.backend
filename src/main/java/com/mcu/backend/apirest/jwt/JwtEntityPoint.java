package com.mcu.backend.apirest.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtEntityPoint implements AuthenticationEntryPoint{

	private final static Logger logger = org.slf4j.LoggerFactory.getLogger(JwtEntityPoint.class);
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		logger.error("fallo en el metodo commence");
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"no autorizado");
	}

	
}
