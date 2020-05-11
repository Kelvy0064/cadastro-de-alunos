package br.com.unicid.model;

public class Boletim {
	private int idCurso;
	private int faltas;
	private float notas;
	private int idDiciplina;
	private String semestre;
	private int rgm;
	
	public Boletim(int idCurso, int faltas, float notas, int idDiciplina, String semestre, int rgm) {
		this.idCurso = idCurso;
		this.faltas = faltas;
		this.notas = notas;
		this.idDiciplina = idDiciplina;
		this.semestre = semestre;
		this.rgm = rgm;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public int getFaltas() {
		return faltas;
	}

	public float getNotas() {
		return notas;
	}

	public int getIdDiciplina() {
		return idDiciplina;
	}
	
	public String getSemestre() {
		return semestre;
	}

	public int getRgm() {
		return rgm;
	}
}
