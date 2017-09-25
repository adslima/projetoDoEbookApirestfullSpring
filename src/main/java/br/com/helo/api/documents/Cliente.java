package br.com.helo.api.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/***
 *
 * @author <a href="mailto:andrews.silva@accenture.com">andrews.silva</a>
 * @date 25 de set de 2017 09:15:05
 */
@Document(collection = "clientes")
public class Cliente {

	/**
	 *
	 */
	@Id
	private String id;

	/**
	 *
	 */
	private String nome;

	/**
	 *
	 */
	private Integer idade;

	/**
	 *
	 * Construtor
	 */
	public Cliente() {
	}

	/**
	 *
	 * Construtor
	 *
	 * @param nome
	 * @param idade
	 */
	public Cliente(final String nome, final Integer idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @return String
	 */
	public String getId() {
		return this.id;
	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @param id void
	 */
	public void setId(final String id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @param nome void
	 */
	public void setNome(final String nome) {
		this.nome = nome;
	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @return Integer
	 */
	public Integer getIdade() {
		return this.idade;
	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @param idade void
	 */
	public void setIdade(final Integer idade) {
		this.idade = idade;
	}

	/* (non-Javadoc)
	 *
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Cliente [id=" + this.id + ", nome=" + this.nome + ", idade=" + this.idade + "]";
	}
}