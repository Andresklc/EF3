package Principal;

import java.awt.BorderLayout;
import java.awt.Color;
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

import Model.UsuarioModel;

@SuppressWarnings("serial")
public class FrmPrincipal extends JFrame implements WindowListener, ActionListener {

	private JDesktopPane desktop = new JDesktopPane();

	// Paso 1: Agregar el formulario

	// Adminsitrativa
	private List<JMenuItem> listaItemMenus = new ArrayList<JMenuItem>();
	private List<JMenu> listaMenus = new ArrayList<JMenu>();
	private UsuarioModel model = new UsuarioModel();

	// Agrega el item de menu
	private JMenuItem mntRegAlumno;
	private JMenuItem mntRegAutor;
	private JMenuItem mntRegLibro;
	private JMenuItem mntRegSala;
	private JMenuItem mntRegUsuario;
	private JMenuItem mntRegProveedor;
	
	private JMenuItem mntCrudAlumno;
	private JMenuItem mntCrudAutor;
	private JMenuItem mntCrudLibro;
	private JMenuItem mntCrudSala;
	private JMenuItem mntCrudUsuario;
	private JMenuItem mntCrudProveedor;
	
	private JMenuItem mntConsultaAlumno;
	private JMenuItem mntConsultaAutor;
	private JMenuItem mntConsultaLibro;
	private JMenuItem mntConsultaSala;
	private JMenuItem mntConsultaUsuario;
	private JMenuItem mntConsultaProveedor;
	
	private JMenuItem mntReporteAlumno;
	private JMenuItem mntReporteAutor;
	private JMenuItem mntReporteLibro;
	private JMenuItem mntReporteSala;
	private JMenuItem mntReporteUsuario;
	private JMenuItem mntReporteProveedor;

	// Formularios
	

	public FrmPrincipal(String cad, int x, int y) {
		super(cad);
		this.setLocation(0, 0);
		this.setSize(636, 365);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);

		desktop.setSize(1000, 500);
		desktop.setBackground(new Color(44, 62, 80));

		getContentPane().add(desktop, BorderLayout.CENTER);

		addWindowListener(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnAdministracin = new JMenu("Registros (PC1)");
		mnAdministracin.setVisible(false);
		menuBar.add(mnAdministracin);

		JMenu mnCrud = new JMenu("Crud (PC02)");
		mnCrud.setVisible(false);
		menuBar.add(mnCrud);

		JMenu mnConsultas = new JMenu("Consulta (PC03)");
		mnConsultas.setVisible(false);
		menuBar.add(mnConsultas);

		JMenu mnReporte = new JMenu("Reporte (PC03)");
		mnReporte.setVisible(false);
		menuBar.add(mnReporte);

		// pc01
		mntRegAlumno = new JMenuItem("Registro de Alumno");
		mntRegAlumno.setVisible(false);
		mntRegAlumno.addActionListener(this);
		mnAdministracin.add(mntRegAlumno);

		mntRegAutor = new JMenuItem("Registro de Autor");
		mntRegAutor.setVisible(false);
		mntRegAutor.addActionListener(this);
		mnAdministracin.add(mntRegAutor);

		mntRegLibro = new JMenuItem("Registro de Libro");
		mntRegLibro.setVisible(false);
		mntRegLibro.addActionListener(this);
		mnAdministracin.add(mntRegLibro);

		mntRegSala = new JMenuItem("Registro de Sala");
		mntRegSala.setVisible(false);
		mntRegSala.addActionListener(this);
		mnAdministracin.add(mntRegSala);

		mntRegUsuario = new JMenuItem("Registro de Usuario");
		mntRegUsuario.setVisible(false);
		mntRegUsuario.addActionListener(this);
		mnAdministracin.add(mntRegUsuario);

		mntRegUsuario = new JMenuItem("Registro de Usuario");
		mntRegUsuario.setVisible(false);
		mntRegUsuario.addActionListener(this);
		mnAdministracin.add(mntRegUsuario);

		mntRegProveedor = new JMenuItem("Registro de Proveedor");
		mntRegProveedor.setVisible(false);
		mntRegProveedor.addActionListener(this);
		mnAdministracin.add(mntRegProveedor);		
		
		// pc02
		mntCrudAlumno = new JMenuItem("Crud Alumno");
		mntCrudAlumno.setVisible(false);
		mntCrudAlumno.addActionListener(this);
		mnCrud.add(mntCrudAlumno);

		mntCrudAutor = new JMenuItem("Crud Autor");
		mntCrudAutor.setVisible(false);
		mntCrudAutor.addActionListener(this);
		mnCrud.add(mntCrudAutor);

		mntCrudLibro = new JMenuItem("Crud Libro");
		mntCrudLibro.setVisible(false);
		mntCrudLibro.addActionListener(this);
		mnCrud.add(mntCrudLibro);

		mntCrudSala = new JMenuItem("Crud Sala");
		mntCrudSala.setVisible(false);
		mntCrudSala.addActionListener(this);
		mnCrud.add(mntCrudSala);

		mntCrudUsuario = new JMenuItem("Crud Usuario");
		mntCrudUsuario.setVisible(false);
		mntCrudUsuario.addActionListener(this);
		mnCrud.add(mntCrudUsuario);


		mntCrudProveedor = new JMenuItem("Crud Proveedor");
		mntCrudProveedor.setVisible(false);
		mntCrudProveedor.addActionListener(this);
		mnCrud.add(mntCrudProveedor);
		
		// pc03
		mntConsultaAlumno = new JMenuItem("Consulta Alumno");
		mntConsultaAlumno.setVisible(false);
		mntConsultaAlumno.addActionListener(this);
		mnConsultas.add(mntConsultaAlumno);

		mntConsultaAutor = new JMenuItem("Consulta Autor");
		mntConsultaAutor.setVisible(false);
		mntConsultaAutor.addActionListener(this);
		mnConsultas.add(mntConsultaAutor);

		mntConsultaLibro = new JMenuItem("Consulta Libro");
		mntConsultaLibro.setVisible(false);
		mntConsultaLibro.addActionListener(this);
		mnConsultas.add(mntConsultaLibro);

		mntConsultaSala = new JMenuItem("Consulta Sala");
		mntConsultaSala.setVisible(false);
		mntConsultaSala.addActionListener(this);
		mnConsultas.add(mntConsultaSala);

		mntConsultaUsuario = new JMenuItem("Consulta Usuario");
		mntConsultaUsuario.setVisible(false);
		mntConsultaUsuario.addActionListener(this);
		mnConsultas.add(mntConsultaUsuario);
		
		mntConsultaProveedor = new JMenuItem("Consulta Proveedor");
		mntConsultaProveedor.setVisible(false);
		mntConsultaProveedor.addActionListener(this);
		mnConsultas.add(mntConsultaProveedor);
		
		
		// pc03
		mntReporteAlumno = new JMenuItem("Reporte Alumno");
		mntReporteAlumno.setVisible(false);
		mntReporteAlumno.addActionListener(this);
		mnReporte.add(mntReporteAlumno);

		mntReporteAutor = new JMenuItem("Reporte Autor");
		mntReporteAutor.setVisible(false);
		mntReporteAutor.addActionListener(this);
		mnReporte.add(mntReporteAutor);

		mntReporteLibro = new JMenuItem("Reporte Libro");
		mntReporteLibro.setVisible(false);
		mntReporteLibro.addActionListener(this);
		mnReporte.add(mntReporteLibro);

		mntReporteSala = new JMenuItem("Reporte Sala");
		mntReporteSala.setVisible(false);
		mntReporteSala.addActionListener(this);
		mnReporte.add(mntReporteSala);

		mntReporteUsuario = new JMenuItem("Reporte Usuario");
		mntReporteUsuario.setVisible(false);
		mntReporteUsuario.addActionListener(this);
		mnReporte.add(mntReporteUsuario);

		mntReporteProveedor = new JMenuItem("Reporte Proveedor");
		mntReporteProveedor.setVisible(false);
		mntReporteProveedor.addActionListener(this);
		mnReporte.add(mntReporteProveedor);

		// Paso 2: Se a�ade los menus a la lista
		listaMenus.add(mnAdministracin);
		listaMenus.add(mnCrud);
		listaMenus.add(mnConsultas);
		listaMenus.add(mnReporte);
		
		// Paso 3: Se a�ade los items de menu a la lista
		listaItemMenus.add(mntRegAlumno);
		listaItemMenus.add(mntRegAutor);
		listaItemMenus.add(mntRegLibro);
		listaItemMenus.add(mntRegSala);
		listaItemMenus.add(mntRegUsuario);
		listaItemMenus.add(mntRegProveedor);

		listaItemMenus.add(mntCrudAlumno);
		listaItemMenus.add(mntCrudAutor);
		listaItemMenus.add(mntCrudLibro);
		listaItemMenus.add(mntCrudSala);
		listaItemMenus.add(mntCrudUsuario);
		listaItemMenus.add(mntCrudProveedor);
		
		listaItemMenus.add(mntConsultaAlumno);
		listaItemMenus.add(mntConsultaAutor);
		listaItemMenus.add(mntConsultaLibro);
		listaItemMenus.add(mntConsultaSala);
		listaItemMenus.add(mntConsultaUsuario);
		listaItemMenus.add(mntConsultaProveedor);
		
		listaItemMenus.add(mntReporteAlumno);
		listaItemMenus.add(mntReporteAutor);
		listaItemMenus.add(mntReporteLibro);
		listaItemMenus.add(mntReporteSala);
		listaItemMenus.add(mntReporteUsuario);
		listaItemMenus.add(mntReporteProveedor);
	
		// Paso 4: Se los formularios al contenedor
			
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");

			FrmPrincipal jf = new FrmPrincipal("Sistema de gesti�n de biblioteca", 900, 600);
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
		int n = JOptionPane.showConfirmDialog(e.getWindow(), "�Desea cerrar la aplicaci�n?", "Confirmaci�n",
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
		//PC01 Registros
	
		
	}

	public void muestraOpciones() {
	
	}

	public void verificaMenu(JMenu aux) {
		for (int i = 0; i < aux.getItemCount(); i++) {
			if (aux.getItem(i).isVisible()) {
				aux.setVisible(true);
				break;
			}
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
}