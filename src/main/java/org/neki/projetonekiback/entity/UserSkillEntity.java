package org.neki.projetonekiback.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UserSkill")
public class UserSkillEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_userSkill")
	private Long id;
	
	@Column(name = "knowledge_level", nullable = false)
	private Long knowledgeLevel;
	
	@Column(name = "created_at", nullable = false)
	private LocalDate created_at;
	
	@Column(name = "updated_at", nullable = true)
	private LocalDate updated_at;
	
	@ManyToOne
	@JoinColumn(name = "id_skill", nullable = false)
	private SkillEntity skill;
	
	@ManyToOne
	@JoinColumn(name = "id_user", nullable = false)
	private UserEntity user;
	
	public UserSkillEntity() {
		super();
	}

	public UserSkillEntity(Long id, Long knowledgeLevel, LocalDate created_at, LocalDate updated_at, SkillEntity skill,
			UserEntity user) {
		super();
		this.id = id;
		this.knowledgeLevel = knowledgeLevel;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.skill = skill;
		this.user = user;
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

	@Override
	public int hashCode() {
		return Objects.hash(created_at, id, knowledgeLevel, skill, updated_at, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserSkillEntity other = (UserSkillEntity) obj;
		return Objects.equals(created_at, other.created_at) && Objects.equals(id, other.id)
				&& Objects.equals(knowledgeLevel, other.knowledgeLevel) && Objects.equals(skill, other.skill)
				&& Objects.equals(updated_at, other.updated_at) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "UserSkillEntity [id=" + id + ", knowledgeLevel=" + knowledgeLevel + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + ", skill=" + skill + ", user=" + user + "]";
	}

}
