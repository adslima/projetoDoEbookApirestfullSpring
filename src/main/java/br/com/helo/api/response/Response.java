package br.com.helo.api.response;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <a href="mailto:andrews.silva@accenture.com">andrews.silva</a>
 * @date 20 de set de 2017 17:14:46
 * @param <T>
 */
public class Response<T> {

	private T data;
	private List<String> errors;

	/**
	 * @return retorna o valor de {@link #data}
	 */
	public T getData() {
		return this.data;
	}

	/**
	 * seta o valor do parametro data no atributo {@link #data}
	 *
	 * @param data
	 */
	public void setData(final T data) {
		this.data = data;
	}

	/**
	 * @return retorna o valor de {@link #errors}
	 */
	public List<String> getErrors() {
		if (this.errors == null) {
			this.errors = new ArrayList<String>();
		}
		return this.errors;
	}

	/**
	 * seta o valor do parametro erros no atributo {@link #errors}
	 *
	 * @param erros
	 */
	public void setErrors(final List<String> errors) {
		this.errors = errors;
	}

	/**
	 *
	 * Construtor
	 */
	public Response() {

	}
}
