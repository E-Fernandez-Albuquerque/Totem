package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.EstacoesDAO;

import javax.swing.JLabel;
import javax.swing.JComboBox;

public class teste4 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				/*try {
					teste4 frame = new teste4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				*/
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public teste4(String id) {
		String horaInicio = "2022-05-15 08:00:00";
		ArrayList<String> estacoes = EstacoesDAO.verificarEstacoesLivres(horaInicio);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reserva");
		lblNewLabel.setBounds(30, 104, 184, 22);
		contentPane.add(lblNewLabel);
		
		JComboBox<String> comboBox = new JComboBox();
		comboBox.setBounds(193, 104, 231, 22);
		contentPane.add(comboBox);
		
		int count = 0;
		while(count < estacoes.size()) {
			comboBox.addItem(estacoes.get(count));
			count++;
		}
	}

}
