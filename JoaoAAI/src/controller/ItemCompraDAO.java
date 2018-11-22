package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionManager;
import model.ItemCompra;
import model.Produto;

public class ItemCompraDAO {
	public void create(ItemCompra i) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;

		// Falta fechar a conexão com o banco
		try {
			stmt = con.prepareStatement(
					"INSERT INTO itemcompra (cod_prod, qnt_cmp, vlr_cmp, cmp_fnl) VALUES (?, ?, ?, N");
			
			stmt.setInt(1, i.getProduto());
			stmt.setDouble(2, i.getQuantCompra());
			stmt.setDouble(3, i.getValorCompra());
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Item adicionado ao carrinho", "Acões BD",
					JOptionPane.PLAIN_MESSAGE);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto no carrinho " + e, "Acões BD", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public List<ItemCompra> read() {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<ItemCompra> ItemCompra = new ArrayList<ItemCompra>();

		try {
			stmt = con.prepareStatement("SELECT * FROM ItemCompra");
			rs = stmt.executeQuery();

			while (rs.next()) {
				ItemCompra iC = new ItemCompra();
				iC.setCodCompra(rs.getInt("num_cmp"));
				iC.setProduto(rs.getInt("cod_prod"));
				iC.setQuantCompra(rs.getInt("cod_prod"));
				iC.setValorCompra(rs.getDouble("cod_prod"));
				iC.setCompraFinalizada(rs.getString("cmp_fnl"));

				ItemCompra.add(iC);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ItemCompra;

	}

	public void delete(ItemCompra iC) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM ItemCompra WHERE num_cmp = ?");
			stmt.setInt(1, iC.getProduto());
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Produto excluido com sucesso", "Acões BD", JOptionPane.PLAIN_MESSAGE);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao excluir produto " + e, "Acões BD", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}
}
