package br.com.unicid.model;

import java.sql.ResultSet;

public class CursoDiciplina {
	private int idCurso;
	private int idDiciplina;

	public CursoDiciplina(int idCurso, int idDiciplina) {
		this.idCurso = idCurso;
		this.idDiciplina = idDiciplina;

	}

	public int getIdCurso() {
		return idCurso;
	}

	public int getIdDiciplina() {
		return idDiciplina;
	}
}