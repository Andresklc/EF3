package gui;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;


import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import Entidad.Ventas;
import Entidad.articuloSolo;
import Entidad.cliente;
import Model.ClienteModel;
import Model.VentaModel;
import Util.Validaciones;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import interfaces.BoletaImpresa;
import interfaces.frmConsultaArticuloxnombre;
import interfaces.frmConsultaClienteXApellidos;


import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.event.MouseEvent;

public class frmInternalBoleta extends JInternalFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public frmConsultaArticuloxnombre frmConsultaArticuloxnombre = new frmConsultaArticuloxnombre();
	public frmConsultaClienteXApellidos frmConsultaClienteXApellidos = new frmConsultaClienteXApellidos();
	private JPanel contentPane;
	private JLabel lblBoleta;
	public static JTextField txtCodigoCliente;
	public static JTextField txtNombres;
	public static JTextField txtDni;
	private JButton btnBuscarCliente;
	private JPanel panel_1;
	private JLabel label;
	public static  JTextField txtCodigoArticulo;
	public static  JTextField txtNombreArticulo;
	public static  JTextField txtPrecio;
	private JButton btnBuscarArticulo;
	private JLabel lblNombre;
	private JLabel lblPrecio;
	public static JTextField txtCantidad;
	private JLabel lblCantidad;
	private JButton btnEliminar;
	private JButton btnGrabar;
	private JTable tblDetalle;
	private JScrollPane scrollPane;
	public static JTextField txtDireccion;
	private JLabel lblDireccion;
	private JLabel lblApellido;
	public static JTextField txtApellido;
	private JButton btnEliminar_1;
	private JButton btnAdicionarCliente;
	public static JRadioButton rdbtnMasculino;
	public static JRadioButton rdbtnFemenino;
	private ButtonGroup grupo1;
	private int idSeleccionado = -1;
	private JButton btnBoleta;
	public static JLabel lbliDUsuario;
	public static JLabel lblUsuario;
	private JButton btnImprimirBoleta;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmInternalBoleta frame = new frmInternalBoleta();
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
	public frmInternalBoleta() {
		setTitle("Creador de Boleta");
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconifiable(true);
		setBounds(100, 100, 667, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblBoleta = new JLabel("Boleta");
		lblBoleta.setForeground(Color.WHITE);
		lblBoleta.setOpaque(true);
		lblBoleta.setBackground(Color.BLACK);
		lblBoleta.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoleta.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBoleta.setBounds(0, 22, 667, 47);
		contentPane.add(lblBoleta);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 80, 631, 147);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 38, 46, 14);
		panel.add(lblCdigo);
		
		txtCodigoCliente = new JTextField();
		txtCodigoCliente.addActionListener(this);
		txtCodigoCliente.setEnabled(false);
		txtCodigoCliente.setEditable(false);
		txtCodigoCliente.setBounds(88, 35, 110, 20);
		panel.add(txtCodigoCliente);
		txtCodigoCliente.setColumns(10);
		
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(10, 74, 77, 14);
		panel.add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(88, 71, 117, 20);
		panel.add(txtNombres);
		txtNombres.setColumns(10);
		
		btnBuscarCliente = new JButton("");
		btnBuscarCliente.addActionListener(this);
		btnBuscarCliente.setIcon(new ImageIcon(frmInternalBoleta.class.getResource("/iconos/Search.gif")));
		btnBuscarCliente.setBounds(208, 21, 55, 36);
		panel.add(btnBuscarCliente);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(409, 77, 55, 14);
		panel.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(452, 74, 110, 20);
		panel.add(txtDni);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(88, 104, 305, 20);
		panel.add(txtDireccion);
		
		lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setBounds(10, 107, 55, 14);
		panel.add(lblDireccion);
		
		btnAdicionarCliente = new JButton("");
		btnAdicionarCliente.addActionListener(this);
		btnAdicionarCliente.setIcon(new ImageIcon(frmInternalBoleta.class.getResource("/iconos/Add.gif")));
		btnAdicionarCliente.setBounds(273, 21, 55, 36);
		panel.add(btnAdicionarCliente);
		
		btnEliminar = new JButton("");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(338, 21, 55, 36);
		panel.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon(frmInternalBoleta.class.getResource("/iconos/Delete.gif")));
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(215, 74, 77, 14);
		panel.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(264, 71, 129, 20);
		panel.add(txtApellido);
		
		JLabel lblGener = new JLabel("Genero:");
		lblGener.setBounds(419, 33, 55, 14);
		panel.add(lblGener);
		
		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(480, 29, 89, 23);
		panel.add(rdbtnMasculino);
		
		rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setBounds(480, 47, 89, 23);
		panel.add(rdbtnFemenino);
		
		grupo1 = new ButtonGroup();
		grupo1.add(rdbtnFemenino);
		grupo1.add(rdbtnMasculino);

		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos del Articulo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 279, 568, 90);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		label = new JLabel("C\u00F3digo:");
		label.setBounds(10, 27, 46, 14);
		panel_1.add(label);
		
		txtCodigoArticulo = new JTextField();
		txtCodigoArticulo.setEnabled(false);
		txtCodigoArticulo.setEditable(false);
		txtCodigoArticulo.setColumns(10);
		txtCodigoArticulo.setBounds(88, 24, 178, 20);
		panel_1.add(txtCodigoArticulo);
		
		btnBuscarArticulo = new JButton("");
		btnBuscarArticulo.addActionListener(this);
		btnBuscarArticulo.setIcon(new ImageIcon(frmInternalBoleta.class.getResource("/iconos/Search.gif")));
		btnBuscarArticulo.setBounds(330, 11, 89, 33);
		panel_1.add(btnBuscarArticulo);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 63, 77, 14);
		panel_1.add(lblNombre);
		
		txtNombreArticulo = new JTextField();
		txtNombreArticulo.setEnabled(false);
		txtNombreArticulo.setEditable(false);
		txtNombreArticulo.setColumns(10);
		txtNombreArticulo.setBounds(88, 60, 276, 20);
		panel_1.add(txtNombreArticulo);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(372, 63, 77, 14);
		panel_1.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setEnabled(false);
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(430, 60, 128, 20);
		panel_1.add(txtPrecio);
		
		btnEliminar_1 = new JButton("");
		btnEliminar_1.addActionListener(this);
		btnEliminar_1.setIcon(new ImageIcon(frmInternalBoleta.class.getResource("/iconos/Delete.gif")));
		btnEliminar_1.setBounds(450, 11, 89, 33);
		panel_1.add(btnEliminar_1);
		
		btnGrabar = new JButton("Agregar a boleta");
		btnGrabar.addActionListener(this);
		btnGrabar.setIcon(null);
		btnGrabar.setBounds(10, 380, 175, 20);
		contentPane.add(btnGrabar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 406, 631, 168);
		contentPane.add(scrollPane);
		
		tblDetalle = new JTable();
		tblDetalle.addMouseListener(this);
		tblDetalle.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","ARTICULO", "CANTIDAD", "IMPORTE"
			}
		));
		tblDetalle.getColumnModel().getColumn(0).setPreferredWidth(60);
		tblDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
		tblDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
		tblDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);


		tblDetalle.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblDetalle);
		
		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(588, 290, 53, 14);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.addActionListener(this);
		txtCantidad.setBounds(588, 310, 46, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setText("1");
		txtCantidad.setColumns(10);
		
		btnBoleta = new JButton("Generar Boleta");
		btnBoleta.addActionListener(this);
		btnBoleta.setEnabled(false);
		btnBoleta.setBounds(20, 238, 216, 30);
		contentPane.add(btnBoleta);
		
		lbliDUsuario = new JLabel("");
		lbliDUsuario.setBounds(692, 227, 46, 14);
		contentPane.add(lbliDUsuario);
		
		 lblUsuario = new JLabel("");
		lblUsuario.setBounds(702, 254, 36, 14);
		contentPane.add(lblUsuario);
		
		btnImprimirBoleta = new JButton("Imprimir Boleta");
		btnImprimirBoleta.addActionListener(this);
		btnImprimirBoleta.setBounds(474, 380, 167, 20);
		contentPane.add(btnImprimirBoleta);
		
		tamano_defecto();
	}
	public void mensaje(String ms){
		JOptionPane.showMessageDialog(this, ms);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnImprimirBoleta) {
			actionPerformedBtnImprimirBoletaJButton(e);
		}
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabarJButton(e);
		}
		if (e.getSource() == btnBoleta) {
			actionPerformedBtnBoletaJButton(e);
		}
		
		if (e.getSource() == btnAdicionarCliente) {
			actionPerformedBtnAdicionarClienteJButton(e);
		}

		if (e.getSource() == btnEliminar_1) {
			actionPerformedBtnEliminar_1JButton(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminarJButton(e);
		}
		if (e.getSource() == btnBuscarArticulo) {
			actionPerformedBtnBuscarArticuloJButton(e);
		}
		if (e.getSource() == btnBuscarCliente) {
			actionPerformedBtnBuscarClienteJButton(e);
		}
	}
	protected void actionPerformedBtnBuscarClienteJButton(ActionEvent e) {
		frmConsultaClienteXApellidos frm=new frmConsultaClienteXApellidos();
			frm.setVisible(true);
			
			habilita_boton();
			
		
			
	}
	protected void actionPerformedBtnBuscarArticuloJButton(ActionEvent e) {
		frmConsultaArticuloxnombre frm=new frmConsultaArticuloxnombre();
		frm.setVisible(true);

	}
	
	
	protected void actionPerformedBtnEliminarJButton(ActionEvent e) {
		txtCodigoCliente.setText("");
		txtNombres.setText("");
		txtApellido.setText("");
		txtDireccion.setText("");
		grupo1.clearSelection();
		txtDni.setText("");
		vaciar();
		tamano_defecto();
	}
	protected void actionPerformedBtnEliminar_1JButton(ActionEvent e) {
		txtCodigoArticulo.setText("");
		txtNombreArticulo.setText("");
		txtPrecio.setText("");
	}

	
	
		
	protected void actionPerformedBtnAdicionarClienteJButton(ActionEvent e) {
		String nom=txtNombres.getText();
		String ape=txtApellido.getText();
		String dni=txtDni.getText();
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
			txtCodigoCliente.setText("");
			txtNombres.setText("");
			txtApellido.setText("");
			txtDireccion.setText("");
			 grupo1.clearSelection();
			txtDni.setText("");
			
		}
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblDetalle) {
			mouseClickedTblDetalleJTable(e);
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
	protected void mouseClickedTblDetalleJTable(MouseEvent e) {
		int fila=tblDetalle.getSelectedRow();
		idSeleccionado=(Integer)tblDetalle.getValueAt(fila, 0);	
		String nomAr=(String)tblDetalle.getValueAt(fila, 1);
		int can=(Integer)tblDetalle.getValueAt(fila, 2);
		double imp=(Double)tblDetalle.getValueAt(fila, 3);
		
		
		System.out.println(idSeleccionado+" - "+nomAr+" - "+can+" - "+imp); 
	}
	private void habilita_boton() {
		if(txtCodigoArticulo.getText()!="") {
		btnBoleta.setEnabled(true);}else {
			btnBoleta.setEnabled(false);
		}
	}
	private void vaciar(){
		btnBoleta.setEnabled(false);
		
	}
	private void tamano_defecto(){this.setSize(new Dimension(668, 310));}
	private void tamano_abierto(){this.setSize(new Dimension(667, 619));
	}
	protected void actionPerformedBtnBoletaJButton(ActionEvent e) {
		tamano_abierto();
		vaciar();
		Ventas v=new Ventas();
		v.setCodUs(Integer.parseInt(lbliDUsuario.getText()));
		v.setCodCl(Integer.parseInt(txtCodigoCliente.getText()));
		VentaModel vm=new VentaModel();
		int salida=vm.insertaVentas(v);
		if(salida>0) {
			mensaje("Boleta generada");
		}else {
			mensaje("Error al generar la boleta");
		}
		
	}
	protected void actionPerformedBtnGrabarJButton(ActionEvent e) {
		articuloSolo A=new articuloSolo();
		A.setCodArt(Integer.parseInt(txtCodigoArticulo.getText()));
		A.setCantidad(Integer.parseInt(txtCantidad.getText()));
		double calculador=(Double.parseDouble(txtPrecio.getText())*Integer.parseInt(txtCantidad.getText()));
		A.setPrecio(calculador);
		VentaModel vm=new VentaModel();
		int salida=vm.insertaDetalleVenta(A);
		if(salida>0) {
			System.out.println ("Ingreso un producto");
		}else {
			System.out.println ("Error al ingresar producto");
		}
		
		List<Ventas> lstVentas=vm.listaVenta(Integer.parseInt(txtCodigoCliente.getText()));
		DefaultTableModel dtm = (DefaultTableModel) tblDetalle.getModel();
		dtm.setRowCount(0);
		Object[] fila = null; 
		for (Ventas x:lstVentas){
			fila = new Object[] {x.getCodVen(), x.getArt(),x.getCantida(),x.getMontoVen()};
			dtm.addRow(fila);
		}
		
	}
	protected void actionPerformedBtnImprimirBoletaJButton(ActionEvent e) {
		BoletaImpresa frm=new BoletaImpresa();
		frm.setVisible(true);
	}
}
