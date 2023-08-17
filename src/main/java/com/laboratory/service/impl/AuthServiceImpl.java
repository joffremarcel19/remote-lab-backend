package com.laboratory.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl {
	//LoginServiceImpl serviceLogin = new LoginServiceImpl();
	//@Autowired
	//private ILoginService service;

	public boolean tieneAcceso(String path) {
		
		boolean rpta = false;
		
		
		String metodoRol = "";
		switch (path) {
		case "listar":
				metodoRol = "ADMIN,USER,consulta";
			break;		
		case "listarId":
				metodoRol = "ADMIN,USER,DBA";
			break;
		case "eliminar":
			metodoRol="ADMIN";
			break;
		case "editar":
			metodoRol="ADMIN";
			break;
		}
		
		System.out.println(metodoRol);
		String metodoRoles[] = metodoRol.split(",");
		
		Authentication usuarioLogueado = SecurityContextHolder.getContext().getAuthentication();
		
		for(GrantedAuthority auth : usuarioLogueado.getAuthorities()) {
			String rolUser = auth.getAuthority();
			System.out.println(rolUser);
			
			for(String rolMet : metodoRoles) {
				System.out.println(rolMet);
				if(rolUser.equalsIgnoreCase(rolMet)) {
					rpta = true;
				}
			}
		}
		return rpta;
	}
}
