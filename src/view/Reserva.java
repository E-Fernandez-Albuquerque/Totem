package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.text.MaskFormatter;

import model.EstacoesDAO;
import model.ReservasDAO;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.SwingConstants;

public class Reserva extends JFrame {
	/*ImageIcon check = new ImageIcon("check.png");
	ImageIcon medical = new ImageIcon("cesar-logo.png");
	ImageIcon ilustracao = new ImageIcon("ilustracao.png");
	*/
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				/*try {
					Reserva frame = new Reserva();
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
	public Reserva(String id, String horaInicio) {
		ArrayList<String> estacoes = EstacoesDAO.verificarEstacoesLivres(horaInicio);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Estações livres:");
		lblNewLabel_1_1_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1_2_1_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel_1_1_2_1_1.setBounds(135, 245, 229, 35);
		contentPane.add(lblNewLabel_1_1_2_1_1);
		//MASK
		MaskFormatter fmtDataMask = null;
				try {
					fmtDataMask = new MaskFormatter("####-##-##");
				} catch (ParseException e1) {
					e1.printStackTrace();
					
				}
		JFormattedTextField ftmData = new JFormattedTextField(fmtDataMask);
		ftmData.setHorizontalAlignment(SwingConstants.CENTER);
		ftmData.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ftmData.setBounds(374, 107, 99, 35);
		contentPane.add(ftmData);
		
				MaskFormatter fmtHourMask = null;	
				
				try {
					fmtHourMask = new MaskFormatter("##:##:##");
				} catch (ParseException e2) {
					e2.printStackTrace();
					
				}
				MaskFormatter fmtHourMask2 = null;	
				try {
					fmtHourMask2 = new MaskFormatter("##:##:##");
				} catch (ParseException e3) {
					e3.printStackTrace();
					
				}
		JFormattedTextField fmtHour = new JFormattedTextField(fmtHourMask);
		fmtHour.setHorizontalAlignment(SwingConstants.CENTER);
		fmtHour.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fmtHour.setBounds(374, 199, 99, 35);
		contentPane.add(fmtHour);
		
		JFormattedTextField ftmHour2= new JFormattedTextField(fmtHourMask2);
		ftmHour2.setHorizontalAlignment(SwingConstants.CENTER);
		ftmHour2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ftmHour2.setBounds(374, 153, 99, 35);
		contentPane.add(ftmHour2);
				
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(374, 245, 99, 35);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Horario de saída:");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel_1_1_1_1.setBounds(162, 199, 202, 34);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Horario de entrada:");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2.setForeground(Color.GRAY);
		lblNewLabel_1_1_2.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel_1_1_2.setBounds(135, 155, 229, 31);
		contentPane.add(lblNewLabel_1_1_2);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setBackground(new Color(255, 51, 0));
		btnNewButton.setForeground(new Color(255, 102, 0));
		btnNewButton.setFont(new Font("Segoe UI Historic", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = ftmData.getText();
				String horaEntrada = (ftmData.getText() + " " + ftmHour2.getText());
				String horaSaida = (ftmData.getText() + " " + fmtHour.getText());
				String idFuncionario = id;
				String estacao = (String) comboBox.getSelectedItem();
				ReservasDAO.inserirReserva(estacao, horaEntrada, horaSaida, null, null, idFuncionario);
				
				Inicio screen = new Inicio();
				screen.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblNewLabel_1_2 = new JLabel("Data:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setForeground(Color.GRAY);
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(265, 109, 99, 31);
		contentPane.add(lblNewLabel_1_2);
		btnNewButton.setBounds(540, 355, 135, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src/img/WhatsApp Image 2022-05-23 at 18.38.07.jpeg"));
		lblNewLabel.setBounds(-17, -31, 805, 472);
		contentPane.add(lblNewLabel);
		
		int count = 0;
		while(count < estacoes.size()) {
			comboBox.addItem(estacoes.get(count));
			count++;
		}
	}
}
