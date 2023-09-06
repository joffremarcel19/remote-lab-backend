package com.laboratory;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.laboratory.model.School;
import com.laboratory.model.Users;
import com.laboratory.repo.IUserRepo;


@SpringBootTest
class LaboratoryBackendApplicationTests {
	/*
		
	@Autowired
	private IUserRepo repo;

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Test
	void verificarClave() {
		/*Users us = new Users();		
		us.setUsername("0703806307");
		us.setPassword(bcrypt.encode("123"));				
		us.setState(true);
		us.setEmail("joffremarcel19@gmail.com");
		us.setFirstnames("Joffre");
		us.setLastnames("Farias");
		Faculty em = new Faculty();
		em.setIdFaculty(1);
		us.setFaculty(em);
		Users retorno = repo.save(us);
		
		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));*/
	//}

}
