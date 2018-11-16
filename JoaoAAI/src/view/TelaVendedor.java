package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;

public class TelaVendedor extends JPanel {
	private JTextField textField_1;
	private JTextField textField;
	private JTextField txtEmail;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public TelaVendedor() {
		setBackground(new Color(48, 50, 61));
		setBounds(0, 0, 825, 555);
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setLocation(new Point(500, 300));
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setBounds(0, 60, 825, 495);
		add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Deletar", null, panel_1, null);
		panel_1.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(50, 128, 179, 26);
		panel_1.add(textField_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(120, 180, 179, 26);
		panel_1.add(textField);
		
		txtEmail = new JTextField();
		txtEmail.setText("Texto");
		txtEmail.setToolTipText("");
		txtEmail.setColumns(10);
		txtEmail.setBounds(50, 256, 179, 26);
		panel_1.add(txtEmail);
		
		JLabel lblNewLabel = new JLabel("Nome :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(50, 103, 45, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblTelefone = new JLabel("Telefone :");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setBounds(60, 184, 60, 14);
		panel_1.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("E-mail :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(50, 231, 45, 14);
		panel_1.add(lblEmail);
		
		JLabel lblCnpj = new JLabel("Cnpj : ");
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCnpj.setBounds(50, 293, 45, 17);
		panel_1.add(lblCnpj);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(50, 321, 179, 26);
		panel_1.add(textField_3);
		
		JLabel lblMetaMensal = new JLabel("Meta Mensal : ");
		lblMetaMensal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMetaMensal.setBounds(50, 358, 86, 14);
		panel_1.add(lblMetaMensal);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(50, 383, 179, 26);
		panel_1.add(textField_4);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Consultar", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Imprimir", null, panel_3, null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setForeground(Color.WHITE);
		tabbedPane.addTab("Cadastrar", null, panel, null);
		
		JLabel lblClientes = new JLabel("Vendedor");
		lblClientes.setHorizontalTextPosition(SwingConstants.CENTER);
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblClientes.setBounds(0, 11, 203, 45);
		add(lblClientes);
		
		
	}
}
