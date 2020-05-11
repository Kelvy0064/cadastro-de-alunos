package br.com.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.unicid.model.Curso;
import br.com.unicid.model.Diciplina;
import br.com.unicid.util.ConnectionFactory;

public class DiciplinaDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public DiciplinaDAO() {
		try {
			conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Integer salvar(Diciplina diciplina) {
		Integer id = null;
		try {
			String sql = "INSERT INTO diciplina(nome) VALUE(?)";
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, diciplina.getNome());
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
	
	public Integer findCursoDiciplinaByName(String diciplina) {
		Integer resposta = null;
		String sql = "SELECT id FROM diciplina WHERE nome = "+"\"" +diciplina+"\"";
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
}
