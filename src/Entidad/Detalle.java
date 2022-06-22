package Entidad;

public class Detalle  {
	private int Codart,cantidad;
	private double precio;
	
	
	
	public int getCodigoConcepto() {
		return Codart;
	}
	public void setCodigoConcepto(int codigoConcepto) {
		this.Codart = codigoConcepto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
}
