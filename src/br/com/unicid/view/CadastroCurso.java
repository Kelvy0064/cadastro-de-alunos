package br.com.unicid.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;

import br.com.unicid.controller.Principal;

public class CadastroCurso extends JFrame {

	private JPanel contentPane;
	private JTextField txtCadastrarNovoCurso;
	private Principal principal = new Principal();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public CadastroCurso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDoCurso = new JLabel("Nome do Curso");
		lblNomeDoCurso.setBounds(22, 49, 116, 15);
		contentPane.add(lblNomeDoCurso);
		
		txtCadastrarNovoCurso = new JTextField();
		txtCadastrarNovoCurso.setBounds(156, 39, 407, 36);
		contentPane.add(txtCadastrarNovoCurso);
		txtCadastrarNovoCurso.setColumns(10);
		
		JTree tree = new JTree();
		tree.setBounds(88, 159, -1, 21);
		contentPane.add(tree);
		
		JCheckBox chckbxPortugus = new JCheckBox("Português");
		chckbxPortugus.setBounds(434, 111, 129, 23);
		contentPane.add(chckbxPortugus);
		
		JCheckBox chckbxMtemtica = new JCheckBox("Matemática");
		chckbxMtemtica.setBounds(434, 157, 129, 23);
		contentPane.add(chckbxMtemtica);
		
		JCheckBox chckbxPoo = new JCheckBox("POO");
		chckbxPoo.setBounds(180, 111, 65, 23);
		contentPane.add(chckbxPoo);
		
		JCheckBox chckbxProgramaoWeb = new JCheckBox("Programação Web");
		chckbxProgramaoWeb.setBounds(249, 111, 167, 23);
		contentPane.add(chckbxProgramaoWeb);
		
		JCheckBox chckbxTecnicas = new JCheckBox("Técnicas de programação");
		chckbxTecnicas.setBounds(222, 136, 208, 65);
		contentPane.add(chckbxTecnicas);
		
		JLabel lblDiciplinas = new JLabel("Diciplinas");
		lblDiciplinas.setBounds(22, 115, 70, 15);
		contentPane.add(lblDiciplinas);
		
		JButton btnSalvar = new JButton("Cadastrar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtCadastrarNovoCurso.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Insira o nome do curso!");
					return;
				}
				if (chckbxPortugus.isSelected() || chckbxMtemtica.isSelected() || 
						chckbxPoo.isSelected() || chckbxProgramaoWeb.isSelected() || 
						chckbxTecnicas.isSelected()) {
					
					principal.salvaDiciplina(diciplinasSelecionadas());
					principal.salvarCurso(txtCadastrarNovoCurso.getText());
					principal.salvaCursoDiciplina(txtCadastrarNovoCurso.getText(), diciplinasSelecionadas());
					principal.update();
					setVisible(false);
					return;
				}
				
				JOptionPane.showMessageDialog(null, "Marque pelo menos uma diciplina!");
				return;
			}

			private ArrayList<String> diciplinasSelecionadas() {
				ArrayList<String> diciplinas = new ArrayList<String>();
				if (chckbxPortugus.isSelected()) diciplinas.add("Português");
				if (chckbxMtemtica.isSelected()) diciplinas.add("Matemática");
				if (chckbxPoo.isSelected()) diciplinas.add("Programação orientada a objetos");
				if (chckbxProgramaoWeb.isSelected()) diciplinas.add("Programação web");
				if (chckbxTecnicas.isSelected()) diciplinas.add("Técnicas de programção");
				return diciplinas;
			}
		});
		btnSalvar.setBounds(393, 306, 117, 25);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(252, 306, 117, 25);
		contentPane.add(btnCancelar);
	}
}
