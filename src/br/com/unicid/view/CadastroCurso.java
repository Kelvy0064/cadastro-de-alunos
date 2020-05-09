package br.com.unicid.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTree;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroCurso extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCurso frame = new CadastroCurso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		
		textField = new JTextField();
		textField.setBounds(156, 39, 407, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTree tree = new JTree();
		tree.setBounds(88, 159, -1, 21);
		contentPane.add(tree);
		
		JCheckBox chckbxPortugus = new JCheckBox("Português");
		chckbxPortugus.setBounds(37, 170, 129, 23);
		contentPane.add(chckbxPortugus);
		
		JCheckBox chckbxMtemtica = new JCheckBox("Matemática");
		chckbxMtemtica.setBounds(160, 170, 129, 23);
		contentPane.add(chckbxMtemtica);
		
		JCheckBox chckbxPoo = new JCheckBox("POO");
		chckbxPoo.setBounds(291, 170, 65, 23);
		contentPane.add(chckbxPoo);
		
		JCheckBox chckbxProgramaoWeb = new JCheckBox("Programação Web");
		chckbxProgramaoWeb.setBounds(370, 170, 167, 23);
		contentPane.add(chckbxProgramaoWeb);
		
		textField_1 = new JTextField();
		textField_1.setBounds(160, 105, 403, 36);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDiciplinas = new JLabel("Diciplinas");
		lblDiciplinas.setBounds(68, 115, 70, 15);
		contentPane.add(lblDiciplinas);
		
		JButton btnSalvae = new JButton("Salvar");
		btnSalvae.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalvae.setBounds(393, 306, 117, 25);
		contentPane.add(btnSalvae);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(172, 306, 117, 25);
		contentPane.add(btnCancelar);
	}
}
