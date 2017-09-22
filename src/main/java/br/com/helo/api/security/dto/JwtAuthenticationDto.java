package br.com.helo.api.security.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class JwtAuthenticationDto {

	private String email;
	private String senha;

	/**
	 *
	 * Construtor
	 */
	public JwtAuthenticationDto() {
	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @return String
	 */
	@NotEmpty(message = "Email não pode ser vazio.")
	@Email(message = "Email inválido.")
	public String getEmail() {
		return this.email;
	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @param email void
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @return String
	 */
	@NotEmpty(message = "Senha não pode ser vazia.")
	public String getSenha() {
		return this.senha;
	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @param senha void
	 */
	public void setSenha(final String senha) {
		this.senha = senha;
	}

	/* (non-Javadoc)
	 *
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "JwtAuthenticationRequestDto [email=" + this.email + ", senha=" + this.senha + "]";
	}
}
