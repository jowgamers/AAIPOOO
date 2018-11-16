package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import connection.ConnectionManager;
import model.Usuario;

public class UsuarioDAO {

	public boolean confereLogin(String matricula, String senha) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean valido = false;

		try {

			stmt = con.prepareStatement("SELECT * from usuario WHERE matricula = ? and senha = ?"); // Devo usar aspas?
																									// Testar dps
			stmt.setString(1, matricula);
			stmt.setString(2, senha);
			rs = stmt.executeQuery();

			if (rs.next()) {
				valido = true;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return valido;

	}

}
