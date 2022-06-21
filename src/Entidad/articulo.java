package Entidad;

public class articulo extends Categoria{
	private int codArt;
	private String nombArt;
	private int cantidad;
	private double precio;
	
	
	
	
	

	
	

	



	public articulo(String nombre, String nomCat, int codArt, String nombArt, int cantidad, double precio) {
		super(nombre, nomCat);
		this.codArt = codArt;
		this.nombArt = nombArt;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public int getCodArt() {
		return codArt;
	}
	public void setCodArt(int codArt) {
		this.codArt = codArt;
	}
	public String getNombArt() {
		return nombArt;
	}
	public void setNombArt(String nombArt) {
		this.nombArt = nombArt;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
