package br.com.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.unicid.model.Aluno;
import br.com.unicid.util.ConnectionFactory;

public class AlunoDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public AlunoDAO() throws Exception {
		try {
			conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("Erro"+ e.getMessage());
		}
	}
	
	public void salvar(Aluno aluno) throws Exception {
		try {
			String sql = "INSERT INTO aluno(nomeAluno, rgm, dataNascimento, cpf, email, endereco, municipio, uf, celular, idCurso, idPeriodo, idCampus)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, aluno.getNome());
			ps.setInt(2, aluno.getRgm());
			ps.setString(3, aluno.getDataNascimento());
			ps.setString(4, aluno.getCpf());
			ps.setString(5, aluno.getEmail());
			ps.setString(6, aluno.getEndereco());
			ps.setString(7, aluno.getMunicipio());
			ps.setString(8, aluno.getUf());
			ps.setString(9, aluno.getCelular());
			ps.setInt(10, aluno.getIdCurso());
			ps.setString(11, aluno.getPeriodo());
			ps.setString(12, aluno.getCampus());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro"+ e.getMessage());
		}
	}
	
	public Aluno buscaAluno(int rgm) throws SQLException {
		
		ps = conn.prepareStatement("SELECT * FROM aluno WHERE rgm="+rgm);
		rs = ps.executeQuery();
		if(rs.next()){
		return new Aluno(rs.getString("nomeAluno"),
				rs.getInt("rgm"),
				rs.getString("dataNascimento"),
				rs.getString("cpf"),
				rs.getString("email"),
				rs.getString("endereco"),
				rs.getString("municipio"),
				rs.getString("uf"),
				rs.getString("celular"),
				rs.getInt("idCurso"),
				rs.getString("idPeriodo"),
				rs.getString("idCampus"));
		}
		return null;
	}

	public void alteraAluno(Aluno aluno, int rgm) {
		String sql = "UPDATE `aluno` SET `nomeAluno` = \"" + aluno.getNome() + "\", `rgm` = " + aluno.getRgm() +
				", `dataNascimento` = \"" + aluno.getDataNascimento() + "\", `cpf` = \"" + aluno.getCpf() +
				"\", `email` = \"" + aluno.getEmail() + "\", `endereco` = \"" + aluno.getEndereco() +
				"\", `municipio` = \"" + aluno.getMunicipio() + "\", `uf` = \"" + aluno.getUf() +
				"\", `celular` = \"" + aluno.getCelular() + "\", `idCurso` = \"" + aluno.getIdCurso() +
				"\", `idPeriodo` = \"" + aluno.getPeriodo() + "\", `idCampus` = \"" + aluno.getCampus() +
				"\" WHERE `rgm` = " + rgm;
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}