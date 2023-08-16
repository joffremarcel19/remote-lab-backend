package com.laboratory.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUser;
	@Column(name="username", nullable=false, length=90)
	private String username;
	@Column(name="password", nullable=false, length=90)
	private String password;
	@Column(name="firstnames", nullable=false, length=90)
	private String firstnames;
	@Column(name="lastnames", nullable=false, length=90)
	private String lastnames;
	@Column(name="email", nullable=false, length=40)
	private String email;
	@Column(name="cellphone", length=10)
	private String cellphone;
	@Column(name="state")
	private boolean state;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", 
		joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "idUser"), 
		inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "idRole"))
	private List<Role> roles;
	
	@ManyToOne
	@JoinColumn(name = "idFaculty", nullable = false, foreignKey = @ForeignKey(name = "FK_user_faculty"))
	private Faculty faculty;
		
}
