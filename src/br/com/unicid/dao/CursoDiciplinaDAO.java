package br.com.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.unicid.model.CursoDiciplina;
import br.com.unicid.util.ConnectionFactory;

public class CursoDiciplinaDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public CursoDiciplinaDAO() {
		try {
			conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void salvar(CursoDiciplina cursoDiciplina) {
		try {
			String sql = "INSERT INTO curso_diciplina(idCurso, idDiciplina) VALUES(?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, cursoDiciplina.getIdCurso());
			ps.setObject(2, cursoDiciplina.getIdDiciplina());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
