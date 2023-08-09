package com.laboratory.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name="resettoken")
public class ResetToken {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@Column(nullable = false, unique = true)
	private String token;
	@OneToOne(targetEntity = Users.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "id_usuario")
	private Users user;
	@Column(nullable = false)
	private LocalDateTime expiration;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public void setExpiration(LocalDateTime expiration) {
		this.expiration = expiration;
	}

	public LocalDateTime getExpiration() {
		return expiration;
	}

	public void setExpiration(int minutes) {
		LocalDateTime hoy = LocalDateTime.now();
		LocalDateTime exp = hoy.plusMinutes(minutes);
		this.expiration = exp;
	}

	public boolean expired() {
		return LocalDateTime.now().isAfter(this.expiration);
	}
}
