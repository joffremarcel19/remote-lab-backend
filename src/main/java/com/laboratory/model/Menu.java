package com.laboratory.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMenu;
	@Column(name="nameMenu", nullable=false, length=20)
	private String nameMenu;
	@Column(name="icon",nullable=false, length=20)
	private String icon;
	@Column(name="url",nullable=false,length=20)
	private String url;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "menu_rol", joinColumns =@JoinColumn(name = "id_menu", referencedColumnName = "idMenu"), inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "idRole"))
	private List<Role> roles;
	
	public Integer getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}
	public String getNameMenu() {
		return nameMenu;
	}
	public void setNameMenu(String nameMenu) {
		this.nameMenu = nameMenu;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
}
