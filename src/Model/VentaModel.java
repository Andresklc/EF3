package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import Entidad.Ventas;
import Entidad.articuloSolo;
import Util.MySqlDBConexion;


public class VentaModel {
	private static final Logger log = Logger.getLogger(VentaModel.class.getName());
	public List<Ventas> listaVenta(int xc) {
		ArrayList<Ventas> data = new ArrayList<Ventas>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; //Trae la data de la BD
		try {
			con = MySqlDBConexion.getConexion();
			String sql ="select idVentasD,nomArticulo,Cantidad,importe FROM venta "
					+ "join cliente on venta.idCliente=cliente.idCliente Join usuario "
					+ "on venta.idUsuario=usuario.idUsuario join detalle_venta on detalle_venta.idVentas=venta.idVentas "
					+ "join articulo on detalle_venta.idArticulo=articulo.idArticulo "
					+ "where (venta.idCliente=?) and venta.fechaVenta=curdate() and (venta.idVentas=(SELECT max(idVentas) FROM venta))";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, xc);


			log.info(">>> " + pstm);
			
			//En rs se trae los datos de la BD segun el SQL
			rs = pstm.executeQuery();
			
			//Se pasa la data del rs al ArrayList(data)
			while(rs.next()) {
				Ventas bean=new Ventas();
				bean.setCodVen(rs.getInt(1));
				bean.setArt(rs.getString(2));
				bean.setCantida(rs.getInt(3));
				bean.setMontoVen(rs.getDouble(4));
		
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
	
	public int insertaVentas( Ventas Obj) {
		log.info(">>Inicio >> insertaVentas() ");
		int salida=-1;
		Connection conn=null;
		PreparedStatement pstm=null;
		
		try {
			conn=MySqlDBConexion.getConexion();
			String sql = "insert into venta values (null,?,?,curdate(),0)";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, Obj.getCodCl());
			pstm.setInt(2, Obj.getCodUs());


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
		log.info(">>Fin >> insertaVentas()");
		return salida;
		
	
	
	}
	public int insertaDetalleVenta(articuloSolo Obj) {
		log.info(">>Inicio >> insertaDetalleVenta() ");
		int salida=-1;
		Connection conn=null;
		PreparedStatement pstm=null;
		
		try {
			conn=MySqlDBConexion.getConexion();
			String sql = "insert into detalle_venta values (null,(SELECT max(idVentas) FROM venta),?,?,?);";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, Obj.getCodArt());
			pstm.setInt(2, Obj.getCantidad());
			pstm.setDouble(3, Obj.getPrecio());


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
		log.info(">>Fin >> insertaDetalleVenta()");
		return salida;
		
	
	
	}
	
	}
