package view;
/*

cod_cli INT
nom_cli STRING
tel_cli STRING
eml_cli STRING
dta_cad_cli DATE
cpf_cli STRING
lmt_crd DOUBLE

 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.ClienteDAO;
import controller.VendedorDAO;
import model.Cliente;
import model.Vendedor;

public class TelaCliente extends JPanel {

	private JTextField txtNomeVend;
	private JTextField txtTelVend;
	private JTextField txtEmlVnd;
	private JTextField txtMetaMensal;
	private JTextField txtCpfVnd;
	private JTable jTCli;
	private JTextField txtCNome;
	private JTextField txtCCpf;
	private JTextField txtCTel;
	private JTextField txtCEmail;
	private JTextField txtCLmtCred;

	/**
	 * Create the panel.
	 */
	public TelaCliente() {
		setBackground(new Color(48, 50, 61));
		setBounds(0, 0, 825, 555);
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setLocation(new Point(500, 300));
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setBounds(0, 60, 825, 495);
		add(tabbedPane);
		
		JPanel pnlConsultar = new JPanel();
		tabbedPane.addTab("Deletar", null, pnlConsultar, null);
		pnlConsultar.setLayout(null);
		

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jTCli.getSelectedRow() != -1) {

					Cliente c = new Cliente();
					ClienteDAO cDAO = new ClienteDAO();
					c.setNome(txtCNome.getText());
					c.setCpf(txtCCpf.getText());
					c.setEmail(txtCEmail.getText());
					c.setLimiteCredito(Double.parseDouble(txtCLmtCred.getText()));
					c.setTelefones(txtCTel.getText());
					c.setCodigo((int) jTCli.getValueAt(jTCli.getSelectedRow(), 0));
					
					cDAO.update(c);

					txtNomeVend.setText("");
					txtCLmtCred.setText("");
					txtCpfVnd.setText("");
					txtTelVend.setText("");
					txtEmlVnd.setText("");

					lerJTable();

				} // Colocar um else (selecione um produto p excluir em um optionpanel
			}
		});
		btnAtualizar.setBounds(675, 25, 75, 23);
		pnlConsultar.add(btnAtualizar);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 800, 368);
		pnlConsultar.add(scrollPane);

		
		jTCli = new JTable();
		jTCli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (jTCli.getSelectedRow() != -1) {
					
					txtCNome.setText(jTCli.getValueAt(jTCli.getSelectedRow(), 1).toString());
					txtCTel.setText(jTCli.getValueAt(jTCli.getSelectedRow(), 2).toString());
					txtCCpf.setText(jTCli.getValueAt(jTCli.getSelectedRow(), 3).toString());
					txtCEmail.setText(jTCli.getValueAt(jTCli.getSelectedRow(), 4).toString());
					txtCLmtCred.setText(jTCli.getValueAt(jTCli.getSelectedRow(), 6).toString());

				}
			}
		});
		jTCli.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo Cliente", "Nome", "Telefone", "Cpf", "Email", "Data Cadastro", "Limite Credito"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(jTCli);
		
		txtCNome = new JTextField();
		txtCNome.setBounds(9, 25, 150, 29);
		pnlConsultar.add(txtCNome);
		txtCNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome : ");
		lblNome.setBounds(10, 11, 46, 14);
		pnlConsultar.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF : ");
		lblCpf.setBounds(170, 11, 46, 14);
		pnlConsultar.add(lblCpf);
		
		txtCCpf = new JTextField();
		txtCCpf.setColumns(10);
		txtCCpf.setBounds(169, 25, 150, 29);
		pnlConsultar.add(txtCCpf);
		
		JLabel lblTelefone = new JLabel("Telefone :");
		lblTelefone.setBounds(330, 11, 59, 14);
		pnlConsultar.add(lblTelefone);
		
		txtCTel = new JTextField();
		txtCTel.setColumns(10);
		txtCTel.setBounds(329, 25, 94, 29);
		pnlConsultar.add(txtCTel);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(434, 11, 59, 14);
		pnlConsultar.add(lblEmail);
		
		txtCEmail = new JTextField();
		txtCEmail.setColumns(10);
		txtCEmail.setBounds(433, 25, 128, 29);
		pnlConsultar.add(txtCEmail);
		
		JLabel lblMetaMs = new JLabel("Limite Credito: ");
		lblMetaMs.setBounds(572, 11, 108, 14);
		pnlConsultar.add(lblMetaMs);
		
		txtCLmtCred = new JTextField();
		txtCLmtCred.setColumns(10);
		txtCLmtCred.setBounds(571, 25, 94, 29);
		pnlConsultar.add(txtCLmtCred);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jTCli.getSelectedRow() != -1) {

					Cliente c = new Cliente();
					ClienteDAO cDAO = new ClienteDAO();

					c.setCodigo((int) jTCli.getValueAt(jTCli.getSelectedRow(), 0));

					cDAO.delete(c);

					txtNomeVend.setText("");
					txtCpfVnd.setText("");
					txtCLmtCred.setText("");
					txtTelVend.setText("");
					txtEmlVnd.setText("");

					//lerJTable();
				} // Colocar um else (selecione um produto p excluir em um optionpanel
			}
		});
		btnExcluir.setBounds(675, 54, 75, 23);
		pnlConsultar.add(btnExcluir);
		
		
		JPanel lblCadastrar = new JPanel();
		tabbedPane.addTab("Consultar", null, lblCadastrar, null);
		lblCadastrar.setLayout(null);
		
		txtNomeVend = new JTextField();
		txtNomeVend.setBounds(41, 56, 174, 29);
		lblCadastrar.add(txtNomeVend);
		txtNomeVend.setColumns(10);
		
		JLabel lblNomeCli = new JLabel("Nome Cliente : ");
		lblNomeCli.setBounds(41, 31, 107, 14);
		lblCadastrar.add(lblNomeCli);
		
		JLabel lblTelefoneCli = new JLabel("Telefone Cliente: ");
		lblTelefoneCli.setBounds(41, 161, 145, 14);
		lblCadastrar.add(lblTelefoneCli);
		
		txtTelVend = new JTextField();
		txtTelVend.setColumns(10);
		txtTelVend.setBounds(41, 186, 174, 29);
		lblCadastrar.add(txtTelVend);
		
		JLabel lblEmailCliente = new JLabel("Email Cliente :");
		lblEmailCliente.setBounds(41, 226, 97, 14);
		lblCadastrar.add(lblEmailCliente);
		
		txtEmlVnd = new JTextField();
		txtEmlVnd.setColumns(10);
		txtEmlVnd.setBounds(41, 251, 174, 29);
		lblCadastrar.add(txtEmlVnd);
		
		JLabel lblMetaMensal_1 = new JLabel("Meta Mensal : ");
		lblMetaMensal_1.setBounds(41, 291, 97, 14);
		lblCadastrar.add(lblMetaMensal_1);
		
		txtMetaMensal = new JTextField();
		txtMetaMensal.setColumns(10);
		txtMetaMensal.setBounds(41, 316, 174, 29);
		lblCadastrar.add(txtMetaMensal);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Cliente c = new Cliente();
				ClienteDAO cDAO = new ClienteDAO();
				
				c.setNome(txtNomeVend.getText());
				c.setCpf(txtCpfVnd.getText());
				c.setTelefones(txtTelVend.getText());
				c.setEmail(txtEmlVnd.getText());
				c.setLimiteCredito(Double.parseDouble(txtMetaMensal.getText()));
				cDAO.create(c);

				txtNomeVend.setText("");
				txtCpfVnd.setText("");
				txtTelVend.setText("");
				txtEmlVnd.setText("");

				//lerJTable();
			}
		});
		btnNewButton.setBounds(41, 356, 97, 29);
		lblCadastrar.add(btnNewButton);
		
		txtCpfVnd = new JTextField();
		txtCpfVnd.setColumns(10);
		txtCpfVnd.setBounds(41, 121, 174, 29);
		lblCadastrar.add(txtCpfVnd);
		
		JLabel lblCpfCliente = new JLabel("Cpf Cliente : ");
		lblCpfCliente.setBounds(41, 96, 145, 14);
		lblCadastrar.add(lblCpfCliente);
		
		JLabel lblClientes = new JLabel("Clientes : ");
		lblClientes.setHorizontalTextPosition(SwingConstants.CENTER);
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblClientes.setBounds(0, 11, 203, 45);
		add(lblClientes);
		
		
	}
	
	
	public void lerJTable() {
		DefaultTableModel modelo = (DefaultTableModel) jTCli.getModel();
		modelo.setNumRows(0);
		ClienteDAO cDAO = new ClienteDAO();

		for (Cliente c : cDAO.read()) {
			modelo.addRow(new Object[] { c.getCodigo(), c.getNome(), c.getTelefones(), c.getEmail(), c.getDataCad(), c.getCpf(), c.getLimiteCredito()

			});
		}

	}
	
	public void lerJTablePorNome(String nomeCli) {
		DefaultTableModel modelo = (DefaultTableModel) jTCli.getModel();
		modelo.setNumRows(0);
		ClienteDAO cDAO = new ClienteDAO();

		for (Cliente c : cDAO.buscaPorNome(nomeCli)) {
			modelo.addRow(new Object[] { c.getCodigo(), c.getNome(), c.getTelefones(), c.getEmail(), c.getDataCad(), c.getCpf(), c.getLimiteCredito()

			});
		}

	}
}
