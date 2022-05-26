package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//CLASSE RESPONSÁVEL POR CRIAR AS TABELAS GENÉRICAS 
public class DBTables {

	//TABELA DE USUÁRIOS
	public static void criarTabelaFuncionarios() {
		Connection connection = DBConnection.conectDB();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS funcionarios "
					+ "(id varchar(8) PRIMARY KEY, nome varchar(30) NOT NULL, meu_time varchar(15))");
			statement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	
	//TABELA DE ESTAÇÕES
	public static void criarTabelaEstacoes() {
		Connection connection = DBConnection.conectDB();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS estacoes "
					+ "(estacao varchar(6) PRIMARY KEY,"
					+ "horario VARCHAR(19),"
					+ "livre boolean,"
					+ "id_reserva int(11))");
			statement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	
	//TABELA DE RESERVAS
	public static void criarTabelaReservas() {
		Connection connection = DBConnection.conectDB();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS reservas "
					+ "(id_reserva int PRIMARY KEY AUTO_INCREMENT,"
					+ "id_estacao varchar(6),"
					+ "data varchar(10)," //OBS
					+ "reserva_inicia_em varchar(8),"
					+ "reserva_termina_em varchar(8),"
					+ "check_in_em varchar(19),"
					+ "check_out_em varchar(19),"
					+ "id_funcionario varchar(8),"
					+ "foreign key (id_funcionario) REFERENCES funcionarios(id),"
					+ "foreign key (id_estacao) REFERENCES estacoes(estacao))");
			statement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	
}
