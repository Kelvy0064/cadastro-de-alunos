package br.com.unicid.controller;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.unicid.dao.AlunoDAO;
import br.com.unicid.dao.CursoDAO;
import br.com.unicid.dao.CursoDiciplinaDAO;
import br.com.unicid.dao.DiciplinaDAO;
import br.com.unicid.model.Aluno;
import br.com.unicid.model.Curso;
import br.com.unicid.model.CursoDiciplina;
import br.com.unicid.model.Diciplina;
import br.com.unicid.view.Views;

public class Principal {
	private CursoDAO cursoDAO;
	private AlunoDAO alunoDAO;
	private DiciplinaDAO diciplinaDAO;
	private CursoDiciplinaDAO cursoDiciplinaDAO;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Views frame = new Views();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void salvarCurso(String nomeCurso) {
		Curso curso = new Curso(nomeCurso);
		try {
			cursoDAO = new CursoDAO();
			cursoDAO.salvar(curso);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void salvaDiciplina(ArrayList<String> diciplinasSelecionadas) {
		diciplinaDAO = new DiciplinaDAO();
		for (String nomeDiciplina : diciplinasSelecionadas) {
			Diciplina diciplina = new Diciplina(nomeDiciplina);
			diciplinaDAO.salvar(diciplina);
		}
	}

	public void update() {
		cursoDAO.getCursos();
		try {
			Views views = new Views();
			views.setVisible(false);
			views.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void salvaAluno(Aluno alunoRecebido) {
		try {
			Aluno alunoExistente;
			alunoDAO = new AlunoDAO();
			alunoExistente = alunoDAO.buscaAluno(alunoRecebido.getRgm());
			if (alunoExistente != null && alunoExistente.getRgm() == alunoRecebido.getRgm()) {
				JOptionPane.showMessageDialog(null, "O rgm inserido já está cadastrado!");
				return;
			}
			alunoDAO.salvar(alunoRecebido);
			JOptionPane.showMessageDialog(null, "Aluno inserido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void salvaCursoDiciplina(String curso, List<String> diciplinasSelecionadas) {
		cursoDiciplinaDAO = new CursoDiciplinaDAO();
		for (String diciplina : diciplinasSelecionadas) {
			CursoDiciplina cursoDiciplina = new CursoDiciplina(cursoDAO.findCursoByName(curso),
			diciplinaDAO.findCursoDiciplinaByName(diciplina));
			cursoDiciplinaDAO.salvar(cursoDiciplina);
		}
	}

	public Aluno getAlunoByRgm(Integer rgm) {
		try {
			alunoDAO = new AlunoDAO();
			return alunoDAO.buscaAluno(rgm);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void alteraAluno(Aluno aluno, int rgm) {
		alunoDAO.alteraAluno(aluno, rgm);		
	}

	public String getNameCursoById(int idCurso) {
		return cursoDAO.getNameCursoById(idCurso);
	}
}
