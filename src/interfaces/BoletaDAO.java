package interfaces;

import java.util.ArrayList;

import Entidad.Boleta;
import Entidad.Detalle;

public interface BoletaDAO {
	public int save(Boleta bean,ArrayList<Detalle> lista);
	
}
