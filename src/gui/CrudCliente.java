package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
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

import Entidad.cliente;
import Model.ClienteModel;
import Util.Validaciones;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrudCliente extends JInternalFrame implements MouseListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtNombres;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtdni;
	private JTable table;
	private int idSeleccionado = -1;
	private JTextField txtCodigo;
	private JButton btnAgregar;
	private JButton btnActualizar;
	public static JRadioButton rdbtnMasculino;
	public static JRadioButton rdbtnFemenino;
	private ButtonGroup grupo1;
	private JButton btnLimpiar;
	private JButton btnEliminar;


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
	public CrudCliente() {
		setClosable(true);
		setBounds(100, 100, 474, 465);
		getContentPane().setLayout(null);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(102, 103, 194, 20);
		getContentPane().add(txtNombres);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(102, 134, 194, 20);
		getContentPane().add(txtApellido);
		
		txtdni = new JTextField();
		txtdni.setColumns(10);
		txtdni.setBounds(102, 165, 194, 20);
		getContentPane().add(txtdni);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(102, 196, 194, 20);
		getContentPane().add(txtDireccion);
		
		
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(31, 106, 86, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(31, 137, 86, 14);
		getContentPane().add(lblApellidos);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(31, 168, 86, 14);
		getContentPane().add(lblDni);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(31, 199, 86, 14);
		getContentPane().add(lblDireccin);
		
		JLabel lblDireccin_1 = new JLabel("Genero:");
		lblDireccin_1.setBounds(31, 227, 86, 14);
		getContentPane().add(lblDireccin_1);
		
		JLabel lblMantenimientoCliente = new JLabel("Mantenimiento Cliente");
		lblMantenimientoCliente.setOpaque(true);
		lblMantenimientoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoCliente.setForeground(Color.WHITE);
		lblMantenimientoCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMantenimientoCliente.setBackground(Color.RED);
		lblMantenimientoCliente.setBounds(-121, 11, 667, 47);
		getContentPane().add(lblMantenimientoCliente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 278, 428, 122);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(102, 223, 109, 23);
		getContentPane().add(rdbtnMasculino);
		
		rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setBounds(102, 248, 109, 23);
		getContentPane().add(rdbtnFemenino);
		grupo1 = new ButtonGroup();
		grupo1.add(rdbtnFemenino);
		grupo1.add(rdbtnMasculino);
		

		

		

		

		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID", "NOMBRES","APELLIDOS", "DNI","DIRECCIÓN", "SEXO"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(57);
		table.getColumnModel().getColumn(1).setPreferredWidth(179);
		table.getColumnModel().getColumn(2).setPreferredWidth(179);
		table.getColumnModel().getColumn(3).setPreferredWidth(88);
		table.getColumnModel().getColumn(2).setPreferredWidth(179);
		table.getColumnModel().getColumn(4).setPreferredWidth(98);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(340, 69, 89, 32);
		getContentPane().add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(340, 153, 89, 32);
		getContentPane().add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(340, 103, 89, 32);
		getContentPane().add(btnActualizar);
		
		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(102, 69, 79, 20);
		getContentPane().add(txtCodigo);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(31, 69, 86, 14);
		getContentPane().add(lblCodigo);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(340, 190, 89, 32);
		getContentPane().add(btnLimpiar);
		
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
	ClienteModel model=new ClienteModel();
	List<cliente> lstcliente=model.listaCliente();
	DefaultTableModel dtm = (DefaultTableModel) table.getModel();
	dtm.setRowCount(0);
	Object[] fila = null; 
	for (cliente x:lstcliente){
		fila = new Object[] {x.getCodigo(), x.getNombres(),x.getApellidos(),x.getDni(),x.getDireccion(),x.getSexo()};
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
		String nombre=(String)table.getValueAt(fila, 1);
		String apellido=(String)table.getValueAt(fila, 2);		
		String DNI=(String)table.getValueAt(fila, 3);
		String direccion=(String)table.getValueAt(fila, 4);
		String sexo=(String)table.getValueAt(fila, 5);



		
		System.out.println(idSeleccionado+" - "+nombre+" - "+apellido+" - "+DNI+" - "+direccion+" - "+sexo); 
		
		txtCodigo.setText(String.valueOf(idSeleccionado));
		txtNombres.setText(nombre);
		txtApellido.setText(apellido);
		txtdni.setText(DNI);
		txtDireccion.setText(direccion);
		if(sexo.equals("M")) {
			rdbtnMasculino.setSelected(true);}
			if(sexo.equals("F")) {
			rdbtnFemenino.setSelected(true);}
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminarJButton(e);
		}
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiarJButton(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizarJButton(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregarJButton(e);
		}
	}
	protected void actionPerformedBtnAgregarJButton(ActionEvent e) {
		String nom=txtNombre.getText();
		String ape=txtApellido.getText();
		String dni=txtdni.getText();
		String dir=txtDireccion.getText();
		String sex="";
		if(rdbtnMasculino.isSelected()==true) {
		sex="M";}else if(rdbtnFemenino.isSelected()==true){sex="F";}else {mensaje("Selecciona tu genero");}
		
		if(!nom.matches(Validaciones.TEXTO)) {
			mensaje("El Nombre es de 2 a 20 Caracteres");
		}else if(!ape.matches(Validaciones.TEXTO)) {
			mensaje("El Apellido es de 2 a 20 Caracteres");
		}else if(!dni.matches(Validaciones.DNI)) {
			mensaje("El DNI debe tener 8 digitos");
		}else if(!dir.matches(Validaciones.DIRECCION)) {
			mensaje("La direccion contiene de 2 a 30 caracteres ");
		}else {
			cliente obj=new cliente();
			obj.setNombres(nom);
			obj.setApellidos(ape);
			obj.setDni(dni);
			obj.setDireccion(dir);
			obj.setSexo(sex);

			
			ClienteModel model=new ClienteModel();
			int salida=model.insertaCliente(obj);
			if(salida>0) {
				mensaje("Registro Exitoso");
			}else {
				mensaje("Error en el Registro");
			}

			txtNombre.setText("");
			txtApellido.setText("");
			txtDireccion.setText("");
			 grupo1.clearSelection();
			txtdni.setText("");
		}
	}
	protected void actionPerformedBtnActualizarJButton(ActionEvent e) {
		int cod=Integer.parseInt(txtCodigo.getText());
		String nom = txtNombre.getText();
		String ape = txtApellido.getText();
		String dni = txtdni.getText();
		String dir = txtDireccion.getText();
		String sex="";
		if(rdbtnMasculino.isSelected()==true) {
		sex="M";}else if(rdbtnFemenino.isSelected()==true){sex="F";}else {mensaje("Selecciona tu genero");}
		

		if(!nom.matches(Validaciones.TEXTO)) {
			mensaje("El Nombre es de 2 a 20 Caracteres");
		}else if(!ape.matches(Validaciones.TEXTO)) {
			mensaje("El Apellido es de 2 a 20 Caracteres");
		}else if(!dni.matches(Validaciones.DNI)) {
			mensaje("El DNI debe tener 8 digitos");
		}else if(!dir.matches(Validaciones.DIRECCION)) {
			mensaje("La direccion contiene de 2 a 30 caracteres ");
		}else {
			cliente obj=new cliente();
			obj.setCodigo(cod);
			obj.setNombres(nom);
			obj.setApellidos(ape);
			obj.setDni(dni);
			obj.setDireccion(dir);
			obj.setSexo(sex);
			ClienteModel model = new ClienteModel();
			int salida = model.actualizacliente(obj);
			if (salida > 0) {

				mensaje("Se actualizó correctamente");
			}else {
				mensaje("Error en la actualización");
			}
			
			txtCodigo.setText("");
			txtNombre.setText("");
			txtApellido.setText("");
			txtDireccion.setText("");
			 grupo1.clearSelection();
			txtdni.setText("");
			

		}
	
	}
	protected void actionPerformedBtnLimpiarJButton(ActionEvent e) {
		
		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtDireccion.setText("");
		 grupo1.clearSelection();
		txtdni.setText("");
	}
	protected void actionPerformedBtnEliminarJButton(ActionEvent e) {
		if (idSeleccionado == -1) {
			mensaje("Seleccione una Fila");
		}else {
			ClienteModel model = new ClienteModel();
			int salida = model.eliminaCliente(idSeleccionado);
			if (salida > 0) {
				listar();
				idSeleccionado = -1;
				mensaje("Se eliminó correctamente");
			}else {
				mensaje("Error en la eliminación");
			}
			txtCodigo.setText("");
			txtNombre.setText("");
			txtApellido.setText("");
			txtDireccion.setText("");
			 grupo1.clearSelection();
			txtdni.setText("");

		}
	}
	}

