package com.stefanini.servico;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;

import com.stefanini.dao.PerfilDao;
import com.stefanini.model.Perfil;
import com.stefanini.util.IGenericService;

public class PerfilServico implements IGenericService<Perfil, Long> {

	@Inject
	private PerfilDao dao;
	
	@Override
	public Optional<Perfil>  salvar(Perfil entity) {
		return dao.salvar(entity);
	}

	@Override
	public Optional<Perfil> atualizar(Perfil entity) {
		return dao.atualizar(entity);
	}

	@Override
	public void remover(@Valid Long id) {
		dao.remover(id);
	}

	@Override
	public Optional<List<Perfil>> getList() {
		return dao.getList();
	}

	@Override
	public Optional<Perfil> encontrar(Long id) {
		return dao.encontrar(id);
	}

}
