package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import Entidad.Detalle_Usuario;
import Entidad.Usuario;
import Util.MySqlDBConexion;

public class UsuarioModel {

	private static final Logger log = Logger.getLogger(UsuarioModel.class.getName());
	
	public Usuario valida(String login, String clave) {
		Usuario bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = MySqlDBConexion.getConexion();
			String sql = "select * from usuario where nomUsuario=? and claveUsu =?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, login);
			pstm.setString(2, clave);
			log.info(">>>" + pstm);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				bean = new Usuario(rs.getInt(1),rs.getInt(2),rs.getString("nomUsuario"),rs.getString("claveUsu"));
				

			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				conn.close();
				pstm.close();
			} catch (SQLException e) {
			}
		}
		return bean;
	}


	public int insertaUsuario(Detalle_Usuario obj) {
		log.info(">>Inicio >> insertaUsuario() ");
		int salida=-1;
		Connection conn=null;
		PreparedStatement pstm=null;
		
		try {
			conn=MySqlDBConexion.getConexion();
			String sql = "insert into usuario values(null,?,?,?);insert into detalle_usuario values(null,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, obj.getIdRoll());
			pstm.setString(2, obj.getLogin());
			pstm.setString(3, obj.getContraseña());
			pstm.setString(4, obj.getDni());
			pstm.setString(5, obj.getDirUsu());
			pstm.setString(6, obj.getTelUsu());
			pstm.setString(7, obj.getEmailUsu());


			
			
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

		log.info(">>Fin >> insertaUsuario() ");	
		return salida;
	}

public int actualizaUsuario(Detalle_Usuario u) {
	int actualizados = -1;
	Connection con = null;
	PreparedStatement pstm = null;
	try {
		con = MySqlDBConexion.getConexion();
		String sql = "update detalle_usuario set dniUsuario=?, dirUsuario=?, telefono=?, emailUsuario=? where idUsuario=?"; 
		pstm = con.prepareStatement(sql);
		pstm.setString(1, u.getDni());
		pstm.setString(2, u.getDirUsu());
		pstm.setString(3, u.getTelUsu());
		pstm.setString(4, u.getEmailUsu());
		pstm.setInt(5, u.getIdDUsuario());
		log.info(">>> " + pstm);
		actualizados = pstm.executeUpdate();
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
	return actualizados;
}

public int eliminaUsuario(int idUsuario) {
	int eliminados = -1;
	Connection con = null;
	PreparedStatement pstm = null;

	try {
		con = MySqlDBConexion.getConexion();
		String sql ="delete from usuario where idUsuario=?;delete from detalle_usuario where idUsuario=?";
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, idUsuario);
		pstm.setInt(2, idUsuario);
		log.info(">>> " + pstm);
		eliminados = pstm.executeUpdate();
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
	return eliminados;
}
public List<Detalle_Usuario> listaUsuario() {
	ArrayList<Detalle_Usuario> data = new ArrayList<Detalle_Usuario>();
	Connection con = null;
	PreparedStatement pstm = null;
	ResultSet rs = null; //Trae la data de la BD
	try {
		con = MySqlDBConexion.getConexion();
		String sql ="select u.idUsuario,u.idRol,u.nomUsuario,u.claveUsu,ud.dniUsuario,ud.dirUsuario,ud.telefono,ud.emailUsuario from usuario u join detalle_usuario ud on u.idUsuario=ud.idUsuario";
		pstm = con.prepareStatement(sql);
		log.info(">>> " + pstm);
		
		//En rs se trae los datos de la BD segun el SQL
		rs = pstm.executeQuery();
		
		//Se pasa la data del rs al ArrayList(data)
		while(rs.next()) {
			Detalle_Usuario bean=new Detalle_Usuario();
			bean.setIdDUsuario(rs.getInt(1));
			bean.setIdRoll(rs.getInt(2));
			bean.setLogin(rs.getString(3));
			bean.setContraseña(rs.getString(4));
			bean.setDni(rs.getString(5));
			bean.setDirUsu(rs.getString(6));
			bean.setTelUsu(rs.getString(7));
			bean.setEmailUsu(rs.getString(8));
			
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





