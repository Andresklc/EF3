package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import Entidad.Ventas;
import Util.MySqlDBConexion;

public class VentaModel {
	private static final Logger log = Logger.getLogger(VentaModel.class.getName());
	public List<Ventas> listaVenta() {
		ArrayList<Ventas> data = new ArrayList<Ventas>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; //Trae la data de la BD
		try {
			con = MySqlDBConexion.getConexion();
			String sql ="SELECT venta.idVentas,concat_ws(',',apellidos,nombres)as Nombres,nomUsuario,nomArticulo,Cantidad,fechaVenta,Monto,Estado FROM venta join cliente on venta.idCliente=cliente.idCliente Join usuario on venta.idUsuario=usuario.idUsuario join detalle_venta on detalle_venta.idVentas=venta.idVentas join articulo on detalle_venta.idArticulo=articulo.idArticulo";
			pstm = con.prepareStatement(sql);
			log.info(">>> " + pstm);
			
			//En rs se trae los datos de la BD segun el SQL
			rs = pstm.executeQuery();
			
			//Se pasa la data del rs al ArrayList(data)
			while(rs.next()) {
				Ventas bean=new Ventas();
				bean.setCodVen(rs.getInt(1));
				bean.setNomcli(rs.getString(2));
				bean.setNomU(rs.getString(3));
				bean.setArt(rs.getString(4));
				bean.setCantida(rs.getInt(5));
				bean.setFechVen(rs.getDate(6));
				bean.setMontoVen(rs.getDouble(7));
				bean.setEstVen(rs.getInt(8));
				
	
				
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
