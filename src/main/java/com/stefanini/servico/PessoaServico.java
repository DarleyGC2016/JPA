package com.stefanini.servico;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;

import com.stefanini.dao.PessoaDao;
import com.stefanini.model.Pessoa;
import com.stefanini.util.IGenericService;

/**
 * 
 * Classe de servico, as regras de negocio devem estar nessa classe
 * @author joaopedromilhome
 *
 */
public class PessoaServico implements IGenericService<Pessoa, Long> {
	
	@Inject
	private PessoaDao dao;
	
	
	/**
	 * Salvar os dados de uma Pessoa
	 */
	
	@Override
	public Optional<Pessoa> salvar(@Valid Pessoa entity) {
		// TODO Auto-generated method stub
		return dao.salvar(entity);
	}
	

	/**
	 * Atualizar o dados de uma pessoa
	 */
	@Override
	public Optional<Pessoa> atualizar(@Valid Pessoa entity) {
		return dao.atualizar(entity);
	}


	/**
	 * Remover uma pessoa pelo id
	 */
	@Override
	public void remover(@Valid Long id) {
		dao.remover(id);		
	}


	/**
	 * Buscar uma lista de Pessoa
	 */
	@Override
	public Optional<List<Pessoa>> getList() {
		return dao.getList();
	}


	/**
	 * Buscar uma Pessoa pelo ID
	 */
	@Override
	public Optional<Pessoa> encontrar(Long id) {
		return dao.encontrar(id);
	}

}
