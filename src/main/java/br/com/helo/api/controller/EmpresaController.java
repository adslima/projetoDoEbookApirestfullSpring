package br.com.helo.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.helo.api.dto.EmpresaDto;

/**
 *
 * @author <a href="mailto:andrews.silva@accenture.com">andrews.silva</a>
 * @date 20 de set de 2017 16:50:31
 */
@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @param empresaDto
	 * @return ResponseEntity<EmpresaDto>
	 */
	@PostMapping
	public ResponseEntity<EmpresaDto> cadastrar(@RequestBody final EmpresaDto empresaDto) {
		empresaDto.setId(1L);
		return ResponseEntity.ok(empresaDto);
	}

}
