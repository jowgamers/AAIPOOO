package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaCliente extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public TelaCliente() {

		setBackground(new Color(47, 79, 79));
		setBounds(86, 0, 670, 516);
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(96, 99, 287, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome : ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(96, 74, 54, 14);
		add(lblNome);
		
		JLabel label = new JLabel("Nome : ");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(96, 130, 54, 14);
		add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(96, 155, 287, 20);
		add(textField_1);
		
		JLabel label_1 = new JLabel("Nome : ");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(96, 186, 54, 14);
		add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(96, 211, 287, 20);
		add(textField_2);
		
		JLabel label_2 = new JLabel("Nome : ");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(96, 242, 54, 14);
		add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(96, 267, 287, 20);
		add(textField_3);
		
		JLabel label_3 = new JLabel("Nome : ");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(96, 298, 54, 14);
		add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(96, 323, 287, 20);
		add(textField_4);
		
		JLabel label_4 = new JLabel("Nome : ");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(96, 354, 54, 14);
		add(label_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(96, 379, 287, 20);
		add(textField_5);
		
		JLabel lblAquiVaiSer = new JLabel("AQUI VAI SER O MENU");
		lblAquiVaiSer.setForeground(Color.WHITE);
		lblAquiVaiSer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAquiVaiSer.setBounds(96, 11, 147, 14);
		add(lblAquiVaiSer);
	}

}
