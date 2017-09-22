package br.com.helo.api.security.dto;

/**
 *
 * @author <a href="mailto:andrews.silva@accenture.com">andrews.silva</a>
 * @date 22 de set de 2017 10:11:06
 */
public class TokenDto {

	/**
	 *
	 */
	private String token;

	/**
	 *
	 * Construtor
	 */
	public TokenDto() {
	}

	/**
	 *
	 * Construtor
	 *
	 * @param token
	 */
	public TokenDto(final String token) {
		this.token = token;
	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @return String
	 */
	public String getToken() {
		return this.token;
	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @param token void
	 */
	public void setToken(final String token) {
		this.token = token;
	}

}
