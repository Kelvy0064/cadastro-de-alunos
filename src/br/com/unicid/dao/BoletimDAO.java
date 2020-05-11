package br.com.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.unicid.model.Boletim;
import br.com.unicid.util.ConnectionFactory;

public class BoletimDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public BoletimDAO() {
		try {
			conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void salvar(Boletim boletim) {
		try {
			String sql = "INSERT INTO boletim(idCurso, faltas, nota, idDiciplina, semestre, aluno) VALUES(?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boletim.getIdCurso());
			ps.setInt(2, boletim.getFaltas());
			ps.setFloat(3, boletim.getNotas());
			ps.setInt(4, boletim.getIdDiciplina());
			ps.setString(5, boletim.getSemestre());
			ps.setInt(6, boletim.getRgm());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
