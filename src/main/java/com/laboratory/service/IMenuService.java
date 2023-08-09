package com.laboratory.service;

import java.util.List;

import com.laboratory.model.Menu;


public interface IMenuService extends ICRUD<Menu, Integer>{
	
	List<Menu> listarMenuPorUsuario(String nombre);
	

}
