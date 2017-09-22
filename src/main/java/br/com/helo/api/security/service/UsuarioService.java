package br.com.helo.api.security.service;

import java.util.Optional;

import br.com.helo.api.security.entities.Usuario;

/**
 *
 * @author <a href="mailto:andrews.silva@accenture.com">andrews.silva</a>
 * @date 22 de set de 2017 09:29:33
 */
public interface UsuarioService {

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @param email
	 * @return Optional<Usuario>
	 */
	Optional<Usuario> buscarPorEmail(String email);

}
