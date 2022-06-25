package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Point;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmSistema extends JInternalFrame implements ActionListener {
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmSistema frame = new frmSistema();
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
	public frmSistema() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Informaci\u00F3n del Sistema");
		setBounds(100, 100, 581, 322);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Informaci\u00F3n del Sistema");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(10, 21, 545, 35);
		getContentPane().add(lblNewLabel);
		
		JTextArea txtrAplicacinHechaEn = new JTextArea();
		txtrAplicacinHechaEn.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtrAplicacinHechaEn.setText("Aplicaci\u00F3n hecha en Java que permite organizar y agilizar el proceso \r\nde venta de productos de la tienda.Ademas esta aplicaci\u00F3n tiene \r\ncomo finalidad lograr que los pedidos de los productos se entreguen \r\nen los plazos fijados y en las cantidades solicitadas.\r\nPremite tener un seguimiento de los productos,su stock,precio y \r\ncalidad.En consecuencia, las ganancias por parte del usuario\r\naumentaran en un 100%.");
		txtrAplicacinHechaEn.setBounds(10, 67, 545, 166);
		getContentPane().add(txtrAplicacinHechaEn);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalir.setBounds(234, 253, 89, 23);
		getContentPane().add(btnSalir);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalirJButton(e);
		}
	}
	protected void actionPerformedBtnSalirJButton(ActionEvent e) {
		dispose();
	}
}
