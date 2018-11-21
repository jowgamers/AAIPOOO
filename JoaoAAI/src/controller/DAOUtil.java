package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionManager;

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

}
