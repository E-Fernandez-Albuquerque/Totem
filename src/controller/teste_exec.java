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
		//EstacoesDAO.inserirEstacao("A22");
		ReservasDAO.inserirReserva(1, "A22", "2022-05-15 08:00:00", "2022-05-15 12:00:00", null, null, "32112ARR");
		
		//ReservasDAO.fazerCheckin("32112ARR", "2022-05-15 08:00:00");
		
		/*
		while (true) {
			Scanner sc = new Scanner (System.in);//INICIALIZA UM SCANNER PARA LEITURA DO ID
		
			System.out.println("ID: ");
			String id = sc.nextLine();//AGUARDA INSERÇÃO DO ID
			String horaInicio = "2022-05-15 08:00:00";
			String horaSaida = "2022-05-15 12:00:00";
		
			String idRetorno = UsuariosDAO.procurarFuncionario(id);//VERIFICA EXISTÊNCIA DO ID
		
			if (idRetorno != null) {//CASO O ID NÃO SEJA NULO
				boolean reserva = ReservasDAO.verificaReserva(idRetorno, horaInicio);//VERIFICA EXISTÊNCIA DE RESERVA
				boolean checkin = ReservasDAO.verificaCheckinReserva(idRetorno, horaInicio);//VERIFICA EXISTÊNCIA DE CHECKIN
				boolean checkout = ReservasDAO.verificaCheckoutReserva(idRetorno, horaSaida);//VERIFICA EXISTÊNCIA DE CHECKOUT
				if (reserva && !checkin && !checkout) {//SE EXISTIR APENAS RESERVA
					ReservasDAO.fazerCheckin(idRetorno, horaInicio);//REALIZA O CHECKIN
					System.out.println("Realizando checkin...");
					continue;
				} else if (reserva && checkin && !checkout){//SE CHECKIN JÁ FOI REALIZADO
					ReservasDAO.fazerCheckout(idRetorno, horaSaida);//REALIZA O CHECKOUT
					System.out.println("Realizando checkout...");
					continue;
				} else {//CASO NÃO EXISTA RESERVA
					System.out.println("Nenhuma reserva localizada para o usuário. Realize uma nova reserva.");
					System.out.println("Estações livres: ");
					EstacoesDAO.verificarEstacoesLivres(horaInicio);//PRINTA ESTAÇÕES LIVRES PARA O HORÁRIO ESPECIFICADO
					break;
				}
			} else {//CASO ID NÃO SEJA IDENTIFICADO
				System.out.println("Usuário não identificado");
			}
		}
		*/
		
		

		
		
		
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
