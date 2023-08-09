package com.laboratory.repo;

import com.laboratory.model.Users;

public interface IUserRepo extends IGenericRepo<Users, Integer>  {

	//select * from usuario where username = ?
	Users findOneByUsername(String username);	
}
