package com.stefanini.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author joaopedromilhome
 *
 */
@Entity
@Table(name = "TB_PESSOA")
public class Pessoa implements Serializable{

	
	/**
	 * Serializacao da Classe
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ID da Tabela
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CO_SEQ_PESSOA")
	private Long co_seq_pessoa;
	/**
	 * Nome da pessoa
	 */
	@NotNull
	@Column(name = "NO_NOME")
	private String nome;
	
	/**
	 * Email da Pessoa
	 */
	@NotNull
	@Column(name = "DS_EMAIL")
	private String email;
	/**
	 * Data de Nascimento 
	 */
	@NotNull
	@Column(name = "DT_NASCIMENTO")
	private LocalDate dataNascimento; 
	/**
	 * Situacao da Pessoa
	 */
	@NotNull
	@Column(name = "ST_PESSOA")
	private Boolean situacao;
	
	
	@OneToMany(mappedBy = "pessoa")
	private List<Endereco> enderecos;
	
	@ManyToMany
	@JoinTable(name = "TB_PESSOA_PERFIL",
	          joinColumns = @JoinColumn(name="CO_SEQ_PESSOA"),
	          inverseJoinColumns = @JoinColumn(name="CO_SEQ_PERFIL")
			)
	private List<Perfil> perfils;

	/**
	 * Metodo construtor da classe
	 */
	public Pessoa() {
	}

	

	/**
	 * Construtor da Classe, Obrigando receber todos os parametros
	 * @param nome
	 * @param email
	 * @param dataNascimento
	 * @param situacao
	 */
	public Pessoa(@NotNull String nome, @NotNull String email, @NotNull LocalDate dataNascimento,@NotNull Boolean situacao) {
		super();
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.situacao = situacao;
	}

	
	public Pessoa(Long co_seq_pessoa, @NotNull String nome, @NotNull String email, @NotNull LocalDate dataNascimento,@NotNull Boolean situacao) {
		super();
		this.co_seq_pessoa = co_seq_pessoa;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.situacao = situacao;
	}


	public Long getCo_seq_pessoa() {
		return co_seq_pessoa;
	}

	public void setCo_seq_pessoa(Long co_seq_pessoa) {
		this.co_seq_pessoa = co_seq_pessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Perfil> getPerfils() {
		return perfils;
	}

	public void setPerfils(List<Perfil> perfils) {
		this.perfils = perfils;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n id: ");
		builder.append(getCo_seq_pessoa());
		builder.append("\n Nome: ");
		builder.append(getNome());
		builder.append("\n E-mail: ");
		builder.append(getEmail());
		builder.append("\n Datade Nascimento: ");
		builder.append(getDataNascimento());
		builder.append("\n Situacao: ");
		builder.append(getSituacao());
		return builder.toString();
	}



    
}
