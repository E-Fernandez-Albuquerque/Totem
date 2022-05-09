package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DBConnection;
import model.Usuarios;

public class UsuariosDAO {
	//INSERIR E PERSISTIR USUÁRIO EM DB
	public static void insertUser(Usuarios usuario) {
		Connection connection = DBConnection.conectDB();//ESTABELECIMENTO DE CONEXÃO COM DB
		PreparedStatement statement = null;//RESPONSÁVEL POR EXECUTAR AS QUERYS SQL
		
		try {
			statement = connection.prepareStatement("INSERT INTO usuarios (id, name) VALUES (?, ?)");//COMANDO SQL
			statement.setString(1, usuario.getId());//SUBSTITUI O VALOR DA "?" DO STATEMENT 
			statement.setString(2, usuario.getName());//SUBSTITUI O VALOR DA "?" DO STATEMENT 
			statement.executeUpdate();//EXECUTA A QUERY INSERIDA NO PREPARESTATEMENT
		}catch (SQLException e){
			e.printStackTrace();//EXIBIR OS ERROS DE CÓDIGO SQL
		}
	}
	//PROCURAR E RETORNAR USUÁRIO DO DB
	public static ResultSet searchUser(Usuarios usuario) {
		Connection connection = DBConnection.conectDB();//ESTABELECIMENTO DE CONEXÃO COM DB
		PreparedStatement statement;//RESPONSÁVEL POR EXECUTAR AS QUERYS SQL
		ResultSet result;//MODELO DE RETORNO DE VALORES DO DB
		try {
			statement = connection.prepareStatement("SELECT * FROM usuarios WHERE id = ?");//COMANDO SQL
			statement.setString(1, usuario.getId());//SUBSTITUI O VALOR DA "?" DO STATEMENT 
			result = statement.executeQuery();//EXECUTA A QUERY INSERIDA NO PREPARESTATEMENT
			return result;
			
		} catch (SQLException e1) {
			e1.printStackTrace();//EXIBIR OS ERROS DE CÓDIGO SQL
			return null;
		}
	}
}
