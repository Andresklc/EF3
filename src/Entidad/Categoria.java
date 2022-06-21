package Entidad;

public class Categoria extends proveedor{

	private int idCat;
	private String nomCat;
	private String descCat;
	private int estCat;
	
	
	public Categoria(String nombre,String nomCat) {
		super(nombre);
		this.nomCat = nomCat;

	}
	public int getIdCat() {
		return idCat;
	}
	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}
	public String getNomCat() {
		return nomCat;
	}
	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}
	public String getDescCat() {
		return descCat;
	}
	public void setDescCat(String descCat) {
		this.descCat = descCat;
	}
	public int getEstCat() {
		return estCat;
	}
	public void setEstCat(int estCat) {
		this.estCat = estCat;
	}
	
	
}
