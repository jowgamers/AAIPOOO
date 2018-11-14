package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class TelaCliente extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaCliente() {

		setBackground(new Color(47, 79, 79));
		setBounds(0, 0, 825, 555);
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setLocation(new Point(500, 300));
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setBounds(0, 60, 825, 495);
		add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Deletar", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Consultar", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Imprimir", null, panel_3, null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setForeground(Color.WHITE);
		tabbedPane.addTab("Cadastrar", null, panel, null);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setBackground(new Color(51, 0, 102));
		lblClientes.setHorizontalTextPosition(SwingConstants.CENTER);
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblClientes.setBounds(0, 11, 203, 45);
		add(lblClientes);
	}
}
