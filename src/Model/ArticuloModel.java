package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import Entidad.articulo;
import Util.MySqlDBConexion;


public class ArticuloModel {


	private static final Logger log = Logger.getLogger(UsuarioModel.class.getName());
	
	public ArrayList<articulo> listAllByNombre(String nombre) {
		ArrayList<articulo> data=new ArrayList<articulo>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs=null;
		try {
			conn = MySqlDBConexion.getConexion();
			String sql="select idArticulo,nomArticulo,PrecioUnitario from Articulo where nomArticulo like ?";
			pstm=conn.prepareCall(sql);
			pstm.setString(1, "%"+nombre+"%");
			log.info(">>>" + pstm);
			rs=pstm.executeQuery();
			while(rs.next()) {
				articulo bean1=new articulo();
				bean1.setCodigo(rs.getInt(1));
				bean1.setNombre(rs.getString(2));
				bean1.setPrecio(rs.getDouble(3));
				data.add(bean1);

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
	public List<articulo> listaArticulo() {
		ArrayList<articulo> data = new ArrayList<articulo>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; //Trae la data de la BD
		try {
			con = MySqlDBConexion.getConexion();
			String sql ="select idArticulo,nomArticulo,PrecioUnitario from Articulo";
			pstm = con.prepareStatement(sql);
			log.info(">>> " + pstm);
			
			//En rs se trae los datos de la BD segun el SQL
			rs = pstm.executeQuery();
			
			//Se pasa la data del rs al ArrayList(data)
			articulo c = null;
			while(rs.next()){
				c = new articulo();
				// Se colocan los campos de la base de datos
				c.setCodigo(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setPrecio(rs.getDouble(3));
				
				data.add(c);
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
