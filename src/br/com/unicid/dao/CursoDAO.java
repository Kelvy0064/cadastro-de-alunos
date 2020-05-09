package br.com.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.unicid.model.Curso;
import br.com.unicid.util.ConnectionFactory;

public class CursoDAO {
	private Connection conn;
	private PreparedStatement ps;

	public CursoDAO() throws Exception {
		try {
			conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("Erro" + e.getMessage());
		}
	}

	public void salvar(Curso curso) {
		try {
			String sql = "INSERT INTO cursos(nome) VALUE(?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, curso.getNome());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
