package br.com.helo.api.security.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author <a href="mailto:andrews.silva@accenture.com">andrews.silva</a>
 * @date 20 de set de 2017 09:27:11
 */
public class SenhaUtils {

	/**
	 * Gera um hash utilizando o BCrypt.
	 *
	 * <code><pre></pre></code>
	 *
	 * @param senha
	 * @return String
	 */
	public static String gerarBCrypt(final String senha) {
		if (senha == null) {
			return senha;
		}
		final BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		return bCryptEncoder.encode(senha);
	}

	/**
	 * Verifica se a senha é válida.
	 *
	 * <code><pre></pre></code>
	 *
	 * @param senha
	 * @param senhaEncoded
	 * @return boolean
	 */
	public static boolean senhaValida(final String senha, final String senhaEncoded) {
		final BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		return bCryptEncoder.matches(senha, senhaEncoded);
	}
}
