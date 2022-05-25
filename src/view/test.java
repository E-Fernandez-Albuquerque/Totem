package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import model.UsuariosDAO;
import model.EstacoesDAO;
import model.ReservasDAO;

public class test extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
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
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(112, 63, 184, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				
				ResultSet funcionario = UsuariosDAO.procurarFuncionario(id);
				try {
					id = funcionario.getString("id");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//VERIFICA EXISTÊNCIA DO ID
				String horaInicio = "2022-05-15 08:00:00";
				String horaSaida = "2022-05-15 12:00:00";
				
				if (id != null) {//CASO O ID NÃO SEJA NULO
					boolean reserva = ReservasDAO.verificaReserva(id, horaInicio);//VERIFICA EXISTÊNCIA DE RESERVA
					boolean checkin = ReservasDAO.verificaCheckinReserva(id, horaInicio);//VERIFICA EXISTÊNCIA DE CHECKIN
					boolean checkout = ReservasDAO.verificaCheckoutReserva(id, horaSaida);//VERIFICA EXISTÊNCIA DE CHECKOUT
					if (reserva && !checkin && !checkout) {//SE EXISTIR APENAS RESERVA
						ReservasDAO.fazerCheckin(id, horaInicio);//REALIZA O CHECKIN
						System.out.println("Fazer checkin");
						teste2 screen = new teste2(id);
						screen.setVisible(true);
						dispose();
					} else if (reserva && checkin && !checkout){//SE CHECKIN JÁ FOI REALIZADO
						ReservasDAO.fazerCheckout(id, horaSaida);//REALIZA O CHECKOUT
						System.out.println("Fazer checkout");
						teste3 screen = new teste3(id);
						screen.setVisible(true);
						dispose();
					} else {//CASO NÃO EXISTA RESERVA
						System.out.println("Nenhuma reserva localizada para o usuário. Realize uma nova reserva.");
						System.out.println("Estações livres: ");
						System.out.println("Redirecionar para tela Reserva");
						teste4 screen = new teste4(id);
						screen.setVisible(true);
						dispose();
						EstacoesDAO.verificarEstacoesLivres(horaInicio);//PRINTA ESTAÇÕES LIVRES PARA O HORÁRIO ESPECIFICADO
					}
				} else {//CASO ID NÃO SEJA IDENTIFICADO
					System.out.println("Usuário não identificado");
				}
				
				/*if (id.equals("123")) {
					System.out.println("Redirecionar para tela X");
					teste2 screen = new teste2(id);
					screen.setVisible(true);
					dispose();
				} else if (id.equals("1234")) {
					System.out.println("Redirecionar para tela Y");
					teste3 screen = new teste3(id);
					screen.setVisible(true);
					dispose();
				} else {
					System.out.println("Não identificado");
				}*/
				
				
			}
		});
		btnNewButton.setBounds(152, 113, 89, 23);
		contentPane.add(btnNewButton);
	}
}
