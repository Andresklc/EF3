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

import gui.frmConsultaArticuloXNombre;
import gui.frmConsultaClienteXApellidos;
import gui.frmInternalBoleta;
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

	public frmInternalBoleta frmInternalBoleta = new frmInternalBoleta();
	private JMenuItem mntArticulo;
	public frmConsultaArticuloXNombre frmConsultaArticuloXNombre = new frmConsultaArticuloXNombre();
	private JMenuItem mntCliente;
	public frmConsultaClienteXApellidos frmConsultaClienteXApellidos = new frmConsultaClienteXApellidos();

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
		frmConsultaClienteXApellidos.setMaximizable(false);
		desktop.add(frmConsultaClienteXApellidos);
		frmConsultaArticuloXNombre.setBounds(116, 65, 726, 364);
		frmConsultaClienteXApellidos.getContentPane().add(frmConsultaArticuloXNombre);
		
		frmConsultaArticuloXNombre.setMaximizable(false);
		frmInternalBoleta.setBounds(-16, -15, 776, 672);
		frmConsultaClienteXApellidos.getContentPane().add(frmInternalBoleta);
		frmInternalBoleta.setTitle("Generador de Boleta");

			
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
		if (arg0.getSource() == mntCliente) {
			centrar(frmConsultaClienteXApellidos);
			frmConsultaClienteXApellidos.setVisible(true);
		}
		if (arg0.getSource() == mntArticulo) {
			centrar(frmConsultaArticuloXNombre);
			frmConsultaArticuloXNombre.setVisible(true);
		}
		if (arg0.getSource() == mntboleta) {
			centrar(frmInternalBoleta);
			frmInternalBoleta.setVisible(true);
		}
		//PC01 Registros
	
		
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
		frmConsultaArticuloXNombre frm=new frmConsultaArticuloXNombre();
		frm.setVisible(true);
	}
	protected void actionPerformedMntClienteJMenuItem(ActionEvent arg0) {
		frmConsultaClienteXApellidos frm=new frmConsultaClienteXApellidos();
		frm.setVisible(true);
	}
}