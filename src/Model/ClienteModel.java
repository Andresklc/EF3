package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


import Entidad.cliente;
import Util.MySqlDBConexion;

public class ClienteModel {
	
private static final Logger log = Logger.getLogger(UsuarioModel.class.getName());
	
	public ArrayList<cliente> listaporNombreApellido(String nombre) {
		ArrayList<cliente> data=new ArrayList<cliente>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs=null;
		try {
			conn = MySqlDBConexion.getConexion();
			String sql="select idCliente,nombres,sexo,dni from cliente where nombres like ?";
			pstm=conn.prepareCall(sql);
			pstm.setString(1, "%"+nombre+"%");
			log.info(">>>" + pstm);
			rs=pstm.executeQuery();
			while(rs.next()) {
				cliente bean=new cliente();
				bean.setCodigo(rs.getInt(1));
				bean.setNombres(rs.getString(2));
				bean.setSexo(rs.getString(3));
				bean.setDni(rs.getString(4));
				
				data.add(bean);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(conn!=null) conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return data;		
	}
	public List<cliente> listaCliente() {
		ArrayList<cliente> data = new ArrayList<cliente>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; //Trae la data de la BD
		try {
			con = MySqlDBConexion.getConexion();
			String sql ="select idCliente,nombres,sexo,dni from cliente";
			pstm = con.prepareStatement(sql);
			log.info(">>> " + pstm);
			
			//En rs se trae los datos de la BD segun el SQL
			rs = pstm.executeQuery();
			
			//Se pasa la data del rs al ArrayList(data)
			while(rs.next()) {
				cliente bean=new cliente();
				bean.setCodigo(rs.getInt(1));
				bean.setNombres(rs.getString(2));
				bean.setSexo(rs.getString(3));
				bean.setDni(rs.getString(4));
				
				data.add(bean);

			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	

}
