package com.laboratory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboratory.model.ResetToken;
import com.laboratory.repo.IGenericRepo;
import com.laboratory.repo.IResetTokenRepo;
import com.laboratory.service.IResetTokenService;

@Service
public class ResetTokenServiceImpl extends CRUDImpl<ResetToken, Integer> implements IResetTokenService {
	
	@Autowired
	private IResetTokenRepo repo;

	@Override
	protected IGenericRepo<ResetToken, Integer> getRepo() {
	
		return repo;
	}

	@Override
	public ResetToken findByToken(String token) {
		// TODO Auto-generated method stub
		return repo.findByToken(token);
	}

	@Override
	public void guardar(ResetToken token) {
		repo.save(token);		
	}

	@Override
	public void eliminar(ResetToken token) {
		repo.delete(token);
		
	}
	
}
