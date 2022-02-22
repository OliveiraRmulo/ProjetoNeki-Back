package org.neki.projetonekiback.dto;

import java.time.LocalDate;

import org.neki.projetonekiback.entity.SkillEntity;
import org.neki.projetonekiback.entity.UserEntity;
import org.neki.projetonekiback.entity.UserSkillEntity;

public class UserSkillInserirDTO {
	
	private Long id;
	private Long knowledgeLevel;
	private LocalDate created_at;
	private LocalDate updated_at;
	private SkillEntity skill;
	private UserEntity user;
	
	public UserSkillInserirDTO() {
			super();
	}
	
	public UserSkillInserirDTO(Long id, Long knowledgeLevel, LocalDate created_at, LocalDate updated_at,
			SkillEntity skill, UserEntity user) {
		super();
		this.id = id;
		this.knowledgeLevel = knowledgeLevel;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.skill = skill;
		this.user = user;
	}
	
	public UserSkillInserirDTO(UserSkillEntity userSkill) {
		super();
		this.id = userSkill.getId();
		this.knowledgeLevel = userSkill.getKnowledgeLevel();
		this.created_at = userSkill.getCreated_at();
		this.updated_at = userSkill.getUpdated_at();
		this.user = userSkill.getUser();
		this.skill = userSkill.getSkill();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getKnowledgeLevel() {
		return knowledgeLevel;
	}

	public void setKnowledgeLevel(Long knowledgeLevel) {
		this.knowledgeLevel = knowledgeLevel;
	}

	public LocalDate getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDate created_at) {
		this.created_at = created_at;
	}

	public LocalDate getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDate updated_at) {
		this.updated_at = updated_at;
	}

	public SkillEntity getSkill() {
		return skill;
	}

	public void setSkill(SkillEntity skill) {
		this.skill = skill;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	

}
