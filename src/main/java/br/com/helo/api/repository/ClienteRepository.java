package br.com.helo.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.helo.api.documents.Cliente;

/**
 *
 * @author <a href="mailto:andrews.silva@accenture.com">andrews.silva</a>
 * @date 25 de set de 2017 09:03:52
 */
public interface ClienteRepository extends MongoRepository<Cliente, String> {
	Cliente findByNome(String nome);

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @param idadeInicial
	 * @param idadeFinal
	 * @return List<Cliente>
	 */
	@Query("{ 'idade' : { $gt: ?0, $lt: ?1 } }")
	List<Cliente> findByIdadeBetween(int idadeInicial, int idadeFinal);
}