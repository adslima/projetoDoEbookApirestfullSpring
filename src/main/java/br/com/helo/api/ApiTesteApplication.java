package br.com.helo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 *
 * @author <a href="mailto:andrews.silva@accenture.com">andrews.silva</a>
 * @date 21 de set de 2017 11:23:20
 */
@SpringBootApplication
@EnableCaching
public class ApiTesteApplication {

	/**
	 *
	 *
	 * <code><pre></pre></code>
	 *
	 * @param args void
	 */
	public static void main(final String[] args) {
		SpringApplication.run(ApiTesteApplication.class, args);
	}
}
