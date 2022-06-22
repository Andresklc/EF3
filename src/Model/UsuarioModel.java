package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Logger;

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

	
}


