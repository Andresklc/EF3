package gui;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entidad.cliente;
import Model.ClienteModel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;


import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;

public class frmConsultaClienteXApellidos  extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblCliente;
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmConsultaClienteXApellidos frame = new frmConsultaClienteXApellidos();
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
	public frmConsultaClienteXApellidos() {
		setBounds(100, 100, 776, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 740, 224);
		contentPane.add(scrollPane);
		
		tblCliente = new JTable();
		tblCliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00D3DIGO", "NOMBRES", "DNI", "SEXO"
			}
		));
		tblCliente.getColumnModel().getColumn(0).setPreferredWidth(57);
		tblCliente.getColumnModel().getColumn(1).setPreferredWidth(179);
		tblCliente.getColumnModel().getColumn(2).setPreferredWidth(88);
		tblCliente.getColumnModel().getColumn(3).setPreferredWidth(98);
		tblCliente.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCliente);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(76, 41, 674, 20);
		contentPane.add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 44, 59, 14);
		contentPane.add(lblNombre);
	
		listar();
	}
	
	
	public void actionPerformed(ActionEvent e) {
	}
	private void listar() {
		ClienteModel model=new ClienteModel();
		List<cliente> lstcliente=model.listaCliente();
		DefaultTableModel dtm = (DefaultTableModel) tblCliente.getModel();
		dtm.setRowCount(0);
		Object[] fila = null; 
		for (cliente x:lstcliente){
			fila = new Object[] {x.getCodigo(), x.getNombres(),x.getDni(),x.getSexo()};
			dtm.addRow(fila);
		}
		}
	}


