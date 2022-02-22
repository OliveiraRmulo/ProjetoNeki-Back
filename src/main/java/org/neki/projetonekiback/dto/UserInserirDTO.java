package org.neki.projetonekiback.dto;

import java.time.LocalDate;

import org.neki.projetonekiback.entity.UserEntity;

public class UserInserirDTO {

	private Long id;
	private String login;
	private String password;
	private LocalDate lastLoginDate;

	public UserInserirDTO() {

	}

	public UserInserirDTO(Long id, String login, String password, LocalDate lastLoginDate) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.lastLoginDate = lastLoginDate;
	}

	public UserInserirDTO(UserEntity user) {
		super();
		this.id = user.getId();
		this.login = user.getLogin();
		this.password = user.getPassword();
		lastLoginDate = user.getLastLoginDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(LocalDate lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

}
