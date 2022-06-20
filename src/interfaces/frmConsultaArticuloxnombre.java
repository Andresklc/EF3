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
				JButton cancelButton = new JButton("Cancel");
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
				txtNombre.setBounds(79, 33, 598, 20);
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
		listar();
	}
	
	private void listar() {
		ArticuloModel model=new ArticuloModel();
		List<articulo> lstArticulo=model.listaArticulo();
		DefaultTableModel dtm = (DefaultTableModel) tblConceptos.getModel();
		dtm.setRowCount(0);
		Object[] fila = null; 
		for (articulo x:lstArticulo){
			fila = new Object[] {x.getCodigo(), x.getNombre(),x.getPrecio()};
			dtm.addRow(fila);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			actionPerformedOkButtonJButton(e);
		}
	}
	protected void actionPerformedOkButtonJButton(ActionEvent e) {
		
	}
}
