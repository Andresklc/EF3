package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Entidad.Detalle_Usuario;
import Model.UsuarioModel;
import Util.Validaciones;

import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrudUsuario extends JInternalFrame implements MouseListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private JTextField txtDireccion;
	private JTextField txtdni;
	private JTable table;
	private int idSeleccionado = -1;
	private JTextField txtCodigo;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JButton btnAgregar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnLimpiar;
	private JTextField txtRoll;
	private JLabel lblRoll;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrudCliente frame = new CrudCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CrudUsuario() {
		setClosable(true);
		setBounds(100, 100, 735, 465);
		getContentPane().setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(102, 134, 194, 20);
		getContentPane().add(txtUsuario);
		
		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(102, 165, 194, 20);
		getContentPane().add(txtContraseña);
		
		txtdni = new JTextField();
		txtdni.setColumns(10);
		txtdni.setBounds(371, 69, 194, 20);
		getContentPane().add(txtdni);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(371, 103, 194, 20);
		getContentPane().add(txtDireccion);
		
		JLabel lblNewLabel = new JLabel("Usuario/Nombre:");
		lblNewLabel.setBounds(20, 140, 86, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblApellidos = new JLabel("Contrase\u00F1a");
		lblApellidos.setBounds(20, 168, 86, 14);
		getContentPane().add(lblApellidos);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(326, 72, 86, 14);
		getContentPane().add(lblDni);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(326, 106, 86, 14);
		getContentPane().add(lblDireccin);
		
		JLabel lblMantenimientoCliente = new JLabel("Mantenimiento Usuarios");
		lblMantenimientoCliente.setOpaque(true);
		lblMantenimientoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoCliente.setForeground(Color.WHITE);
		lblMantenimientoCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMantenimientoCliente.setBackground(Color.RED);
		lblMantenimientoCliente.setBounds(-121, 11, 895, 47);
		getContentPane().add(lblMantenimientoCliente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 214, 676, 210);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		

		

		

		

		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID", "ROLL","USUARIO","CONTRASEÑA", "DNI","DIRECCIÓN", "TELEFONO","EMAIL"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(57);
		table.getColumnModel().getColumn(1).setPreferredWidth(57);
		table.getColumnModel().getColumn(2).setPreferredWidth(179);
		table.getColumnModel().getColumn(3).setPreferredWidth(179);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(88);
		table.getColumnModel().getColumn(5).setPreferredWidth(88);
		table.getColumnModel().getColumn(6).setPreferredWidth(200);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(587, 69, 89, 30);
		getContentPane().add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(587, 140, 89, 30);
		getContentPane().add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(587, 103, 89, 30);
		getContentPane().add(btnActualizar);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setEnabled(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(102, 69, 101, 20);
		getContentPane().add(txtCodigo);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(20, 69, 86, 14);
		getContentPane().add(lblCodigo);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(371, 134, 194, 20);
		getContentPane().add(txtTelefono);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(326, 137, 86, 14);
		getContentPane().add(lblTelefono);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(371, 165, 194, 20);
		getContentPane().add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(326, 165, 86, 14);
		getContentPane().add(lblEmail);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(587, 173, 89, 30);
		getContentPane().add(btnLimpiar);
		
		txtRoll = new JTextField();
		txtRoll.setColumns(10);
		txtRoll.setBounds(102, 103, 101, 20);
		getContentPane().add(txtRoll);
		
		lblRoll = new JLabel("Roll:");
		lblRoll.setBounds(20, 106, 86, 14);
		getContentPane().add(lblRoll);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(76, 41, 233, 20);
		contentPanel.add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 44, 59, 14);
		contentPanel.add(lblNombre);
		

		

		
		listar();
	}
	public void mensaje(String ms){
		JOptionPane.showMessageDialog(this, ms);
	}
	

private void listar() {
	UsuarioModel model=new UsuarioModel();
	List<Detalle_Usuario> lstUsuario=model.listaUsuario();
	DefaultTableModel dtm = (DefaultTableModel) table.getModel();
	dtm.setRowCount(0);
	Object[] fila = null; 
	for (Detalle_Usuario x:lstUsuario){
		fila = new Object[] {x.getIdDUsuario(), x.getIdRoll(),x.getLogin(),x.getContraseña(),x.getDni(),x.getDirUsu(),x.getTelUsu(),x.getEmailUsu()};
		dtm.addRow(fila);
	}
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			mouseClickedTableJTable(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTableJTable(MouseEvent e) {
		int fila=table.getSelectedRow();
		idSeleccionado=(Integer)table.getValueAt(fila, 0);
		int rol=(int) table.getValueAt(fila, 1);
		String usu=(String)table.getValueAt(fila, 2);		
		String con=(String)table.getValueAt(fila, 3);
		String dni=(String)table.getValueAt(fila, 4);
		String dir=(String)table.getValueAt(fila, 5);
		String tel=(String)table.getValueAt(fila, 6);
		String ema=(String)table.getValueAt(fila, 7);



		
		System.out.println(idSeleccionado+" - "+rol+" - "+usu+" - "+con+" - "+dni+" - "+dir+" - "+tel+" - "+ema); 
		txtCodigo.setText(String.valueOf(idSeleccionado));
		txtRoll.setText(String.valueOf(rol));
		txtUsuario.setText(usu);
		txtContraseña.setText(con);
		txtdni.setText(dni);
		txtDireccion.setText(dir);
		txtTelefono.setText(tel);
		txtEmail.setText(ema);


	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiarJButton(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminarJButton(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizarJButton(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregarJButton(e);
		}
	}
	protected void actionPerformedBtnAgregarJButton(ActionEvent e) {
		int rol=Integer.parseInt(txtRoll.getText());
		String usu=	txtUsuario.getText();
		String con=txtContraseña.getText();
		String dni=txtdni.getText();
		String dir=txtDireccion.getText();
		String tel=txtTelefono.getText();
		String ema=txtEmail.getText();
		if(rol>2 || rol<1) {
			mensaje("El Nombre es de 2 a 20 Caracteres");
		}else if(!usu.matches(Validaciones.TEXTO)) {
			mensaje("El Apellido es de 2 a 20 Caracteres");
		}else if(!con.matches(Validaciones.TEXTO)) {
			mensaje("El Apellido es de 2 a 20 Caracteres");
		}else if(!dni.matches(Validaciones.DNI)) {
			mensaje("El DNI debe tener 8 digitos");
		}else if(!dir.matches(Validaciones.DIRECCION)) {
			mensaje("La direccion contiene de 2 a 30 caracteres ");
		}else if(!tel.matches(Validaciones.TELEFONO)) {
			mensaje("La direccion contiene de 2 a 30 caracteres ");
		}else if(!ema.matches(Validaciones.CORREO)) {
			mensaje("La direccion contiene de 2 a 30 caracteres ");
		}else {
			Detalle_Usuario obj=new Detalle_Usuario();
			obj.setIdRoll(rol);
			obj.setLogin(usu);
			obj.setContraseña(con);
			obj.setDni(dni);
			obj.setDirUsu(dir);
			obj.setTelUsu(tel);
			obj.setEmailUsu(ema);

			
			UsuarioModel model=new UsuarioModel();
			int salida=model.insertaUsuario(obj);
			if(salida>0) {
				mensaje("Registro Exitoso");
			}else {
				mensaje("Error en el Registro");
			}
			txtCodigo.setText("");
			txtRoll.setText("");
			txtUsuario.setText("");
			txtContraseña.setText("");
			txtdni.setText("");
			txtDireccion.setText("");
			txtTelefono.setText("");
			txtEmail.setText("");
	}
	}
	protected void actionPerformedBtnActualizarJButton(ActionEvent e) {
		int cod=Integer.parseInt(txtCodigo.getText());
		int rol=Integer.parseInt(txtRoll.getText());
		String usu=	txtUsuario.getText();
		String con=txtContraseña.getText();
		String dni=txtdni.getText();
		String dir=txtDireccion.getText();
		String tel=txtTelefono.getText();
		String ema=txtEmail.getText();
		if(rol>2 || rol<1) {
			mensaje("El Nombre es de 2 a 20 Caracteres");
		}else {
			Detalle_Usuario obj=new Detalle_Usuario();
			obj.setIdDUsuario(cod);
			obj.setIdRoll(rol);
			obj.setLogin(usu);
			obj.setContraseña(con);
			obj.setDni(dni);
			obj.setDirUsu(dir);
			obj.setTelUsu(tel);
			obj.setEmailUsu(ema);

			
			UsuarioModel model=new UsuarioModel();
			int salida=model.actualizaUsuario(obj);
			if(salida>0) {
				mensaje("Registro Exitoso");
			}else {
				mensaje("Error en el Registro");
			}
			txtCodigo.setText("");
			txtRoll.setText("");
			txtUsuario.setText("");
			txtContraseña.setText("");
			txtdni.setText("");
			txtDireccion.setText("");
			txtTelefono.setText("");
			txtEmail.setText("");
	}
		
	}
	protected void actionPerformedBtnEliminarJButton(ActionEvent e) {
		if (idSeleccionado == -1) {
			mensaje("Seleccione una Fila");
		}else {
			UsuarioModel model = new UsuarioModel();
			int salida = model.eliminaUsuario(idSeleccionado);
			if (salida > 0) {
				listar();
				idSeleccionado = -1;
				mensaje("Se eliminó correctamente");
			}else {
				mensaje("Error en la eliminación");
			}
			txtCodigo.setText("");
			txtRoll.setText("");
			txtUsuario.setText("");
			txtContraseña.setText("");
			txtdni.setText("");
			txtDireccion.setText("");
			txtTelefono.setText("");
			txtEmail.setText("");
		
		}
	}
	protected void actionPerformedBtnLimpiarJButton(ActionEvent e) {
		txtCodigo.setText("");
		txtRoll.setText("");
		txtUsuario.setText("");
		txtContraseña.setText("");
		txtdni.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtEmail.setText("");
	}
	}

