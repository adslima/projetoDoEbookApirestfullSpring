package br.com.helo.api.security.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.helo.api.security.entities.Usuario;
import br.com.helo.api.security.repository.UsuarioRepository;
import br.com.helo.api.security.service.UsuarioService;

/**
 *
 * @author <a href="mailto:andrews.silva@accenture.com">andrews.silva</a>
 * @date 22 de set de 2017 09:32:03
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

	/**
	 *
	 */
	@Autowired
	private UsuarioRepository usuarioRepository;

	/* (non-Javadoc)
	 *
	 * @see br.com.helo.api.service.UsuarioService#buscarPorEmail(java.lang.String) */
	@Override
	public Optional<Usuario> buscarPorEmail(final String email) {

		return Optional.ofNullable(this.usuarioRepository.findByEmail(email));
	}
}
