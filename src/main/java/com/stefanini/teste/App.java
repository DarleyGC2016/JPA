package com.stefanini.teste;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

import com.stefanini.model.Endereco;
import com.stefanini.model.Perfil;
import com.stefanini.model.Pessoa;
import com.stefanini.servico.EnderecoServico;
import com.stefanini.servico.PerfilServico;
import com.stefanini.servico.PessoaServico;

public class App {

	@Inject
	private PessoaServico servico;
	
	@Inject 
	private EnderecoServico es;
	
	@Inject 
	private PerfilServico ps;
	
	public static void main(String[] args) {
		// CONFIGURACAO PARA INICIAR O CONTAINER PARA GERENCIAMENTO DO CDI
		SeContainerInitializer initializer = SeContainerInitializer.newInstance();
		try (final SeContainer container = initializer.initialize()) {
			App app = container.select(App.class).get();
			app.executar();
		}
	}

	public void executar() {
		/** Pessoa
		 	buscarTodos();
			encontrar();
			remover();
			atualizarPessoa();
		*/
		
    	/**
    	 * Em comum
    	 * salvar();
    	 */
		
		/** Endereço
		  atualizarEndereco();
		  listaEndereco();
		  encontrarIdEndereco();
		*/
		/** Perfil 
		  listaPerfil();
		   encontrarIdPerfil();
		  removerPerfil();
		  atualizarPerfil();
		 */
		
	}
	
	
	public void remover() {
		servico.remover(7L);
	}

	public void removerEndereco() {	
		es.remover(1L);
	}
	
	public void removerPerfil() {
			ps.remover(8L);
	}
	
	public void encontrar() {
		Optional<Pessoa> pessoa = servico.encontrar(7L);
		if (pessoa.isPresent()) {
			System.out.println("Pessoa encontrada");
			System.out.println(pessoa.get());
		} else {
			System.out.println("Pessoa não encontrada");
		}
	}
	
	public void encontrarIdPerfil() {
		Optional<Perfil> perfil = ps.encontrar(1L);
		
		if(perfil.isPresent()) {
			System.out.println(perfil.get());
		}else {
			System.out.println("Não foi encontrado nenhum perfil!!");
		}
		
	}
	
	
	public void encontrarIdEndereco() {
		Optional<Endereco> end = es.encontrar(1L);
		
		if(end.isPresent()) {
			System.out.println(end.get());
		}else {
			System.out.println("Não foi encontrado nenhum endereço!!");
		}
	}
	
	public void buscarTodos() {
		servico.getList().ifPresent(pessoas -> {
			pessoas.forEach(pessoa -> {
				System.out.println(pessoa);
			});
		});
	}

	public void salvar() {
		Timestamp incluir = Timestamp.valueOf(LocalDateTime.of(2020, 03, 07, 9, 30));
		Timestamp alterar = Timestamp.valueOf(LocalDateTime.of(2020, 03, 07, 17, 30));
		
	    Perfil perfil = new Perfil( "Eduarda", "Twitter", incluir, alterar);
	    ps.salvar(perfil);
		List<Perfil> perfils = new ArrayList<Perfil>();     
	    perfils.add(ps.salvar(perfil).get());
	    
		Pessoa pessoa = new Pessoa("Eduarda Maria", "eduardam@gmail.com", LocalDate.of(1986, 4, 12), Boolean.TRUE);
	
		Endereco endereco = new Endereco("Qa", "25 conj.F Casa 1", "Tijuca", "Ventões", "PA", "148811001");
        endereco.setPessoa(pessoa);
        pessoa.setPerfils(perfils);
        servico.salvar(pessoa);
        es.salvar(endereco);
	}
	
	public void atualizarPerfil() {
		Timestamp incluir = Timestamp.valueOf(LocalDateTime.of(2020, 03, 07, 9, 30));
		Timestamp alterar = Timestamp.valueOf(LocalDateTime.of(2020, 03, 07, 17, 30));
		
	    Perfil perfil = new Perfil(1L, "Eduarda Maria", "Twitter", incluir, alterar);
	    
	    ps.atualizar(perfil);
	}
	
	public void atualizarEndereco() {
		Endereco endereco = new Endereco(6L,
										8L,
										"Qi", 
										"25 conj.F Casa 1",
										"Asa norte", 
										"Brasilia", 
										"df", 
										"22200110");
		es.atualizar(endereco);
	}
	public void atualizarPessoa() {
		Pessoa pessoa = new Pessoa(
									1L,
									"Eduarda",
									"eduardam@gmail.com",
									LocalDate.of(1996, 4, 12),
									Boolean.FALSE
									);
		servico.atualizar(pessoa);
	}
	
	public void listaEndereco() {
		es.getList().ifPresent(enderecos ->{
			enderecos.forEach(end ->System.out.println(end));
		});
	}
    
	public void listaPerfil() {
		ps.getList().ifPresent(perfils->{
			perfils.forEach(perfil->System.out.println(perfil));
		});
	}
}
