package interfaces;

import java.util.ArrayList;
import Entidad.cliente;

public interface clienteDAO {
	public ArrayList<cliente> listAllByApellido(String ape);

}
