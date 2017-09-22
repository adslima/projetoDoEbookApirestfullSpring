package br.com.helo.api.security.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.helo.api.security.utils.JwtTokenUtil;

/**
 *
 * @author <a href="mailto:andrews.silva@accenture.com">andrews.silva</a>
 * @date 22 de set de 2017 10:03:49
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

	private static final String AUTH_HEADER = "Authorization";

	private static final String BEARER_PREFIX = "Bearer ";
	/**
	 *
	 */
	@Autowired
	private UserDetailsService userDetailsService;
	/**
	 *
	 */
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	/* (non-Javadoc)
	 *
	 * @see org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain) */
	@Override
	protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain)
			throws ServletException, IOException {

		String token = request.getHeader(AUTH_HEADER);

		if (token != null && token.startsWith(BEARER_PREFIX)) {
			token = token.substring(7);
		}
		final String username = this.jwtTokenUtil.getUsernameFromToken(token);

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

			if (this.jwtTokenUtil.tokenValido(token)) {

				final UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
						null, userDetails.getAuthorities());

				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		chain.doFilter(request, response);
	}

}
