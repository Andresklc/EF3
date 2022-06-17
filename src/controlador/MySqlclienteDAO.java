package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Entidad.cliente;
import interfaces.clienteDAO;
import Util.MySqlDBConexion;

public class MySqlclienteDAO implements clienteDAO{

	@Override
	public ArrayList<cliente> listAllByApellido(String ape) {
		ArrayList<cliente> data=new ArrayList<cliente>();
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlDBConexion.getConexion();
			String sql="call buscar_cliente(?)";
			cstm=cn.prepareCall(sql);
			cstm.setString(1, ape);
			rs=cstm.executeQuery();
			while(rs.next()) {
				cliente bean=new cliente();
				bean.setCodigo(rs.getString(1));
				bean.setNombres(rs.getString(2));
				bean.setApellidos(rs.getString(3));
				bean.setDni(rs.getInt(4));
				bean.setSexo(rs.getString(5));
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
