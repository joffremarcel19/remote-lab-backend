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
	@Column(name="names", nullable=false, length=90)
	private String names;
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

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLastnames() {
		return lastnames;
	}

	public void setLastnames(String lastnames) {
		this.lastnames = lastnames;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
		
}
