package Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import gui.frmBoleta;


import java.awt.Frame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class FrmInicio extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem mntmBoleto;
	
	private frmBoleta frmboleta = new frmBoleta();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//UIManager.setLookAndFeel("com.jtattoo.palf.luna.LunaLookAndFeel");
					FrmInicio frame = new FrmInicio();
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
	public FrmInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnProcesos = new JMenu("Procesos");
		menuBar.add(mnProcesos);
		
		mntmBoleto = new JMenuItem("Boleta");
		mntmBoleto.setIcon(null);
		mntmBoleto.addActionListener(this);
		mnProcesos.add(mntmBoleto);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.activeCaption);
		frmboleta.setLocation(50, 152);
		
		
		//desktopPane.add(frmboleta);
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmBoleto) {
			actionPerformedMntmBoletoJMenuItem(e);
		}
	}
	protected void actionPerformedMntmBoletoJMenuItem(ActionEvent e) {
		frmboleta.setVisible(true);
	}
}
