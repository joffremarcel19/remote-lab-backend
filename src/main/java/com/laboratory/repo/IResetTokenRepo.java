package com.laboratory.repo;

import com.laboratory.model.ResetToken;

public interface IResetTokenRepo extends IGenericRepo<ResetToken, Integer> {
	
	ResetToken findByToken(String token);
}
