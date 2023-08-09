package com.laboratory.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.laboratory.model.Users;


public interface ILoginRepo extends IGenericRepo<Users, Integer> {
	@Query("FROM Users us where us.username =:usuario")
	Users verificarNombreUsuario(@Param("usuario") String usuario);

	@Transactional
	@Modifying
	@Query("UPDATE Users us SET us.password =:clave WHERE us.username=:nombre")
	void cambiarClave(@Param("clave") String clave, @Param("nombre") String nombre);
}
