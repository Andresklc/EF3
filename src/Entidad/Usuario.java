package Entidad;


public class Usuario {

	private int idUsuario;
	private int idRoll;
	private String login;
	private String contraseña;
	
	
	
	public Usuario(int idUsuario, int idRoll, String login, String contraseña) {
		this.idUsuario = idUsuario;
		this.idRoll = idRoll;
		this.login = login;
		this.contraseña = contraseña;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdRoll() {
		return idRoll;
	}
	public void setIdRoll(int idRoll) {
		this.idRoll = idRoll;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


		
	
	

}
