package com.stefanini.servico;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;

import com.stefanini.dao.EnderecoDao;
import com.stefanini.model.Endereco;
import com.stefanini.util.IGenericService;

public class EnderecoServico implements IGenericService<Endereco, Long> {
   
	@Inject
	private EnderecoDao dao;
	
	@Override
	public Optional<Endereco> salvar(@Valid Endereco entity) {
		
		return dao.salvar(entity);
	}

	@Override
	public Optional<Endereco> atualizar(@Valid Endereco entity) {
		
		return dao.atualizar(entity);
	}

	@Override
	public void remover(@Valid Long id) {
	  
       dao.remover(id);
	}

	@Override
	public Optional<List<Endereco>> getList() {
		return dao.getList();
	}

	@Override
	public Optional<Endereco> encontrar(Long id) {
		return dao.encontrar(id);
	}

}
