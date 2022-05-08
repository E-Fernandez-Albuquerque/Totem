package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//CLASSE RESPONSÁVEL POR CRIAR AS TABELAS GENÉRICAS 
public class DBTables {

	//TABELA DE USUÁRIOS
	public static void createTableUser() {
		Connection connection = DBConnection.conectDB();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS usuarios "
					+ "(id varchar(8) PRIMARY KEY, " + "name varchar(255) NOT NULL)");
			statement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	//TABELA DE ESTAÇÕES DE TRABALHO
	public static void createTableStation() {
		Connection connection = DBConnection.conectDB();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS estacoes "
					+ "(id VARCHAR(3) PRIMARY KEY)");
			statement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	//TABELA DE RESERVAS
	public static void createTableReservation() {
		Connection connection = DBConnection.conectDB();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS reservas "
					+ "(id_usuario VARCHAR(8), id_estacao VARCHAR(3), date VARCHAR(10), duration int, checkin BOOLEAN, "
					+ "checkout BOOLEAN, FOREIGN KEY (id_usuario) REFERENCES usuarios(id), FOREIGN KEY (id_estacao) REFERENCES estacoes(id))");
			statement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
}
