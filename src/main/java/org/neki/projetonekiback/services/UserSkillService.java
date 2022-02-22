package org.neki.projetonekiback.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.neki.projetonekiback.dto.UserSkillExibirDTO;
import org.neki.projetonekiback.dto.UserSkillInserirDTO;
import org.neki.projetonekiback.entity.UserSkillEntity;
import org.neki.projetonekiback.repositories.UserSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSkillService {
	
	@Autowired
	UserSkillRepository userSkillRepository;
	
	
		//Listar todos
		public List<UserSkillExibirDTO> findAll() {
			List<UserSkillExibirDTO> userSkillExibirDTO = new ArrayList<UserSkillExibirDTO>();
			List<UserSkillEntity> userSkill = userSkillRepository.findAll();
		
			for (UserSkillEntity userSkill1 : userSkill) {
				UserSkillExibirDTO userSkillExibir = new UserSkillExibirDTO(userSkill1);
				userSkillExibirDTO.add(userSkillExibir);
			}
			return userSkillExibirDTO;
	}
	
		//Listar Por Id (Retornar as skills associadas ao id do usuario)
		public UserSkillExibirDTO findById(Long id) {
			Optional<UserSkillEntity> opUserSkill = userSkillRepository.findById(id);
			if (opUserSkill.isPresent()) {
				return new UserSkillExibirDTO(opUserSkill.get());
			}
			return null;
		}
		
		//Inserir
		public UserSkillExibirDTO save (UserSkillInserirDTO userSkillInserirDTO) {
			UserSkillEntity userSkill = new UserSkillEntity();
			
			userSkill.setKnowledgeLevel(userSkillInserirDTO.getKnowledgeLevel());
			userSkill.setCreated_at(LocalDate.now());
			userSkill.setUser(userSkillInserirDTO.getUser());
			userSkill.setSkill(userSkillInserirDTO.getSkill());
			
			
			UserSkillEntity userSkill1 = userSkillRepository.save(userSkill);
			return new UserSkillExibirDTO(userSkill1);
		}
		
		//Atualizar (Level da skill associada ao usuario)
		public UserSkillExibirDTO update (Long id, UserSkillInserirDTO userSkillInserirDTO) {
			UserSkillEntity userSkill = new UserSkillEntity();
			if (!userSkillRepository.existsById(id)) {
				return null;
			}
			userSkill.setId(id);
			userSkill.setKnowledgeLevel(userSkillInserirDTO.getKnowledgeLevel());
			userSkill.setUpdated_at(LocalDate.now());
			userSkill.setUser(userSkillInserirDTO.getUser());
			userSkill.setSkill(userSkillInserirDTO.getSkill());
		

			userSkill = userSkillRepository.save(userSkill);
			return new UserSkillExibirDTO(userSkill);
		}
		
		//Deletar Por Id (skill associada ao usuario)
		public boolean deleteById(Long id) {
			if(!userSkillRepository.existsById(id)) {
				return false;
			}
			userSkillRepository.deleteById(id);
			return true;
			
		}

}
