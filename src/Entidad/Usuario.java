package Entidad;


public class Usuario {

	private int idUsuario;
	private int idRoll;
	private String login;
	private String contrase�a;
	
	
	
	public Usuario(int idUsuario, int idRoll, String login, String contrase�a) {
		this.idUsuario = idUsuario;
		this.idRoll = idRoll;
		this.login = login;
		this.contrase�a = contrase�a;
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
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}


		
	
	

}
