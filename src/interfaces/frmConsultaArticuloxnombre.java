package interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entidad.articulo;
import Model.ArticuloModel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.util.List;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmConsultaArticuloxnombre extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTable tblConceptos;
	private JScrollPane scrollPane;
	private JButton okButton;
	private int idSeleccionado = -1;
	private JButton cancelButton;
	private JButton btnBuscar;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmConsultaArticuloxnombre dialog = new frmConsultaArticuloxnombre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmConsultaArticuloxnombre() {
		setBounds(100, 100, 726, 364);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.activeCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
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
			contentPanel.setLayout(null);
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(28, 36, 41, 14);
				contentPanel.add(lblNombre);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setBounds(79, 33, 486, 20);
				contentPanel.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(28, 64, 649, 188);
				contentPanel.add(scrollPane);
				{
					tblConceptos = new JTable();
					tblConceptos.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"ID", "CATEGORIA", "NOMBRE","PROVEEDOR","CANTIDAD","PRECIO"
						}
					));
					tblConceptos.getColumnModel().getColumn(0).setPreferredWidth(20);
					tblConceptos.getColumnModel().getColumn(1).setPreferredWidth(60);
					tblConceptos.getColumnModel().getColumn(2).setPreferredWidth(60);
					tblConceptos.getColumnModel().getColumn(3).setPreferredWidth(90);
					tblConceptos.getColumnModel().getColumn(4).setPreferredWidth(60);
					tblConceptos.getColumnModel().getColumn(5).setPreferredWidth(60);
				
					
					tblConceptos.setFillsViewportHeight(true);
					scrollPane.setViewportView(tblConceptos);
				}
			}
		}
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(588, 32, 89, 23);
		contentPanel.add(btnBuscar);
		listar();
	}
	
	private void listar() {
		ArticuloModel model=new ArticuloModel();
		List<articulo> lstArticulo=model.listaArticulo();
		DefaultTableModel dtm = (DefaultTableModel) tblConceptos.getModel();
		dtm.setRowCount(0);
		Object[] fila = null; 
		for (articulo x:lstArticulo){
			fila = new Object[] {x.getCodArt(),x.getNomCat(), x.getNombArt(),x.getNombre(),x.getCantidad(),x.getPrecio()};
			dtm.addRow(fila);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscarJButton(e);
		}
		if (e.getSource() == cancelButton) {
			actionPerformedCancelButtonJButton(e);
		}
		if (e.getSource() == okButton) {
			actionPerformedOkButtonJButton(e);
		}
	}
	protected void actionPerformedOkButtonJButton(ActionEvent e) {
		int fila=tblConceptos.getSelectedRow();
		idSeleccionado=(Integer)tblConceptos.getValueAt(fila, 0);
		String categoria=(String)tblConceptos.getValueAt(fila, 1);
		String nombre=(String)tblConceptos.getValueAt(fila, 2);
		String proveedor=(String)tblConceptos.getValueAt(fila, 3);
		int cantidad=(Integer)tblConceptos.getValueAt(fila, 4);
		double precioU=(Double)tblConceptos.getValueAt(fila, 5);


		
		System.out.println(idSeleccionado+" - "+categoria+" - "+nombre+" - "+proveedor+" - "+cantidad+" - "+precioU); 
		
		new articulo(proveedor, proveedor, idSeleccionado, proveedor, cantidad, precioU);


		 dispose();

	}
	protected void actionPerformedCancelButtonJButton(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedBtnBuscarJButton(ActionEvent e) {
	String nombre=txtNombre.getText();
		
		ArticuloModel model=new ArticuloModel();
		List<articulo> lstArticulo=model.listAllByNombre(nombre);
		DefaultTableModel dtm = (DefaultTableModel) tblConceptos.getModel();
		dtm.setRowCount(0);
		Object[] fila = null; 
		for (articulo x:lstArticulo){
			fila = new Object[] {x.getCodArt(),x.getNomCat(), x.getNombArt(),x.getNombre(),x.getCantidad(),x.getPrecio()};
			dtm.addRow(fila);
		
		}
	}
}
