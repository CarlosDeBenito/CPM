package igu;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class VentanaConfirmacion extends JDialog {

	private static final long serialVersionUID = 1L;
	private VentanaRegistro vR;
	private JPanel panel;


	public VentanaConfirmacion(VentanaRegistro vR) {
		setTitle("Ya ha pedido");
		this.vR = vR;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(getPanel(), BorderLayout.CENTER);
		{
			JPanel panel_1 = new JPanel();
			getContentPane().add(panel_1, BorderLayout.NORTH);
			{
				JLabel lblOk = new JLabel("");
				lblOk.setIcon(new ImageIcon(VentanaConfirmacion.class.getResource("/img/ok.png")));
				panel_1.add(lblOk);
			}
		}
	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(44, 169, 695, 241);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 695, 241);
				panel.add(scrollPane);
				{	
					JTextArea textJustificante = new JTextArea();
					textJustificante.setText(vR.getVentana().getOrder().toString());
					//textJustificante.setText(vR.getVentana().getHolidaying().getReservas().toString());
					scrollPane.setViewportView(textJustificante);
				}
			}
		}
		return panel;
	}
}
