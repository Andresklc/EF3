package interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entidad.cliente;
import Model.ClienteModel;
import gui.frmInternalBoleta;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class frmConsultaClienteXApellidos extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tblCliente;
	private JTextField txtNombre;
	private JButton cancelButton;
	private JButton btnBuscar;
	private JButton okButton;
	private int idSeleccionado = -1;
	private JLabel lblApellido;
	private JTextField txtApellidos;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmConsultaClienteXApellidos dialog = new frmConsultaClienteXApellidos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmConsultaClienteXApellidos() {
		setBounds(100, 100, 776, 354);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 80, 740, 224);
			contentPanel.add(scrollPane);
			
			tblCliente = new JTable();
			tblCliente.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"C\u00D3DIGO", "NOMBRES","APELLIDOS", "DNI","DIRECCIÓN", "SEXO"
				}
			));
			tblCliente.getColumnModel().getColumn(0).setPreferredWidth(57);
			tblCliente.getColumnModel().getColumn(1).setPreferredWidth(179);
			tblCliente.getColumnModel().getColumn(2).setPreferredWidth(179);
			tblCliente.getColumnModel().getColumn(3).setPreferredWidth(88);
			tblCliente.getColumnModel().getColumn(2).setPreferredWidth(179);
			tblCliente.getColumnModel().getColumn(4).setPreferredWidth(98);
			tblCliente.setFillsViewportHeight(true);
			scrollPane.setViewportView(tblCliente);
			
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(76, 41, 233, 20);
			contentPanel.add(txtNombre);
			
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setBounds(10, 44, 59, 14);
			contentPanel.add(lblNombre);
			
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(this);
			btnBuscar.setBounds(629, 40, 121, 20);
			contentPanel.add(btnBuscar);
			
			lblApellido = new JLabel("Apellido");
			lblApellido.setBounds(333, 44, 59, 14);
			contentPanel.add(lblApellido);
			
			txtApellidos = new JTextField();
			txtApellidos.setBounds(391, 41, 228, 20);
			contentPanel.add(txtApellidos);
			txtApellidos.setColumns(10);
			listar();
		}
		
	}
	private void listar() {
		ClienteModel model=new ClienteModel();
		List<cliente> lstcliente=model.listaCliente();
		DefaultTableModel dtm = (DefaultTableModel) tblCliente.getModel();
		dtm.setRowCount(0);
		Object[] fila = null; 
		for (cliente x:lstcliente){
			fila = new Object[] {x.getCodigo(), x.getNombres(),x.getApellidos(),x.getDni(),x.getDireccion(),x.getSexo()};
			dtm.addRow(fila);
		}
		}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			actionPerformedOkButtonJButton(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscarJButton(e);
		}
		if (e.getSource() == cancelButton) {
			actionPerformedCancelButtonJButton(e);
		}
	}
	protected void actionPerformedCancelButtonJButton(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedBtnBuscarJButton(ActionEvent e) {
		
		String nombre=txtNombre.getText();
		String apellidos=txtApellidos.getText();
		
		ClienteModel model=new ClienteModel();
		List<cliente> lstcliente=model.listaporNombreApellido(nombre,apellidos);;
		DefaultTableModel dtm = (DefaultTableModel) tblCliente.getModel();
		dtm.setRowCount(0);
		Object[] fila = null; 
		for (cliente x:lstcliente){
			fila = new Object[] {x.getCodigo(), x.getNombres(),x.getApellidos(),x.getDni(),x.getDireccion(),x.getSexo()};
			dtm.addRow(fila);
		
		}
	}
	protected void actionPerformedOkButtonJButton(ActionEvent e) {
		int fila=tblCliente.getSelectedRow();
		idSeleccionado=(Integer)tblCliente.getValueAt(fila, 0);
		String nombre=(String)tblCliente.getValueAt(fila, 1);
		String apellido=(String)tblCliente.getValueAt(fila, 2);		
		String DNI=(String)tblCliente.getValueAt(fila, 3);
		String direccion=(String)tblCliente.getValueAt(fila, 4);
		String sexo=(String)tblCliente.getValueAt(fila, 5);



		
		System.out.println(idSeleccionado+" - "+nombre+" - "+nombre+" - "+apellido+" - "+DNI+" - "+direccion+" - "+sexo); 
		
		frmInternalBoleta.txtCodigoCliente.setText(String.valueOf(idSeleccionado));
		frmInternalBoleta.txtNombres.setText(nombre);
		frmInternalBoleta.txtApellido.setText(apellido);
		frmInternalBoleta.txtDireccion.setText(direccion);
		frmInternalBoleta.txtSexo.setText(sexo);
		frmInternalBoleta.txtDni.setText(DNI);


		 dispose();
	}
}
