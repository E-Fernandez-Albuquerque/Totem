package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ReservasDAO {
	/*
	//SEM USO
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
	
	//SEM USO
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
	*/
	//FUNÇÃO QUE REGISTRA UMA NOVA RESERVA
	public static void inserirReserva(String idEstacao, String data, String dataHoraInicio, String dataHoraFim, String checkin, String checkout, String idFuncionario) {
		Connection connection = DBConnection.conectaDB();//ESTABELECIMENTO DE CONEXÃO COM DB
		PreparedStatement statement = null;//RESPONSÁVEL POR EXECUTAR AS QUERYS SQL
		
		try {
			statement = connection.prepareStatement("INSERT INTO reservas (id_estacao, data, reserva_inicia_em, reserva_termina_em, check_in_em, check_out_em, id_funcionario) VALUES (?, ?, ?, ?, ?, ?, ?)");//COMANDO SQL
			statement.setString(1, idEstacao);//SUBSTITUI O VALOR DA "?" DO STATEMENT 
			statement.setString(2, data);//SUBSTITUI O VALOR DA "?" DO STATEMENT 
			statement.setString(3, dataHoraInicio);//SUBSTITUI O VALOR DA "?" DO STATEMENT 
			statement.setString(4, dataHoraFim);//SUBSTITUI O VALOR DA "?" DO STATEMENT 
			statement.setString(5, checkin);//SUBSTITUI O VALOR DA "?" DO STATEMENT 
			statement.setString(6, checkout);//SUBSTITUI O VALOR DA "?" DO STATEMENT 
			statement.setString(7, idFuncionario);
			statement.executeUpdate();//EXECUTA A QUERY INSERIDA NO PREPARESTATEMENT
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	//REALIZA O CHECKIN DE UMA RESERVA
	public static void fazerCheckin(String id, String data, String horaInicio) {
		Connection connection = DBConnection.conectaDB();//ESTABELECIMENTO DE CONEXÃO COM DB
		PreparedStatement statement = null;//RESPONSÁVEL POR EXECUTAR AS QUERYS SQL
		ResultSet result;//MODELO DE RETORNO DE VALORES DO DB
		try {
			statement = connection.prepareStatement("select * from reservas where id_funcionario = ? and data = ?");//COMANDO SQL
			statement.setString(1, id);//SUBSTITUI O VALOR DA "?" DO STATEMENT 
			statement.setString(2, data);//SUBSTITUI O VALOR DA "?" DO STATEMENT 
			result = statement.executeQuery();//EXECUTA A QUERY INSERIDA NO PREPARESTATEMENT
			result.next();
			
			String checkin = result.getString("check_in_em");
			String inicio = horaInicio;
			if (checkin == null) {
				statement = connection.prepareStatement("UPDATE reservas SET check_in_em = ? WHERE id_funcionario = ? AND data = ?");//COMANDO SQL
				statement.setString(1, inicio);//SUBSTITUI O VALOR DA "?" DO STATEMENT 
				statement.setString(2, id);//SUBSTITUI O VALOR DA "?" DO STATEMENT 
				statement.setString(3, data);//SUBSTITUI O VALOR DA "?" DO STATEMENT 
				statement.executeUpdate();
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	//VERIFICA STATUS DA RESERVA - RETORNA BOOLEANO
	public static boolean verificaReserva(String idFuncionario, String data) {
		Connection connection = DBConnection.conectaDB();//ESTABELECIMENTO DE CONEXÃO COM DB
		PreparedStatement statement = null;//RESPONSÁVEL POR EXECUTAR AS QUERYS SQL
		ResultSet reserva;
		
		try {
			statement = connection.prepareStatement("SELECT * FROM reservas WHERE id_funcionario = ? AND data = ?");
			statement.setString(1, idFuncionario);
			statement.setString(2, data);
			reserva = statement.executeQuery();
			if (reserva.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//VERIFICA STATUS DE CHECKIN - RETORNA BOOLEANO
	public static boolean verificaCheckinReserva(String idFuncionario, String data) {
		Connection connection = DBConnection.conectaDB();//ESTABELECIMENTO DE CONEXÃO COM DB
		PreparedStatement statement = null;//RESPONSÁVEL POR EXECUTAR AS QUERYS SQL
		ResultSet reserva;
		
		try {
			statement = connection.prepareStatement("SELECT check_in_em FROM reservas WHERE id_funcionario = ? AND data = ?");
			statement.setString(1, idFuncionario);
			statement.setString(2, data);
			reserva = statement.executeQuery();
			if (reserva.next()) {
				String checkin = reserva.getString("check_in_em");
				if (checkin == null) {
					return false;
				} else {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//FAZ CHECKOUT
	public static void fazerCheckout(String id, String data, String horaSaida) {
		Connection connection = DBConnection.conectaDB();//ESTABELECIMENTO DE CONEXÃO COM DB
		PreparedStatement statement = null;//RESPONSÁVEL POR EXECUTAR AS QUERYS SQL
		ResultSet result;//MODELO DE RETORNO DE VALORES DO DB
		try {
			statement = connection.prepareStatement("select * from reservas where id_funcionario = ? and data = ?");//COMANDO SQL
			statement.setString(1, id);//SUBSTITUI O VALOR DA "?" DO STATEMENT 
			statement.setString(2, data);//SUBSTITUI O VALOR DA "?" DO STATEMENT 
			result = statement.executeQuery();//EXECUTA A QUERY INSERIDA NO PREPARESTATEMENT
			result.next();
			
			String checkout = result.getString("check_out_em");
			String horaFinal = result.getString("reserva_termina_em");
			if (checkout == null) {
				statement = connection.prepareStatement("DELETE FROM reservas WHERE id_funcionario = ? AND data = ?");//COMANDO SQL
				statement.setString(1, id);//SUBSTITUI O VALOR DA "?" DO STATEMENT 
				statement.setString(2, data);//SUBSTITUI O VALOR DA "?" DO STATEMENT 
				statement.executeUpdate();
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	//VERIFICA STATUS DO CHECKOUT - RETORNA BOOLEANO
	public static boolean verificaCheckoutReserva(String idFuncionario, String data) {
		Connection connection = DBConnection.conectaDB();//ESTABELECIMENTO DE CONEXÃO COM DB
		PreparedStatement statement = null;//RESPONSÁVEL POR EXECUTAR AS QUERYS SQL
		ResultSet reserva;
		
		try {
			statement = connection.prepareStatement("SELECT check_out_em FROM reservas WHERE id_funcionario = ? AND data = ?");
			statement.setString(1, idFuncionario);
			statement.setString(2, data);
			reserva = statement.executeQuery();
			if (reserva.next()) {
				String checkout = reserva.getString("check_out_em");
				if (checkout == null) {
					return false;
				} else {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static ResultSet dadosReserva(String idFuncionario, String data) {
		Connection connection = DBConnection.conectaDB();//ESTABELECIMENTO DE CONEXÃO COM DB
		PreparedStatement statement = null;//RESPONSÁVEL POR EXECUTAR AS QUERYS SQL
		ResultSet reserva;
		
		try {
			statement = connection.prepareStatement("SELECT * FROM reservas WHERE id_funcionario = ? AND data = ?");
			statement.setString(1, idFuncionario);
			statement.setString(2, data);
			reserva = statement.executeQuery();
			reserva.next();
			if (reserva != null) {
				return reserva;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
