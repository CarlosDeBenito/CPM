package igu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class VentanaConfirmacion extends JDialog {

	private static final long serialVersionUID = 1L;
	private VentanaRegistro vR;
	private final JPanel contentPanel = new JPanel();
	private JPanel pnPedido;
	private JPanel pnNorte;
	private JButton btnMisReservas;
	private JButton btnImprimir;


	public VentanaConfirmacion(VentanaRegistro vR) {
		setTitle("Ya ha pedido");
		this.vR = vR;
		setBounds(100, 100, 786, 526);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);	
		contentPanel.add(getPnNorte());
		contentPanel.add(getPnPedido());
	}
	
	private JPanel getPnNorte() {
		if (pnNorte == null) {
			pnNorte = new JPanel();
			pnNorte.setBackground(Color.WHITE);
			pnNorte.setBounds(44, 21, 695, 127);
			contentPanel.add(pnNorte);
			pnNorte.setLayout(null);
			{
				JLabel lblConfirmar = new JLabel("");
				lblConfirmar.setBounds(628, 0, 56, 84);
				pnNorte.add(lblConfirmar);
				lblConfirmar.setIcon(new ImageIcon(VentanaConfirmacion.class.getResource("/img/ok.png")));
			}
			pnNorte.add(getBtnImprimir());
			pnNorte.add(getBtnMisReservas());
		}
		return pnNorte;
	}
	
	private JPanel getPnPedido() {
		if (pnPedido == null) {
			pnPedido = new JPanel();
			pnPedido.setBounds(44, 169, 695, 241);
			contentPanel.add(pnPedido);
			pnPedido.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 695, 241);
				pnPedido.add(scrollPane);
				{	
					JTextArea textJustificante = new JTextArea();
					textJustificante.setText(vR.getVentana().getOrder().toStringConDescuento());
					scrollPane.setViewportView(textJustificante);
				}
			}
		}
		return pnPedido;
	}
	
	private JButton getBtnMisReservas() {
		if (btnMisReservas == null) {
			btnMisReservas = new JButton("Mis reservas");
			btnMisReservas.setMnemonic('m');
			btnMisReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vR.dispose();
				dispose();
			}
		});
		btnMisReservas.setBounds(399, 68, 186, 31);
		pnNorte.add(btnMisReservas);
		btnMisReservas.setForeground(Color.BLACK);
		btnMisReservas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		}
		return btnMisReservas;
	}
	
	private JButton getBtnImprimir() {
		if (btnImprimir == null) {
			btnImprimir = new JButton("Imprimir justificante");
			btnImprimir.setMnemonic('i');
			btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Reservas reservas = vR.getVentana().getHolidaying().getReservas();
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				String fechaJus = sdf.format(cal.getTime());
//				String nombreArchivo=reservas.getdNI() +"_" +fechaJus +".txt";
//				reservas.escribir(nombreArchivo); 
			}
		});
		btnImprimir.setBounds(62, 68, 254, 29);
		pnNorte.add(btnImprimir);
		btnImprimir.setBackground(Color.WHITE);
		btnImprimir.setForeground(Color.BLACK);
		btnImprimir.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnImprimir.setActionCommand("Cancel");
		}
		return btnImprimir;
	}
}
