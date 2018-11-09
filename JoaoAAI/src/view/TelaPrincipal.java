package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Button;
import java.awt.Panel;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;

	public void trocarPanel(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPrincipal() {
		setResizable(false);
		setUndecorated(true); // Tirar a borda
		// setLocationRelativeTo(null); //Nem ideia
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 756, 516); // Aparentemente é onde vai abrir a JFrame os 2 1
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(102, 51, 51));
		panel.setBounds(0, 0, 76, 516);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblVendedor = new JLabel("Vendedor");
		lblVendedor.setForeground(new Color(255, 255, 255));
		lblVendedor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVendedor.setBounds(10, 164, 58, 14);
		panel.add(lblVendedor);

		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setForeground(Color.WHITE);
		lblFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFornecedor.setBounds(5, 272, 68, 14);
		panel.add(lblFornecedor);

		JLabel lblCarnes = new JLabel("Carnes");
		lblCarnes.setForeground(Color.WHITE);
		lblCarnes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCarnes.setBounds(18, 382, 42, 14);
		panel.add(lblCarnes);

		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblClientes.setBounds(17, 491, 45, 14);
		panel.add(lblClientes);

		JButton btnVendedor = new JButton("");
		btnVendedor
				.setRolloverIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/customer-service (1).png")));
		btnVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnVendedor.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/customer-service (2).png")));
		btnVendedor.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVendedor.setContentAreaFilled(false);
		btnVendedor.setBorderPainted(false);
		btnVendedor.setBounds(8, 102, 62, 62);
		panel.add(btnVendedor);

		JButton btnForne = new JButton("");
		btnForne.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/firefighter2.png")));
		btnForne.setRolloverIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/firefighter (1).png")));
		btnForne.setHorizontalTextPosition(SwingConstants.CENTER);
		btnForne.setContentAreaFilled(false);
		btnForne.setBorderPainted(false);
		btnForne.setBounds(8, 212, 62, 62);
		panel.add(btnForne);

		JButton btnCliente = new JButton("");
		btnCliente.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/man2.png")));
		btnCliente.setRolloverIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/man (1).png")));
		btnCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCliente.setContentAreaFilled(false);
		btnCliente.setBorderPainted(false);
		btnCliente.setBounds(8, 430, 62, 62);
		panel.add(btnCliente);

		JButton btnProd = new JButton("");
		btnProd.setBounds(8, 320, 62, 62);
		panel.add(btnProd);
		btnProd.setHorizontalTextPosition(SwingConstants.CENTER);
		btnProd.setRolloverIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/cow (1).png")));
		btnProd.setContentAreaFilled(false);
		btnProd.setBorderPainted(false);
		btnProd.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/cow.png")));
		
		JButton btnInicial = new JButton("");
		btnInicial.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/man (1).png")));
		btnInicial.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInicial.setContentAreaFilled(false);
		btnInicial.setBorderPainted(false);
		btnInicial.setBounds(8, 6, 62, 62);
		panel.add(btnInicial);
		
		JLabel lblInicial = new JLabel("Inicial");
		lblInicial.setForeground(Color.WHITE);
		lblInicial.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInicial.setBounds(23, 67, 33, 14);
		panel.add(lblInicial);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(86, 0, 670, 516);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		//Pensar se deixarei isso nessa classe ou trocarei
		JPanel panelInicial = new JPanel();
		layeredPane.add(panelInicial, "name_6988325258147");

		/**
		 *  Botões para a troca de telas
		 */
		btnProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaProduto telaProd = new TelaProduto();
				trocarPanel(telaProd);
			}
		});

		btnInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				trocarPanel(panelInicial);
			}
		});
		
		btnVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaVendedor telaVende = new TelaVendedor();
				trocarPanel(telaVende);
			}
		});

		btnForne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaFornecedor telaForne = new TelaFornecedor();
				trocarPanel(telaForne);
			}
		});

		
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCliente telaCliente = new TelaCliente();
				trocarPanel(telaCliente);
			}
		});

	}
}
