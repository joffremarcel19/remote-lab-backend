package com.laboratory.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.laboratory.model.Users;
import com.laboratory.repo.ILoginRepo;
import com.laboratory.service.ILoginService;


@Service
public class LoginServiceImpl implements ILoginService{

	@Override
	public Users verificarNombreUsuario(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void CambiarClave(String clave, String nombre) {
		// TODO Auto-generated method stub
		
	}
/*
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired
	private ILoginRepo repo;
	
	@Override
	public Users verificarNombreUsuario(String usuario) {
		// TODO Auto-generated method stub
		return repo.verificarNombreUsuario(usuario);
	}

	@Override
	public void CambiarClave(String clave, String nombre) {
		repo.cambiarClave(bcrypt.encode(clave), nombre);		
	}*/

}
