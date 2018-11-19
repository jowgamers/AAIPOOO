package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionManager;
import model.Fornecedor;
import model.Vendedor;

public class FornecedorDAO {
	
	public void create(Fornecedor f) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"INSERT INTO fornecedores (nom_frn, tel_frn, cnpj_frn, eml_frn, dta_cad_frn, nom_cto) VALUES (?,?,?,?,NOW(),?) ");

			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getTelefones());
			stmt.setString(3, f.getCnpj());
			stmt.setString(4, f.getEmail());
			stmt.setString(6, f.getNomeContato());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso", "Acões BD",
					JOptionPane.PLAIN_MESSAGE);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao cadastrar fornecedor" + e, "Acões BD",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public List<Fornecedor> read() {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();

		try {
			stmt = con.prepareStatement("SELECT * FROM fornecedores");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Fornecedor f = new Fornecedor();
				f.setCodigo(rs.getInt("cod_frn"));
				f.setNome(rs.getString("nom_frn"));
				f.setTelefones(rs.getString("tel_frn"));
				f.setCnpj(rs.getString("cnpj_frn"));
				f.setEmail(rs.getString("eml_frn"));
				f.setDataCad(rs.getDate("dta_cad_frn"));
				f.setNomeContato(rs.getString("nom_cto"));

				listaFornecedor.add(f);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaFornecedor;

	}

	public void update(Fornecedor f) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"UPDATE vendedores SET nom_frn = ? , tel_frn = ? , cnpj_frn = ? , eml_frn = ? , nom_cto = ? WHERE cod_frn = ?");

			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getTelefones());
			stmt.setString(3, f.getCnpj());
			stmt.setString(4, f.getEmail());
			stmt.setString(5, f.getNomeContato());
			stmt.setInt(6, f.getCodigo());
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso", "Acões BD",
					JOptionPane.PLAIN_MESSAGE);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao atualizar fornecedor" + e, "Acões BD",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public void delete(Fornecedor f) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM fornecedores WHERE cod_vnd = ?");
			stmt.setInt(1, f.getCodigo());
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Fornecedor excluido com sucesso", "Acões BD", JOptionPane.PLAIN_MESSAGE);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao excluir fornecedor " + e, "Acões BD", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public List<Fornecedor> buscaPorNomeForn(String nomFor) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();

		try {
			stmt = con.prepareStatement("SELECT * FROM fornecedores WHERE cod_frn like ?");
			stmt.setString(1, "%" + nomFor + "%");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Fornecedor f = new Fornecedor();
				f.setCodigo(rs.getInt("cod_frn"));
				f.setNome(rs.getString("nom_frn"));
				f.setTelefones(rs.getString("tel_frn"));
				f.setCnpj(rs.getString("cnpj_frn"));
				f.setEmail(rs.getString("eml_frn"));
				f.setDataCad(rs.getDate("dta_cad_frn"));
				f.setNomeContato(rs.getString("nom_cto"));

				listaFornecedor.add(f);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaFornecedor;

	}
}
