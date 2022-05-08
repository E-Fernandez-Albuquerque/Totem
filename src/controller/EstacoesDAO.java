package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DBConnection;
import model.Estacoes;

public class EstacoesDAO {
	
	//FUNÇÃO RESPONSÁVEL POR INSERIR E PERSISTIR REGISTRO DE ESTAÇÕES EM BANCO DE DADOS
	public static void insertStation(Estacoes estacao) {
		Connection connection = DBConnection.conectDB();//ESTABELECIMENTO DE CONEXÃO COM DB
		PreparedStatement statement = null;//RESPONSÁVEL POR EXECUTAR AS QUERYS SQL
		
		//COMANDOS SQL
		try {
			statement = connection.prepareStatement("INSERT INTO estacoes (id) VALUES (?)");
			
			statement.setString(1, estacao.getId());//SUBSTITUI O VALOR DA "?" DO STATEMENT 
			statement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();//EXIBIR OS ERROS DE CÓDIGO SQL
		}
	}

	public static String searchStation(Estacoes estacao) {
		Connection connection = DBConnection.conectDB();//ESTABELECIMENTO DE CONEXÃO COM DB
		PreparedStatement statement;//RESPONSÁVEL POR EXECUTAR AS QUERYS SQL
		ResultSet result;//MODELO DE RETORNO DE VALORES DO DB
		
		try {
			statement = connection.prepareStatement("SELECT * FROM estacoes WHERE id = ?");
			statement.setString(1, estacao.getId());//SUBSTITUI O VALOR DA "?" DO STATEMENT 
			result = statement.executeQuery();//EXECUTA A QUERY INSERIDA NO PREPARESTATEMENT
			result.next();//ORDENAÇÃO DO CURSOR NO RESULTSET
			return result.getString("id");//SELECIONA A COLUNA A SER RETORNADA
			
		} catch (SQLException e1) {
			e1.printStackTrace();//EXIBIR OS ERROS DE CÓDIGO SQL
			return "(Erro) Estacao nao localizada";
		}
	}
}
