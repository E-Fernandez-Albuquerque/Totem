package controller;

import java.awt.Color;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.EstacoesDAO;
import model.ReservasDAO;

public class MapaInterativo {
	
	public static void disponibilidade(ArrayList<String> estacoes, JButton estacao) {
		int count = 0;
		while(count < estacoes.size()) {
			System.out.println("DISPONIBILIDADE" + estacao.getText() + " / " +  estacoes.get(count));
			if (estacoes.get(count).equals(estacao.getText())) {
				estacao.setEnabled(true);
				estacao.setBackground(new Color(50, 200, 25));
				estacao.setForeground(new Color(255,255,255));
				break;
			} else {
				estacao.setEnabled(false);
				estacao.setBackground(new Color(200, 14, 14));
				estacao.setForeground(new Color(255,255,255));
			}
			count++;
		}
	}
	
	public static void ocupacao(ArrayList<String> estacoes, ArrayList<JLabel> lbls) {
		ArrayList<String> todasEstacoes = EstacoesDAO.todasEstacoes();
		ArrayList<String> lblsOcupadas = new ArrayList<String>();
		for (int i=0; i < todasEstacoes.size(); i++) {
			if (!estacoes.contains(todasEstacoes.get(i))) {
				String usuario = ReservasDAO.usuarioReserva(todasEstacoes.get(i));
				System.out.println("Usuario: " + usuario);
				lblsOcupadas.add(usuario);
			} else {
				lblsOcupadas.add("");
			}
		};
		
		for (int j=0; j < lblsOcupadas.size(); j++) {
			lbls.get(j).setText(lblsOcupadas.get(j));
		}
//			for (int j=0; j < estacoes.size(); j++) {
//				if(todasEstacoes.get(i).equals(estacoes.get(j))) {
//					lblsOcupadas.add(todasEstacoes.get(i));
//					break;
//				} 
//			}
		}
	}
