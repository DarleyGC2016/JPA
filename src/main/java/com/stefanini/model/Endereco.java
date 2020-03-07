package com.stefanini.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Darley43t
 *
 */
@Entity
@Table(name = "TB_ENDERECO")
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long co_seq_endereco;

	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "CO_SEQ_PESSOA")
	private Pessoa pessoa;
	@NotNull
	@Column(name = "DS_LOGRADOURO")
	private String logradouro;
	
	@NotNull
	@Column(name = "DS_COMPLEMENTO")
	private String complemento;
	
	@NotNull
	@Column(name = "DS_BAIRRO")
	private String bairro;
	
	@NotNull
	@Column(name = "DS_CIDADE")
	private String cidade;
	
	@NotNull
	@Column(name = "CO_UF")
	private String uf;
	
	@NotNull
	@Column(name = "DS_CEP")
	private String cep;

	public Endereco() {
		super();
	}

	public Endereco(@NotNull String logradouro, @NotNull String complemento, @NotNull String bairro,
			@NotNull String cidade, @NotNull String uf, @NotNull String cep) {
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}


	public Endereco(Long co_seq_endereco,Long idPessoa, @NotNull String logradouro, @NotNull String complemento,
			@NotNull String bairro, @NotNull String cidade, @NotNull String uf, @NotNull String cep) {
		this.co_seq_endereco = co_seq_endereco;
		this.pessoa = new Pessoa();
		getPessoa().setCo_seq_pessoa(idPessoa);
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}

	public Long getCo_seq_endereco() {
		return co_seq_endereco;
	}

	public void setCo_seq_endereco(Long co_seq_endereco) {
		this.co_seq_endereco = co_seq_endereco;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((co_seq_endereco == null) ? 0 : co_seq_endereco.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (co_seq_endereco == null) {
			if (other.co_seq_endereco != null)
				return false;
		} else if (!co_seq_endereco.equals(other.co_seq_endereco))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n Id: ");
		builder.append(getCo_seq_endereco());
		builder.append("\n Logradouro: ");
		builder.append(getLogradouro());
		builder.append("\n Complemento: ");
		builder.append(getComplemento());
		builder.append("\n Bairro: ");
		builder.append(getBairro());
		builder.append("\n Cidade: ");
		builder.append(getCidade());
		builder.append("\n Uf: ");
		builder.append(getUf());
		builder.append("\n Cep: ");
		builder.append(getCep());
		return builder.toString();
	}
	
	

	
}
