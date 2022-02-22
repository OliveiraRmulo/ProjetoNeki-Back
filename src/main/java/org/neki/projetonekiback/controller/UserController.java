package org.neki.projetonekiback.controller;

import java.util.List;

import org.neki.projetonekiback.dto.UserExibirDTO;
import org.neki.projetonekiback.dto.UserInserirDTO;
import org.neki.projetonekiback.services.UserService;
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
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	@ApiOperation(value = "Listar todos usuários ", notes = "Listar todos usuários")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuários listados com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar esse recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros internos do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<List<UserExibirDTO>> findAll() {
		List<UserExibirDTO> userExibirDTO = userService.findAll();
		return ResponseEntity.ok(userExibirDTO);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Listar usuário por ID", notes = "Listar usuário por ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuário encontrado com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar esse recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros internos do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<UserExibirDTO> findById(@PathVariable Long id) {
		UserExibirDTO userExibirDTO = userService.findById(id);
		if(null != userExibirDTO) {
			return ResponseEntity.ok(userExibirDTO);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ApiOperation(value = "Cadastrar usuário", notes = "Cadastrar usuário")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Usuários cadastrados com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar esse recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros internos do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public UserExibirDTO save(@RequestBody UserInserirDTO userInserirDTO) {
		UserExibirDTO userExibirDTO = userService.save(userInserirDTO);
		return userExibirDTO;
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualizar usuário", notes = "Atualizar usuário")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuário atualizado com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar esse recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros internos do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<UserExibirDTO> update(@PathVariable Long id, @RequestBody UserInserirDTO userInserirDTO) {
			UserExibirDTO userExibirDTO = userService.update(id, userInserirDTO);
			if(userExibirDTO == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(userExibirDTO);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deletar usuário", notes = "Deletar usuário")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuário deletado com sucesso"),
			@ApiResponse(code = 204, message = "Não há Conteúdo"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar esse recurso"),
			@ApiResponse(code = 500, message = "Erros internos do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		if(!userService.deleteById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
	
}
