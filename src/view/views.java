package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class views extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					views frame = new views();
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
	public views() throws Exception{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(12, 0, 721, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Aluno");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmSalvar);
		
		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mnNewMenu.add(mntmAlterar);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mnNewMenu.add(mntmConsultar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Excluir");
		mnNewMenu.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmS = new JMenuItem("Sair");
		mntmS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mntmS.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.SHIFT_MASK));
		mnNewMenu.add(mntmS);
		
		JMenu mnNewMenu_1 = new JMenu("Notas e Faltas");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmSalvar_1 = new JMenuItem("Salvar");
		mnNewMenu_1.add(mntmSalvar_1);
		
		JMenuItem mntmAlterar_1 = new JMenuItem("Alterar");
		mntmAlterar_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mntmAlterar_1);
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mnNewMenu_1.add(mntmExcluir);
		
		JMenuItem mntmConsultar_1 = new JMenuItem("Consultar");
		mnNewMenu_1.add(mntmConsultar_1);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 61, 558, 269);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Dados Pessoais", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblRgm = new JLabel("RGM");
		lblRgm.setBounds(12, 23, 38, 15);
		panel.add(lblRgm);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(77, 12, 95, 28);
		panel.add(formattedTextField);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(190, 25, 57, 15);
		panel.add(lblNome);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(272, 12, 269, 28);
		panel.add(formattedTextField_1);
		
		JLabel lblDataNascimento = new JLabel("Data Nascimento");
		lblDataNascimento.setBounds(12, 65, 121, 15);
		panel.add(lblDataNascimento);
		
		JFormattedTextField txtDataNascimento = new JFormattedTextField();
		txtDataNascimento.setBounds(152, 52, 95, 28);
		panel.add(txtDataNascimento);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(272, 65, 38, 15);
		panel.add(lblCpf);
		
		JFormattedTextField formattedTextField_2_1 = new JFormattedTextField();
		formattedTextField_2_1.setBounds(320, 52, 221, 28);
		panel.add(formattedTextField_2_1);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(12, 110, 57, 15);
		panel.add(lblEmail);
		
		JFormattedTextField formattedTextField_1_1 = new JFormattedTextField();
		formattedTextField_1_1.setBounds(77, 97, 468, 28);
		panel.add(formattedTextField_1_1);
		
		JLabel lblEnd = new JLabel("End.");
		lblEnd.setBounds(12, 155, 57, 15);
		panel.add(lblEnd);
		
		JFormattedTextField formattedTextField_1_1_1 = new JFormattedTextField();
		formattedTextField_1_1_1.setBounds(77, 142, 468, 28);
		panel.add(formattedTextField_1_1_1);
		
		JLabel lblMunicipio = new JLabel("Município");
		lblMunicipio.setBounds(12, 204, 80, 15);
		panel.add(lblMunicipio);
		
		JFormattedTextField formattedTextField_2_1_1 = new JFormattedTextField();
		formattedTextField_2_1_1.setBounds(100, 191, 121, 28);
		panel.add(formattedTextField_2_1_1);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(243, 204, 27, 15);
		panel.add(lblUf);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
		comboBox.setBounds(288, 190, 50, 29);
		panel.add(comboBox);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(361, 204, 57, 15);
		panel.add(lblCelular);
		
		JFormattedTextField formattedTextField_2_1_1_1 = new JFormattedTextField();
		formattedTextField_2_1_1_1.setBounds(424, 191, 121, 28);
		panel.add(formattedTextField_2_1_1_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Curso", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(12, 12, 57, 15);
		panel_1.add(lblCurso);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Análise e Desenvolvimento de Sistemas", "Gestão Ambiental", "Gestão Comercial", "Gestão de Recursos Humanos", "Gestão da Tecnologia da Informação", "Gestão Financeira", "Gestão Hospitalar", "Gestão Pública", "Logística", "Marketing", "Processos Gerenciais", "Secretariado", "Segurança no Trabalho"}));
		comboBox_1.setBounds(106, 7, 435, 24);
		panel_1.add(comboBox_1);
		
		JLabel lblCampos = new JLabel("Campos");
		lblCampos.setBounds(12, 55, 57, 15);
		panel_1.add(lblCampos);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"Tatuapé", "Pinheiros"}));
		comboBox_1_1.setBounds(106, 50, 435, 24);
		panel_1.add(comboBox_1_1);
		
		JLabel lblPeriodo = new JLabel("Período");
		lblPeriodo.setBounds(12, 97, 57, 15);
		panel_1.add(lblPeriodo);
		
		JRadioButton rdbtnMatutino = new JRadioButton("Matutino");
		rdbtnMatutino.setBounds(106, 93, 89, 23);
		panel_1.add(rdbtnMatutino);
		
		JRadioButton rdbtnVesperino = new JRadioButton("Vesperino");
		rdbtnVesperino.setBounds(215, 93, 97, 23);
		panel_1.add(rdbtnVesperino);
		
		JRadioButton rdbtnNoturno = new JRadioButton("Noturno");
		rdbtnNoturno.setBounds(336, 93, 97, 23);
		panel_1.add(rdbtnNoturno);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Notas e Faltas\n", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblRgm_1 = new JLabel("RGM");
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
		
		JLabel lblRgm_1_1 = new JLabel("Diciplina");
		lblRgm_1_1.setBounds(12, 96, 65, 15);
		panel_2.add(lblRgm_1_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(95, 91, 446, 24);
		panel_2.add(comboBox_2);
		
		JLabel lblRgm_1_1_1 = new JLabel("Semestre");
		lblRgm_1_1_1.setBounds(12, 133, 78, 15);
		panel_2.add(lblRgm_1_1_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(95, 128, 114, 24);
		panel_2.add(comboBox_3);
		
		JLabel lblRgm_1_1_1_1 = new JLabel("Nota");
		lblRgm_1_1_1_1.setBounds(224, 133, 78, 15);
		panel_2.add(lblRgm_1_1_1_1);
		
		JComboBox comboBox_3_1 = new JComboBox();
		comboBox_3_1.setBounds(268, 127, 72, 24);
		panel_2.add(comboBox_3_1);
		
		JLabel lblRgm_1_1_1_1_1 = new JLabel("Faltas");
		lblRgm_1_1_1_1_1.setBounds(375, 133, 56, 15);
		panel_2.add(lblRgm_1_1_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(439, 127, 102, 25);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
	  	
	}
}
