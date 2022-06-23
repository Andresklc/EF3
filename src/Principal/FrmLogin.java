package Principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import Entidad.Usuario;
import Model.UsuarioModel;
import Util.DatosGlobales;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class FrmLogin extends JDialog implements ActionListener {

	public JLabel lblLogin, lblClave;
	public JTextField txtLogin;
	public JPasswordField txtClave;
	public JButton btnEnviar, btnLimpiar;
	private UsuarioModel model = new UsuarioModel();

	public FrmPrincipal frm;
	private JLabel lblIcon;

	//
	public FrmLogin(FrmPrincipal frm) {
		getContentPane().setBackground(new Color(0, 128, 128));
		this.frm = frm;

		getContentPane().setLayout(null);
		this.setSize(534, 639);
		this.setLocationRelativeTo(null);
		this.setTitle("Sistema de Venta de Ropa");
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(new Color(102, 153, 102));
		panelLogin.setBounds(33, 313, 454, 279);
		getContentPane().add(panelLogin);
		panelLogin.setLayout(null);
		
				btnEnviar = new JButton("Enviar");
				btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnEnviar.setBounds(73, 170, 300, 40);
				panelLogin.add(btnEnviar);
				btnEnviar.setBackground(SystemColor.activeCaption);
				
						btnLimpiar = new JButton("Limpiar");
						btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 15));
						btnLimpiar.setBounds(172, 220, 100, 38);
						panelLogin.add(btnLimpiar);
						btnLimpiar.setBackground(SystemColor.activeCaption);
						
								lblLogin = new JLabel("Username:");
								lblLogin.setBounds(38, 32, 100, 25);
								panelLogin.add(lblLogin);
								lblLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
								lblLogin.setForeground(Color.BLACK);
								
										txtLogin = new JTextField("luis");
										txtLogin.setForeground(SystemColor.desktop);
										txtLogin.setBounds(142, 60, 144, 32);
										panelLogin.add(txtLogin);
										txtLogin.setBackground(SystemColor.scrollbar);
										
												lblClave = new JLabel("Password:");
												lblClave.setBounds(38, 91, 100, 25);
												panelLogin.add(lblClave);
												lblClave.setFont(new Font("Tahoma", Font.BOLD, 12));
												lblClave.setForeground(Color.BLACK);
												
														txtClave = new JPasswordField("luis");
														txtClave.setBounds(142, 117, 144, 32);
														panelLogin.add(txtClave);
														txtClave.setBackground(SystemColor.scrollbar);
														
														lblIcon = new JLabel("");
														lblIcon.setIcon(new ImageIcon(FrmLogin.class.getResource("/iconos/pngegg1.2.png")));
														lblIcon.setIconTextGap(6);
														lblIcon.setBounds(104, 10, 300, 300);
														getContentPane().add(lblIcon);
														txtClave.addActionListener(this);
										txtLogin.addActionListener(this);
						btnLimpiar.addActionListener(this);
				btnEnviar.addActionListener(this);

		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviar || e.getSource() == txtLogin || e.getSource() == txtClave) {

			String login = txtLogin.getText().trim();
			String clave = new String(txtClave.getPassword());

			Usuario bean = model.valida(login, clave);

			if (bean != null) {
				
				DatosGlobales.ID_USUARIO = bean.getIdUsuario();
				frm.setVisible(true);
				this.setVisible(false);

			} else {
				JOptionPane.showMessageDialog(this, "Usuario no valido");
			}

		}
		if (e.getSource() == btnLimpiar) {
			txtLogin.setText("");
			txtClave.setText("");
			txtLogin.requestFocus();
		}

		
		
	}

	public void windowDeactivated(WindowEvent e) {
	}
}
