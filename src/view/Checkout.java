package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ReservasDAO;
import model.UsuariosDAO;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Checkout extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				/*try {
					Checkout frame = new Checkout();
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
	 * @throws SQLException 
	 */
	public Checkout(String id, String horaSaida, String horaInicio) throws SQLException {

		ResultSet reserva = null;
		try {
			reserva = ReservasDAO.dadosReserva(id, horaInicio);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String entrada = reserva.getString("reserva_inicia_em");
		String saida = reserva.getString("reserva_termina_em");
		String estacao = reserva.getString("id_estacao");
		ResultSet funcionario = UsuariosDAO.procurarFuncionario(id);
		String nome = funcionario.getString("nome");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("SAÍDA");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(314, 204, 79, 32);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblHoraDeEntrada_1 = new JLabel("ENTRADA");
		lblHoraDeEntrada_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoraDeEntrada_1.setForeground(new Color(255, 102, 0));
		lblHoraDeEntrada_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHoraDeEntrada_1.setBounds(73, 190, 98, 61);
		contentPane.add(lblHoraDeEntrada_1);
		
		JLabel lblNewLabel_1 = new JLabel("ESTAÇÃO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 102, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(548, 197, 108, 50);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Check-out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservasDAO.fazerCheckout(id, horaSaida);//REALIZA O CHECKOUT
				Inicio screen = new Inicio();
				screen.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(255, 51, 0));
		btnNewButton.setForeground(new Color(255, 102, 0));
		btnNewButton.setBounds(285, 356, 131, 39);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("src/img/23_05_2022_20_04_58-removebg-preview.png"));
		lblNewLabel_3.setBounds(10, 11, 115, 67);
		contentPane.add(lblNewLabel_3);
		
		JLabel lbl_entrada = new JLabel("New label");
		lbl_entrada.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_entrada.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbl_entrada.setBounds(10, 265, 227, 36);
		contentPane.add(lbl_entrada);
		
		JLabel lbl_saida = new JLabel("New label");
		lbl_saida.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_saida.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbl_saida.setBounds(247, 267, 207, 32);
		contentPane.add(lbl_saida);
		
		JLabel lbl_estacao = new JLabel("New label");
		lbl_estacao.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_estacao.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbl_estacao.setBounds(501, 269, 195, 32);
		contentPane.add(lbl_estacao);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio screen = new Inicio();
				screen.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(305, 407, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lbl_nome = new JLabel("Lbl nome");
		lbl_nome.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbl_nome.setBounds(52, 96, 432, 50);
		contentPane.add(lbl_nome);
		
		lbl_estacao.setText(estacao);
		lbl_entrada.setText(entrada);
		lbl_saida.setText(saida);
		lbl_nome.setText("Olá, " + nome);
		
		JLabel lblNewLabel = new JLabel("Check-out");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(228, 22, 243, 32);
		contentPane.add(lblNewLabel);
	
	}

}
