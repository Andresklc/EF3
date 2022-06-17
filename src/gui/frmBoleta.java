package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import controlador.MySqlBoletaDAO;
import Entidad.Boleta;
import Entidad.Detalle;
import Util.Libreria;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.EtchedBorder;

public class frmBoleta extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MySqlBoletaDAO boletaDAO=new MySqlBoletaDAO();

	private JPanel contentPane;
	private JLabel lblBoleta;
	public static JTextField txtCodigoCliente;
	public static JTextField txtNombres;
	public static JTextField txtApellidos;
	public static JTextField txtSexo;
	public static JTextField txtDni;
	private JButton btnBuscarLector;
	private JPanel panel_1;
	private JLabel label;
	public static  JTextField txtCodigoArticulo;
	public static  JTextField txtNombreArticulo;
	public static  JTextField txtPrecio;
	private JButton btnBuscarConcepto;
	private JLabel lblNombre;
	private JLabel lblPrecio;
	private JTextField txtCantidad;
	private JLabel lblCantidad;
	private JButton btnAdicionar;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmBoleta frame = new frmBoleta();
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
	public frmBoleta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		lblBoleta.setBounds(0, 22, 746, 47);
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
		txtCodigoCliente.setEditable(false);
		txtCodigoCliente.setBounds(88, 35, 178, 20);
		panel.add(txtCodigoCliente);
		txtCodigoCliente.setColumns(10);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(10, 74, 77, 14);
		panel.add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.setEditable(false);
		txtNombres.setBounds(88, 71, 276, 20);
		panel.add(txtNombres);
		txtNombres.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(372, 74, 77, 14);
		panel.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setEditable(false);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(430, 71, 296, 20);
		panel.add(txtApellidos);
		
		btnBuscarLector = new JButton("");
		btnBuscarLector.addActionListener(this);
		btnBuscarLector.setIcon(new ImageIcon(frmBoleta.class.getResource("/iconos/busca.png")));
		btnBuscarLector.setBounds(275, 11, 89, 46);
		panel.add(btnBuscarLector);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(540, 38, 55, 14);
		panel.add(lblSexo);
		
		txtSexo = new JTextField();
		txtSexo.setEditable(false);
		txtSexo.setColumns(10);
		txtSexo.setBounds(605, 38, 121, 20);
		panel.add(txtSexo);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(372, 41, 55, 14);
		panel.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		txtDni.setColumns(10);
		txtDni.setBounds(430, 38, 100, 20);
		panel.add(txtDni);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos del Articulo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 277, 736, 90);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		label = new JLabel("C\u00F3digo:");
		label.setBounds(10, 27, 46, 14);
		panel_1.add(label);
		
		txtCodigoArticulo = new JTextField();
		txtCodigoArticulo.setColumns(10);
		txtCodigoArticulo.setBounds(88, 24, 178, 20);
		panel_1.add(txtCodigoArticulo);
		
		btnBuscarConcepto = new JButton("");
		btnBuscarConcepto.addActionListener(this);
		btnBuscarConcepto.setIcon(new ImageIcon(frmBoleta.class.getResource("/iconos/busca.png")));
		btnBuscarConcepto.setBounds(275, 11, 89, 46);
		panel_1.add(btnBuscarConcepto);
		
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
		
		btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setIcon(new ImageIcon(frmBoleta.class.getResource("/iconos/add.png")));
		btnAdicionar.setBounds(374, 11, 89, 46);
		panel_1.add(btnAdicionar);
		
		btnEliminar = new JButton("");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(frmBoleta.class.getResource("/iconos/cerrar.png")));
		btnEliminar.setBounds(473, 11, 89, 46);
		panel_1.add(btnEliminar);

		
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
		btnGrabar.addActionListener(this);
		btnGrabar.setIcon(new ImageIcon(frmBoleta.class.getResource("/iconos/save.png")));
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
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(frmBoleta.class.getResource("/iconos/copy.png")));
		btnNuevo.setBounds(10, 577, 89, 46);
		contentPane.add(btnNuevo);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			actionPerformedButton(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
		if (arg0.getSource() == btnBuscarConcepto) {
			actionPerformedBtnBuscarConcepto(arg0);
		}
		if (arg0.getSource() == btnBuscarLector) {
			actionPerformedBtnBuscarLector(arg0);
		}
	}
	protected void actionPerformedBtnBuscarLector(ActionEvent arg0) {
		frmConsultaClienteXApellidos frm=new frmConsultaClienteXApellidos();
		frm.setVisible(true);
	}
	protected void actionPerformedBtnBuscarConcepto(ActionEvent arg0) {
		frmConsultaArticuloXNombre frm=new frmConsultaArticuloXNombre();
		frm.setVisible(true);
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		/*
		//variables
		int cod,can;
		String nom;
		double pre;
		//leer
		cod=Integer.parseInt(txtCodigoConcepto.getText());
		nom=txtNombreConcepto.getText();
		can=Integer.parseInt(txtCantidad.getText());
		pre=Double.parseDouble(txtPrecio.getText());
		//obtener modelo de la tabla tblDetalle
		DefaultTableModel model=(DefaultTableModel) tblDetalle.getModel();
		//arreglo de la clase Object con los valores de las variables
		Object row[]= {cod,nom,pre,can,(pre*can)};
		//enviar row dentro de model como fila
		model.addRow(row);
		//
		sumaImportes();
		*/
		int cod, can;
		String nom;
		double pre;
		// Leer
		cod = Integer.parseInt(txtCodigoArticulo.getText());
		nom = txtNombreArticulo.getText();
		can = Integer.parseInt(txtCantidad.getText());
		pre = Double.parseDouble(txtPrecio.getText());
		for (int i = 0; i < tblDetalle.getRowCount(); i++) {
			if (cod == Integer.parseInt(tblDetalle.getValueAt(i, 0).toString())) {
				JOptionPane.showMessageDialog(null, "No se admiten duplicados");
				return;
			}
		}
		DefaultTableModel modelo = (DefaultTableModel) tblDetalle.getModel();
		// Arreglo
		Object row[] = {cod, nom, pre, can, pre*can};
		// Enviar row dentro del model como fila
		modelo.addRow(row);
		//
		sumaImportes();
		
	}

	
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		//obtener posición de la fila seleccionada
		int posFila;
		posFila=tblDetalle.getSelectedRow();
		//obtener modelo de la tabla tblDetalle
		DefaultTableModel model=(DefaultTableModel) tblDetalle.getModel();
		//eliminar del objeto "model" la posición de la fila seleccionada
		model.removeRow(posFila);
		//
		sumaImportes();
	}
	
	//método para sumar la columna importe
	void sumaImportes() {
		//acumulador
		double suma=0;
		//bucle para realizar recorrido sobre la tabla tblDetalle
		for(int i=0;i<tblDetalle.getRowCount();i++)
			suma+=Double.parseDouble(tblDetalle.getValueAt(i, 4).toString());
		
		txtTotal.setText(suma+"");
	}
	protected void actionPerformedButton(ActionEvent arg0) {
		//crear objeto de la clase Boleta
		Boleta bol=new Boleta();
		//setear atributos de bol
		bol.setNumeroBoleta(getNumero());
		bol.setCodigoLector(getCodigoLector());
		bol.setFecha(getFecha());
		bol.setTotal(getTotal());
		bol.setCodigoUsuario(Libreria.codigoUsuario);
		
		//arreglo de objetos de la clase Detalle
		ArrayList<Detalle> data=new ArrayList<Detalle>();
		//bucle para realizar recorrido sobre la tabla "tblDetalle"
		for(int i=0;i<tblDetalle.getRowCount();i++) {
			//crear objeto de la clase Detalle
			Detalle d=new Detalle();
			//setear atributos del objeto "d" según los datos de la fila actual
			d.setCodigoConcepto(Integer.parseInt(tblDetalle.getValueAt(i, 0).toString()));
			d.setPrecio(Double.parseDouble(tblDetalle.getValueAt(i, 2).toString()));
			d.setCantidad(Integer.parseInt(tblDetalle.getValueAt(i, 3).toString()));
			//adicionar objeto "d" dentro del arreglo "data"
			data.add(d);
		}
		//invocar al método save
		int resu=boletaDAO.save(bol, data);
		//
		if(resu>0) {
			mensaje("Boleta registrada");
			limpieza();
		}
		else
			mensaje("Error en el registro de boleta");
	}
	
	//
	int getNumero() {
		return Integer.parseInt(txtNumero.getText());
	}
	String getCodigoLector() {
		return txtCodigoCliente.getText();
	}
	LocalDate getFecha() {
		return LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dcFecha.getDate()));
	}
	double getTotal() {
		return Double.parseDouble(txtTotal.getText());
	}
	void mensaje(String m) {
		JOptionPane.showMessageDialog(null, m);
	}
	void limpieza() {
		txtCodigoCliente.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtSexo.setText("");
		txtDni.setText("");
		txtCodigoArticulo.setText("");
		txtNombreArticulo.setText("");
		txtPrecio.setText("0");
		txtTotal.setText("0");
		txtNumero.setText("0");
		dcFecha.setDate(new Date());
		DefaultTableModel model=(DefaultTableModel) tblDetalle.getModel();
		model.setRowCount(0);
	}
	protected void actionPerformedBtnNuevo(ActionEvent arg0) {
		limpieza();
		txtNumero.setText(Libreria.numeroBoleta()+"");
	}
}





