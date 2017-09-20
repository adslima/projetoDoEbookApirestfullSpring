package br.com.helo.api.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.helo.api.dto.EmpresaDto;
import br.com.helo.api.response.Response;

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
	 * @param result
	 * @return ResponseEntity<Response<EmpresaDto>>
	 */
	@PostMapping
	public ResponseEntity<Response<EmpresaDto>> cadastrar(@Valid @RequestBody final EmpresaDto empresaDto,
			final BindingResult result) {

		final Response<EmpresaDto> response = new Response<EmpresaDto>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		empresaDto.setId(1L);
		response.setData(empresaDto);

		return ResponseEntity.ok(response);
	}

}
