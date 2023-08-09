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
@Table(name = "submenu")
public class Submenu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSubmenu;
	
	@Column(name = "submenuName", length = 100, nullable = false)
	private String submenuName;
	@Column(name = "url", length = 100)
	private String url;
	@Column(name = "icon", length = 50)
	private String icon;

	@ManyToOne
	@JoinColumn(name = "id_menu", nullable = false, foreignKey =@ForeignKey(name = "FK_submenu_menu"))
	private Menu menu;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "submenu_rol", joinColumns = @JoinColumn(name = "id_submenu", referencedColumnName = "idSubmenu"), inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "idRole"))
	private List<Role> roles;


	public Integer getIdSubmenu() {
		return idSubmenu;
	}


	public void setIdSubmenu(Integer idSubmenu) {
		this.idSubmenu = idSubmenu;
	}


	public String getSubmenuName() {
		return submenuName;
	}


	public void setSubmenuName(String submenuName) {
		this.submenuName = submenuName;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getIcon() {
		return icon;
	}


	public void setIcon(String icon) {
		this.icon = icon;
	}


	public Menu getMenu() {
		return menu;
	}


	public void setMenu(Menu menu) {
		this.menu = menu;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}	
	
}
