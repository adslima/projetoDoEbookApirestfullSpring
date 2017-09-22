package br.com.helo.api.security.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 *
 * @author <a href="mailto:andrews.silva@accenture.com">andrews.silva</a>
 * @date 22 de set de 2017 09:41:41
 */
@Component
public class JwtTokenUtil {

	static final String CLAIM_KEY_USERNAME = "sub";

	static final String CLAIM_KEY_ROLE = "role";

	static final String CLAIM_KEY_CREATED = "created";

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private Long expiration;

	/**
	 * Obtém o username (email) contido no token JWT.
	 *
	 * @param token
	 * @return String
	 */
	public String getUsernameFromToken(final String token) {
		String username;
		try {
			final Claims claims = this.getClaimsFromToken(token);
			username = claims.getSubject();
		} catch (final Exception e) {
			username = null;
		}
		return username;
	}

	/**
	 * Retorna a data de expiração de um token JWT.
	 *
	 * @param token
	 * @return Date
	 */
	public Date getExpirationDateFromToken(final String token) {
		Date expiration;
		try {
			final Claims claims = this.getClaimsFromToken(token);
			expiration = claims.getExpiration();
		} catch (final Exception e) {
			expiration = null;
		}
		return expiration;
	}

	/**
	 * Cria um novo token (refresh).
	 *
	 * @param token
	 * @return String
	 */
	public String refreshToken(final String token) {
		String refreshedToken;
		try {
			final Claims claims = this.getClaimsFromToken(token);
			claims.put(CLAIM_KEY_CREATED, new Date());
			refreshedToken = this.gerarToken(claims);
		} catch (final Exception e) {
			refreshedToken = null;
		}
		return refreshedToken;
	}

	/**
	 * Verifica e retorna se um token JWT é válido.
	 *
	 * @param token
	 * @return boolean
	 */
	public boolean tokenValido(final String token) {
		return !this.tokenExpirado(token);
	}

	/**
	 * Retorna um novo token JWT com base nos dados do usuários.
	 *
	 * @param userDetails
	 * @return String
	 */
	public String obterToken(final UserDetails userDetails) {

		final Map<String, Object> claims = new HashMap<>();

		claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());

		userDetails.getAuthorities().forEach(authority -> claims.put(CLAIM_KEY_ROLE, authority.getAuthority()));

		claims.put(CLAIM_KEY_CREATED, new Date());

		return this.gerarToken(claims);
	}

	/**
	 * Realiza o parse do token JWT para extrair as informações contidas no corpo dele.
	 *
	 * @param token
	 * @return Claims
	 */
	private Claims getClaimsFromToken(final String token) {

		Claims claims;

		try {

			claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		} catch (final Exception e) {
			claims = null;
		}
		return claims;
	}

	/**
	 * Retorna a data de expiração com base na data atual.
	 *
	 * @return Date
	 */
	private Date gerarDataExpiracao() {
		return new Date(System.currentTimeMillis() + this.expiration * 1000);
	}

	/**
	 * Verifica se um token JTW está expirado.
	 *
	 * @param token
	 * @return boolean
	 */
	private boolean tokenExpirado(final String token) {

		final Date dataExpiracao = this.getExpirationDateFromToken(token);

		if (dataExpiracao == null) {
			return false;
		}
		return dataExpiracao.before(new Date());
	}

	/**
	 * Gera um novo token JWT contendo os dados (claims) fornecidos. *
	 *
	 * @param claims
	 * @return String
	 */
	private String gerarToken(final Map<String, Object> claims) {

		return Jwts.builder().setClaims(claims).setExpiration(this.gerarDataExpiracao())
				.signWith(SignatureAlgorithm.HS512, this.secret).compact();
	}
}
