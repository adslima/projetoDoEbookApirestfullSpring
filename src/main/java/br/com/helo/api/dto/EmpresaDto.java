package br.com.helo.api.dto;

/**
 *
 * @author <a href="mailto:andrews.silva@accenture.com">andrews.silva</a>
 * @date 20 de set de 2017 15:09:22
 */
public class EmpresaDto {

	private Long id;
	private String razaoSocial;
	private String cnpj;

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
	 * @return retorna o valor de {@link #razaoSocial}
	 */
	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	/**
	 * seta o valor do parametro razaoSocial no atributo {@link #razaoSocial}
	 *
	 * @param razaoSocial
	 */
	public void setRazaoSocial(final String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	/**
	 * @return retorna o valor de {@link #cnpj}
	 */
	public String getCnpj() {
		return this.cnpj;
	}

	/**
	 * seta o valor do parametro cnpj no atributo {@link #cnpj}
	 *
	 * @param cnpj
	 */
	public void setCnpj(final String cnpj) {
		this.cnpj = cnpj;
	}

}
