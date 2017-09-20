package br.com.helo.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author <a href="mailto:andrews.silva@accenture.com">andrews.silva</a>
 * @date 20 de set de 2017 10:51:18
 */
@RestController
@RequestMapping("/api/exemplo")
public class ExemploController {

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @param nome
	 * @return String
	 */
	@GetMapping(value = "/{nome}")
	public String exemplo(@PathVariable("nome") final String nome) {
		return "Olá " + nome;
	}

}
