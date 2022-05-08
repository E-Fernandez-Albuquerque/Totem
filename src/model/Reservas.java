package model;

//CRIA OS MODELOS DE RESERVAS E SUAS FUNÇÕES GET E SET
public class Reservas {
	
	private String id_usuario;
	private String id_estacao;
	private String date;
	private int duration;
	private boolean checkin;
	private boolean checkout;
	
	public Reservas() {	
	}

	public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getId_estacao() {
		return id_estacao;
	}

	public void setId_estacao(String id_estacao) {
		this.id_estacao = id_estacao;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isCheckin() {
		return checkin;
	}

	public void setCheckin(boolean checkin) {
		this.checkin = checkin;
	}

	public boolean isCheckout() {
		return checkout;
	}

	public void setCheckout(boolean checkout) {
		this.checkout = checkout;
	}
	
	
	
	
}
