package gui;


import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entidad.articulo;
import Model.ArticuloModel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class frmConsultaArticulo extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JButton bnEnviar;
	private JTable tblConceptos;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmConsultaArticulo frame = new frmConsultaArticulo();
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
	public frmConsultaArticulo() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
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
			txtNombre.setBounds(76, 34, 511, 20);
			contentPanel.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			bnEnviar = new JButton("");
			bnEnviar.addActionListener(this);
			bnEnviar.setIcon(new ImageIcon(frmConsultaArticulo.class.getResource("/iconos/Add.gif")));
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
	
		listar();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bnEnviar) {
			actionPerformedBnEnviarJButton(e);
		}
	}
	protected void actionPerformedBnEnviarJButton(ActionEvent e) {
		String nombre=txtNombre.getText();
		
		ArticuloModel model=new ArticuloModel();
		List<articulo> lstArticulo=model.listAllByNombre(nombre);
		DefaultTableModel dtm = (DefaultTableModel) tblConceptos.getModel();
		dtm.setRowCount(0);
		Object[] fila = null; 
		for (articulo x:lstArticulo){
			fila = new Object[] {x.getCodigo(), x.getNombre(),x.getPrecio()};
			dtm.addRow(fila);
		}
		
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
	}


