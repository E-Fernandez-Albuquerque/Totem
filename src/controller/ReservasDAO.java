package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DBConnection;
import model.Reservas;
import model.Estacoes;
import model.Usuarios;

import java.util.Scanner;

public class ReservasDAO {
	
	public static void insertReservation(Reservas reserva, Estacoes estacao, Usuarios usuario) {
		Connection connection = DBConnection.conectDB();//ESTABELECIMENTO DE CONEXÃO COM DB
		PreparedStatement statement = null;//RESPONSÁVEL POR EXECUTAR AS QUERYS SQL
		
		try {
			statement = connection.prepareStatement("INSERT INTO reservas (id_usuario, id_estacao, date, duration, checkin, checkout) VALUES (?, ?, ?, ?, ?, ?)");//COMANDO SQL
			statement.setString(1, usuario.getId());//SUBSTITUI O VALOR DA "?" DO STATEMENT 
			statement.setString(2, estacao.getId());//SUBSTITUI O VALOR DA "?" DO STATEMENT 
			statement.setString(3, reserva.getDate());//SUBSTITUI O VALOR DA "?" DO STATEMENT 
			statement.setInt(4, reserva.getDuration());//SUBSTITUI O VALOR DA "?" DO STATEMENT 
			statement.setBoolean(5, reserva.isCheckin());//SUBSTITUI O VALOR DA "?" DO STATEMENT 
			statement.setBoolean(6, reserva.isCheckout());//SUBSTITUI O VALOR DA "?" DO STATEMENT 
			statement.executeUpdate();//EXECUTA A QUERY INSERIDA NO PREPARESTATEMENT
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

	public static ResultSet searchReservation(Usuarios usuario) {
		Connection connection = DBConnection.conectDB();//ESTABELECIMENTO DE CONEXÃO COM DB
		PreparedStatement statement;//RESPONSÁVEL POR EXECUTAR AS QUERYS SQL
		ResultSet result;//MODELO DE RETORNO DE VALORES DO DB
		try {
			statement = connection.prepareStatement("SELECT * FROM reservas WHERE id_usuario = ?");
			statement.setString(1, usuario.getId());//SUBSTITUI O VALOR DA "?" DO STATEMENT 
			result = statement.executeQuery();//EXECUTA A QUERY INSERIDA NO PREPARESTATEMENT
			return result;
			
		} catch (SQLException e1) {
			e1.printStackTrace();//EXIBIR OS ERROS DE CÓDIGO SQL
			return null;
		}
	}
	
	public static void leitura_id(Usuarios usuario) {
		Connection connection = DBConnection.conectDB();//ESTABELECIMENTO DE CONEXÃO COM DB
		PreparedStatement statement = null;//RESPONSÁVEL POR EXECUTAR AS QUERYS SQL
		ResultSet results;//MODELO DE RETORNO DE VALORES DO DB
		try {
			statement = connection.prepareStatement("SELECT * FROM reservas WHERE id_usuario = ?");
			statement.setString(1, usuario.getId());//SUBSTITUI O VALOR DA "?" DO STATEMENT 
			results = statement.executeQuery();//EXECUTA A QUERY INSERIDA NO PREPARESTATEMENT
			
			results.next();
			Boolean checkin = results.getBoolean("checkin");//RETORNA O VALOR DE UMA COLUNA PARA A VARIÁVEL
			Boolean checkout = results.getBoolean("checkout");//RETORNA O VALOR DE UMA COLUNA PARA A VARIÁVEL
			Reservas reserva = new Reservas();//CRIA UM OBJETO 
			reserva.setId_usuario(usuario.getId());//DEFINE VALOR PARA UM ATRIBUTO DO OBJETO
			reserva.setCheckin(checkin);//DEFINE VALOR PARA UM ATRIBUTO DO OBJETO
			reserva.setCheckout(checkout);//DEFINE VALOR PARA UM ATRIBUTO DO OBJETO
			
			//VERIFICAÇÃO DE STATUS DE RESERVA
			if (reserva.isCheckin() == false && reserva.isCheckout() == false) {
			try {
				statement = connection.prepareStatement("UPDATE reservas SET checkin = true WHERE id_usuario = ?");
				statement.setString(1, usuario.getId());//SUBSTITUI O VALOR DA "?" DO STATEMENT 
				statement.executeUpdate();//EXECUTA A QUERY INSERIDA NO PREPARESTATEMENT
				System.out.println("Realizando checkin...");
			}catch (SQLException e){
				e.printStackTrace();//EXIBIR OS ERROS DE CÓDIGO SQL
			}
			
		} else if (reserva.isCheckin() == true && reserva.isCheckout() == false) {
			try {
				statement = connection.prepareStatement("UPDATE reservas SET checkout = true WHERE id_usuario = ?");
				statement.setString(1, usuario.getId());
				statement.executeUpdate();//EXECUTA A QUERY INSERIDA NO PREPARESTATEMENT
				System.out.println("Realizando checkout...");
			}catch (SQLException e){
				e.printStackTrace();//EXIBIR OS ERROS DE CÓDIGO SQL
			}
		} else {
			try {
				statement = connection.prepareStatement("DELETE FROM reservas WHERE id_usuario = ?");
				statement.setString(1, usuario.getId());
				statement.executeUpdate();//EXECUTA A QUERY INSERIDA NO PREPARESTATEMENT
				System.out.println("Realizar nova reserva!");
			}catch (SQLException e){
				e.printStackTrace();//EXIBIR OS ERROS DE CÓDIGO SQL
			}
		}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
