package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entidad.articulo;
import controlador.MySqlarticuloDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmConsultaArticuloXNombre extends JDialog implements KeyListener, ActionListener {
	
	
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JButton bnEnviar;
	private JTable tblConceptos;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmConsultaArticuloXNombre dialog = new frmConsultaArticuloXNombre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmConsultaArticuloXNombre() {
		setModal(true);
		setBounds(100, 100, 726, 364);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 37, 70, 14);
			contentPanel.add(lblNombre);
		}
		{
			txtNombre = new JTextField();
			txtNombre.addKeyListener(this);
			txtNombre.setBounds(76, 34, 511, 20);
			contentPanel.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			bnEnviar = new JButton("");
			bnEnviar.addActionListener(this);
			bnEnviar.setIcon(new ImageIcon(frmConsultaArticuloXNombre.class.getResource("/iconos/Add.gif")));
			bnEnviar.setBounds(611, 11, 89, 45);
			contentPanel.add(bnEnviar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 62, 680, 252);
			contentPanel.add(scrollPane);
			{
				tblConceptos = new JTable();
				tblConceptos.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"C\u00D3DIGO", "NOMBRE", "precio"
					}
				));
				tblConceptos.getColumnModel().getColumn(0).setPreferredWidth(57);
				tblConceptos.getColumnModel().getColumn(1).setPreferredWidth(489);
				tblConceptos.setFillsViewportHeight(true);
				scrollPane.setViewportView(tblConceptos);
			}
		}
	
		
	}

	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == txtNombre) {
			keyReleasedTxtNombre(arg0);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtNombre(KeyEvent arg0) {
		//leer caja
		String nom;
		nom=txtNombre.getText();
		//obtener modelo de la tabla tblConceptos
		DefaultTableModel model=(DefaultTableModel) tblConceptos.getModel();
		//limpiar filas del modelo
		model.setRowCount(0);
		//invocar al método listAllByNombre
		ArrayList<articulo> lista=new MySqlarticuloDAO().listAllByNombre(nom);
		//bucle
		for(articulo con:lista) {
			//arreglo de la clase Object
			Object[] row= {con.getCodigo(),con.getNombre(),con.getPrecio()};
			//
			model.addRow(row);
		}		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bnEnviar) {
			actionPerformedBnEnviar(e);
		}
	}
	protected void actionPerformedBnEnviar(ActionEvent e) {
		int row;
		String cod,nom,pre;
		row=tblConceptos.getSelectedRow();
		cod=tblConceptos.getValueAt(row, 0).toString();
		nom=tblConceptos.getValueAt(row, 1).toString();
		pre=tblConceptos.getValueAt(row, 2).toString();
		frmBoleta.txtCodigoArticulo.setText(cod);
		frmBoleta.txtNombreArticulo.setText(nom);
		frmBoleta.txtPrecio.setText(pre);
		dispose();
	}
	
	void mensaje(String m){
		JOptionPane.showMessageDialog(null,m);
	}
	
}
