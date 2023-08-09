package com.laboratory.service;

import java.util.List;

import com.laboratory.model.Submenu;



public interface ISubMenuService extends ICRUD<Submenu, Integer>{
	List<Submenu> listarSubmenuPorUsuario(String nombre, Integer idMenu);

}
