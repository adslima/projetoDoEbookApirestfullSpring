package br.com.helo.api.security.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.helo.api.security.JwtUserFactory;
import br.com.helo.api.security.entities.Usuario;
import br.com.helo.api.security.service.UsuarioService;

/**
 *
 * @author <a href="mailto:andrews.silva@accenture.com">andrews.silva</a>
 * @date 22 de set de 2017 09:58:33
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	/**
	 *
	 */
	@Autowired
	private UsuarioService usuarioService;

	/* (non-Javadoc)
	 *
	 * @see
	 * org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String) */
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		final Optional<Usuario> funcionario = this.usuarioService.buscarPorEmail(username);
		if (funcionario.isPresent()) {
			return JwtUserFactory.create(funcionario.get());
		}
		throw new UsernameNotFoundException("Email não encontrado.");
	}

}
