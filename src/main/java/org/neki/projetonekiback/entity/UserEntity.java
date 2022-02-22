package org.neki.projetonekiback.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Long id;

	@Column(name = "login", length = 12, nullable = false, unique = true)
	private String login;

	@Column(name = "password", length = 100, nullable = false)
	private String password;

	@Column(name = "last_login_date", nullable = true)
	private LocalDate lastLoginDate;

	@OneToMany(mappedBy = "user")
	private List<UserEntity> user;

	public UserEntity() {
		super();
	}

	public UserEntity(Long id, String login, String password, LocalDate lastLoginDate) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.lastLoginDate = lastLoginDate;
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

	@Override
	public int hashCode() {
		return Objects.hash(id, lastLoginDate, login, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(lastLoginDate, other.lastLoginDate)
				&& Objects.equals(login, other.login) && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", login=" + login + ", password=" + password + ", lastLoginDate=" + lastLoginDate
				+ "]";
	}

}
