package model;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
	//VARIÁVEIS RESPONSÁVEIS PELA CONEXÃO COM O BANCO DE DADOS
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/cesar?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";
	private static final String USER = "root";
	private static final String PWD = "";
	
	//FUNÇÃO RESPONSÁVEL PELA CONEXÃO COM O DB
	public static Connection conectDB() {

		try {
			Class.forName(DRIVER);
			
			return DriverManager.getConnection(URL, USER, PWD);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
