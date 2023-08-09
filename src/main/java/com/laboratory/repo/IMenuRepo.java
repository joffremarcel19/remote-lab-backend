package com.laboratory.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.laboratory.model.Menu;




public interface IMenuRepo extends IGenericRepo<Menu, Integer>{

	@Query(value="select m.* from menu_rol mr \r\n"
			+ "			inner join user_role ur on ur.id_role = mr.id_role\r\n"
			+ "			inner join menu m on m.id_menu = mr.id_menu\r\n"
			+ "			inner join users u on u.id_user = ur.id_user where u.username=:nombre", nativeQuery = true)
	List<Menu> listarMenuPorUsuario(@Param("nombre") String nombre);
	
}
