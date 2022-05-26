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
import java.util.Timer;
import java.util.TimerTask;
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
	public Checkout(String id, String data, String horaSaida) throws SQLException {
		ResultSet reserva = null;
		try {
			reserva = ReservasDAO.dadosReserva(id, data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String entrada = reserva.getString("reserva_inicia_em");
		String saida = reserva.getString("reserva_termina_em");
		String estacao = reserva.getString("id_estacao");
		ResultSet funcionario = UsuariosDAO.procurarFuncionario(id);
		String nome = funcionario.getString("nome");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 354);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Check-out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservasDAO.fazerCheckout(id, data, horaSaida);//REALIZA O CHECKOUT
				Concluido screen = new Concluido();
				screen.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 51, 0));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Segoe UI Historic", Font.BOLD, 11));
		btnNewButton.setBounds(294, 230, 131, 39);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("src/img/23_05_2022_20_04_58-removebg-preview.png"));
		lblNewLabel_3.setBounds(10, 11, 115, 67);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio screen = new Inicio();
				screen.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(315, 280, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Check-out");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(0, 22, 718, 32);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 51, 0, 150));
		panel.setBounds(10, 89, 698, 130);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_nome = new JLabel("Lbl nome");
		lbl_nome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nome.setBounds(0, 0, 698, 50);
		panel.add(lbl_nome);
		lbl_nome.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbl_nome.setText("Olá, " + nome);
		
		JLabel lblHoraDeEntrada_1 = new JLabel("Horário de entrada");
		lblHoraDeEntrada_1.setBounds(10, 52, 207, 36);
		panel.add(lblHoraDeEntrada_1);
		lblHoraDeEntrada_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoraDeEntrada_1.setForeground(Color.WHITE);
		lblHoraDeEntrada_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lbl_entrada = new JLabel("New label");
		lbl_entrada.setBounds(0, 80, 227, 36);
		panel.add(lbl_entrada);
		lbl_entrada.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_entrada.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_entrada.setText(entrada);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Horário de saída");
		lblNewLabel_1_1_1.setBounds(246, 54, 201, 32);
		panel.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lbl_saida = new JLabel("New label");
		lbl_saida.setBounds(243, 82, 207, 32);
		panel.add(lbl_saida);
		lbl_saida.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_saida.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_saida.setText(horaSaida);
		
		JLabel lblNewLabel_1 = new JLabel("Estação utilizada");
		lblNewLabel_1.setBounds(485, 52, 188, 36);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lbl_estacao = new JLabel("New label");
		lbl_estacao.setBounds(482, 82, 195, 32);
		panel.add(lbl_estacao);
		lbl_estacao.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_estacao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lbl_estacao.setText(estacao);
	
	}

}
