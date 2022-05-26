package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ReservasDAO;
import model.UsuariosDAO;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Checkin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				/*try {
					Checkin frame = new Checkin();
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
	public Checkin(String id, String data, String horaInicio) throws SQLException {
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
		setBounds(100, 100, 734, 385);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Check-in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservasDAO.fazerCheckin(id, data, horaInicio);//REALIZA O CHECKIN
				Concluido screen = new Concluido();
				screen.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 51, 0));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Segoe UI Historic", Font.BOLD, 11));
		btnNewButton.setBounds(281, 264, 131, 39);
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
		btnNewButton_1.setBounds(302, 314, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Check-in");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(0, 22, 718, 33);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 100, 50));
		panel.setBounds(10, 89, 698, 163);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_nome = new JLabel("Label nome");
		lbl_nome.setBounds(0, 11, 698, 39);
		panel.add(lbl_nome);
		lbl_nome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		lbl_nome.setText("Olá, " + nome);
		
		JLabel lblNewLabel_2 = new JLabel("Horário de entrada");
		lblNewLabel_2.setBounds(10, 62, 241, 32);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lbl_entrada = new JLabel("New label");
		lbl_entrada.setBounds(35, 115, 184, 36);
		panel.add(lbl_entrada);
		lbl_entrada.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_entrada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_entrada.setText(entrada);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Horário de saída");
		lblNewLabel_1_1_1.setBounds(231, 62, 210, 32);
		panel.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lbl_saida = new JLabel("New label");
		lbl_saida.setBounds(261, 117, 138, 32);
		panel.add(lbl_saida);
		lbl_saida.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_saida.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_saida.setText(saida);
		
		JLabel lblNewLabel_1 = new JLabel("Estação utilizada");
		lblNewLabel_1.setBounds(451, 53, 210, 50);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lbl_estacao = new JLabel("New label");
		lbl_estacao.setBounds(476, 117, 158, 32);
		panel.add(lbl_estacao);
		lbl_estacao.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_estacao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		lbl_estacao.setText(estacao);
	}
}

