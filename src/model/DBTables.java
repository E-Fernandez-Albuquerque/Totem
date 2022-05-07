package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBTables {

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
	
	
	public static void createTableStation() {
		Connection connection = DBConnection.conectDB();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS estacoes "
					+ "(station VARCHAR(3) PRIMARY KEY");
			statement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	
	public static void createTableReservation() {
		Connection connection = DBConnection.conectDB();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS reservas "
					+ "(id VARCHAR(8) PRIMARY KEY, station VARCHAR(3), date VARCHAR(10), duration int, user VARCHAR(8), checkin BOOLEAN, "
					+ "checkout BOOLEAN, FOREIGN KEY (station) REFERENCES station(id), FOREIGN KEY (user) REFERENCES users(id))");
			statement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
}
