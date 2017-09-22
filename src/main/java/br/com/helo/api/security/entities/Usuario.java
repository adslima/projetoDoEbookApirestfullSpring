package br.com.helo.api.security.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.helo.api.security.enums.PerfilEnum;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	/**
	 * Atributo serialVersionUID representa
	 */
	private static final long serialVersionUID = 727896451392719965L;

	/**
	 *
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 *
	 */
	@Column(name = "email", nullable = false)
	private String email;

	/**
	 *
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = false)
	private PerfilEnum perfil;

	/**
	 *
	 */
	@Column(name = "senha", nullable = false)
	private String senha;

	/**
	 *
	 * Construtor
	 */
	public Usuario() {

	}

	/**
	 * @return retorna o valor de {@link #id}
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * seta o valor do parametro id no atributo {@link #id}
	 *
	 * @param id
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * @return retorna o valor de {@link #email}
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @return String
	 */
	public PerfilEnum getPerfil() {
		return this.perfil;
	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @param perfil void
	 */
	public void setPerfil(final PerfilEnum perfil) {
		this.perfil = perfil;
	}

	/**
	 * seta o valor do parametro email no atributo {@link #email}
	 *
	 * @param email
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * @return retorna o valor de {@link #senha}
	 */
	public String getSenha() {
		return this.senha;
	}

	/**
	 * seta o valor do parametro senha no atributo {@link #senha}
	 *
	 * @param senha
	 */
	public void setSenha(final String senha) {
		this.senha = senha;
	}

}
