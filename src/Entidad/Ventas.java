package Entidad;

import java.sql.Date;

public class Ventas {
	
	private int CodVen;
	private int CodCl;
	private String nomcli;
	private int CodUs;
	private String nomU;
	private String Art;
	private int cantida;
	private Date fechVen;
	private double MontoVen;
	private int estVen;
	
	
	

	public int getCantida() {
		return cantida;
	}
	public void setCantida(int cantida) {
		this.cantida = cantida;
	}
	public String getArt() {
		return Art;
	}
	public void setArt(String art) {
		Art = art;
	}
	public int getCodCl() {
		return CodCl;
	}
	public void setCodCl(int codCl) {
		CodCl = codCl;
	}
	public int getCodUs() {
		return CodUs;
	}
	public void setCodUs(int codUs) {
		CodUs = codUs;
	}
	public String getNomcli() {
		return nomcli;
	}
	public void setNomcli(String nomcli) {
		this.nomcli = nomcli;
	}
	public String getNomU() {
		return nomU;
	}
	public void setNomU(String nomU) {
		this.nomU = nomU;
	}
	public int getCodVen() {
		return CodVen;
	}
	public void setCodVen(int codVen) {
		CodVen = codVen;
	}
	public Date getFechVen() {
		return fechVen;
	}
	public void setFechVen(Date fechVen) {
		this.fechVen = fechVen;
	}
	public double getMontoVen() {
		return MontoVen;
	}
	public void setMontoVen(double montoVen) {
		MontoVen = montoVen;
	}
	public int getEstVen() {
		return estVen;
	}
	public void setEstVen(int estVen) {
		this.estVen = estVen;
	}
	
	

}
