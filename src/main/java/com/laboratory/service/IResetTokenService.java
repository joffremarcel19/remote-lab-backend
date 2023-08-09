package com.laboratory.service;

import com.laboratory.model.ResetToken;

public interface IResetTokenService extends ICRUD<ResetToken, Integer> {
	ResetToken findByToken(String token);

	void guardar(ResetToken token);

	void eliminar(ResetToken token);
}
