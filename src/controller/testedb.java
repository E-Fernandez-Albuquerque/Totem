package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DBConnection;
import model.DBTables;
public class testedb {
	
	public static void criarTableRegistro() {
		Connection conexao = DBConnection.conectaDB();
		PreparedStatement statement = null;
		try {
			statement = conexao.prepareStatement("CREATE TABLE IF NOT EXISTS usuarios_cesar "
					+ "(id int AUTO_INCREMENT PRIMARY KEY, " + "nome varchar(255) NOT NULL, "
					+ "cpf varchar(14) NOT NULL UNIQUE, " + "rg varchar(14) NOT NULL, "
					+ "telefone varchar(16) NOT NULL, " + "nascimento varchar(10) NOT NULL, "
					+ "cep varchar(10) NOT NULL, " + "rua varchar(60) NOT NULL, " + "numero varchar(6) NOT NULL, "
					+ "obs TEXT, " + "email varchar(80) NOT NULL)");
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
