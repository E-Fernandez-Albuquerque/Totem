package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DadosPadrao;
import model.DBTables;
import model.EstacoesDAO;
import model.ReservasDAO;
import model.UsuariosDAO;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Inicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Scanner sc = new Scanner(System.in);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255,255,255,220));
		panel.setBounds(67, 185, 414, 91);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Aproxime o seu crachá");
		lblNewLabel_1_1.setBounds(0, 11, 414, 70);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(255,51,0));
		lblNewLabel_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src/img/WhatsApp Image 2022-05-23 at 18.38.07.jpeg"));
		lblNewLabel.setBounds(0, 0, 549, 419);
		contentPane.add(lblNewLabel);
		
		this.addKeyListener(new java.awt.event.KeyAdapter() {
			  public void keyPressed(java.awt.event.KeyEvent evt) {
				//String horaInicio = "2022-05-15 08:00:00";
					String horaSaida = "22:00";
					Date data = new Date();
					SimpleDateFormat fmtdData = new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat fmtdHora = new SimpleDateFormat("HH:mm");
					String dataAtual = fmtdData.format(data);
					String horaAtual = fmtdHora.format(data);
					ResultSet user = null;
					String id = null;
					String nome = null;
					
			    if (evt.getKeyCode() == KeyEvent.VK_Q) {
			    	id = "ASDFGHJK";
					user = UsuariosDAO.procurarFuncionario(id);
			    } else if (evt.getKeyCode() == KeyEvent.VK_W) {
			    	id = "FCVPJK33";
					user = UsuariosDAO.procurarFuncionario(id);
			    } else if (evt.getKeyCode() == KeyEvent.VK_E) {
			    	id = "J3SQ1X55";
					user = UsuariosDAO.procurarFuncionario(id);
			    } else if (evt.getKeyCode() == KeyEvent.VK_R) {
			    	id = "OJHH44R7";
					user = UsuariosDAO.procurarFuncionario(id);
			    } else if (evt.getKeyCode() == KeyEvent.VK_T) {
			    	id = "QPFLC3S1";
					user = UsuariosDAO.procurarFuncionario(id);
			    } else if (evt.getKeyCode() == KeyEvent.VK_Y) {
			    	id = "QWERTYUI";
					user = UsuariosDAO.procurarFuncionario(id);
			    } else if (evt.getKeyCode() == KeyEvent.VK_U) {
			    	id = "TFVEDCIJ";
					user = UsuariosDAO.procurarFuncionario(id);
			    } else if (evt.getKeyCode() == KeyEvent.VK_I) {
			    	id = "ZXASQW12";
					user = UsuariosDAO.procurarFuncionario(id);
			    } else if (evt.getKeyCode() == KeyEvent.VK_O) {
			    	id = "ZXCVBNML";
					user = UsuariosDAO.procurarFuncionario(id);
			    } else if (evt.getKeyCode() == KeyEvent.VK_ENTER){
			    	DadosPadrao.dadosPadrao();
			    } else {
			    	System.out.println("Usuário não identificado.");
			    }
			    try {
					nome = user.getString("nome");
					id = user.getString("id");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    
			    if (id != null) {//CASO O ID NÃO SEJA NULO
					boolean reserva = ReservasDAO.verificaReserva(id, dataAtual);//VERIFICA EXISTÊNCIA DE RESERVA
					boolean checkin = ReservasDAO.verificaCheckinReserva(id, dataAtual);//VERIFICA EXISTÊNCIA DE CHECKIN
					boolean checkout = ReservasDAO.verificaCheckoutReserva(id, dataAtual);//VERIFICA EXISTÊNCIA DE CHECKOUT
					if (reserva && !checkin && !checkout) {//SE EXISTIR APENAS RESERVA
						System.out.println("Fazer checkin");
						Checkin screen;
						try {
							screen = new Checkin(id, dataAtual, horaAtual);
							screen.setResizable(false);
							screen.setVisible(true);
							dispose();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					} else if (reserva && checkin && !checkout){//SE CHECKIN JÁ FOI REALIZADO
						System.out.println("Fazer checkout");
						Checkout screen;
						try {
							screen = new Checkout(id, dataAtual, horaAtual);
							screen.setResizable(false);
							screen.setVisible(true);
							dispose();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					} else {//CASO NÃO EXISTA RESERVA
						System.out.println("Nenhuma reserva localizada para o usuário. Realize uma nova reserva.");
						System.out.println("Estações livres: ");
						System.out.println("Redirecionar para tela Reserva");
						Reserva screen;
						try {
							screen = new Reserva(id, dataAtual, horaAtual);
							screen.setResizable(false);
							screen.setVisible(true);
							dispose();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				} else {//CASO ID NÃO SEJA IDENTIFICADO
					System.out.println("Usuário não identificado");
				}
			    
			  }
			});
	}
}

