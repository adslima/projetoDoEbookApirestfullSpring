package br.com.helo.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

/**
 *
 * @author <a href="mailto:andrews.silva@accenture.com">andrews.silva</a>
 * @date 20 de set de 2017 10:14:15
 */
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

	/**
	 * Atributo serialVersionUID representa
	 */
	private static final long serialVersionUID = 778991376133139440L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "razao_social", nullable = false)
	private String razaoSocial;

	@Column(name = "cnpj", nullable = false)
	private String cnpj;

	@Column(name = "data_criacao", nullable = false)
	private Date dataCriacao;

	@Column(name = "data_atualizacao", nullable = false)
	private Date dataAtualizacao;

	/**
	 *
	 * Construtor
	 */
	public Empresa() {
	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @return Long
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @param id void
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @return String
	 */
	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @param razaoSocial void
	 */
	public void setRazaoSocial(final String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @return String
	 */

	public String getCnpj() {
		return this.cnpj;
	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @param cnpj void
	 */
	public void setCnpj(final String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @return Date
	 */
	public Date getDataCriacao() {
		return this.dataCriacao;
	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @param dataCriacao void
	 */
	public void setDataCriacao(final Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @return Date
	 */
	public Date getDataAtualizacao() {
		return this.dataAtualizacao;
	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @param dataAtualizacao void
	 */
	public void setDataAtualizacao(final Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	/**
	 *
	 * <code><pre></pre></code> void
	 */
	@PreUpdate
	public void preUpdate() {
		this.dataAtualizacao = new Date();
	}

	/**
	 *
	 * <code><pre></pre></code> void
	 */
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		this.dataCriacao = atual;
		this.dataAtualizacao = atual;
	}

	/* (non-Javadoc)
	 *
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Empresa [id=" + this.id + ", razaoSocial=" + this.razaoSocial + ", cnpj=" + this.cnpj + ",dataCriacao="
				+ this.dataCriacao + ",dataAtualizacao=" + this.dataAtualizacao + "]";
	}

}
