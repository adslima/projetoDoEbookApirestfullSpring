package br.com.helo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.helo.api.entity.Empresa;

/**
 *
 * @author <a href="mailto:andrews.silva@accenture.com">andrews.silva</a>
 * @date 20 de set de 2017 10:20:36
 */
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @param cnpj
	 * @return Empresa
	 */
	Empresa findByCnpj(String cnpj);

}
