package com.laboratory.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.laboratory.model.Submenu;


public interface ISubMenuRepo extends IGenericRepo<Submenu, Integer>{
	
	@Query(value="select s.* from menu_rol mr "
			 +"inner join usuario_rol ur on ur.id_rol = mr.id_rol "	 
			 +"inner join menu m on m.id_menu = mr.id_menu "			 	 
			 +"inner join submenu s on m.id_menu=s.id_menu "			 
			 +"inner join usuario u on u.id_usuario = ur.id_usuario where u.nombre = :nombre and s.id_menu=:idMenu", nativeQuery=true)
			List<Submenu> listarSubMenuPorUsuario(@Param("nombre") String nombre, @Param("idMenu") Integer idMenu );

}
