package interfaces;

import java.util.ArrayList;

import Entidad.articulo;

public interface articuloDAO {
	public ArrayList<articulo> listAllByNombre(String nombre);
}
