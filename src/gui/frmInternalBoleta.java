package gui;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;

import java.awt.Font;


import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Entidad.Ventas;
import Model.VentaModel;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import javax.swing.JTable;
import javax.swing.JScrollPane;



import interfaces.frmConsultaArticuloxnombre;
import interfaces.frmConsultaClienteXApellidos;

import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JComboBox;

public class frmInternalBoleta extends JInternalFrame implements ActionListener {

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
	public static JTextField txtSexo;
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
	private JLabel lblTotal;
	private JTextField txtTotal;
	private JButton btnGrabar;
	private JTable tblDetalle;
	private JScrollPane scrollPane;
	private JButton btnNuevo;
	public static JTextField txtDireccion;
	private JLabel lblDireccion;
	private JLabel lblApellido;
	public static JTextField txtApellido;
	private JButton btnEliminar_1;
	private JComboBox<String> cboEstado;

	

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
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconifiable(true);
		setBounds(100, 100, 800, 590);
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
		lblBoleta.setBounds(0, 22, 823, 47);
		contentPane.add(lblBoleta);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 80, 736, 106);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 38, 46, 14);
		panel.add(lblCdigo);
		
		txtCodigoCliente = new JTextField();
		txtCodigoCliente.setEnabled(false);
		txtCodigoCliente.setEditable(false);
		txtCodigoCliente.setBounds(88, 35, 110, 20);
		panel.add(txtCodigoCliente);
		txtCodigoCliente.setColumns(10);
		
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(10, 74, 77, 14);
		panel.add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(88, 71, 141, 20);
		panel.add(txtNombres);
		txtNombres.setColumns(10);
		
		btnBuscarCliente = new JButton("");
		btnBuscarCliente.addActionListener(this);
		btnBuscarCliente.setIcon(new ImageIcon(frmInternalBoleta.class.getResource("/iconos/Search.gif")));
		btnBuscarCliente.setBounds(208, 21, 55, 36);
		panel.add(btnBuscarCliente);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(417, 74, 55, 14);
		panel.add(lblSexo);
		
		txtSexo = new JTextField();
		txtSexo.setColumns(10);
		txtSexo.setBounds(475, 71, 77, 20);
		panel.add(txtSexo);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(562, 74, 55, 14);
		panel.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(605, 71, 110, 20);
		panel.add(txtDni);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(482, 35, 233, 20);
		panel.add(txtDireccion);
		
		lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setBounds(417, 38, 55, 14);
		panel.add(lblDireccion);
		
		JButton btnAdicionarCliente = new JButton("");
		btnAdicionarCliente.setIcon(new ImageIcon(frmInternalBoleta.class.getResource("/iconos/Add.gif")));
		btnAdicionarCliente.setBounds(273, 21, 55, 36);
		panel.add(btnAdicionarCliente);
		
		btnEliminar = new JButton("");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(338, 21, 55, 36);
		panel.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon(frmInternalBoleta.class.getResource("/iconos/Delete.gif")));
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(239, 74, 77, 14);
		panel.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(297, 71, 110, 20);
		panel.add(txtApellido);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos del Articulo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 197, 551, 90);
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
		btnBuscarArticulo.setBounds(275, 11, 89, 33);
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
		txtPrecio.setBounds(430, 60, 110, 20);
		panel_1.add(txtPrecio);
		
		btnEliminar_1 = new JButton("");
		btnEliminar_1.addActionListener(this);
		btnEliminar_1.setIcon(new ImageIcon(frmInternalBoleta.class.getResource("/iconos/Delete.gif")));
		btnEliminar_1.setBounds(374, 11, 89, 33);
		panel_1.add(btnEliminar_1);

		
		lblTotal = new JLabel("Total:");
		lblTotal.setBounds(586, 519, 46, 14);
		contentPane.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		txtTotal.setBounds(629, 516, 110, 20);
		contentPane.add(txtTotal);
		
		btnGrabar = new JButton("");
		btnGrabar.setIcon(new ImageIcon(frmInternalBoleta.class.getResource("/iconos/Save.gif")));
		btnGrabar.setBounds(119, 500, 89, 46);
		contentPane.add(btnGrabar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 298, 750, 191);
		contentPane.add(scrollPane);
		
		tblDetalle = new JTable();
		tblDetalle.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","CLIENTE","USUARIO","ARTICULO", "CANTIDAD", "IMPORTE","FECHA VENTA","ESTADO"
			}
		));
		tblDetalle.getColumnModel().getColumn(0).setPreferredWidth(60);
		tblDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
		tblDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
		tblDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
		tblDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
		tblDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
		tblDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
		tblDetalle.getColumnModel().getColumn(7).setPreferredWidth(70);
		tblDetalle.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblDetalle);
		
		btnNuevo = new JButton("");

		btnNuevo.setIcon(new ImageIcon(frmInternalBoleta.class.getResource("/iconos/Text.gif")));
		btnNuevo.setBounds(10, 502, 89, 46);
		contentPane.add(btnNuevo);
		
		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(573, 215, 77, 14);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.addActionListener(this);
		txtCantidad.setBounds(636, 212, 110, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setText("1");
		txtCantidad.setColumns(10);
		
		cboEstado = new JComboBox<String>();
		cboEstado.setBounds(629, 243, 120, 20);
		contentPane.add(cboEstado);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(573, 246, 77, 14);
		contentPane.add(lblEstado);
		
		listar() ;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == txtCantidad) {
			actionPerformedTxtCantidadJTextField(e);
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
			
		
			
	}
	protected void actionPerformedBtnBuscarArticuloJButton(ActionEvent e) {
		frmConsultaArticuloxnombre frm=new frmConsultaArticuloxnombre();
		frm.setVisible(true);

	}
	
	public void listar() {
		VentaModel model=new VentaModel();
		List<Ventas> lstVenta=model.listaVenta();
		DefaultTableModel dtm = (DefaultTableModel) tblDetalle.getModel();
		dtm.setRowCount(0);
		Object[] fila = null; 
		for (Ventas x:lstVenta){
			fila = new Object[] {x.getCodVen(),x.getNomcli(),x.getNomU(),x.getArt(),x.getCantida(),x.getMontoVen(),x.getFechVen(),x.getEstVen()};
			dtm.addRow(fila);
	}
}
	protected void actionPerformedBtnEliminarJButton(ActionEvent e) {
		txtCodigoCliente.setText("");
		txtNombres.setText("");
		txtApellido.setText("");
		txtDireccion.setText("");
		txtSexo.setText("");
		txtDni.setText("");
	}
	protected void actionPerformedBtnEliminar_1JButton(ActionEvent e) {
		txtCodigoArticulo.setText("");
		txtNombreArticulo.setText("");
		txtPrecio.setText("");
	}
	protected void actionPerformedTxtCantidadJTextField(ActionEvent e) {

	}
	

		
}
