package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Menu;
import logic.Order;
import logic.Product;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextPane;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private Menu menu;
	private Order order;
	private JPanel contentPane;
	private JPanel pnBotones;
	private JButton btnSiguiente;
	private JLabel lblTitulo;
	private JButton btnCancelar;
	private JLabel lblIcono;
	private JLabel lblArticulos;
	private JComboBox<Product> cmbBoxArticulos;
	private JLabel lblUnidades;
	private JSpinner spnUnidades;
	private JButton btnAnadir;
	private JLabel lblPrecioPedido;
	private JTextField txtPrecio;
	private JTextPane txtpnsiSuPedido;

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
		setTitle("McDonalsd's Espa\u00F1a");
		menu = new Menu();
		order = new Order();
		setForeground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.PNG")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 485);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPnBotones());
		contentPane.add(getLblTitulo());
		contentPane.add(getLblIcono());
		contentPane.add(getLblArticulos());
		contentPane.add(getCmbBoxArticulos());
		contentPane.add(getLblUnidades());
		contentPane.add(getSpnUnidades());
		contentPane.add(getBtnAnadir());
		contentPane.add(getLblPrecioPedido());
		contentPane.add(getTxtPrecio());
		contentPane.add(getTxtpnsiSuPedido());
	}

	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.setBounds(417, 380, 233, 29);
			pnBotones.setLayout(new GridLayout(0, 2, 0, 0));
			pnBotones.add(getBtnSiguiente());
			pnBotones.add(getBtnCancelar());
		}
		return pnBotones;
	}

	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setForeground(new Color(255, 255, 255));
			btnSiguiente.setBackground(new Color(50, 205, 50));
			btnSiguiente.setMnemonic('S');
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarVentanaRegistro();
				}
			});
			btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return btnSiguiente;
	}

	private void mostrarVentanaRegistro() {
		VentanaRegistro vR = new VentanaRegistro(this);
		vR.setModal(true);
		vR.setLocationRelativeTo(this);
		vR.setVisible(true);
	}

	private JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("McDonald's");
			lblTitulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 45));
			lblTitulo.setBounds(269, 46, 291, 102);
			lblTitulo.setForeground(Color.BLACK);
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblTitulo;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBackground(Color.RED);
			btnCancelar.setForeground(Color.WHITE);
			btnCancelar.setMnemonic('C');
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return btnCancelar;
	}

	private JLabel getLblIcono() {
		if (lblIcono == null) {
			lblIcono = new JLabel("New label");
			lblIcono.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.PNG")));
			lblIcono.setBounds(42, 21, 206, 153);
		}
		return lblIcono;
	}

	private JLabel getLblArticulos() {
		if (lblArticulos == null) {
			lblArticulos = new JLabel("Art\u00EDculos:");
			lblArticulos.setDisplayedMnemonic('r');
			lblArticulos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblArticulos.setBounds(38, 189, 92, 26);
		}
		return lblArticulos;
	}

	private JComboBox<Product> getCmbBoxArticulos() {
		if (cmbBoxArticulos == null) {
			cmbBoxArticulos = new JComboBox<Product>();
			cmbBoxArticulos.setForeground(new Color(0, 0, 0));
			cmbBoxArticulos.setBackground(new Color(255, 255, 255));
			cmbBoxArticulos.setBounds(38, 223, 279, 32);
			Product[] productos = menu.getProducts();
			for (Product product : productos) {
				cmbBoxArticulos.addItem(product);
			}
		}
		return cmbBoxArticulos;
	}

	private JLabel getLblUnidades() {
		if (lblUnidades == null) {
			lblUnidades = new JLabel("Unidades:");
			lblUnidades.setDisplayedMnemonic('U');
			lblUnidades.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblUnidades.setBounds(352, 189, 92, 26);
		}
		return lblUnidades;
	}

	private JSpinner getSpnUnidades() {
		if (spnUnidades == null) {
			spnUnidades = new JSpinner();
			spnUnidades.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spnUnidades.setBounds(352, 223, 56, 32);
		}
		return spnUnidades;
	}

	private JButton getBtnAnadir() {
		if (btnAnadir == null) {
			btnAnadir = new JButton("A\u00F1adir");
			btnAnadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if ((int) getSpnUnidades().getValue() > 0) {
						order.add((Product) getCmbBoxArticulos().getSelectedItem(), (int) getSpnUnidades().getValue());
						String precio = order.calcTotal() + "";
						getTxtPrecio().setText(precio);
					} else
						JOptionPane.showMessageDialog(null, "Por favor seleccione al menos una unidad del producto");
				}
			});
			btnAnadir.setMnemonic('A');
			btnAnadir.setBackground(new Color(50, 205, 50));
			btnAnadir.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnAnadir.setForeground(new Color(255, 255, 255));
			btnAnadir.setBounds(429, 224, 108, 35);
		}
		return btnAnadir;
	}

	private JLabel getLblPrecioPedido() {
		if (lblPrecioPedido == null) {
			lblPrecioPedido = new JLabel("Precio Pedido:");
			lblPrecioPedido.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPrecioPedido.setBounds(352, 289, 117, 26);
		}
		return lblPrecioPedido;
	}

	private JTextField getTxtPrecio() {
		if (txtPrecio == null) {
			txtPrecio = new JTextField();
			txtPrecio.setEditable(false);
			txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtPrecio.setBounds(352, 320, 117, 32);
			txtPrecio.setColumns(10);
		}
		return txtPrecio;
	}

	public Order getOrder() {
		return order;
	}

	private JTextPane getTxtpnsiSuPedido() {
		if (txtpnsiSuPedido == null) {
			txtpnsiSuPedido = new JTextPane();
			txtpnsiSuPedido.setFont(new Font("Impact", Font.PLAIN, 15));
			txtpnsiSuPedido.setText("Si su pedido es de 50\u20AC o superior 10% de descuento!!");
			txtpnsiSuPedido.setBounds(478, 296, 156, 63);
		}
		return txtpnsiSuPedido;
	}
}
