package com.laboratory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboratory.model.ReservationState;
import com.laboratory.repo.IGenericRepo;
import com.laboratory.repo.IReservationStateRepo;
import com.laboratory.service.IReservationStateService;


@Service
public class ReservationStateServiceImpl extends CRUDImpl<ReservationState, Integer> implements IReservationStateService{

	@Autowired
	private IReservationStateRepo repo;

	@Override
	protected IGenericRepo<ReservationState, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

	
	


}
