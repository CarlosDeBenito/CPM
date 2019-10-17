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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JButton btnEliminar;
	private JPanel pnPedido;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnPedido;
	private JPanel pnFiltros;
	private JButton btnFiltroPostre;
	private JButton btnFiltroHamburguesa;
	private JButton btnFiltroBebida;
	private JButton btnFiltroComplemento;
	private JLabel lblProductos;

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
		setBounds(100, 100, 948, 780);
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
		contentPane.add(getBtnEliminar());
		contentPane.add(getPnPedido());
		contentPane.add(getBtnPedido());
		contentPane.add(getPnFiltros());
		contentPane.add(getLblProductos());
	}

	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.setBounds(668, 670, 233, 29);
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
			btnSiguiente.setEnabled(false);
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
//					if (!order.getOrderList().isEmpty()) {
//						btnSiguiente.setEnabled(true);
						mostrarVentanaRegistro();
					//}
//					else
//						JOptionPane.showMessageDialog(null,
//								"Por favor seleccione al menos una unidad de un producto para continuar");
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
			lblTitulo.setBounds(408, 101, 279, 99);
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
			lblIcono.setBounds(191, 59, 208, 200);
		}
		return lblIcono;
	}

	private JLabel getLblArticulos() {
		if (lblArticulos == null) {
			lblArticulos = new JLabel("Art\u00EDculos:");
			lblArticulos.setDisplayedMnemonic('r');
			lblArticulos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblArticulos.setBounds(201, 319, 92, 26);
		}
		return lblArticulos;
	}

	private JComboBox<Product> getCmbBoxArticulos() {
		if (cmbBoxArticulos == null) {
			cmbBoxArticulos = new JComboBox<Product>();
			cmbBoxArticulos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarFotoYUnidades();
				}
			});
			cmbBoxArticulos.setForeground(new Color(0, 0, 0));
			cmbBoxArticulos.setBackground(new Color(255, 255, 255));
			cmbBoxArticulos.setBounds(201, 352, 279, 32);
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
			lblUnidades.setBounds(545, 319, 92, 26);
		}
		return lblUnidades;
	}

	private JSpinner getSpnUnidades() {
		if (spnUnidades == null) {
			spnUnidades = new JSpinner();
			spnUnidades.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spnUnidades.setBounds(545, 352, 56, 32);
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
						getSpnUnidades().setValue(1);
						if (!order.getOrderList().isEmpty())
							getBtnSiguiente().setEnabled(true);
					} else
						JOptionPane.showMessageDialog(null, "Por favor seleccione al menos una unidad del producto");
				}
			});
			btnAnadir.setMnemonic('A');
			btnAnadir.setBackground(new Color(50, 205, 50));
			btnAnadir.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnAnadir.setForeground(new Color(255, 255, 255));
			btnAnadir.setBounds(684, 349, 108, 35);
		}
		return btnAnadir;
	}

	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (order.unidadesDelPedido(
							(Product) (getCmbBoxArticulos().getSelectedItem())) >= (int) getSpnUnidades().getValue()) {
						order.remove((Product) getCmbBoxArticulos().getSelectedItem(),
								(int) getSpnUnidades().getValue());
						String precio = order.calcTotal() + "";
						getTxtPrecio().setText(precio);
						getSpnUnidades().setValue(1);
						if (order.getOrderList().isEmpty())
							getBtnSiguiente().setEnabled(false);
					} else
						JOptionPane.showMessageDialog(null, "No puedes borrar un producto que no has pedido");
				}
			});
			btnEliminar.setMnemonic('E');
			btnEliminar.setForeground(Color.WHITE);
			btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnEliminar.setBackground(new Color(50, 205, 50));
			btnEliminar.setBounds(793, 349, 108, 35);
		}
		return btnEliminar;
	}

	private JLabel getLblPrecioPedido() {
		if (lblPrecioPedido == null) {
			lblPrecioPedido = new JLabel("Precio Pedido:");
			lblPrecioPedido.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPrecioPedido.setBounds(570, 451, 117, 26);
		}
		return lblPrecioPedido;
	}

	private JTextField getTxtPrecio() {
		if (txtPrecio == null) {
			txtPrecio = new JTextField();
			txtPrecio.setEditable(false);
			txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtPrecio.setBounds(570, 487, 117, 32);
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
			txtpnsiSuPedido.setFont(new Font("Impact", Font.PLAIN, 18));
			txtpnsiSuPedido.setText("Si su pedido es de 50\u20AC o superior 10% de descuento!!");
			txtpnsiSuPedido.setBounds(728, 427, 173, 107);
		}
		return txtpnsiSuPedido;
	}

	private JPanel getPnPedido() {
		if (pnPedido == null) {
			pnPedido = new JPanel();
			pnPedido.setVisible(false);
			pnPedido.setLayout(null);
			pnPedido.setBounds(684, 111, 216, 185);
			pnPedido.add(getScrollPane());
		}
		return pnPedido;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 216, 185);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}

	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}

	private JButton getBtnPedido() {
		if (btnPedido == null) {
			btnPedido = new JButton("");
			JTextArea textJustificante = new JTextArea();
			btnPedido.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					getPnPedido().setVisible(true);
					textJustificante.setText(getOrder().toString());
					scrollPane.setViewportView(textJustificante);
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					getPnPedido().setVisible(false);
					textJustificante.setText("");
				}
			});
			btnPedido.setBackground(Color.WHITE);
			btnPedido.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/pedido.png")));
			btnPedido.setBounds(684, 45, 133, 49);
		}
		return btnPedido;
	}

	private JPanel getPnFiltros() {
		if (pnFiltros == null) {
			pnFiltros = new JPanel();
			pnFiltros.setBorder(null);
			pnFiltros.setBackground(Color.WHITE);
			pnFiltros.setBounds(21, 21, 149, 678);
			pnFiltros.setLayout(new GridLayout(4, 0, 0, 0));
			pnFiltros.add(getBtnFiltroHamburguesa());
			pnFiltros.add(getBtnFiltroBebida());
			pnFiltros.add(getBtnFiltroComplemento());
			pnFiltros.add(getBtnFiltroPostre());
		}
		return pnFiltros;
	}

	private JButton getBtnFiltroPostre() {
		if (btnFiltroPostre == null) {
			btnFiltroPostre = new JButton("Postres");
			btnFiltroPostre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					filtro("Dessert");
				}
			});
			btnFiltroPostre.setBackground(Color.WHITE);
			btnFiltroPostre.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/PO04.png")));
			btnFiltroPostre.setHorizontalTextPosition(SwingConstants.CENTER);
			btnFiltroPostre.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		return btnFiltroPostre;
	}

	private JButton getBtnFiltroHamburguesa() {
		if (btnFiltroHamburguesa == null) {
			btnFiltroHamburguesa = new JButton("Hamburguesas");
			btnFiltroHamburguesa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					filtro("Burger");
				}
			});
			btnFiltroHamburguesa.setBackground(Color.WHITE);
			btnFiltroHamburguesa.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnFiltroHamburguesa.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/HA03.png")));
			btnFiltroHamburguesa.setHorizontalTextPosition(SwingConstants.CENTER);
			btnFiltroHamburguesa.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		return btnFiltroHamburguesa;
	}

	private JButton getBtnFiltroBebida() {
		if (btnFiltroBebida == null) {
			btnFiltroBebida = new JButton("Bebidas");
			btnFiltroBebida.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					filtro("Drink");
				}
			});
			btnFiltroBebida.setBackground(Color.WHITE);
			btnFiltroBebida.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/BE03.png")));
			btnFiltroBebida.setHorizontalTextPosition(SwingConstants.CENTER);
			btnFiltroBebida.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		return btnFiltroBebida;
	}

	private JButton getBtnFiltroComplemento() {
		if (btnFiltroComplemento == null) {
			btnFiltroComplemento = new JButton("Complementos");
			btnFiltroComplemento.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					filtro("Side");
				}
			});
			btnFiltroComplemento.setBackground(Color.WHITE);
			btnFiltroComplemento.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/CO05.png")));
			btnFiltroComplemento.setHorizontalTextPosition(SwingConstants.CENTER);
			btnFiltroComplemento.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		return btnFiltroComplemento;
	}

	private JLabel getLblProductos() {
		if (lblProductos == null) {
			lblProductos = new JLabel("");
			lblProductos.setBounds(236, 405, 185, 114);
		}
		return lblProductos;
	}

	private void mostrarFotoYUnidades() {
		getSpnUnidades().setValue(1);
		if (getCmbBoxArticulos().getItemCount() > 0) {
			String fotoArticulo = "/img/" + (((Product) getCmbBoxArticulos().getSelectedItem()).getCode() + ".png");
			getLblProductos().setIcon(new ImageIcon(VentanaPrincipal.class.getResource(fotoArticulo)));
		}
	}
	
	private void filtro(String filtro) {
		getCmbBoxArticulos().removeAllItems();
		Product[] productos = menu.getProducts();
		for (Product product : productos) {
			if (product.getType().equals(filtro))
				cmbBoxArticulos.addItem(product);
		}
	}
}
