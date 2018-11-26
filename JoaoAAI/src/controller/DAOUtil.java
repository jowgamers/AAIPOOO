package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionManager;
import model.Estastiticas;
import model.Produto;

public class DAOUtil {
	/**
	 * Metodo para vereficar a quantidade de registros presentes em uma tabela, usado na tela principal
	 * @param tabela
	 * @return quantidade na tabela
	 */

	public String qntdRegis(String tabela) {

		Connection con = null;
		String qntdRegistros = "";
		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;


		try {
			stmt = con.prepareStatement("SELECT COUNT(*) as qntde FROM "+tabela);
			rs = stmt.executeQuery();

			while (rs.next()) {
				qntdRegistros = (rs.getString("qntde")); //Confirmar se posso usar como String
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qntdRegistros;

	}

	public List<Estastiticas> read() {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Estastiticas> listaEstastiticas = new ArrayList<Estastiticas>();

		try {
			stmt = con.prepareStatement("SELECT * FROM produtos");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Estastiticas es = new Estastiticas();
				/*
				es.setNome(nome);
				es.setQntde(qntde);
				es.setValor(valor);	
				
				p.setCodigo(rs.getInt("cod_prod"));
				p.setNome(rs.getString("nome_prod"));
				p.setPrecoUnitario(rs.getDouble("vlr_unid"));
				p.setEstoque(rs.getInt("qnt_estoq"));
				p.setEstoqueminimo(rs.getInt("qnt_estoq_min"));
				p.setDataCad(rs.getDate("data_cad"));
*/
				listaEstastiticas.add(es);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaEstastiticas;

	}


}
