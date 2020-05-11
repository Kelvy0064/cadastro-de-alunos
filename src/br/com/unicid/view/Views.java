package br.com.unicid.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import br.com.unicid.controller.Principal;
import br.com.unicid.dao.CursoDAO;
import br.com.unicid.model.Aluno;

public class Views extends JFrame {

	private JPanel contentPane;
	private static JComboBox comboBox;
	private static JTextField textField2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private CursoDAO cursoDAO;
	private JComboBox cmbUf;
	private Principal principal = new Principal();
	JMenuBar menuBar = new JMenuBar();
	JLabel lblRgm_1_1 = new JLabel("Diciplina");
	JMenuItem mntmConsultar = new JMenuItem("Consultar");
	JMenu mnNewMenu = new JMenu("Aluno");
	JMenuItem opcAlterar = new JMenuItem("Alterar");
	JMenuItem mntmSalvar = new JMenuItem("Salvar");
	JMenuItem mntmNewMenuItem = new JMenuItem("Excluir");
	JMenuItem mntmS = new JMenuItem("Sair");
	JSeparator separator = new JSeparator();
	JMenu mnNewMenu_1 = new JMenu("Notas e Faltas");
	JMenuItem mntmSalvar_1 = new JMenuItem("Salvar");
	JMenuItem mntmAlterar_1 = new JMenuItem("Alterar");
	JMenuItem mntmExcluir = new JMenuItem("Excluir");
	JMenuItem mntmConsultar_1 = new JMenuItem("Consultar");
	JMenu mnAjuda = new JMenu("Ajuda");
	JMenuItem mntmSobre = new JMenuItem("Sobre");
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	JPanel panel_1 = new JPanel();
	JLabel lblCurso = new JLabel("Curso");
	JComboBox cmbCursosSalvos = new JComboBox();
	JLabel lblCampos = new JLabel("Campus");
	JComboBox cmbCampus = new JComboBox();
	JLabel lblPeriodo = new JLabel("Período");
	JRadioButton rdbtnMatutino = new JRadioButton("Matutino");
	JRadioButton rdbtnVesperino = new JRadioButton("Vesperino");
	JRadioButton rdbtnNoturno = new JRadioButton("Noturno");
	JButton btnCadastrarNovoCurso = new JButton("Cadastrar novo curso");
	JPanel panel = new JPanel();
	JLabel lblRgm = new JLabel("RGM");
	JFormattedTextField txtRgm = new JFormattedTextField();
	JLabel lblNome = new JLabel("Nome");
	JFormattedTextField txtNome = new JFormattedTextField();
	JLabel lblDataNascimento = new JLabel("Data Nascimento");
	JFormattedTextField txtDataNascimento = new JFormattedTextField();
	JLabel lblCpf = new JLabel("CPF");
	JFormattedTextField txtCpf = new JFormattedTextField();
	JLabel lblEmail = new JLabel("Email");
	JFormattedTextField txtEmail = new JFormattedTextField();
	JLabel lblEnd = new JLabel("End.");
	JFormattedTextField txtEndereco = new JFormattedTextField();
	JComboBox comboBox_2 = new JComboBox();
	JLabel lblMunicipio = new JLabel("Município");
	JFormattedTextField txtMunicipio = new JFormattedTextField();
	JLabel lblUf = new JLabel("UF");
	JLabel lblCelular = new JLabel("Celular");
	JFormattedTextField txtCelular = new JFormattedTextField();
	JPanel panel_2 = new JPanel();
	JLabel lblRgm_1_1_1 = new JLabel("Semestre");
	JComboBox comboBox_3 = new JComboBox();
	JLabel lblRgm_1_1_1_1 = new JLabel("Nota");
	JComboBox comboBox_3_1 = new JComboBox();
	JLabel lblRgm_1 = new JLabel("RGM");
	JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
	JLabel lblRgm_1_1_1_1_1 = new JLabel("Faltas");
	JButton btnSalvaraluno = new JButton("Salvar aluno");
	private final JButton btnAlterar = new JButton("Alterar");

	public Views() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		menuBar.setBorderPainted(false);

//		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(12, 12, 721, 25);
		contentPane.add(menuBar);

		menuBar.add(mnNewMenu);

		mntmSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nome = txtNome.getText();
					int rgm = Integer.parseInt(txtRgm.getText());
					String data = txtDataNascimento.getText();
					String cpf = txtCpf.getText();
					String email = txtEmail.getText();
					String endereco = txtEndereco.getText();
					String municipio = txtMunicipio.getText();
					String uf = cmbUf.getSelectedItem().toString();
					String celular = txtCelular.getText();
					int idCurso = cursoDAO.findCursoByName(cmbCursosSalvos.getSelectedItem().toString());
					String idPeriodo = getPeriodo(rdbtnMatutino, rdbtnNoturno, rdbtnVesperino);
					String idCampus = cmbCampus.getSelectedItem().toString();
					Aluno aluno = new Aluno(nome, rgm, data, cpf, email, endereco, municipio, uf, celular, idCurso,
							idPeriodo, idCampus);
					principal.salvaAluno(aluno);
				} catch (NumberFormatException | NullPointerException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Dados incorreto!");
					return;
				}
			}
		});
		mntmSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmSalvar);
		opcAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer rgm = Integer.parseInt(JOptionPane.showInputDialog("insira o rgm do aluno que deseja alterar"));
				try {
					Aluno aluno = principal.getAlunoByRgm(rgm);
					if(aluno.getPeriodo().equals("matutino")) rdbtnMatutino.setSelected(true);
					if(aluno.getPeriodo().equals("vesperino")) rdbtnVesperino.setSelected(true);
					if(aluno.getPeriodo().equals("noturno")) rdbtnNoturno.setSelected(true);
					cmbCursosSalvos.setSelectedItem(cursoDAO.getNameCursoById(aluno.getIdCurso()));
					cmbCampus.setSelectedItem(aluno.getCampus());
					txtRgm.setText(toString().valueOf(aluno.getRgm()));
					txtNome.setText(aluno.getNome());
					txtDataNascimento.setText(aluno.getDataNascimento());
					txtCpf.setText(aluno.getCpf());
					txtEmail.setText(aluno.getEmail());
					txtEndereco.setText(aluno.getEndereco());
					txtMunicipio.setText(aluno.getMunicipio());
					cmbUf.setSelectedItem(aluno.getUf());
					txtCelular.setText(aluno.getCelular());
					btnAlterar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							try {
								String nome = txtNome.getText();
								int rgm = Integer.parseInt(txtRgm.getText());
								String data = txtDataNascimento.getText();
								String cpf = txtCpf.getText();
								String email = txtEmail.getText();
								String endereco = txtEndereco.getText();
								String municipio = txtMunicipio.getText();
								String uf = cmbUf.getSelectedItem().toString();
								String celular = txtCelular.getText();
								int idCurso = cursoDAO.findCursoByName(cmbCursosSalvos.getSelectedItem().toString());
								String idPeriodo = getPeriodo(rdbtnMatutino, rdbtnNoturno, rdbtnVesperino);
								String idCampus = cmbCampus.getSelectedItem().toString();
								Aluno aluno = new Aluno(nome, rgm, data, cpf, email, endereco, municipio, uf, celular, idCurso,
										idPeriodo, idCampus);
								principal.alteraAluno(aluno, aluno.getRgm());
							} catch (NumberFormatException | NullPointerException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, "Dados incorreto!");
								return;
							}
						}
					});
					btnAlterar.setBounds(97, 199, 117, 25);
					panel.add(btnAlterar);
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "Nenhum aluno encontrado com o rgm: " + rgm);
				}
			}
		});
		

		mnNewMenu.add(opcAlterar);

		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnNewMenu.add(mntmConsultar);

		mnNewMenu.add(mntmNewMenuItem);

		mnNewMenu.add(separator);

		mntmS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mntmS.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.SHIFT_MASK));
		mnNewMenu.add(mntmS);

		menuBar.add(mnNewMenu_1);

		mnNewMenu_1.add(mntmSalvar_1);

		mntmAlterar_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mntmAlterar_1);

		mnNewMenu_1.add(mntmExcluir);

		mnNewMenu_1.add(mntmConsultar_1);

		menuBar.add(mnAjuda);

		mnAjuda.add(mntmSobre);

		tabbedPane.setBounds(12, 61, 558, 269);
		contentPane.add(tabbedPane);

		tabbedPane.addTab("Curso", null, panel_1, null);
		panel_1.setLayout(null);

		lblCurso.setBounds(12, 12, 57, 15);
		panel_1.add(lblCurso);

		cursoDAO = new CursoDAO();

		cmbCursosSalvos.setModel(new DefaultComboBoxModel());

		atualizaLista(cmbCursosSalvos, cursoDAO.getCursos());

		cmbCursosSalvos.setBounds(106, 7, 435, 24);
		panel_1.add(cmbCursosSalvos);

		lblCampos.setBounds(12, 55, 57, 15);
		panel_1.add(lblCampos);

		cmbCampus.setModel(new DefaultComboBoxModel(new String[] { "Tatuapé", "Pinheiros" }));
		cmbCampus.setBounds(106, 50, 435, 24);
		panel_1.add(cmbCampus);

		lblPeriodo.setBounds(12, 97, 57, 15);
		panel_1.add(lblPeriodo);

		rdbtnMatutino.setBounds(106, 93, 89, 23);
		panel_1.add(rdbtnMatutino);

		rdbtnVesperino.setBounds(215, 93, 97, 23);
		panel_1.add(rdbtnVesperino);

		rdbtnNoturno.setBounds(336, 93, 97, 23);
		panel_1.add(rdbtnNoturno);

		btnCadastrarNovoCurso.setFont(new Font("Dialog", Font.BOLD, 10));
		btnCadastrarNovoCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroCurso cadastroCurso = new CadastroCurso();
				cadastroCurso.setVisible(true);
			}
		});
		btnCadastrarNovoCurso.setBounds(356, 166, 169, 49);
		panel_1.add(btnCadastrarNovoCurso);

		tabbedPane.addTab("Dados Pessoais", null, panel, null);
		panel.setLayout(null);

		lblRgm.setBounds(12, 23, 38, 15);
		panel.add(lblRgm);

		txtRgm.setBounds(77, 12, 95, 28);
		panel.add(txtRgm);

		lblNome.setBounds(190, 25, 57, 15);
		panel.add(lblNome);

		txtNome.setBounds(272, 12, 269, 28);
		panel.add(txtNome);

		lblDataNascimento.setBounds(12, 52, 121, 15);
		panel.add(lblDataNascimento);

		txtDataNascimento.setBounds(151, 46, 95, 28);
		panel.add(txtDataNascimento);

		lblCpf.setBounds(282, 52, 38, 15);
		panel.add(lblCpf);

		txtCpf.setBounds(320, 46, 221, 28);
		panel.add(txtCpf);

		lblEmail.setBounds(12, 85, 57, 15);
		panel.add(lblEmail);

		txtEmail.setBounds(73, 79, 468, 28);
		panel.add(txtEmail);

		lblEnd.setBounds(12, 116, 57, 15);
		panel.add(lblEnd);

		txtEndereco.setBounds(73, 110, 468, 28);
		panel.add(txtEndereco);

		lblMunicipio.setBounds(12, 155, 80, 15);
		panel.add(lblMunicipio);

		txtMunicipio.setBounds(97, 149, 121, 28);
		panel.add(txtMunicipio);

		lblUf.setBounds(258, 155, 27, 15);
		panel.add(lblUf);

		JComboBox comboBox;
		cmbUf = new JComboBox();
		cmbUf.setModel(new DefaultComboBoxModel(
				new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB",
						"PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));
		cmbUf.setBounds(299, 148, 50, 29);
		panel.add(cmbUf);

		lblCelular.setBounds(351, 155, 57, 15);
		panel.add(lblCelular);

		txtCelular.setBounds(420, 149, 121, 28);
		panel.add(txtCelular);

		tabbedPane.addTab("Notas e Faltas\n", null, panel_2, null);
		panel_2.setLayout(null);

		lblRgm_1.setBounds(12, 28, 38, 15);
		panel_2.add(lblRgm_1);

		textField = new JTextField();
		textField.setBounds(57, 21, 95, 29);
		panel_2.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(174, 21, 367, 29);
		panel_2.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(12, 55, 529, 29);
		panel_2.add(textField_2);

		lblRgm_1_1.setBounds(12, 96, 65, 15);
		panel_2.add(lblRgm_1_1);

		comboBox_2.setBounds(95, 91, 446, 24);
		panel_2.add(comboBox_2);

		lblRgm_1_1_1.setBounds(12, 133, 78, 15);
		panel_2.add(lblRgm_1_1_1);

		comboBox_3.setBounds(95, 128, 114, 24);
		panel_2.add(comboBox_3);

		lblRgm_1_1_1_1.setBounds(224, 133, 78, 15);
		panel_2.add(lblRgm_1_1_1_1);

		comboBox_3_1.setBounds(268, 127, 72, 24);
		panel_2.add(comboBox_3_1);

		lblRgm_1_1_1_1_1.setBounds(375, 133, 56, 15);
		panel_2.add(lblRgm_1_1_1_1_1);

		textField_3 = new JTextField();
		textField_3.setBounds(439, 127, 102, 25);
		panel_2.add(textField_3);
		textField_3.setColumns(10);

		tabbedPane.addTab("New tab", null, tabbedPane_1, null);

		// Options in the combobox
		String[] options = { "Option1", "Option2", "Option3", "Option4", "Option15" };
		comboBox = new JComboBox(options);
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Do something when you select a value

			}
		});
		
		btnSalvaraluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nome = txtNome.getText();
					int rgm = Integer.parseInt(txtRgm.getText());
					String data = txtDataNascimento.getText();
					String cpf = txtCpf.getText();
					String email = txtEmail.getText();
					String endereco = txtEndereco.getText();
					String municipio = txtMunicipio.getText();
					String uf = cmbUf.getSelectedItem().toString();
					String celular = txtCelular.getText();
					int idCurso = cursoDAO.findCursoByName(cmbCursosSalvos.getSelectedItem().toString());
					String idPeriodo = getPeriodo(rdbtnMatutino, rdbtnNoturno, rdbtnVesperino);
					String idCampus = cmbCampus.getSelectedItem().toString();
					Aluno aluno = new Aluno(nome, rgm, data, cpf, email, endereco, municipio, uf, celular, idCurso,
							idPeriodo, idCampus);
					principal.salvaAluno(aluno);
				} catch (NumberFormatException | NullPointerException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Dados incorreto!");
					return;
				}
			}

			public String formataDataEnviaBD(String stringData) {
				String startDateString = stringData;
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy,MM,dd");
				System.out.println(LocalDate.parse(startDateString, formatter).format(formatter2));
				return LocalDate.parse(startDateString, formatter).format(formatter2);

			}
		});
		btnSalvaraluno.setBounds(405, 199, 136, 25);
		panel.add(btnSalvaraluno);

		JButton btnLimparDados = new JButton("Limpar Dados");
		btnLimparDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpaCampos(cmbCursosSalvos, cmbCampus, rdbtnMatutino, rdbtnVesperino, rdbtnNoturno, txtRgm, txtNome,
						txtDataNascimento, txtCpf, txtEmail, txtEndereco, txtMunicipio, txtCelular);

			}

			private void limpaCampos(JComboBox cmbCursosSalvos, JComboBox cmbCampus, JRadioButton rdbtnMatutino,
					JRadioButton rdbtnVesperino, JRadioButton rdbtnNoturno, JFormattedTextField txtRgm,
					JFormattedTextField txtNome, JFormattedTextField txtDataNascimento, JFormattedTextField txtCpf,
					JFormattedTextField txtEmail, JFormattedTextField txtEndereco, JFormattedTextField txtMunicipio,
					JFormattedTextField txtCelular) {
				txtNome.setText("");
				txtRgm.setText("");
				txtDataNascimento.setText("");
				txtCpf.setText("");
				txtEmail.setText("");
				txtEndereco.setText("");
				txtMunicipio.setText("");
				cmbUf.setSelectedIndex(0);
				txtCelular.setText("");
				cmbCursosSalvos.setSelectedIndex(0);
				cmbCampus.setSelectedIndex(0);
				rdbtnMatutino.setSelected(false);
				rdbtnVesperino.setSelected(false);
				rdbtnNoturno.setSelected(false);
			}
		});
		btnLimparDados.setBounds(237, 199, 136, 25);
		panel.add(btnLimparDados);
		
	}

	private String getPeriodo(JRadioButton rdbtnMatutino, JRadioButton rdbtnNoturno, JRadioButton rdbtnVesperino) {
		String resposta = null;
		if (rdbtnMatutino.isSelected())
			resposta = "matutino";
		if (rdbtnVesperino.isSelected())
			resposta = "vesperino";
		if (rdbtnNoturno.isSelected())
			resposta = "noturno";
		if (resposta.isEmpty())
			throw new NullPointerException();
		return resposta;
	}

	private void atualizaLista(JComboBox alvo, ArrayList<String> cursos) {
		for (String curso : cursoDAO.getCursos()) {
			alvo.addItem(curso);
		}

	}

}
