package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
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
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
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
		 setLocationRelativeTo(null); //Nem ideia
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 980, 580); // Aparentemente � onde vai abrir a JFrame os 2 1
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new java.awt.Color(5, 7, 51)); // AZUL ESCURO
		panel.setBounds(0, 0, 156, 580);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnVendedor = new JButton("Vendedor");
		btnVendedor.setFocusable(false);
		btnVendedor.setForeground(Color.WHITE);
		btnVendedor.setHorizontalAlignment(SwingConstants.LEADING);
		btnVendedor.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVendedor.setContentAreaFilled(false);
		btnVendedor.setBounds(0, 179, 155, 35);
		panel.add(btnVendedor);

		JButton btnForne = new JButton("Fornecedor");
		btnForne.setFocusable(false);
		btnForne.setForeground(Color.WHITE);
		btnForne.setHorizontalAlignment(SwingConstants.LEFT);
		btnForne.setHorizontalTextPosition(SwingConstants.LEFT);
		btnForne.setContentAreaFilled(false);
		btnForne.setBounds(0, 225, 155, 35);
		panel.add(btnForne);

		JButton btnCliente = new JButton("Clientes");
		btnCliente.setFocusable(false);
		btnCliente.setHorizontalAlignment(SwingConstants.LEFT);
		btnCliente.setForeground(Color.WHITE);
		btnCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCliente.setContentAreaFilled(false);
		btnCliente.setBounds(0, 317, 155, 35);
		panel.add(btnCliente);

		JButton btnProd = new JButton("Carnes");
		btnProd.setFocusable(false);
		btnProd.setForeground(Color.WHITE);
		btnProd.setHorizontalAlignment(SwingConstants.LEFT);
		btnProd.setBounds(0, 271, 155, 35);
		panel.add(btnProd);
		btnProd.setHorizontalTextPosition(SwingConstants.CENTER);
		btnProd.setContentAreaFilled(false);

		//testar
		JButton btnInicial = new JButton("Inicial");
		btnInicial.setFocusable(false);
		btnInicial.setContentAreaFilled(false);
		btnInicial.setForeground(Color.WHITE);
		btnInicial.setHorizontalAlignment(SwingConstants.LEADING);
		btnInicial.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInicial.setBounds(0, 133, 155, 35);
		panel.add(btnInicial);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setBounds(59, 66, 37, 14);
		panel.add(lblNome);
		lblNome.setForeground(SystemColor.desktop);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));

		// Pensar se deixarei isso nessa classe ou trocarei
		JPanel panelInicial = new JPanel();
		panelInicial.setBounds(155, 25, 825, 555);
		contentPane.add(panelInicial);
		panelInicial.setBackground(Color.DARK_GRAY);
		panelInicial.setLayout(null);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 825, 555);
		panelInicial.add(layeredPane);
		layeredPane.setLayout(null);
		
		
		JPanel panelPrinc = new JPanel();
		panelPrinc.setBounds(0, 0, 825, 555);
		layeredPane.add(panelPrinc);
		panelPrinc.setBackground(new java.awt.Color(71, 120, 197));
		panelPrinc.setLayout(null);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setBounds(284, 105, 46, 14);
		panelPrinc.add(lblClientes);
		
		JLabel lblVendedores = new JLabel("Vendedores");
		lblVendedores.setForeground(Color.WHITE);
		lblVendedores.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVendedores.setBounds(63, 105, 68, 14);
		panelPrinc.add(lblVendedores);
		
		JLabel lblFornecedores = new JLabel("Fornecedores");
		lblFornecedores.setForeground(Color.WHITE);
		lblFornecedores.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFornecedores.setBounds(688, 105, 78, 14);
		panelPrinc.add(lblFornecedores);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setForeground(Color.WHITE);
		lblProdutos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProdutos.setBounds(492, 105, 50, 14);
		panelPrinc.add(lblProdutos);
		
		JLabel lblNewLabel = new JLabel("2");
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(300, 71, 15, 34);
		panelPrinc.add(lblNewLabel);
		
		JLabel label = new JLabel("2");
		label.setForeground(SystemColor.desktop);
		label.setFont(new Font("Tahoma", Font.PLAIN, 28));
		label.setBounds(90, 71, 15, 34);
		panelPrinc.add(label);
		
		JLabel label_1 = new JLabel("2");
		label_1.setForeground(SystemColor.desktop);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		label_1.setBounds(720, 71, 15, 34);
		panelPrinc.add(label_1);
		
		JLabel label_2 = new JLabel("2");
		label_2.setForeground(SystemColor.desktop);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		label_2.setBounds(510, 71, 15, 34);
		panelPrinc.add(label_2);
		
		JLabel lblLogo = new JLabel("LOGO");
		lblLogo.setBounds(274, 156, 277, 242);
		panelPrinc.add(lblLogo);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		
		Panel header = 	new Panel();
		header.setBackground(new java.awt.Color(71, 120, 197));
		header.setBounds(0, 0, 980, 26);
		contentPane.add(header);
		header.setLayout(null);
		
		JLabel lbl_fechar = new JLabel("X");
		lbl_fechar.setBounds(946, 0, 34, 27);
		header.add(lbl_fechar);
		lbl_fechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.exit(0);
			}
		});
		lbl_fechar.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fechar.setForeground(new Color(224, 255, 255));
		lbl_fechar.setFont(new Font("Tahoma", Font.BOLD, 18));
		
				JLabel lbl_mini = new JLabel("-");
				lbl_mini.setHorizontalTextPosition(SwingConstants.CENTER);
				lbl_mini.setBounds(914, -3, 34, 27);
				header.add(lbl_mini);
				lbl_mini.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
					
						setState(ICONIFIED);
					}
				});
				lbl_mini.setHorizontalAlignment(SwingConstants.CENTER);
				lbl_mini.setForeground(new Color(224, 255, 255));
				lbl_mini.setFont(new Font("Tahoma", Font.PLAIN, 30));

		/**
		 * Bot�es para a troca de telas
		 */
		btnProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaProduto telaProd = new TelaProduto();
				trocarPanel(telaProd);
			}
		});

		btnInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				trocarPanel(panelPrinc);
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
