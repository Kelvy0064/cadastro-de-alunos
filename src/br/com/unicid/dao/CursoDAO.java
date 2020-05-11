package br.com.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.unicid.model.Curso;
import br.com.unicid.model.Periodo;
import br.com.unicid.util.ConnectionFactory;

public class CursoDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public CursoDAO() throws Exception {
		try {
			conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("Erro" + e.getMessage());
		}
	}

	public Integer salvar(Curso curso) {
		Integer id = null;
		try {
			String sql = "INSERT INTO cursos(nome) VALUE(?)";
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, curso.getNome());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Integer findCursoByName(String curso) {
		Integer resposta = null;
		String sql = "SELECT id FROM cursos WHERE nome = "+"\"" +curso+"\"";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs != null && rs.next()){
                resposta = rs.getInt("id");
            }
			return resposta;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<String> getCursos() {
		ArrayList<String> cursos = new ArrayList<String>();
		String sql = "SELECT nome FROM cursos";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				cursos.add(rs.getString("nome"));
			}
			return cursos;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getNameCursoById(int idCurso) {
		String resposta = null;
		String sql = "SELECT nome FROM cursos WHERE id = "+idCurso;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs != null && rs.next()){
                resposta = rs.getString("nome");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}
}
