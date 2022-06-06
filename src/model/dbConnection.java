package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBConnection {
	
	static String database = "";
	//VARIÁVEIS RESPONSÁVEIS PELA CONEXÃO COM O BANCO DE DADOS
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/" + database + "?useUnicode=yes&characterEncoding=UTF-8&useSSL=false&max-connections=1500";
	private static final String USER = "root";
	private static final String PWD = "";
	
	public static String criaDB(String nomeBD) {
		try {
			Class.forName(DRIVER);
			System.out.println(URL);
			Connection connection = DriverManager.getConnection(URL, USER, PWD);
			PreparedStatement statement = null;
			try {
				statement = connection.prepareStatement("CREATE DATABASE IF NOT EXISTS " + nomeBD);
				System.out.println(statement);
				statement.executeUpdate();
				return "jdbc:mysql://localhost:3306/" + nomeBD + "?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";
			}catch (SQLException e){
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	};
	
	//FUNÇÃO RESPONSÁVEL PELA CONEXÃO COM O DB
	public static Connection conectaDB() {
		database = "CesarTotem";
		URL = criaDB(database);
		System.out.println(URL);
		try {
			Class.forName(DRIVER);
			System.out.println(URL);
			return DriverManager.getConnection(URL, USER, PWD);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
