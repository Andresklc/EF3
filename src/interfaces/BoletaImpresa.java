package interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


import Entidad.Ventas;
import Model.VentaModel;
import gui.frmInternalBoleta;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import Util.GeneradorReporte;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class BoletaImpresa extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JPanel panelReporteBoleta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BoletaImpresa dialog = new BoletaImpresa();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BoletaImpresa() {
		setBounds(100, 100, 607, 407);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panelReporteBoleta = new JPanel();
		panelReporteBoleta.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Boleta", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelReporteBoleta.setBounds(10, 11, 571, 313);
		contentPanel.add(panelReporteBoleta);
		panelReporteBoleta.setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("SALIR");
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			boletagenerada();
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			actionPerformedOkButtonJButton(e);
		}
	}
	protected void actionPerformedOkButtonJButton(ActionEvent e) {
		 dispose();
	}
	public void boletagenerada() {
		int Cod=Integer.parseInt(frmInternalBoleta.txtCodigoCliente.getText());
		VentaModel vm=new VentaModel();
		List<Ventas> lstVentas=vm.listaVentaid(Cod);
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lstVentas);
		String jasper = "Simple_Blue.jasper";	
		
		JasperPrint print = GeneradorReporte.genera(jasper, dataSource, null);
		
		JRViewer jRViewer = new JRViewer(print);
		
		panelReporteBoleta.removeAll();
		panelReporteBoleta.add(jRViewer);
		panelReporteBoleta.repaint();
		panelReporteBoleta.revalidate();
		}
	}

