package br.com.helo.api.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 *
 * @author <a href="mailto:andrews.silva@accenture.com">andrews.silva</a>
 * @date 22 de set de 2017 10:01:07
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	/* (non-Javadoc)
	 *
	 * @see org.springframework.security.web.AuthenticationEntryPoint#commence(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * org.springframework.security.core.AuthenticationException) */
	@Override
	public void commence(final HttpServletRequest request, final HttpServletResponse response,
			final AuthenticationException authException) throws IOException {

		response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
				"Acesso negado. Você deve estar autenticado no sistema” +“ para acessar a URL solicitada.");
	}

}