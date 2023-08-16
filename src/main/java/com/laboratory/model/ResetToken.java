package com.laboratory.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
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
