package com.laboratory.service.impl;

import java.util.List;

import com.laboratory.repo.IGenericRepo;
import com.laboratory.service.ICRUD;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

	//permite crear un Repo generico para poder invocar los metodos debe ser abstracto.
	protected abstract IGenericRepo<T, ID> getRepo();

	@Override
	public T registrar(T t) throws Exception {

		return getRepo().save(t);
	}

	@Override
	public T modificar(T t) throws Exception {

		return getRepo().save(t);
	}

	@Override
	public List<T> listar() throws Exception {

		return getRepo().findAll();
	}

	@Override
	public T listarPorId(ID id) throws Exception {
			return getRepo().findById(id).orElse(null);
	}

	@Override
	public void eliminar(ID id) throws Exception {
		getRepo().deleteById(id);
	}

}
