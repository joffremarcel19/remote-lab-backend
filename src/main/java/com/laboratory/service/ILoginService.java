package com.laboratory.service;

import com.laboratory.model.Users;

public interface ILoginService {
	Users verificarNombreUsuario(String usuario);
	void CambiarClave(String clave, String nombre);
}
