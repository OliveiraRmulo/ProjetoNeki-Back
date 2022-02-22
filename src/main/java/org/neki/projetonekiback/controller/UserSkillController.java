package org.neki.projetonekiback.controller;

import java.util.List;

import org.neki.projetonekiback.dto.UserSkillExibirDTO;
import org.neki.projetonekiback.dto.UserSkillInserirDTO;
import org.neki.projetonekiback.services.UserSkillService;
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
@RequestMapping("/userSkill")
public class UserSkillController {
	
	@Autowired
	UserSkillService userSkillService;
	
	@GetMapping
	@ApiOperation(value = "Listar skills dos usuários ", notes = "Listar skills dos usuários")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Skill dos usúarios listadas com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar esse recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros internos do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<List<UserSkillExibirDTO>> findAll() {
		List<UserSkillExibirDTO> userSkillExibirDTO = userSkillService.findAll();
		return ResponseEntity.ok(userSkillExibirDTO);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Listar skill associadas ao Id do usuário", notes = "Listar skill associadas ao Id do usuário")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Skill associada ao usúario encontrada com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar esse recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros internos do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<UserSkillExibirDTO> findById(@PathVariable Long id) {
		UserSkillExibirDTO userSkillExibirDTO = userSkillService.findById(id);
		if(null != userSkillExibirDTO) {
			return ResponseEntity.ok(userSkillExibirDTO);
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
	
	public UserSkillExibirDTO save(@RequestBody UserSkillInserirDTO userSkillInserirDTO) {
		UserSkillExibirDTO userSkillExibirDTO = userSkillService.save(userSkillInserirDTO);
		return userSkillExibirDTO;
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualizar Skill", notes = "Atualizar Skill")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Skill atualizada com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar esse recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros internos do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<UserSkillExibirDTO> update(@PathVariable Long id, @RequestBody UserSkillInserirDTO userSkillInserirDTO) {
			UserSkillExibirDTO userSkillExibirDTO = userSkillService.update(id, userSkillInserirDTO);
			if(userSkillExibirDTO == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(userSkillExibirDTO);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deletar skill", notes = "Deletar skill")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Skill deletada com sucesso"),
			@ApiResponse(code = 204, message = "Não há Conteúdo"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar esse recurso"),
			@ApiResponse(code = 500, message = "Erros internos do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		if(!userSkillService.deleteById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
	
	
}
