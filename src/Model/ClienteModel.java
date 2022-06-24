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
	
private static final Logger log = Logger.getLogger(ClienteModel.class.getName());
	
	public ArrayList<cliente> listaporNombreApellido(String nombre,String apellidos) {
		ArrayList<cliente> data=new ArrayList<cliente>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs=null;
		try {
			conn = MySqlDBConexion.getConexion();
			String sql="select idCliente,nombres,apellidos,sexo,dni,Direccion,fechaIncripcion from cliente where (nombres like ?) and (apellidos like ?)";
			pstm=conn.prepareCall(sql);
			pstm.setString(1, "%"+nombre+"%");
			pstm.setString(2, "%"+apellidos+"%");
			log.info(">>>" + pstm);
			rs=pstm.executeQuery();
			while(rs.next()) {
				cliente bean=new cliente();
				bean.setCodigo(rs.getInt(1));
				bean.setNombres(rs.getString(2));
				bean.setApellidos(rs.getString(3));
				bean.setSexo(rs.getString(4));
				bean.setDni(rs.getString(5));
				bean.setDireccion(rs.getString(6));
				
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
			String sql ="select idCliente,nombres,apellidos,sexo,dni,Direccion,fechaIncripcion from cliente";
			pstm = con.prepareStatement(sql);
			log.info(">>> " + pstm);
			
			//En rs se trae los datos de la BD segun el SQL
			rs = pstm.executeQuery();
			
			//Se pasa la data del rs al ArrayList(data)
			while(rs.next()) {
				cliente bean=new cliente();
				bean.setCodigo(rs.getInt(1));
				bean.setNombres(rs.getString(2));
				bean.setApellidos(rs.getString(3));
				bean.setSexo(rs.getString(4));
				bean.setDni(rs.getString(5));
				bean.setDireccion(rs.getString(6));
				bean.setFechaI(rs.getDate(7));
				
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
	

	public int insertaCliente(cliente obj) {
		log.info(">>Inicio >> insertaCliente() ");
		int salida=-1;
		Connection conn=null;
		PreparedStatement pstm=null;
		
		try {
			conn=MySqlDBConexion.getConexion();
			String sql = "insert into cliente values(null,?,?,?,?,?,curdate())";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getDni());
			pstm.setString(2, obj.getNombres());
			pstm.setString(3, obj.getApellidos());
			pstm.setString(4, obj.getDireccion());
			pstm.setString(5, obj.getSexo());
			
			
			salida = pstm.executeUpdate();
			log.info(">>SQL>> "+pstm);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm !=null)pstm.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
			
		}

		log.info(">>Fin >> insertaCliente() ");	
		return salida;
	}
}
