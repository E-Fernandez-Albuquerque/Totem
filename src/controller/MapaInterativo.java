package controller;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

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
	
	public static void indisponibilidade(ArrayList<String> estacoes, JButton estacao, JComboBox comboBox, String estacaoString) {
		int count = 0;
		while(count < comboBox.getItemCount()) {
			System.out.println("INDISPONIBILIDADE: " + comboBox.getItemAt(count) + " / " + comboBox.getItemCount());
			if (!comboBox.getItemAt(count).equals(estacaoString)) {
				String nome = ReservasDAO.usuarioReserva(estacaoString);
				if (nome != null) {
					estacao.setText(nome);
				}
			}
			count++;
		}
	}

}
