package controller;

import java.io.ObjectInputFilter.Status;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import model.Usuarios;
import model.DBConnection;
import model.DBTables;
import model.Estacoes;
import model.Reservas;

public class teste_exec {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		/*
		DBConnection.conectDB();
		DBTables.createTableUser();
		DBTables.createTableStation();
		DBTables.createTableReservation();
		*/
		Usuarios usuario = new Usuarios();
		usuario.setId("123");
		usuario.setName("Usuario Teste RFID");
		UsuariosDAO.insertUser(usuario);
		
		Estacoes estacao = new Estacoes();
		estacao.setId("A02");
		EstacoesDAO.insertStation(estacao);
		
		Reservas reserva = new Reservas();
		reserva.setDate("08/05/2022");
		reserva.setDuration(8);
		reserva.setCheckout(false);
		reserva.setCheckin(false);
		ReservasDAO.insertReservation(reserva, estacao, usuario);
		
		String rUsuario = UsuariosDAO.searchUser(usuario);
		String rEstacao = EstacoesDAO.searchStation(estacao);
		ResultSet rDataReserva = ReservasDAO.searchReservation(usuario);
		rDataReserva.next();
		String data = rDataReserva.getString("date");
		System.out.println("Reserva encontrada: " + rUsuario + " - " + rEstacao + " - " + rDataReserva.getString("date"));
		System.out.println("Status: Checkin=" + rDataReserva.getBoolean("checkin") + " Checkout=" + rDataReserva.getBoolean("checkout"));
		System.out.print("Insira o seu id: ");
		String id = sc.nextLine();
		Usuarios id_RFID = new Usuarios();
		id_RFID.setId(id);
		System.out.println("Realizando checkin...");
		ReservasDAO.leitura_id(id_RFID);
		ResultSet RFID = ReservasDAO.searchReservation(id_RFID);
		RFID.next();
		System.out.println("Status: Checkin=" + RFID.getBoolean("checkin") + " Checkout=" + RFID.getBoolean("checkout"));
	}
}
