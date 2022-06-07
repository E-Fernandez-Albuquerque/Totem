package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ReservasDAO;
import model.UsuariosDAO;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.awt.Image;

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
		setBounds(100, 100, 643, 372);
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
		btnNewButton.setBackground(new Color(101, 236, 43));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Segoe UI Historic", Font.BOLD, 11));
		btnNewButton.setBounds(248, 245, 131, 39);
		contentPane.add(btnNewButton);
		
		JLabel lblPhoto = new JLabel("");
		ImageIcon imageIconPh = new ImageIcon("src/img/photo.png"); // load the image to a imageIcon
		Image imagePh = imageIconPh.getImage(); // transform it 
		Image newimgPh = imagePh.getScaledInstance(252, 155,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIconPh = new ImageIcon(newimgPh);  // transform it back
		lblPhoto.setIcon(imageIconPh);
		lblPhoto.setBounds(10, 39, 252, 155);
		contentPane.add(lblPhoto);
		
		JLabel lblCesar = new JLabel("");
		ImageIcon imageIconCesar = new ImageIcon("src/img/23_05_2022_20_04_58-removebg-preview.png"); // load the image to a imageIcon
		Image imageCesar = imageIconCesar.getImage(); // transform it 
		Image newimgCesar = imageCesar.getScaledInstance(50, 28,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIconCesar = new ImageIcon(newimgCesar);  // transform it back
		lblCesar.setIcon(imageIconCesar);
		lblCesar.setBounds(0, 0, 50, 28);
		contentPane.add(lblCesar);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio screen = new Inicio();
				screen.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(269, 295, 89, 23);
		btnNewButton_1.setForeground(new Color(236, 99, 43));
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(232, 50, 371, 133);
		panel.setBorder(BorderFactory.createLineBorder(new Color(236, 99, 43)));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_nome = new JLabel("Label nome");
		lbl_nome.setBounds(10, 11, 351, 39);
		panel.add(lbl_nome);
		lbl_nome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		lbl_nome.setText("Olá, " + nome);
		
		JLabel lbl_entrada = new JLabel("New label");
		lbl_entrada.setBounds(10, 48, 351, 36);
		panel.add(lbl_entrada);
		lbl_entrada.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_entrada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_entrada.setText("São " + horaInicio + ". Sua reserva é para as " + entrada);
		
		JLabel lbl_saida = new JLabel("New label");
		lbl_saida.setBounds(10, 95, 351, 32);
		panel.add(lbl_saida);
		lbl_saida.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_saida.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_saida.setText("A reserva encerra às " + saida);
		
		JLabel lbl_estacao = new JLabel("New label");
		lbl_estacao.setBounds(10, 72, 351, 32);
		panel.add(lbl_estacao);
		lbl_estacao.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_estacao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		lbl_estacao.setText("Estação escolhida: " + estacao);
		
		JLabel lblHoraDeEntrada_1 = new JLabel("Deseja realizar o Check-in?");
		lblHoraDeEntrada_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoraDeEntrada_1.setForeground(Color.BLACK);
		lblHoraDeEntrada_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHoraDeEntrada_1.setBounds(0, 198, 627, 36);
		contentPane.add(lblHoraDeEntrada_1);
	}
}

