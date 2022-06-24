package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import Entidad.cliente;
import Model.ClienteModel;
import Util.Validaciones;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class frmRegistroCliente extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtDireccion;
	private JLabel lblDireccin;
	private JLabel lblDireccin_1;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFemenino;
	private final JButton btnRegistrar = new JButton("Ingresar Cliente");
	private final JLabel lblNewLabel_1 = new JLabel("Inscripci\u00F3n de Clientes");
	private ButtonGroup grupo1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmRegistroCliente frame = new frmRegistroCliente();
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
	public frmRegistroCliente() {
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Inscripcion de Clientes");
		setBounds(100, 100, 367, 323);
		getContentPane().setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(98, 87, 194, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(43, 90, 86, 14);
		getContentPane().add(lblNewLabel);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(98, 118, 194, 20);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(98, 149, 194, 20);
		getContentPane().add(txtDni);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(43, 121, 86, 14);
		getContentPane().add(lblApellidos);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(43, 152, 86, 14);
		getContentPane().add(lblDni);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(98, 180, 194, 20);
		getContentPane().add(txtDireccion);
		
		lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(43, 183, 86, 14);
		getContentPane().add(lblDireccin);
		
		lblDireccin_1 = new JLabel("Genero:");
		lblDireccin_1.setBounds(43, 211, 86, 14);
		getContentPane().add(lblDireccin_1);
		
		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(98, 207, 109, 23);
		getContentPane().add(rdbtnMasculino);
		
		rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setBounds(98, 232, 109, 23);
		
		grupo1 = new ButtonGroup();
		grupo1.add(rdbtnFemenino);
		grupo1.add(rdbtnMasculino);
		
		
		getContentPane().add(rdbtnFemenino);
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(98, 262, 155, 20);
		getContentPane().add(btnRegistrar);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(-72, 11, 476, 60);
		getContentPane().add(lblNewLabel_1);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrarJButton(e);
		}
	}
	protected void actionPerformedBtnRegistrarJButton(ActionEvent e) {
		String nom=txtNombre.getText();
		String ape=txtApellido.getText();
		String dni=txtDni.getText();
		String dir=txtDireccion.getText();
		String sex="";
		if(rdbtnMasculino.isSelected()==true) {
		sex="M";}else if(rdbtnFemenino.isSelected()==true){sex="F";}else {mensaje("Selecciona tu genero");}
		
		if(!nom.matches(Validaciones.TEXTO)) {
			mensaje("El Nombre es de 2 a 20 Caracteres");
		}else if(!ape.matches(Validaciones.TEXTO)) {
			mensaje("El Apellido es de 2 a 20 Caracteres");
		}else if(!dni.matches(Validaciones.DNI)) {
			mensaje("El DNI debe tener 8 digitos");
		}else if(!dir.matches(Validaciones.DIRECCION)) {
			mensaje("La direccion contiene de 2 a 30 caracteres ");
		}else {
			cliente obj=new cliente();
			obj.setNombres(nom);
			obj.setApellidos(ape);
			obj.setDni(dni);
			obj.setDireccion(dir);
			obj.setSexo(sex);

			
			ClienteModel model=new ClienteModel();
			int salida=model.insertaCliente(obj);
			if(salida>0) {
				mensaje("Registro Exitoso");
			}else {
				mensaje("Error en el Registro");
			}

			txtNombre.setText("");
			txtApellido.setText("");
			txtDireccion.setText("");
			 grupo1.clearSelection();
			txtDni.setText("");
			
		}
	}
	public void mensaje(String ms){
		JOptionPane.showMessageDialog(this, ms);
	}
}
