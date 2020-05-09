package br.com.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.unicid.model.Campus;
import br.com.unicid.util.ConnectionFactory;

public class CampusDAO {
	private Connection conn;
	private PreparedStatement ps;

	public CampusDAO() {
		try {
			conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void salvar(Campus campus) {
		try {
			String sql = "INSERT INTO campus(campus) VALUE(?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, campus.getCampus());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
