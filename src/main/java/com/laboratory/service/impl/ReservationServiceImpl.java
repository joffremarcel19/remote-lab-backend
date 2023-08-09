package com.laboratory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboratory.model.Reservation;
import com.laboratory.repo.IGenericRepo;
import com.laboratory.repo.IReservationRepo;
import com.laboratory.service.IReservationService;


@Service
public class ReservationServiceImpl extends CRUDImpl<Reservation, Integer> implements IReservationService{

	@Autowired
	private IReservationRepo repo;

	@Override
	protected IGenericRepo<Reservation, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

	
	


}
