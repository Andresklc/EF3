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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.util.Date;
import javax.swing.JTable;
import javax.swing.JScrollPane;


import com.toedter.calendar.JDateChooser;

import interfaces.frmConsultaArticuloxnombre;
import interfaces.frmConsultaClienteXApellidos;

import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

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
	private JLabel lblNro;
	private JTextField txtNumero;
	private JLabel lblFechaEmisin;
	private JButton btnGrabar;
	private JTable tblDetalle;
	private JScrollPane scrollPane;
	private JDateChooser dcFecha;
	private JButton btnNuevo;
	public static JTextField txtDireccion;
	private JLabel lblDireccion;

	

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
		setBounds(100, 100, 450, 300);
		setBounds(100, 100, 772, 662);
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
		lblBoleta.setBounds(0, 22, 767, 47);
		contentPane.add(lblBoleta);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 160, 736, 106);
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
		txtNombres.setBounds(88, 71, 276, 20);
		panel.add(txtNombres);
		txtNombres.setColumns(10);
		
		btnBuscarCliente = new JButton("");
		btnBuscarCliente.addActionListener(this);
		btnBuscarCliente.setIcon(new ImageIcon(frmInternalBoleta.class.getResource("/iconos/Search.gif")));
		btnBuscarCliente.setBounds(208, 11, 55, 46);
		panel.add(btnBuscarCliente);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(392, 74, 55, 14);
		panel.add(lblSexo);
		
		txtSexo = new JTextField();
		txtSexo.setColumns(10);
		txtSexo.setBounds(440, 71, 77, 20);
		panel.add(txtSexo);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(544, 74, 55, 14);
		panel.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(574, 71, 141, 20);
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
		btnAdicionarCliente.setBounds(273, 11, 55, 46);
		panel.add(btnAdicionarCliente);
		
		btnEliminar = new JButton("");
		btnEliminar.setBounds(338, 11, 55, 46);
		panel.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon(frmInternalBoleta.class.getResource("/iconos/Delete.gif")));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos del Articulo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 277, 736, 90);
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
		btnBuscarArticulo.setBounds(275, 11, 89, 46);
		panel_1.add(btnBuscarArticulo);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 63, 77, 14);
		panel_1.add(lblNombre);
		
		txtNombreArticulo = new JTextField();
		txtNombreArticulo.setColumns(10);
		txtNombreArticulo.setBounds(88, 60, 276, 20);
		panel_1.add(txtNombreArticulo);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(372, 63, 77, 14);
		panel_1.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(430, 60, 110, 20);
		panel_1.add(txtPrecio);
		
		txtCantidad = new JTextField();
		txtCantidad.setText("1");
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(616, 60, 110, 20);
		panel_1.add(txtCantidad);
		
		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(558, 66, 77, 14);
		panel_1.add(lblCantidad);
		
		JButton btnEliminar_1 = new JButton("");
		btnEliminar_1.setIcon(new ImageIcon(frmInternalBoleta.class.getResource("/iconos/Delete.gif")));
		btnEliminar_1.setBounds(374, 11, 89, 46);
		panel_1.add(btnEliminar_1);

		
		lblTotal = new JLabel("Total:");
		lblTotal.setBounds(586, 581, 46, 14);
		contentPane.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		txtTotal.setBounds(636, 575, 110, 20);
		contentPane.add(txtTotal);
		
		lblNro = new JLabel("Nro.");
		lblNro.setBounds(572, 83, 77, 14);
		contentPane.add(lblNro);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(619, 80, 127, 20);
		contentPane.add(txtNumero);
		
		lblFechaEmisin = new JLabel("Fecha Emisi\u00F3n:");
		lblFechaEmisin.setBounds(20, 109, 92, 14);
		contentPane.add(lblFechaEmisin);
		
		btnGrabar = new JButton("");
		btnGrabar.setIcon(new ImageIcon(frmInternalBoleta.class.getResource("/iconos/Save.gif")));
		btnGrabar.setBounds(119, 575, 89, 46);
		contentPane.add(btnGrabar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 378, 736, 191);
		contentPane.add(scrollPane);
		
		tblDetalle = new JTable();
		tblDetalle.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00D3DIGO", "NOMBRE", "PRECIO", "CANTIDAD", "IMPORTE"
			}
		));
		tblDetalle.getColumnModel().getColumn(0).setPreferredWidth(57);
		tblDetalle.getColumnModel().getColumn(1).setPreferredWidth(333);
		tblDetalle.getColumnModel().getColumn(3).setPreferredWidth(70);
		tblDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
		tblDetalle.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblDetalle);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(101, 109, 181, 20);
		contentPane.add(dcFecha);
		//
		dcFecha.setDateFormatString("yyyy-MM-dd");
		//
		dcFecha.setDate(new Date());
		
		btnNuevo = new JButton("");

		btnNuevo.setIcon(new ImageIcon(frmInternalBoleta.class.getResource("/iconos/Text.gif")));
		btnNuevo.setBounds(10, 577, 89, 46);
		contentPane.add(btnNuevo);
		
		
	}
	public void actionPerformed(ActionEvent e) {
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
}
