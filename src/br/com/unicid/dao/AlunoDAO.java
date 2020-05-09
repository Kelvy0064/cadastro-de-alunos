package br.com.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.unicid.model.Aluno;
import br.com.unicid.model.Curso;
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
			String sql = "INSERT INTO aluno(nome, rgm, dataNascimento, cpf, email, endereco, municipio, uf, celular, idCurso)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, aluno.getNome());
			ps.setInt(2, aluno.getRgm());
			ps.setDate(3, aluno.getDataNascimento());
			ps.setString(4, aluno.getCpf());
			ps.setString(5, aluno.getEmail());
			ps.setString(6, aluno.getEndereco());
			ps.setString(7, aluno.getMunicipio());
			ps.setString(8, aluno.getUf());
			ps.setString(9, aluno.getCelular());
			ps.setInt(10, 9);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro"+ e.getMessage());
		}
	}
	
	public List<String> buscaAluno(int rgm) throws SQLException {
		ArrayList<String> dadosAluno = new ArrayList<String>();
		ps = conn.prepareStatement("SELECT nome FROM aluno WHERE rgm="+rgm);
		rs = ps.executeQuery();
		String  nomeAluno = rs.getString("nome");
		//String nomeCurso = rs.getString("nomeCurso");
		dadosAluno.add(nomeAluno);
		//dadosAluno.add(nomeCurso);
		return dadosAluno;
		
	}
	
}

