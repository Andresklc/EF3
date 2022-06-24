package Entidad;

import java.sql.Date;

public class cliente {
	private int codigo;
	private String nombres,apellidos,direccion,dni,sexo;
	private Date fechaI;
	
	

	

	public Date getFechaI() {
		return fechaI;
	}

	public void setFechaI(Date fechaI) {
		this.fechaI = fechaI;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}



	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	


	
	
	
	
	
}
