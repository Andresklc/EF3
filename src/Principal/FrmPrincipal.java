package Principal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import gui.CrudCliente;
import gui.CrudUsuario;
import gui.frmActualizarCliente;
import gui.frmConsultaArticulo;
import gui.frmConsultaCliente;
import gui.frmInternalBoleta;
import gui.frmRegistroCliente;
import gui.frmSistema;

import java.awt.SystemColor;

@SuppressWarnings("serial")
public class FrmPrincipal extends JFrame implements WindowListener, ActionListener {

	private JDesktopPane desktop = new JDesktopPane();

	// Paso 1: Agregar el formulario

	// Adminsitrativa
	private List<JMenuItem> listaItemMenus = new ArrayList<JMenuItem>();
	private List<JMenu> listaMenus = new ArrayList<JMenu>();

	
	// Agrega el item de menu

	private JMenuItem mntboleta;
	private JMenuItem mntArticulo;
	private JMenuItem mntCliente;
	public frmConsultaCliente frmConsultaCliente = new frmConsultaCliente();
	public frmConsultaArticulo frmConsultaArticulo = new frmConsultaArticulo();
	public frmInternalBoleta frmInternalBoleta = new frmInternalBoleta();
	public frmRegistroCliente frmRegistroCliente=new frmRegistroCliente();
	private JMenuItem mntFormularioCliente;
	private JMenuItem mntmActualizarCliente;
	public frmActualizarCliente frmActualizarCliente=new frmActualizarCliente();
	public frmSistema frmSistema=new frmSistema();
	public CrudCliente CrudCliente=new CrudCliente();
	public CrudUsuario CrudUsuario=new CrudUsuario();
	private JMenuItem mntCrudClientes;
	private JMenuItem mntCrudUsuario;

	private JMenuItem mntInfo;


	// Formularios
	

	public FrmPrincipal(String cad, int x, int y) {
		super(cad);
		this.setLocation(0, 0);
		this.setSize(636, 365);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);

		desktop.setSize(1000, 500);
		desktop.setBackground(SystemColor.activeCaption);

		getContentPane().add(desktop, BorderLayout.CENTER);

		addWindowListener(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

			
		JMenu mnProcesos = new JMenu("Procesos");
		menuBar.add(mnProcesos);
		
		mntboleta = new JMenuItem("Boleta");
		mntboleta.setVisible(true);
		mntboleta.addActionListener(this);
		mnProcesos.add(mntboleta);
		
		listaMenus.add(mnProcesos);
		
		listaItemMenus.add(mntboleta);
		
		JMenu mnFormularios = new JMenu("Formulario");
		menuBar.add(mnFormularios);
		
		mntFormularioCliente = new JMenuItem("Inscripcion Cliente");
		mntFormularioCliente.addActionListener(this);
		mnFormularios.add(mntFormularioCliente);
		
		mntmActualizarCliente = new JMenuItem("Actualizar Cliente");
		mntmActualizarCliente.addActionListener(this);
		mnFormularios.add(mntmActualizarCliente);
		
		JMenu mnCrud = new JMenu("Mantenimiento");
		menuBar.add(mnCrud);
		
		mntCrudUsuario = new JMenuItem("Usuarios");
		mntCrudUsuario.addActionListener(this);
		mnCrud.add(mntCrudUsuario);
		
		mntCrudClientes = new JMenuItem("Clientes");
		mntCrudClientes.addActionListener(this);
		mnCrud.add(mntCrudClientes);
		
		
		
		JMenu mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		mntArticulo = new JMenuItem("Articulo");
		mntArticulo.setVisible(true);
		mntArticulo.addActionListener(this);
		mnConsulta.add(mntArticulo);
		
		listaMenus.add(mnConsulta);
		
		listaItemMenus.add(mntArticulo);
		
		mntCliente = new JMenuItem("Cliente");
		mntCliente.setVisible(true);
		mntCliente.addActionListener(this);
		mnConsulta.add(mntCliente);
		
		JMenu mnSistema = new JMenu("Sistema");
		menuBar.add(mnSistema);
		
		mntInfo = new JMenuItem("Informacion del Sistema");
		mntInfo.addActionListener(this);
		mnSistema.add(mntInfo);
		
		frmConsultaCliente.setLocation(111, 171);
		frmConsultaCliente.setMaximizable(false);
		
		desktop.add(frmConsultaCliente);
		
		
		frmInternalBoleta.setTitle("Generador de Boleta");
		frmInternalBoleta.setLocation(204, 54);
		frmInternalBoleta.setMaximizable(false);
		
		desktop.add(frmInternalBoleta);
		

		frmConsultaArticulo.setMaximizable(false);
		frmConsultaArticulo.setLocation(350, 234);

		desktop.add(frmConsultaArticulo);
		
		
		frmRegistroCliente.setMaximizable(false);
		frmRegistroCliente.setLocation(350, 234);
		desktop.add(frmRegistroCliente);
		
		frmActualizarCliente.setMaximizable(false);
		frmActualizarCliente.setLocation(350, 234);
		desktop.add(frmActualizarCliente);
		
		frmSistema.setMaximizable(false);
		frmSistema.setLocation(350, 234);
		desktop.add(frmSistema);
			

		CrudCliente.setMaximizable(false);
		CrudCliente.setLocation(350, 234);
		desktop.add(CrudCliente);
		
		CrudUsuario.setMaximizable(false);
		CrudUsuario.setLocation(350, 234);
		desktop.add(CrudUsuario);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");

			FrmPrincipal jf = new FrmPrincipal("Sistema de Venta de Ropa", 900, 600);
			jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			jf.setVisible(false);

			FrmLogin frm = new FrmLogin(jf);
			frm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			frm.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
		int n = JOptionPane.showConfirmDialog(e.getWindow(), "¿Desea cerrar la aplicación?", "Confirmación",
				JOptionPane.YES_NO_OPTION);
		if (n == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == mntCrudUsuario) {
			centrar(CrudUsuario);
			CrudUsuario.setVisible(true);
			
		}
		if (arg0.getSource() == mntCrudClientes) {
			centrar(CrudCliente);
			CrudCliente.setVisible(true);
		}
		if (arg0.getSource() == mntInfo) {
			centrar(frmSistema);
			frmSistema.setVisible(true);

		}
		if (arg0.getSource() == mntmActualizarCliente) {
			centrar(frmActualizarCliente);
			frmActualizarCliente.setVisible(true);
		}
		if (arg0.getSource() == mntFormularioCliente) {
			centrar(frmRegistroCliente);
			frmRegistroCliente.setVisible(true);
		}
		if (arg0.getSource() == mntCliente) {
			centrar(frmConsultaCliente);
			frmConsultaCliente.setVisible(true);
		}
		if (arg0.getSource() == mntArticulo) {
			centrar(frmConsultaArticulo);
			frmConsultaArticulo.setVisible(true);
		}
		if (arg0.getSource() == mntboleta) {
			centrar(frmInternalBoleta);
			frmInternalBoleta.setVisible(true);
		}
	}
	
		
	



	public void centrar(JInternalFrame frm) {
		// Dimensiones de la pantalla
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		// Dimensiones del formulario
		Dimension ventana = frm.getSize();

		int posX = (int) (pantalla.getWidth() - ventana.getWidth()) / 2;
		frm.setLocation(posX, 40);
		
	}
	protected void actionPerformedMnboleta(ActionEvent arg0) {
		frmInternalBoleta frm=new frmInternalBoleta();
		frm.setVisible(true);
	}
	protected void actionPerformedMntArticuloJMenuItem(ActionEvent arg0) {
		frmConsultaArticulo frm=new frmConsultaArticulo();
		frm.setVisible(true);
	}
	protected void actionPerformedMntClienteJMenuItem(ActionEvent arg0) {
		frmConsultaCliente frm=new frmConsultaCliente();
		frm.setVisible(true);
	}
	protected void actionPerformedMntFormularioClienteJMenuItem(ActionEvent arg0) {
		frmRegistroCliente frm=new frmRegistroCliente();
		frm.setVisible(true);
	}
	protected void actionPerformedMntmActualizarClienteJMenuItem(ActionEvent arg0) {
		frmActualizarCliente frm=new frmActualizarCliente();
		frm.setVisible(true);
	}

	protected void actionPerformedMntCrudClientesJMenuItem(ActionEvent arg0) {
		CrudCliente frm=new CrudCliente();
		frm.setVisible(true);
	}
	protected void actionPerformedMntCrudUsuarioJMenuItem(ActionEvent arg0) {
		CrudUsuario frm=new CrudUsuario();
		frm.setVisible(true);
	}

	protected void actionPerformedMntInfoJMenuItem(ActionEvent arg0) {
		frmSistema frm=new frmSistema();
		frm.setVisible(true);

	}
}