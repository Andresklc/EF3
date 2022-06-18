package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entidad.cliente;
import controlador.MySqlclienteDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmConsultaClienteXApellidos extends JDialog implements KeyListener, ActionListener {

	private JPanel contentPane;
	private JTextField txtApellidos;
	private JButton btnEnviar;
	private JTable tblCliente;

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
		setModal(true);
		setTitle("Buscar Lector");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 776, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 44, 72, 14);
		contentPane.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.addKeyListener(this);
		txtApellidos.setBounds(78, 41, 573, 20);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		btnEnviar = new JButton("");
		btnEnviar.addActionListener(this);
		btnEnviar.setIcon(new ImageIcon(frmConsultaClienteXApellidos.class.getResource("/iconos/Add.gif")));
		btnEnviar.setBounds(661, 22, 89, 52);
		contentPane.add(btnEnviar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 740, 224);
		contentPane.add(scrollPane);
		
		tblCliente = new JTable();
		tblCliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00D3DIGO", "NOMBRES", "APELLIDOS", "DNI", "sexo"
			}
		));
		tblCliente.getColumnModel().getColumn(0).setPreferredWidth(57);
		tblCliente.getColumnModel().getColumn(1).setPreferredWidth(179);
		tblCliente.getColumnModel().getColumn(2).setPreferredWidth(198);
		tblCliente.getColumnModel().getColumn(3).setPreferredWidth(88);
		tblCliente.getColumnModel().getColumn(4).setPreferredWidth(98);
		tblCliente.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCliente);
	
	}
		
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == txtApellidos) {
			keyReleasedTxtApellidos(arg0);
		}
	}
	public void keyTyped(KeyEvent arg0) {
	}
	protected void keyReleasedTxtApellidos(KeyEvent arg0) {
		//leer caja
		String apellido;
		apellido=txtApellidos.getText();
		//obtener modelo de la tabla tblLectores
		DefaultTableModel model=(DefaultTableModel) tblCliente.getModel();
		//limpiar filas del modelo
		model.setRowCount(0);
		//invocar al método listAllByApellido
		ArrayList<cliente> lista=new MySqlclienteDAO().listAllByApellido(apellido);
		//bucle
		for(cliente lec:lista) {
			//arreglo de la clase Object
			Object[] row= {lec.getCodigo(),lec.getNombres(),lec.getApellidos(),lec.getDni(),lec.getSexo()};
			//
			model.addRow(row);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviar) {
			actionPerformedBtnEnviar(e);
		}
	}
	protected void actionPerformedBtnEnviar(ActionEvent e) {
		//variables
		int posFila;
		String cod,nom,ape,dni,sexo;
		//fila seleccionada
		posFila=tblCliente.getSelectedRow();
		//valores de la fila seleccionada
		cod=tblCliente.getValueAt(posFila,0).toString();
		nom=tblCliente.getValueAt(posFila,1).toString();
		ape=tblCliente.getValueAt(posFila,2).toString();
		dni=tblCliente.getValueAt(posFila,3).toString();
		sexo=tblCliente.getValueAt(posFila,4).toString();
		//mostrar en las cajas
		frmBoleta.txtCodigoCliente.setText(cod);
		frmBoleta.txtNombres.setText(nom);
		frmBoleta.txtApellidos.setText(ape);
		frmBoleta.txtDni.setText(dni);
		frmBoleta.txtSexo.setText(sexo);
		dispose();
	}
	
	void mensaje(String m){
		JOptionPane.showMessageDialog(null,m);
	}
}
