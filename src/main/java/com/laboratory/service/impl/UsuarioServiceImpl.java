package com.laboratory.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.laboratory.model.Users;
import com.laboratory.repo.IGenericRepo;
import com.laboratory.repo.IUserRepo;
import com.laboratory.service.IUsuarioService;

import org.springframework.security.core.userdetails.User;

@Service
public class UsuarioServiceImpl extends CRUDImpl<Users, Integer> implements UserDetailsService, IUsuarioService{

	@Autowired
	private IUserRepo repo;	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	 //System.out.print(username);
		//Usuario usuario = repo.findOneByUsername(username);
		
		Users user=repo.findOneByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe", username));
		}
		
		List<GrantedAuthority> roles = new ArrayList<>();
		
		user.getRoles().forEach(rol -> {
			roles.add(new SimpleGrantedAuthority(rol.getNameRole()));
		});
		
		UserDetails ud = new User(user.getUsername(), user.getPassword(), roles);
		
		return ud;
	}

	@Override
	protected IGenericRepo<Users, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

}
