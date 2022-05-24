package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ReservasDAO;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	 */
	public Checkin(String id, String horaInicio) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("SAÍDA");
		lblNewLabel_1_1_1.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(376, 128, 79, 32);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblHoraDeEntrada_1 = new JLabel("ENTRADA");
		lblHoraDeEntrada_1.setForeground(new Color(255, 102, 0));
		lblHoraDeEntrada_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHoraDeEntrada_1.setBounds(179, 108, 98, 61);
		contentPane.add(lblHoraDeEntrada_1);
		
		JLabel lblNewLabel_2 = new JLabel("DATA");
		lblNewLabel_2.setForeground(new Color(255, 102, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(52, 123, 79, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("DATA");
		lblNewLabel.setForeground(new Color(204, 204, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(52, 130, 79, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblHoraDeEntrada = new JLabel("ENTRADA");
		lblHoraDeEntrada.setForeground(new Color(204, 204, 204));
		lblHoraDeEntrada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHoraDeEntrada.setBounds(179, 111, 98, 58);
		contentPane.add(lblHoraDeEntrada);
		
		JLabel lblNewLabel_1_1 = new JLabel("SAÍDA");
		lblNewLabel_1_1.setForeground(new Color(204, 204, 204));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(376, 123, 79, 44);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("ESTAÇÃO");
		lblNewLabel_1.setForeground(new Color(255, 102, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(531, 113, 108, 50);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("CHECK-IN");
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
		btnNewButton.setForeground(new Color(255, 102, 0));
		btnNewButton.setBounds(328, 365, 115, 39);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("src/img/23_05_2022_20_04_58-removebg-preview.png"));
		lblNewLabel_3.setBounds(10, 11, 115, 67);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("ESTAÇÃO");
		lblNewLabel_1_2.setForeground(new Color(204, 204, 204));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(531, 108, 108, 64);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_4.setBounds(43, 195, 82, 36);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("New label");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_4_1.setBounds(183, 199, 82, 32);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("New label");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_4_1_1.setBounds(363, 199, 82, 32);
		contentPane.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("New label");
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_4_1_1_1.setBounds(537, 199, 82, 32);
		contentPane.add(lblNewLabel_4_1_1_1);
	}

}

