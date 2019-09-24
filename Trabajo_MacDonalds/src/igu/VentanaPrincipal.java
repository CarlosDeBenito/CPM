package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnBotones;
	private JButton btnSiguiente;
	private JLabel lblVentanaPrincipal;
	private JLabel lblOfertas;
	private JLabel lblOfertas_1;
	private JMenuBar menuBar;
	private JMenu mnInicio;
	private JMenuItem mntmMeAburro;
	private JButton btnSalir;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnBotones(), BorderLayout.SOUTH);
		contentPane.add(getLblVentanaPrincipal(), BorderLayout.NORTH);
		contentPane.add(getLblOfertas(), BorderLayout.WEST);
		contentPane.add(getLblOfertas_1(), BorderLayout.EAST);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
	}

	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.setLayout(new GridLayout(0, 2, 0, 0));
			pnBotones.add(getBtnSiguiente());
			pnBotones.add(getBtnSalir());
		}
		return pnBotones;
	}
	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setMnemonic('i');
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarVentanaRegistro();
				}
			});
			btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return btnSiguiente;
	}
	
	private void mostrarVentanaRegistro(){
		VentanaRegistro vR = new VentanaRegistro(this);
		vR.setModal(true);
		vR.setLocationRelativeTo(this);
		vR.setVisible(true);
	}
	private JLabel getLblVentanaPrincipal() {
		if (lblVentanaPrincipal == null) {
			lblVentanaPrincipal = new JLabel("Ventana Principal");
			lblVentanaPrincipal.setForeground(new Color(204, 51, 51));
			lblVentanaPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblVentanaPrincipal;
	}
	private JLabel getLblOfertas() {
		if (lblOfertas == null) {
			lblOfertas = new JLabel("Ofertas");
		}
		return lblOfertas;
	}
	private JLabel getLblOfertas_1() {
		if (lblOfertas_1 == null) {
			lblOfertas_1 = new JLabel("Ofertas");
		}
		return lblOfertas_1;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnInicio());
		}
		return menuBar;
	}
	private JMenu getMnInicio() {
		if (mnInicio == null) {
			mnInicio = new JMenu("Inicio");
			mnInicio.add(getMntmMeAburro());
		}
		return mnInicio;
	}
	private JMenuItem getMntmMeAburro() {
		if (mntmMeAburro == null) {
			mntmMeAburro = new JMenuItem("Me aburro");
		}
		return mntmMeAburro;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.setMnemonic('S');
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return btnSalir;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}
}
