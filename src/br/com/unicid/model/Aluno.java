package br.com.unicid.model;

import java.time.LocalDate;

public class Aluno {
	private String nome;
	private int rgm;
	private String dataNascimento;
	private String cpf;
	private String email;
	private String endereco;
	private String municipio;
	private String uf;
	private String celular;
	private int idCurso;
	private String periodo;
	private String campus;
	
	public Aluno(String nome, int rgm, String dataNascimento, String cpf, String email, String endereco, String municipio,
			String uf, String celular, int idCurso, String periodo, String campus) {
		this.nome = nome;
		this.rgm = rgm;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
		this.municipio = municipio;
		this.uf = uf;
		this.celular = celular;
		this.idCurso = idCurso;
		this.periodo = periodo;
		this.campus = campus;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getRgm() {
		return rgm;
	}

	public void setRgm(int rgm) {
		this.rgm = rgm;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public int getIdCurso() {
		return idCurso;
	}
	
	public String getPeriodo() {
		return periodo;
	}
	
	public String getCampus() {
		return campus;
	}
	
	
}
