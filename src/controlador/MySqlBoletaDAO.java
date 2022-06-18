package controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidad.Boleta;
import Entidad.Detalle;
import Util.MySqlDBConexion;
import interfaces.BoletaDAO;

public class MySqlBoletaDAO implements BoletaDAO{

	@Override
	public int save(Boleta bean, ArrayList<Detalle> lista) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstmBol=null,pstmDet=null;
		try {
			//1
			cn=MySqlDBConexion.getConexion();
			//2. anular el commit de la conexión 
			cn.setAutoCommit(false);
			//3. sentencia sql para Boleta
			String sqlBol="insert into boleta values(?,?,?,?,?)";
			//4. crear objeto pstmBol
			pstmBol=cn.prepareStatement(sqlBol);
			//5. parámetros
			pstmBol.setInt(1, bean.getNumeroBoleta());
			pstmBol.setString(2, bean.getCodigoLector());
			pstmBol.setDate(3,Date.valueOf(bean.getFecha()));
			pstmBol.setInt(4, bean.getCodigoUsuario());
			pstmBol.setDouble(5, bean.getTotal());
			//6. ejecutar
			salida=pstmBol.executeUpdate();
			
			//grabar detalle boleta
			//1. sentencia sql para detalle boleta
			String sqlDet="insert into tb_detalle_boleta values(?,?,?,?)";
			//2. bucle para realizar recorrido sobre lista
			for(Detalle d:lista) {
				//3. crear objeto pstmDet
				pstmDet=cn.prepareStatement(sqlDet);
				//4 parámetros
				pstmDet.setInt(1, bean.getNumeroBoleta());
				pstmDet.setInt(2, d.getCodigoConcepto());
				pstmDet.setDouble(3, d.getPrecio());
				pstmDet.setInt(4, d.getCantidad());
				//5 ejecutar
				salida=pstmDet.executeUpdate();
			}
			//confirmar insert's
			cn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			//revertir los insert's
			try {
				cn.rollback();
				//
				salida=-1;
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}
		finally {
			try {
				if(pstmDet!=null) pstmDet.close();
				if(pstmBol!=null) pstmBol.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

}
