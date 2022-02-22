package org.neki.projetonekiback.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.neki.projetonekiback.dto.UserExibirDTO;
import org.neki.projetonekiback.dto.UserInserirDTO;
import org.neki.projetonekiback.entity.UserEntity;
import org.neki.projetonekiback.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	//Listar todos
	public List<UserExibirDTO> findAll() {
		List<UserExibirDTO> userExibirDTO = new ArrayList<UserExibirDTO>();
		List<UserEntity> user = userRepository.findAll();
		
		for (UserEntity user1 : user) {
			UserExibirDTO userExibir = new UserExibirDTO(user1);
			userExibirDTO.add(userExibir);
		}
		return userExibirDTO;
	}
	
	//Listar Por Id
	public UserExibirDTO findById(Long id) {
		Optional<UserEntity> opUser = userRepository.findById(id);
		if (opUser.isPresent()) {
			return new UserExibirDTO(opUser.get());
		}
		return null;
	}
	
	//Inserir
	public UserExibirDTO save (UserInserirDTO userInserirDTO) {
		UserEntity user = new UserEntity();
		
		user.setLogin(userInserirDTO.getLogin());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(userInserirDTO.getPassword()));
		user.setLastLoginDate(LocalDate.now());
		
		UserEntity user1 = userRepository.save(user);
		return new UserExibirDTO(user1);
	}
	
	//Atualizar
	public UserExibirDTO update (Long id, UserInserirDTO userInserirDTO) {
		UserEntity user = new UserEntity();
		if (!userRepository.existsById(id)) {
			return null;
		}
		user.setId(id);
		user.setLogin(userInserirDTO.getLogin());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(userInserirDTO.getPassword()));
		user.setLastLoginDate(LocalDate.now());

		user = userRepository.save(user);
		return new UserExibirDTO(user);
	}
	
	//Deletar Por Id
	public boolean deleteById(Long id) {
		if(!userRepository.existsById(id)) {
			return false;
		}
		userRepository.deleteById(id);
		return true;
		
	}
	
}
