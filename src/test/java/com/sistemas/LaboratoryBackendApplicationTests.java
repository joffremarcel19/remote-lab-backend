package com.sistemas;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.laboratory.repo.IUserRepo;


@SpringBootTest
class LaboratoryBackendApplicationTests {

		
	@Autowired
	private IUserRepo repo;

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Test
	void verificarClave() {
		/*Usuario us = new Usuario();		
		us.setUsername("0703806307");
		us.setPassword(bcrypt.encode("123"));				
		us.setEnabled(true);
		Empresa em = new Empresa();
		em.setIdEmpresa(1);
		us.setEmpresa(em);
		Usuario retorno = repo.save(us);
		
		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));*/
	}

}
