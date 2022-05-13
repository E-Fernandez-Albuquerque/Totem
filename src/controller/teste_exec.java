package controller;

import java.io.ObjectInputFilter.Status;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import model.Usuarios;
import model.UsuariosDAO;
import model.DBConnection;
import model.DBTables;
import model.Estacoes;
import model.EstacoesDAO;
import model.Reservas;
import model.ReservasDAO;

public class teste_exec {

	public static void main(String[] args) throws SQLException {
		
		//UsuariosDAO.inserirFuncionario("32112ARR", "Eric", "Desenvolvimento");
		//EstacoesDAO.inserirEstacaoMockada("A22");
		//ReservasDAO.inserirReservaMockada(1, "A22", "2022-05-15 08:00:00", "2022-05-15 12:00:00", null, null, "32112ARR");
		
		//ReservasDAO.fazerCheckin("32112ARR", "2022-05-15 08:00:00");
		
		
		while (true) {
			Scanner sc = new Scanner (System.in);
		
			System.out.println("ID: ");
			String id = sc.nextLine();
			String horaInicio = "2022-05-15 08:00:00";
			String horaSaida = "2022-05-15 12:00:00";
		
			String idRetorno = UsuariosDAO.procurarFuncionario(id);
		
			if (idRetorno != null) {
				boolean reserva = ReservasDAO.verificaReserva(idRetorno, horaInicio);
				boolean checkin = ReservasDAO.verificaCheckinReserva(idRetorno, horaInicio);
				boolean checkout = ReservasDAO.verificaCheckoutReserva(idRetorno, horaSaida);
				if (reserva && !checkin && !checkout) {
					ReservasDAO.fazerCheckin(idRetorno, horaInicio);
					System.out.println("Realizando checkin...");
					continue;
				} else if (reserva && checkin && !checkout){
					ReservasDAO.fazerCheckout(idRetorno, horaSaida);
					System.out.println("Realizando checkout...");
					continue;
				} else {
					System.out.println("Nenhuma reserva localizada para o usuário. Realize uma nova reserva.");
					System.out.println("Estações livres: ");
					EstacoesDAO.verificarEstacoesLivres(horaInicio);
					break;
				}
			} else {
				System.out.println("Usuário não identificado");
			}
		}
		
		

		
		
		
		/*
		Scanner sc = new Scanner(System.in);
		
		//CRIAÇÃO DE OBJETOS
		Reservas reserva = new Reservas();
		reserva.setCheckin(false);
		reserva.setCheckout(false);
		reserva.setDate("09/05/2022");
		reserva.setDuration(8);
		
		Usuarios usuario = new Usuarios();
		usuario.setId("555");
		usuario.setName("Eric");
		
		Estacoes estacao = new Estacoes();
		estacao.setId("B38");
		
		//PERSISTÊNCIA EM DB (CREATE)
		UsuariosDAO.insertUser(usuario);
		EstacoesDAO.insertStation(estacao);
		ReservasDAO.insertReservation(reserva, estacao, usuario);
		
		//RECUPERAÇÃO DE INFORMAÇÕES (READ)
		Usuarios usuario2 = new Usuarios();
		System.out.println("ID: ");
		String id = sc.nextLine();
		usuario2.setId(id);
		ResultSet retornoDB = UsuariosDAO.searchUser(usuario2);
		try {
			retornoDB.next();
			String userName = retornoDB.getString("name");
			System.out.println("Nome do usuario: " + userName);
		
			ResultSet reservaDB = ReservasDAO.searchReservation(usuario2);
			reservaDB.next();
			String stationId = reservaDB.getString("id_estacao");
			String stationDate = reservaDB.getString("date");
			System.out.print("Estacao reservada: " + stationId + " - " + stationDate);
		} catch (SQLException e){
			int test = 5;
			if (test==5) {
				System.out.println("IF dentro de catch");
			} else {
				System.out.println("else dentro de catch");
			}
			System.out.println("ID nao localizado!");
		}
	*/}
}
