package org.neki.projetonekiback.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.neki.projetonekiback.dto.SkillExibirDTO;
import org.neki.projetonekiback.dto.SkillInserirDTO;
import org.neki.projetonekiback.entity.SkillEntity;
import org.neki.projetonekiback.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {
	
	@Autowired
	private SkillRepository skillRepository;
	

	
	//Listar todos
	public List<SkillExibirDTO> findAll() {
		List<SkillExibirDTO> skillExibirDTO = new ArrayList<SkillExibirDTO>();
		List<SkillEntity> skill = skillRepository.findAll();
		
		for (SkillEntity skill1 : skill) {
			SkillExibirDTO skillExibir = new SkillExibirDTO(skill1);
			skillExibirDTO.add(skillExibir);
		}
		return skillExibirDTO;
	}
	
	//Listar Por Id
		public SkillExibirDTO findById(Long id) {
			Optional<SkillEntity> opSkill = skillRepository.findById(id);
			if (opSkill.isPresent()) {
				return new SkillExibirDTO(opSkill.get());
			}
			return null;
		}
	
		//Inserir
		public SkillExibirDTO save (SkillInserirDTO skillInserirDTO) {
			SkillEntity skill = new SkillEntity();
			
			skill.setName(skillInserirDTO.getName());
			skill.setVersion(skillInserirDTO.getVersion());
			skill.setDescription(skillInserirDTO.getDescription());
			skill.setImageUrl(skillInserirDTO.getImageUrl());

			
			SkillEntity skill1 = skillRepository.save(skill);
			return new SkillExibirDTO(skill1);
		}
	
		//Atualizar
		public SkillExibirDTO update (Long id, SkillInserirDTO skillInserirDTO) {
			SkillEntity skill = new SkillEntity();
			if (!skillRepository.existsById(id)) {
				return null;
			}
			skill.setId(id);
			skill.setName(skillInserirDTO.getName());
			skill.setVersion(skillInserirDTO.getVersion());
			skill.setDescription(skillInserirDTO.getDescription());
			skill.setImageUrl(skillInserirDTO.getImageUrl());

			skill = skillRepository.save(skill);
			return new SkillExibirDTO(skill);
		}
	
		//Deletar Por Id
		public boolean deleteById(Long id) {
			if(!skillRepository.existsById(id)) {
				return false;
			}
			skillRepository.deleteById(id);
			return true;
			
		}
}
