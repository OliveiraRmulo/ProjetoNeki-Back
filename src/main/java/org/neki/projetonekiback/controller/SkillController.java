package org.neki.projetonekiback.controller;

import java.util.List;

import org.neki.projetonekiback.dto.SkillExibirDTO;
import org.neki.projetonekiback.dto.SkillInserirDTO;
import org.neki.projetonekiback.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/skill")
public class SkillController {
	
	@Autowired
	private SkillService skillService;
	
	@GetMapping
	@ApiOperation(value = "Listar todas skills ", notes = "Listar todas skills")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Skills listadas com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar esse recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros internos do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<List<SkillExibirDTO>> findAll() {
		List<SkillExibirDTO> skillExibirDTO = skillService.findAll();
		return ResponseEntity.ok(skillExibirDTO);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Listar skill por ID", notes = "Listar skill por ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Skill encontrada com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar esse recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros internos do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<SkillExibirDTO> findById(@PathVariable Long id) {
		SkillExibirDTO skillExibirDTO = skillService.findById(id);
		if(null != skillExibirDTO) {
			return ResponseEntity.ok(skillExibirDTO);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ApiOperation(value = "Cadastrar skill", notes = "Cadastrar skill")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Skill cadastrada com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar esse recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros internos do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public SkillExibirDTO save(@RequestBody SkillInserirDTO skillInserirDTO) {
		SkillExibirDTO skillExibirDTO = skillService.save(skillInserirDTO);
		return skillExibirDTO;
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualizar skill", notes = "Atualizar skill")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Skill atualizada com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar esse recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros internos do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<SkillExibirDTO> update(@PathVariable Long id, @RequestBody SkillInserirDTO skillInserirDTO) {
			SkillExibirDTO skillExibirDTO = skillService.update(id, skillInserirDTO);
			if(skillExibirDTO == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(skillExibirDTO);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deletar usuário", notes = "Deletar usuário")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Skill deletada com sucesso"),
			@ApiResponse(code = 204, message = "Não há Conteúdo"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar esse recurso"),
			@ApiResponse(code = 500, message = "Erros internos do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		if(!skillService.deleteById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}

}
