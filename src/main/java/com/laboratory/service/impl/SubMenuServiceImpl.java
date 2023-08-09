package com.laboratory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboratory.model.Submenu;
import com.laboratory.repo.IGenericRepo;
import com.laboratory.repo.ISubMenuRepo;
import com.laboratory.service.ISubMenuService;


@Service
public class SubMenuServiceImpl extends CRUDImpl<Submenu, Integer> implements ISubMenuService{

	@Autowired
	private ISubMenuRepo repo;

	@Override
	protected IGenericRepo<Submenu, Integer> getRepo() {
		return repo;
	}
		
	@Override
	public List<Submenu> listarSubmenuPorUsuario(String nombre, Integer idMenu) {
		// TODO Auto-generated method stub
		return repo.listarSubMenuPorUsuario(nombre, idMenu);
	}
	

}
