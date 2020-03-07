package com.stefanini.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name =  "TB_PERFIL")
public class Perfil implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CO_SEQ_PERFIL")
	private Long id;
	
	@NotNull
	@Column(name = "NO_PERFIL")
	private String nome;
	
	@NotNull
	@Column(name = "DS_PERFIL")
	private String ds_perfil;
	
	@NotNull
	@Column(name = "DT_HORA_INCLUSAO")
	private Timestamp horaIncluir;
	
	@NotNull
	@Column(name = "DT_HORA_ALTERACAO")
	private Timestamp horaEditar;

	@ManyToMany(mappedBy = "perfils")
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	public Perfil() {
		super();
	}

	public Perfil(@NotNull String nome, @NotNull String ds_perfil, @NotNull Timestamp horaIncluir,
			@NotNull Timestamp horaEditar) {
		super();
		this.nome = nome;
		this.ds_perfil = ds_perfil;
		this.horaIncluir = horaIncluir;
		this.horaEditar = horaEditar;
	}
	
	public Perfil(Long id, @NotNull String nome, @NotNull String ds_perfil, @NotNull Timestamp horaIncluir,
			@NotNull Timestamp horaEditar) {
		this.id = id;
		this.nome = nome;
		this.ds_perfil = ds_perfil;
		this.horaIncluir = horaIncluir;
		this.horaEditar = horaEditar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDs_perfil() {
		return ds_perfil;
	}

	public void setDs_perfil(String ds_perfil) {
		this.ds_perfil = ds_perfil;
	}

	public Timestamp getHoraIncluir() {
		return horaIncluir;
	}

	public void setHoraIncluir(Timestamp horaIncluir) {
		this.horaIncluir = horaIncluir;
	}

	public Timestamp getHoraEditar() {
		return horaEditar;
	}

	public void setHoraEditar(Timestamp horaEditar) {
		this.horaEditar = horaEditar;
	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Perfil other = (Perfil) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n Id: ");
		builder.append(getId());
		builder.append("\n Perfil: ");
		builder.append(getNome());
		builder.append("\n Rede Social: ");
		builder.append(getDs_perfil());
		builder.append("\n Hora de Inclução: ");
		builder.append(getHoraIncluir());
		builder.append("\n HoraEditar: ");
		builder.append(getHoraEditar());
		return builder.toString();
	}



	
}
