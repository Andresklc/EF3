package Entidad;

import java.time.LocalDate;

public class Boleta {
	private int numeroBoleta,codigoUsuario;
	private String codigoLector;
	private LocalDate fecha;
	private double total;
	
	public int getNumeroBoleta() {
		return numeroBoleta;
	}
	public void setNumeroBoleta(int numeroBoleta) {
		this.numeroBoleta = numeroBoleta;
	}
	public int getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public String getCodigoLector() {
		return codigoLector;
	}
	public void setCodigoLector(String codigoLector) {
		this.codigoLector = codigoLector;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
}
