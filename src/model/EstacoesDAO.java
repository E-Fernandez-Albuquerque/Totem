package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

public class EstacoesDAO {
	/*
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
	*/
	
	//FUNÇÃO PARA REGISTRAR UMA NOVA ESÇÃO
	public static void inserirEstacao(String id) {
		Connection connection = DBConnection.conectaDB();//ESTABELECIMENTO DE CONEXÃO COM DB
		PreparedStatement statement = null;//RESPONSÁVEL POR EXECUTAR AS QUERYS SQL
		
		//COMANDOS SQL
		try {
			statement = connection.prepareStatement("INSERT INTO estacoes (estacao) VALUES (?)");
			
			statement.setString(1, id);//SUBSTITUI O VALOR DA "?" DO STATEMENT 
			statement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();//EXIBIR OS ERROS DE CÓDIGO SQL
		} finally {
			try {
				if(statement != null){
					statement.close();
					connection.close();
				}
			} catch (SQLException e) {
				// LOGGING
				e.printStackTrace();
			}
		}
	}
	
	//VERIFICA ESTAÇÕES LIVRES, RETORNANDO
	//TROCAR 'PRINT' POR ARRAY
	public static ArrayList<String> verificarEstacoesLivres (String data) {
		Connection connection = DBConnection.conectaDB();
		PreparedStatement statement = null;
		ResultSet estacoesLivres = null;
		ArrayList<String> estacoes = new ArrayList<>(1);
		try {
			statement = connection.prepareStatement("SELECT estacao FROM estacoes WHERE estacao NOT IN (SELECT id_estacao FROM reservas WHERE data = ?)");
			statement.setString(1, data);
			estacoesLivres = statement.executeQuery();
			while (estacoesLivres.next()) {
				estacoes.add(estacoesLivres.getString("estacao"));
			}
			return estacoes;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(statement != null){
					statement.close();
					connection.close();
				}
			} catch (SQLException e) {
				// LOGGING
				e.printStackTrace();
			}
		}
		return estacoes;
	}
	
	public static ArrayList<String> todasEstacoes(){
		Connection connection = DBConnection.conectaDB();
		PreparedStatement statement = null;
		ResultSet estacoesLivres = null;
		ArrayList<String> estacoes = new ArrayList<>(1);
		try {
			statement = connection.prepareStatement("SELECT estacao FROM estacoes");
			estacoesLivres = statement.executeQuery();
			while (estacoesLivres.next()) {
				estacoes.add(estacoesLivres.getString("estacao"));
			}
			return estacoes;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(statement != null){
					statement.close();
					connection.close();
				}
			} catch (SQLException e) {
				// LOGGING
				e.printStackTrace();
			}
		}
		return estacoes;
	}
}
