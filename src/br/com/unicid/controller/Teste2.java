package br.com.unicid.controller;

import br.com.unicid.dao.DiciplinaDAO;
import br.com.unicid.model.Diciplina;

public class Teste2 {

	public static void main(String[] args) {
		Diciplina diciplina = new Diciplina("asdas");
		try {
			DiciplinaDAO diciplinaDAO = new DiciplinaDAO();
			diciplinaDAO.salvar(diciplina);
			System.out.println(diciplinaDAO.getIdDiciplina());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
