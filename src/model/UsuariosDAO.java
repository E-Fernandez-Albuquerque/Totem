package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuariosDAO {

		public static void inserirFuncionario(String id, String nome, String time) {
			Connection connection = DBConnection.conectaDB();//ESTABELECIMENTO DE CONEXÃO COM DB
			PreparedStatement statement = null;//RESPONSÁVEL POR EXECUTAR AS QUERYS SQL
			
			try {
				statement = connection.prepareStatement("INSERT INTO funcionarios (id, nome, meu_time) VALUES (?, ?, ?)");//COMANDO SQL
				statement.setString(1, id);//SUBSTITUI O VALOR DA "?" DO STATEMENT 
				statement.setString(2, nome);//SUBSTITUI O VALOR DA "?" DO STATEMENT 
				statement.setString(3, time);//SUBSTITUI O VALOR DA "?" DO STATEMENT 
				statement.executeUpdate();//EXECUTA A QUERY INSERIDA NO PREPARESTATEMENT
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		public static ResultSet procurarFuncionario(String id) {
			Connection connection = DBConnection.conectaDB();//ESTABELECIMENTO DE CONEXÃO COM DB
			PreparedStatement statement = null;//RESPONSÁVEL POR EXECUTAR AS QUERYS SQL
			ResultSet result;
			try {
				statement = connection.prepareStatement("SELECT * FROM funcionarios WHERE id = ?");//COMANDO SQL
				statement.setString(1, id);//SUBSTITUI O VALOR DA "?" DO STATEMENT 
				result = statement.executeQuery();//EXECUTA A QUERY INSERIDA NO PREPARESTATEMENT
				result.next();
				return result;
			} catch (SQLException e) {
				return null;
			}
		}
}
