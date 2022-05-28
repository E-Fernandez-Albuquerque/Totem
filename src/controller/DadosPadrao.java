package controller;

import model.DBConnection;
import model.DBTables;
import model.EstacoesDAO;
import model.UsuariosDAO;

public class DadosPadrao {

	public static void dadosPadrao(){
		DBConnection.conectaDB();
		int count = 0;
		DBTables.criarDB("cesar2");
		DBTables.criarTabelaEstacoes();
		DBTables.criarTabelaFuncionarios();
		DBTables.criarTabelaReservas();
		String[] estacoes = {"A01", "A02", "A03", "A04", "A05", "A06", "A07"};
		String[] id = {"QWERTYUI","ASDFGHJK", "ZXCVBNML", "TFVEDCIJ", "J3SQ1X55", "OJHH44R7", "ZXASQW12", "FCVPJK33", "QPFLC3S1"};
		String[] nome = {"Eric","Beatriz", "Lena", "Renato", "Italo", "Edvan", "Anderson", "Douglas", "Vinicius"};
		while (count < estacoes.length) {
			EstacoesDAO.inserirEstacao(estacoes[count]);
			count++;
		}
		count = 0;
		while (count < id.length) {
			UsuariosDAO.inserirFuncionario(id[count], nome[count], null);
			count++;
		}
	}
}
