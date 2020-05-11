package br.com.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.unicid.model.Periodo;
import br.com.unicid.util.ConnectionFactory;

public class PeriodoDAO {
	private Connection conn;
	private PreparedStatement ps;

	public PeriodoDAO() {
		try {
			conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void salvar(Periodo periodo) {
		try {
			String sql = "INSERT INTO periodos(periodo) VALUE(?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, periodo.getPeriodo());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
