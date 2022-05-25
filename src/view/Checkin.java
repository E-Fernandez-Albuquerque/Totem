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
	public Checkin(String id, String horaInicio) throws SQLException {
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
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Saída");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(318, 206, 82, 32);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Entrada");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(255, 102, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(121, 206, 82, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Estação");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 102, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(508, 199, 82, 50);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Check-in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservasDAO.fazerCheckin(id, horaInicio);//REALIZA O CHECKIN
				Inicio screen = new Inicio();
				screen.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(255, 51, 0));
		btnNewButton.setForeground(UIManager.getColor("Button.disabledShadow"));
		btnNewButton.setBounds(279, 365, 158, 39);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("src/img/23_05_2022_20_04_58-removebg-preview.png"));
		lblNewLabel_3.setBounds(10, 11, 115, 67);
		contentPane.add(lblNewLabel_3);
		
		JLabel lbl_entrada = new JLabel("New label");
		lbl_entrada.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_entrada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_entrada.setBounds(68, 263, 184, 36);
		contentPane.add(lbl_entrada);
		
		JLabel lbl_saida = new JLabel("New label");
		lbl_saida.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_saida.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_saida.setBounds(284, 265, 138, 32);
		contentPane.add(lbl_saida);
		
		JLabel lbl_estacao = new JLabel("New label");
		lbl_estacao.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_estacao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_estacao.setBounds(469, 265, 158, 32);
		contentPane.add(lbl_estacao);
		
		
		lbl_estacao.setText(estacao);
		lbl_entrada.setText(entrada);
		lbl_saida.setText(saida);
		
		JLabel lbl_nome = new JLabel("Label nome");
		lbl_nome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbl_nome.setBounds(100, 103, 280, 39);
		contentPane.add(lbl_nome);
		
		lbl_nome.setText("Olá, " + nome);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio screen = new Inicio();
				screen.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(318, 415, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Check-in");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(251, 25, 221, 33);
		contentPane.add(lblNewLabel);
	}
}

