package br.com.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

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

	public void salvar(Diciplina diciplina) {
		try {
			String sql = "INSERT INTO diciplina(nome) VALUE(?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, diciplina.getNome());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getIdDiciplina() {
		int resultado = 0;
		try {
			String sql = "SELECT id FROM diciplina LIMIT 1";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			resultado = rs.getInt("id");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return resultado;
	}
}
