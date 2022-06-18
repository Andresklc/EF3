package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidad.articulo;
import Util.MySqlDBConexion;
import interfaces.articuloDAO;

public class MySqlarticuloDAO implements articuloDAO{

	@Override
	public ArrayList<articulo> listAllByNombre(String nombre) {
		ArrayList<articulo> data=new ArrayList<articulo>();
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlDBConexion.getConexion();
			String sql="call buscar_articulo(?)";
			cstm=cn.prepareCall(sql);
			cstm.setString(1, nombre);
			rs=cstm.executeQuery();
			while(rs.next()) {
				articulo bean=new articulo();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setPrecio(rs.getDouble(4));
				data.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(cstm!=null) cstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return data;		
	}

}
