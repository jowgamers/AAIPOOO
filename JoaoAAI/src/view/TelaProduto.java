package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaProduto extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public TelaProduto() {

		setBackground(new Color(102, 205, 170));
		setBounds(86, 0, 670, 516);
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(50, 79, 148, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(50, 110, 148, 20);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(50, 141, 148, 20);
		add(textField_2);
	}

}
