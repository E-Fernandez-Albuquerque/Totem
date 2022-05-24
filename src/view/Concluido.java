package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Concluido extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Concluido frame = new Concluido();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	
	public TimerTask novaTela() {
		Inicio screen = new Inicio();
		screen.setVisible(true);
		dispose();
		return null;
	}
	
	public Concluido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src/img/concluido.gif"));
		lblNewLabel.setBounds(0, 0, 760, 391);
		contentPane.add(lblNewLabel);
		int delay = 2500;
		Timer timer = new Timer();
		timer.schedule(novaTela(), delay);
		dispose();
	}

}

