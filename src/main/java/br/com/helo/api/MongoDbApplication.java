package br.com.helo.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.helo.api.documents.Cliente;
import br.com.helo.api.repository.ClienteRepository;

/**
 *
 * @author <a href="mailto:andrews.silva@accenture.com">andrews.silva</a>
 * @date 25 de set de 2017 09:19:11
 */
@SpringBootApplication
public class MongoDbApplication implements CommandLineRunner {

	/**
	 *
	 */
	@Autowired
	private ClienteRepository repository;

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @param args void
	 */
	public static void main(final String[] args) {

		SpringApplication.run(MongoDbApplication.class, args);

	}

	/* (non-Javadoc)
	 *
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[]) */
	@Override
	public void run(final String... args) throws Exception {

		this.repository.deleteAll();

		this.repository.save(new Cliente("Alice", 20));

		this.repository.save(new Cliente("João", 30));

		this.repository.save(new Cliente("Maria", 40));

		System.out.println("Lista todos com o findAll():");

		System.out.println("-------------------------------");

		this.repository.findAll().forEach(System.out::println);

		System.out.println();

		System.out.println("Busca um único cliente com o findByNome('Alice'):");

		System.out.println("--------------------------------");

		System.out.println(this.repository.findByNome("Alice"));

		System.out.println();

		System.out.println("Clientes com idade entre 18 and 35:");

		System.out.println("--------------------------------");

		this.repository.findByIdadeBetween(18, 35).forEach(System.out::println);
	}
}
