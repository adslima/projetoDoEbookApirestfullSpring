package br.com.helo.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author <a href="mailto:andrews.silva@accenture.com">andrews.silva</a>
 * @date 21 de set de 2017 10:50:44
 */
@RestController
@RequestMapping("/api")
public class VersionamentoApiController {
	/**
	 * Versionamento de API pela url, define versão 'v1'.
	 *
	 * @param nome
	 * @return ResponseEntity<Response<String>>
	 */
	@GetMapping(value = "/v1/ola/{nome}")
	public ResponseEntity<String> olaNomeV1(@PathVariable("nome") final String nome) {
		return ResponseEntity.ok(String.format("API v1: Olá %s!", nome));
	}

	/**
	 * Versionamento de API pela url, define versão 'v2'.
	 *
	 * @param nome
	 * @return ResponseEntity<Response<String>>
	 */
	@GetMapping(value = "/v2/ola/{nome}")
	public ResponseEntity<String> olaNomeV2(@PathVariable("nome") final String nome) {
		return ResponseEntity.ok(String.format("API v2: Olá %s!", nome));
	}

	/**
	 * Versionamento de API pelo Header 'X-API-Version', define versão 'v1'.
	 *
	 * @param nome
	 * @return ResponseEntity<Response<String>>
	 */
	@GetMapping(value = "/ola/{nome}", headers = "X-API-Version=v1")
	public ResponseEntity<String> olaNomeHeaderV1(@PathVariable("nome") final String nome) {
		return ResponseEntity.ok(String.format("API Header v1: Olá %s!", nome));
	}

	/**
	 * Versionamento de API pelo Header 'X-API-Version', define versão 'v2'.
	 *
	 * @param nome
	 * @return ResponseEntity<Response<String>>
	 */
	@GetMapping(value = "/ola/{nome}", headers = "X-API-Version=v2")
	public ResponseEntity<String> olaNomeHeaderV2(@PathVariable("nome") final String nome) {
		return ResponseEntity.ok(String.format("API Header v2: Olá %s!", nome));
	}
}