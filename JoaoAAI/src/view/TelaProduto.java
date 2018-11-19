package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.ProdutoDAO;
import model.Produto;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaProduto extends JPanel {
	private JTextField txtNome;
	private JTextField txtVlr;
	private JTextField txtQntEstoq;
	private JTextField txtQntMinEstoq;
	private JTable jTProd;
	private JTextField txtCNome;
	private JTextField txtCVlr;
	private JTextField txtCEstoq;
	private JTextField txtCEstoqMin;
	private JTextField txtBuscaNome;

	/**
	 * Create the panel.
	 */

	public TelaProduto() {

		setBackground(new Color(48, 50, 61));
		setBounds(0, 0, 825, 555);
		setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setLocation(new Point(500, 300));
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setBounds(0, 38, 825, 517);
		add(tabbedPane);

		JPanel consultarPanel = new JPanel();
		tabbedPane.addTab("Consultar", null, consultarPanel, null);
		consultarPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 139, 800, 339);
		consultarPanel.add(scrollPane);

		jTProd = new JTable();
		jTProd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (jTProd.getSelectedRow() != -1) {
					txtCNome.setText(jTProd.getValueAt(jTProd.getSelectedRow(), 1).toString());
					txtCVlr.setText(jTProd.getValueAt(jTProd.getSelectedRow(), 2).toString());
					txtCEstoq.setText(jTProd.getValueAt(jTProd.getSelectedRow(), 3).toString());
					txtCEstoqMin.setText(jTProd.getValueAt(jTProd.getSelectedRow(), 4).toString());
				}
			}
		});
		jTProd.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Codigo", "Nome", "Valor Unidade", "Estoque", "Estoque Minimo", "Data Cadastro" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(jTProd);

		txtCNome = new JTextField();
		txtCNome.setBounds(10, 44, 164, 31);
		consultarPanel.add(txtCNome);
		txtCNome.setColumns(10);

		txtCVlr = new JTextField();
		txtCVlr.setColumns(10);
		txtCVlr.setBounds(184, 44, 86, 31);
		consultarPanel.add(txtCVlr);

		txtCEstoq = new JTextField();
		txtCEstoq.setColumns(10);
		txtCEstoq.setBounds(280, 44, 86, 31);
		consultarPanel.add(txtCEstoq);

		txtCEstoqMin = new JTextField();
		txtCEstoqMin.setColumns(10);
		txtCEstoqMin.setBounds(376, 44, 86, 31);
		consultarPanel.add(txtCEstoqMin);

		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setBounds(10, 29, 46, 14);
		consultarPanel.add(lblNome_1);

		JLabel lblVlrUnidade = new JLabel("Vlr Unidade: ");
		lblVlrUnidade.setBounds(184, 29, 86, 14);
		consultarPanel.add(lblVlrUnidade);

		JLabel lblQntEstoque = new JLabel("Qnt Estoque: ");
		lblQntEstoque.setBounds(280, 29, 86, 14);
		consultarPanel.add(lblQntEstoque);

		JLabel lblQntEstoqueMinima = new JLabel("Qnt Estoque Minima: ");
		lblQntEstoqueMinima.setBounds(376, 29, 154, 14);
		consultarPanel.add(lblQntEstoqueMinima);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jTProd.getSelectedRow() != -1) {

					Produto p = new Produto();
					ProdutoDAO pDAO = new ProdutoDAO();

					p.setNome(txtCNome.getText());
					p.setEstoque(Integer.parseInt(txtCEstoq.getText()));
					p.setEstoqueminimo(Integer.parseInt(txtCEstoqMin.getText()));
					p.setPrecoUnitario(Double.parseDouble(txtCVlr.getText()));
					p.setCodigo((int) jTProd.getValueAt(jTProd.getSelectedRow(), 0));

					pDAO.update(p);

					txtCNome.setText("");
					txtCEstoq.setText("");
					txtCEstoqMin.setText("");
					txtCVlr.setText("");

					lerJTable();

				} // Colocar um else (selecione um produto p excluir em um optionpanel
			}
		});
		btnAtualizar.setBounds(472, 44, 98, 31);
		consultarPanel.add(btnAtualizar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jTProd.getSelectedRow() != -1) {

					Produto p = new Produto();
					ProdutoDAO pDAO = new ProdutoDAO();

					p.setCodigo((int) jTProd.getValueAt(jTProd.getSelectedRow(), 0));

					pDAO.delete(p);

					txtCNome.setText("");
					txtCEstoq.setText("");
					txtCEstoqMin.setText("");
					txtCVlr.setText("");

					lerJTable();
				} // Colocar um else (selecione um produto p excluir em um optionpanel
			}
		});
		btnExcluir.setBounds(580, 44, 98, 31);
		consultarPanel.add(btnExcluir);

		txtBuscaNome = new JTextField();
		txtBuscaNome.setColumns(10);
		txtBuscaNome.setBounds(10, 97, 164, 31);
		consultarPanel.add(txtBuscaNome);

		JButton btnPesquisar = new JButton("Buscar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lerJTablePorNome(txtBuscaNome.getText());

			}
		});
		btnPesquisar.setBounds(184, 97, 98, 31);
		consultarPanel.add(btnPesquisar);

		DefaultTableModel modelo = (DefaultTableModel) jTProd.getModel();
		//lerJTable();

		JPanel cadastrarPanel = new JPanel();
		cadastrarPanel.setBackground(new Color(32, 178, 170));
		cadastrarPanel.setForeground(Color.WHITE);
		tabbedPane.addTab("Cadastrar", null, cadastrarPanel, null);
		cadastrarPanel.setLayout(null);

		txtNome = new JTextField();
		txtNome.setBounds(67, 84, 245, 35);
		cadastrarPanel.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(67, 60, 113, 14);
		cadastrarPanel.add(lblNome);

		JLabel lblVlr = new JLabel("Valor: ");
		lblVlr.setBounds(67, 130, 113, 14);
		cadastrarPanel.add(lblVlr);

		txtVlr = new JTextField();
		txtVlr.setColumns(10);
		txtVlr.setBounds(67, 154, 245, 35);
		cadastrarPanel.add(txtVlr);

		JLabel lblQuantidadeEmEstoque = new JLabel("Quantidade em estoque:");
		lblQuantidadeEmEstoque.setBounds(67, 200, 174, 14);
		cadastrarPanel.add(lblQuantidadeEmEstoque);

		txtQntEstoq = new JTextField();
		txtQntEstoq.setColumns(10);
		txtQntEstoq.setBounds(67, 224, 245, 35);
		cadastrarPanel.add(txtQntEstoq);

		JLabel lblQuantidadeMinimaEm = new JLabel("Quantidade minima em estoque:");
		lblQuantidadeMinimaEm.setBounds(67, 270, 245, 14);
		cadastrarPanel.add(lblQuantidadeMinimaEm);

		txtQntMinEstoq = new JTextField();
		txtQntMinEstoq.setColumns(10);
		txtQntMinEstoq.setBounds(67, 294, 245, 35);
		cadastrarPanel.add(txtQntMinEstoq);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Produto p = new Produto();
				ProdutoDAO pDAO = new ProdutoDAO();

				p.setNome(txtNome.getText());
				p.setEstoque(Integer.parseInt(txtQntEstoq.getText()));
				p.setEstoqueminimo(Integer.parseInt(txtQntMinEstoq.getText()));
				p.setPrecoUnitario(Double.parseDouble(txtVlr.getText()));

				pDAO.create(p);

				txtNome.setText("");
				txtQntEstoq.setText("");
				txtQntMinEstoq.setText("");
				txtVlr.setText("");

				lerJTable();

			}
		});
		btnCadastrar.setBounds(67, 375, 89, 23);
		cadastrarPanel.add(btnCadastrar);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Imprimir", null, panel_3, null);

		JLabel lblClientes = new JLabel("Produto");
		lblClientes.setHorizontalTextPosition(SwingConstants.CENTER);
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblClientes.setBounds(0, 0, 203, 45);
		add(lblClientes);
	}

	public void lerJTable() {
		DefaultTableModel modelo = (DefaultTableModel) jTProd.getModel();
		modelo.setNumRows(0);
		ProdutoDAO pDAO = new ProdutoDAO();

		for (Produto p : pDAO.read()) {
			modelo.addRow(new Object[] { p.getCodigo(), p.getNome(), p.getPrecoUnitario(), p.getEstoque(),
					p.getEstoqueminimo(), p.getDataCad()

			});
		}

	}
	
	public void lerJTablePorNome(String nomeProd) {
		DefaultTableModel modelo = (DefaultTableModel) jTProd.getModel();
		modelo.setNumRows(0);
		ProdutoDAO pDAO = new ProdutoDAO();

		for (Produto p : pDAO.buscaNome(nomeProd)) {
			modelo.addRow(new Object[] { p.getCodigo(), p.getNome(), p.getPrecoUnitario(), p.getEstoque(),
					p.getEstoqueminimo(), p.getDataCad()

			});
		}

	}
}
