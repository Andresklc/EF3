package Entidad;

public class Detalle_Usuario  {
	

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
	private int idRoll;
	private String login;
	private String contrase�a;
	private int idDUsuario;
	private String dni,dirUsu,TelUsu,emailUsu;
	public int getIdDUsuario() {
		return idDUsuario;
	}
	public void setIdDUsuario(int idDUsuario) {
		this.idDUsuario = idDUsuario;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDirUsu() {
		return dirUsu;
	}
	public void setDirUsu(String dirUsu) {
		this.dirUsu = dirUsu;
	}
	public String getTelUsu() {
		return TelUsu;
	}
	public void setTelUsu(String telUsu) {
		TelUsu = telUsu;
	}
	public String getEmailUsu() {
		return emailUsu;
	}
	public void setEmailUsu(String emailUsu) {
		this.emailUsu = emailUsu;
	}
	
	
	

}
