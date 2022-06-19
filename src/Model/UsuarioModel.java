package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import Entidad.Opcion;
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
				bean = new Usuario();
				bean.setIdUsuario(rs.getInt(1));
				bean.setIdRoll(rs.getInt(2));
				bean.setLogin(rs.getString("nomUsuario"));
				bean.setContraseña(rs.getString("claveUsu"));;

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

	public List<Opcion> obtieneOpciones(int idUsuario) {
		ArrayList<Opcion> data = new ArrayList<Opcion>();
		Opcion bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = MySqlDBConexion.getConexion();
			String sql = "select p.idOpcion, p.nombre  from opcion p inner join rol_has_opcion r on p.idOpcion = r.idOpcion inner join rol c on r.idrol = c.idrol inner join usuario_has_rol h on c.idrol = h.idRol where idUsuario = ? order by 2;";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idUsuario);
			log.info(">>>" + pstm);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				bean = new Opcion();
				bean.setIdOpcion(rs.getInt("idopcion"));
				bean.setNombre(rs.getString("nombre"));
				data.add(bean);
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
		return data;
	}

/*public int insertausuario(Usuario obj) {
		//se va imprimir en la consola este numero
			log.info(">>>inicio>>> insertaempresa()");
		int salida = -1;
		Connection conn=null;
		PreparedStatement pstm=null;
		
		try {
			conn=MySqlDBConexion.getConexion();
			String sql="insert into usuario values(null,?,?,?,?,?,?,curtime(),?,?,?)";
			
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getApellido());
			pstm.setString(3, obj.getDni());
			pstm.setString(4, obj.getLogin());
			pstm.setString(5, obj.getPassword());
			pstm.setString(6, obj.getCorreo());
			pstm.setDate(7, obj.getFechaNacimiento());
			pstm.setString(8, obj.getDireccion());
			pstm.setString(9, obj.getPais());
			
			salida= pstm.executeUpdate();
			
			log.info(">>>sql>>>" +pstm);
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) pstm.close();
				if(conn!=null) conn.close();
				
			} catch (Exception e2) {
			  e2.printStackTrace();
			}
			
		}
		
		
		
		log.info(">>>fin>>> insertausuario()");
		
		return salida;
	}public int actualizaUsuario(Usuario obj) {
		int actualizados = -1;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
		con = MySqlDBConexion.getConexion();
		String sql = "update usuario set nombre=?, apellido=?,dni=?,login=?,password=?, pais=?, correo=?, fechaNacimiento=? where idUsuario=?";
		pstm = con.prepareStatement(sql);
		pstm.setString(1, obj.getNombre());
		pstm.setString(2, obj.getApellido());
		pstm.setString(3, obj.getDni());
		pstm.setString(4, obj.getLogin());
		pstm.setString(5, obj.getPassword());
		pstm.setString(6, obj.getPais());
		pstm.setString(7, obj.getCorreo());
		pstm.setDate(8, obj.getFechaNacimiento());
		pstm.setInt(9, obj.getIdUsuario());
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
		String sql ="delete from usuario where idUsuario=?";
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, idUsuario);
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
		public List<Usuario> listaUsuario() {
		ArrayList<Usuario> data = new ArrayList<Usuario>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; //Trae la data de la BD
		try {
		con = MySqlDBConexion.getConexion();
		String sql ="select * from usuario";
		pstm = con.prepareStatement(sql);
		log.info(">>> " + pstm);
		//En rs se trae los datos de la BD segun el SQL
		rs = pstm.executeQuery();
		//Se pasa la data del rs al ArrayList(data)
		Usuario c = null;
		while(rs.next()){
		c = new Usuario();
		// Se colocan los campos de la base de datos
		c.setIdUsuario(rs.getInt(1));
		c.setNombre(rs.getString(2));
		c.setApellido(rs.getString(3));
		c.setDni(rs.getString(4));
		c.setLogin(rs.getString(5));
		c.setPassword(rs.getString(6));
		c.setCorreo(rs.getString(7));
		c.setFechaNacimiento(rs.getDate(9));
		c.setDireccion(rs.getString(10));
		c.setPais(rs.getString(11));
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
		
*/
}


