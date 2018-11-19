package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.FornecedorDAO;
import model.Fornecedor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaFornecedor extends JPanel {
	private JTextField txtNomeFor;
	private JTextField txtTelFrn;
	private JTextField txtEmlVnd;
	private JTextField txtMetaMensal;
	private JTextField txtCpfFrn;
	private JTable jTFor;
	private JTextField txtCNome;
	private JTextField txtCCpf;
	private JTextField txtCTel;
	private JTextField txtCEmail;
	private JTextField txtNomCnt;

	/**
	 * Create the panel.
	 */
	public TelaFornecedor() {
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
				if (jTFor.getSelectedRow() != -1) {

					Fornecedor v = new Fornecedor();
					FornecedorDAO vDAO = new FornecedorDAO();
					v.setNome(txtCNome.getText());
					v.setCnpj(txtCCpf.getText());
					v.setEmail(txtCEmail.getText());
					v.setNomeContato(txtNomCnt.getText());
					v.setTelefones(txtCTel.getText());
					v.setCodigo((int) jTFor.getValueAt(jTFor.getSelectedRow(), 0));
					
					vDAO.update(v);

					txtNomeFor.setText("");
					txtCpfFrn.setText("");
					txtTelFrn.setText("");
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

		
		jTFor = new JTable();
		jTFor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (jTFor.getSelectedRow() != -1) {
					
					txtCNome.setText(jTFor.getValueAt(jTFor.getSelectedRow(), 1).toString());
					txtCTel.setText(jTFor.getValueAt(jTFor.getSelectedRow(), 2).toString());
					txtCCpf.setText(jTFor.getValueAt(jTFor.getSelectedRow(), 3).toString());
					txtCEmail.setText(jTFor.getValueAt(jTFor.getSelectedRow(), 4).toString());
					txtNomCnt.setText(jTFor.getValueAt(jTFor.getSelectedRow(), 6).toString());

				}
			}
		});
		jTFor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo Fornecedor", "Nome", "Telefone", "Cpf", "Email", "Data Cadastro", "Meta Mensal"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(jTFor);
		
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
		
		JLabel lblMetaMs = new JLabel("Meta M\u00EAs : ");
		lblMetaMs.setBounds(572, 11, 75, 14);
		pnlConsultar.add(lblMetaMs);
		
		txtNomCnt = new JTextField();
		txtNomCnt.setColumns(10);
		txtNomCnt.setBounds(571, 25, 94, 29);
		pnlConsultar.add(txtNomCnt);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jTFor.getSelectedRow() != -1) {

					Fornecedor v = new Fornecedor();
					FornecedorDAO vDAO = new FornecedorDAO();

					v.setCodigo((int) jTFor.getValueAt(jTFor.getSelectedRow(), 0));

					vDAO.delete(v);

					txtNomeFor.setText("");
					txtCpfFrn.setText("");
					txtTelFrn.setText("");
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
		
		txtNomeFor = new JTextField();
		txtNomeFor.setBounds(41, 56, 174, 29);
		lblCadastrar.add(txtNomeFor);
		txtNomeFor.setColumns(10);
		
		JLabel lblNomeFornecedor = new JLabel("Nome Fornecedor : ");
		lblNomeFornecedor.setBounds(41, 31, 107, 14);
		lblCadastrar.add(lblNomeFornecedor);
		
		JLabel lblTelefoneFornecedor = new JLabel("Telefone Fornecedor: ");
		lblTelefoneFornecedor.setBounds(41, 161, 145, 14);
		lblCadastrar.add(lblTelefoneFornecedor);
		
		txtTelFrn = new JTextField();
		txtTelFrn.setColumns(10);
		txtTelFrn.setBounds(41, 186, 174, 29);
		lblCadastrar.add(txtTelFrn);
		
		JLabel lblEmailFornecedor = new JLabel("Email Fornecedor :");
		lblEmailFornecedor.setBounds(41, 226, 97, 14);
		lblCadastrar.add(lblEmailFornecedor);
		
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
				
				Fornecedor v = new Fornecedor();
				FornecedorDAO vDAO = new FornecedorDAO();
				
				v.setNome(txtNomeFor.getText());
				v.setCnpj(txtCpfFrn.getText());
				v.setTelefones(txtTelFrn.getText());
				v.setEmail(txtEmlVnd.getText());
				v.setNomeContato(txtMetaMensal.getText());
				vDAO.create(v);

				txtNomeFor.setText("");
				txtCpfFrn.setText("");
				txtTelFrn.setText("");
				txtEmlVnd.setText("");

				//lerJTable();
			}
		});
		btnNewButton.setBounds(41, 356, 97, 29);
		lblCadastrar.add(btnNewButton);
		
		txtCpfFrn = new JTextField();
		txtCpfFrn.setColumns(10);
		txtCpfFrn.setBounds(41, 121, 174, 29);
		lblCadastrar.add(txtCpfFrn);
		
		JLabel lblCpfFornecedor = new JLabel("Cpf Fornecedor : ");
		lblCpfFornecedor.setBounds(41, 96, 145, 14);
		lblCadastrar.add(lblCpfFornecedor);
		
		JLabel lblClientes = new JLabel("Fornecedor");
		lblClientes.setHorizontalTextPosition(SwingConstants.CENTER);
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblClientes.setBounds(0, 11, 203, 45);
		add(lblClientes);
		
		
	}
	
	
	public void lerJTable() {
		DefaultTableModel modelo = (DefaultTableModel) jTFor.getModel();
		modelo.setNumRows(0);
		FornecedorDAO vDAO = new FornecedorDAO();

		for (Fornecedor f : vDAO.read()) {
			modelo.addRow(new Object[] { f.getCodigo(), f.getNome(), f.getTelefones(), f.getCnpj(), f.getEmail(), f.getDataCad(), f.getNomeContato()

			});
		}

	}
	
	public void lerJTablePorNome(String nomFor) {
		DefaultTableModel modelo = (DefaultTableModel) jTFor.getModel();
		modelo.setNumRows(0);
		FornecedorDAO fDAO = new FornecedorDAO();

		for (Fornecedor f : fDAO.buscaPorNomeForn(nomFor)) {
			modelo.addRow(new Object[] { f.getCodigo(), f.getNome(), f.getTelefones(), f.getCnpj(), f.getEmail(), f.getDataCad(), f.getNomeContato()

			});
		}

	}
}
