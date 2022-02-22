package org.neki.projetonekiback.dto;

import org.neki.projetonekiback.entity.SkillEntity;

public class SkillExibirDTO {

	private Long id;
	private String name;
	private String version;
	private String description;
	private String imageUrl;
	
	public SkillExibirDTO() {
		super();
	}

	public SkillExibirDTO(Long id, String name, String version, String description, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	public SkillExibirDTO(SkillEntity skill) {
		super();
		this.id = skill.getId();
		this.name = skill.getName();
		this.version = skill.getVersion();
		this.description = skill.getDescription();
		this.imageUrl = skill.getImageUrl();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}
