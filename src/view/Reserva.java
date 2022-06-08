package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.text.MaskFormatter;

import controller.MapaInterativo;
import model.EstacoesDAO;
import model.ReservasDAO;
import model.UsuariosDAO;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSlider;
import javax.swing.JSpinner;

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
	 * @throws SQLException 
	 */
	public Reserva(String id, String data, String horaInicio) throws SQLException {
		ArrayList<String> estacoes = EstacoesDAO.verificarEstacoesLivres(data);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255,255,255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ResultSet funcionario = UsuariosDAO.procurarFuncionario(id);
		String nome = funcionario.getString("nome");
		//MASK
		MaskFormatter fmtDataMask = null;
		try {
			fmtDataMask = new MaskFormatter("####-##-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		MaskFormatter fmtHourMask = null;	
				
		try {
			fmtHourMask = new MaskFormatter("##:##");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		MaskFormatter fmtHourMask2 = null;	
		try {
			fmtHourMask2 = new MaskFormatter("##:##:##");
		} catch (ParseException e3) {
		e3.printStackTrace();
					
		}
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255,255,255,235));
		panel.setBounds(10, 59, 452, 342);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lbl_nome = new JLabel("Olá, ");
		lbl_nome.setBounds(0, 11, 429, 35);
		panel.add(lbl_nome);
		lbl_nome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nome.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		lbl_nome.setText("Olá, " + nome + "!");
		
		
		JLabel lbl_horario = new JLabel("Você chegou às <dynamic>.");
		lbl_horario.setBounds(10, 57, 419, 35);
		panel.add(lbl_horario);
		lbl_horario.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_horario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lbl_horario.setText("Você chegou às " + horaInicio + ".");
		
		JLabel lbl_info = new JLabel("Escolha horário de saída e estação de deseja utilizar.");
		lbl_info.setBounds(10, 99, 419, 35);
		panel.add(lbl_info);
		lbl_info.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_info.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblHorario = new JLabel("Horario de saída:");
		lblHorario.setBounds(54, 166, 202, 34);
		panel.add(lblHorario);
		lblHorario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorario.setForeground(new Color(255, 51, 0));
		lblHorario.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		
		
		JLabel lblEstacoes = new JLabel("Estações livres:");
		lblEstacoes.setBounds(27, 211, 229, 35);
		panel.add(lblEstacoes);
		lblEstacoes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstacoes.setForeground(new Color(255, 51, 0));
		lblEstacoes.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(266, 211, 99, 35);
		panel.add(comboBox);
		
		JButton btnConfirma = new JButton("Confirmar");
		btnConfirma.setBounds(230, 275, 135, 31);
		panel.add(btnConfirma);
		btnConfirma.setBackground(new Color(255, 51, 0));
		btnConfirma.setForeground(Color.WHITE);
		btnConfirma.setFont(new Font("Segoe UI Historic", Font.BOLD, 11));
		
		
		
		JLabel lblIndisponivel = new JLabel("Sem estações disponíveis. Tente novamente mais tarde.");
		lblIndisponivel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIndisponivel.setForeground(Color.RED);
		lblIndisponivel.setHorizontalAlignment(SwingConstants.CENTER);
		lblIndisponivel.setBounds(0, 134, 429, 14);
		panel.add(lblIndisponivel);
		
		lblIndisponivel.setVisible(false);
		ImageIcon imageIcon = new ImageIcon("src/img/mapa"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(252, 440,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		
		JComboBox comboBox_hora = new JComboBox();
		ArrayList<String> horarios = new ArrayList<>(Arrays.asList (new String[]{"00:00", "00:30","01:00", "01:30","02:00", "02:30","03:00", "03:30","04:00", "04:30","05:00", "05:30","06:00", "06:30","07:00", "07:30","08:00", "08:30","09:00", "09:30","10:00", "10:30","11:00", "11:30","12:00", "12:30","13:00", "13:30","14:00", "14:30","15:00", "15:30","16:00", "16:30","17:00", "17:30","18:00", "18:30","19:00", "19:30","20:00", "20:30","21:00", "21:30","22:00", "22:30","23:00", "23:30",}));
		for (int k = 0; k < horarios.size(); k++) {
			comboBox_hora.addItem(horarios.get(k));
		}
		
		comboBox_hora.setSelectedIndex(14);
		
		comboBox_hora.setBounds(266, 166, 99, 35);
		panel.add(comboBox_hora);
		
		
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String data = ftmData.getText();
				
				SimpleDateFormat fmtdHora = new SimpleDateFormat("HH:mm");
				String hora = (String) comboBox_hora.getSelectedItem();
				
				String idFuncionario = id;
				String estacao = (String) comboBox.getSelectedItem();
				System.out.println(idFuncionario);
				ReservasDAO.inserirReserva(estacao, data, horaInicio, hora, null, null, idFuncionario);
				ReservasDAO.fazerCheckin(id, data, horaInicio);
				
				Concluido screen = new Concluido();
				screen.setVisible(true);
				dispose();
			}
		});
		
		JButton btnCancela = new JButton("Cancelar");
		btnCancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio screen = new Inicio();
				screen.setVisible(true);
				dispose();
			}
		});
		btnCancela.setBounds(117, 279, 89, 23);
		panel.add(btnCancela);
		
		
		
		
		
//		ImageIcon imageIconBack = new ImageIcon("src/img/WhatsApp Image 2022-05-23 at 18.38.07.jpeg"); // load the image to a imageIcon
//		Image imageBack = imageIconBack.getImage(); // transform it 
//		Image newimgback = imageBack.getScaledInstance(734, 480,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
//		imageIconBack = new ImageIcon(newimgback);
		
		/*
		//JLabel lblA01 = new JLabel("A01");
		//lblA01.addMouseListener(new MouseAdapter() {
		//	@Override
		//	public void mouseClicked(MouseEvent e) {
		//		comboBox.getModel().setSelectedItem("A01");
		//	}
		//});
		//lblA01.setBounds(516, 29, 46, 14);
		//contentPane.add(lblA01);
		
		JLabel lblA03 = new JLabel("A03");
		lblA03.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox.getModel().setSelectedItem("A03");
			}
		});
		lblA03.setBounds(516, 128, 46, 14);
		contentPane.add(lblA03);
		
		JLabel lblA02 = new JLabel("A02");
		lblA02.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox.getModel().setSelectedItem("A02");
			}
		});
		lblA02.setBounds(516, 77, 46, 14);
		contentPane.add(lblA02);
		*/
		JButton btnA01 = new JButton("A01");
		btnA01.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnA01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.getModel().setSelectedItem("A01");
			}
		});
		btnA01.setBounds(502, 44, 28, 20);
		btnA01.setMargin(new Insets(0,0,0,0));
		//btnA01.setOpaque(false);
		//btnA01.setContentAreaFilled(false);
		//btnA01.setBorderPainted(false);
		contentPane.add(btnA01);
		
		JButton btnA02 = new JButton("A02");
		btnA02.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnA02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.getModel().setSelectedItem("A02");
			}
		});
		//btnA02.setOpaque(false);
		//btnA02.setContentAreaFilled(false);
		//btnA02.setBorderPainted(false);
		btnA02.setBounds(502, 180, 28, 20);
		btnA02.setMargin(new Insets(0,0,0,0));
		btnA02.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(btnA02);
		
		JButton btnA03 = new JButton("A03");
		btnA03.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnA03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.getModel().setSelectedItem("A03");
			}
		});
		//btnA03.setOpaque(false);
		//btnA03.setContentAreaFilled(false);
		//btnA03.setBorderPainted(false);
		btnA03.setBounds(550, 44, 28, 20);
		btnA03.setMargin(new Insets(0,0,0,0));
		contentPane.add(btnA03);
		
		JButton btnA04 = new JButton("A04");
		btnA04.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnA04.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.getModel().setSelectedItem("A04");
			}
		});
//		btnA04.setOpaque(false);
//		btnA04.setBorderPainted(false);
		btnA04.setBounds(550, 180, 28, 20);
		btnA04.setMargin(new Insets(0,0,0,0));
		contentPane.add(btnA04);
		
		JButton btnA05 = new JButton("A05");
		btnA05.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnA05.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.getModel().setSelectedItem("A05");
			}
		});
//		btnA05.setOpaque(false);
//		btnA05.setBorderPainted(false);
		btnA05.setBounds(598, 44, 28, 20);
		btnA05.setMargin(new Insets(0,0,0,0));
		contentPane.add(btnA05);
		
		JButton btnA06 = new JButton("A06");
		btnA06.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnA06.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.getModel().setSelectedItem("A06");
			}
		});
//		btnA06.setOpaque(false);
//		btnA06.setBorderPainted(false);
		btnA06.setBounds(598, 180, 28, 20);
		btnA06.setMargin(new Insets(0,0,0,0));
		contentPane.add(btnA06);
		
		JButton btnA07 = new JButton("A07");
		btnA07.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.getModel().setSelectedItem("A07");
			}
		});
		btnA07.setMargin(new Insets(0, 0, 0, 0));
		btnA07.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnA07.setBounds(646, 44, 28, 20);
		contentPane.add(btnA07);
		ImageIcon imageIconCesar = new ImageIcon("src/img/23_05_2022_20_04_58-removebg-preview.png"); // load the image to a imageIcon
		Image imageCesar = imageIconCesar.getImage(); // transform it 
		Image newimgCesar = imageCesar.getScaledInstance(50, 28,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIconCesar = new ImageIcon(newimgCesar);  // transform it back
		
//		JLabel lblNewLabel = new JLabel("");
//		//lblNewLabel.setIcon(imageIconBack);
//		lblNewLabel.setBounds(0, -31, 938, 482);
//		contentPane.add(lblNewLabel);
		
		int count = 0;
		System.out.println(estacoes.size());
		if (estacoes.size() == 0) {
			comboBox.setEnabled(false);
			btnConfirma.setEnabled(false);
			comboBox_hora.setEnabled(false);
			lblIndisponivel.setVisible(true);
			
		} else {
			while(count < estacoes.size()) {
			comboBox.addItem(estacoes.get(count));
			count++;
			}
		}
		
		ArrayList<String> total = new ArrayList<String>();
		for (int i = 0; i < 7; i++) {
			total.add("A0" + i);
		}
		System.out.print(total);
		
		for (int i = 0; i < estacoes.size(); i++)
		
		MapaInterativo.disponibilidade(estacoes, btnA01);
		MapaInterativo.disponibilidade(estacoes, btnA02);
		MapaInterativo.disponibilidade(estacoes, btnA03);
		MapaInterativo.disponibilidade(estacoes, btnA04);
		MapaInterativo.disponibilidade(estacoes, btnA05);
		MapaInterativo.disponibilidade(estacoes, btnA06);
		MapaInterativo.disponibilidade(estacoes, btnA07);
		
		JLabel lblA01 = new JLabel("");
		lblA01.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblA01.setBounds(486, 30, 60, 14);
		lblA01.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblA01);
		
		JLabel lblA03 = new JLabel("");
		lblA03.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblA03.setBounds(534, 30, 60, 14);
		lblA03.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblA03);
		
		JLabel lblA05 = new JLabel("");
		lblA05.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblA05.setBounds(582, 30, 60, 14);
		lblA05.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblA05);
		
		JLabel lblA07 = new JLabel("");
		lblA07.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblA07.setBounds(630, 30, 60, 14);
		lblA07.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblA07);
		
		JLabel lblA02 = new JLabel("");
		lblA02.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblA02.setBounds(486, 200, 60, 14);
		lblA02.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblA02);
		
		JLabel lblA04 = new JLabel("");
		lblA04.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblA04.setBounds(534, 200, 60, 14);
		lblA04.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblA04);
		
		JLabel lblA06 = new JLabel("");
		lblA06.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblA06.setBounds(582, 200, 60, 14);
		lblA06.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblA06);
		
		JLabel lblMap = new JLabel("");
		lblMap.setBounds(472, 0, 252, 442);
		contentPane.add(lblMap);
		lblMap.setIcon(imageIcon);
		
		JLabel lblCesar = new JLabel("");
		lblCesar.setIcon(imageIconCesar);
		lblCesar.setBounds(0, 0, 50, 28);
		contentPane.add(lblCesar);
		
		ArrayList<JLabel> labelsEstacoes = new ArrayList<JLabel>();
		labelsEstacoes.add(lblA01);
		labelsEstacoes.add(lblA02);
		labelsEstacoes.add(lblA03);
		labelsEstacoes.add(lblA04);
		labelsEstacoes.add(lblA05);
		labelsEstacoes.add(lblA06);
		labelsEstacoes.add(lblA07);
		
		MapaInterativo.ocupacao(estacoes, labelsEstacoes);
		
		try {
			funcionario.close();
		} catch (SQLException e) {
			// LOGGING
			e.printStackTrace();
		}
		
//		MapaInterativo.indisponibilidade(estacoes, btnA01);
//		MapaInterativo.indisponibilidade(estacoes, btnA02, comboBox, "A02");
//		MapaInterativo.indisponibilidade(estacoes, btnA03, comboBox, "A03");
		
	}
}
