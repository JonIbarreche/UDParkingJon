package es.deusto.spq.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import es.deusto.spq.jdo.Parking;
import es.deusto.spq.jdo.Vehiculo;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;


public class MainWindow extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 6673510127789501132L;
	
	Client client = ClientBuilder.newClient();
	final WebTarget appTarget = client.target("http://localhost:8080/myapp");
	final WebTarget VehiculosTarget = appTarget.path("vehiculos");

	private JList<Vehiculo> vehiculos;
	private JLabel lblMessage = new JLabel("");


	public final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					logger.log(Level.WARNING, "ERROR", e);
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 153));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 139), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final DefaultListModel<Vehiculo> ListaVehiculos = new DefaultListModel<>();
		
		GenericType<List<Vehiculo>> genericType = new GenericType<List<Vehiculo>>() {
		};
		List<Vehiculo> vehiculos2 = VehiculosTarget.request(MediaType.APPLICATION_JSON).get(genericType);

		ListaVehiculos.clear();
		for (Vehiculo vehiculos1 : vehiculos2) {

			ListaVehiculos.addElement(vehiculos1);
		}

		vehiculos = new JList<Vehiculo>(ListaVehiculos);
		vehiculos.setBounds(50, 86, 333, 314);
		vehiculos.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(vehiculos);
		
		final JLabel lblX = new JLabel("X");
		lblX.setBounds(707, 10, 19, 31);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres cerrar la aplicacion?", "Confirmacion",
						JOptionPane.YES_NO_OPTION) == 0) {
					dispose();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
		});
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setHorizontalTextPosition(SwingConstants.CENTER);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblX.setForeground(new Color(255, 255, 255));
		contentPane.add(lblX);
		
		final JTextField txtName = new JTextField();
		txtName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtName.getText().equals("Nombre")) {
					txtName.setText("");
				} else {
					txtName.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtName.getText().equals(""))
					txtName.setText("Nombre");
			}
		});
		txtName.setBorder(null);
		txtName.setFont(new Font("Arial", Font.BOLD, 14));
		txtName.setText("Nombre");
		txtName.setBounds(500, 50, 170, 20);
		txtName.setColumns(10);
		contentPane.add(txtName);

		JScrollPane areaScrollPane = new JScrollPane();
		areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setBounds(500, 86, 170, 190);
		contentPane.add(areaScrollPane);
		
		
		final JTextArea txtDescription = new JTextArea();
		areaScrollPane.setViewportView(txtDescription);
		txtDescription.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				maxLengthdesc(txtDescription, e);
			}

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});
		
				txtDescription.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						if (txtDescription.getText().equals("Descripción (max 255)")) {
							txtDescription.setText("");
						} else {
							txtDescription.selectAll();
						}
					}
		
					@Override
					public void focusLost(FocusEvent e) {
						if (txtDescription.getText().equals(""))
							txtDescription.setText("Descripción (max 255)");
					}
				});
				txtDescription.setLineWrap(true);
				txtDescription.setWrapStyleWord(true);
				txtDescription.setBorder(null);
				txtDescription.setFont(new Font("Arial", Font.BOLD, 14));
				txtDescription.setText("Descripción (max 255)");
				txtDescription.setColumns(10);
				
				final JTextField txtPrecio = new JTextField();
				txtPrecio.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						if (txtPrecio.getText().equals("Precio")) {
							txtPrecio.setText("");
						} else {
							txtPrecio.selectAll();
						}
					}

					@Override
					public void focusLost(FocusEvent e) {
						if (txtPrecio.getText().equals(""))
							txtPrecio.setText("Director");
					}
				});
				txtPrecio.setBorder(null);
				txtPrecio.setFont(new Font("Arial", Font.BOLD, 14));
				txtPrecio.setText("Precio");
				txtPrecio.setBounds(500, 301, 170, 20);
				txtPrecio.setColumns(10);
				contentPane.add(txtPrecio);				

				JButton btnAdd = new JButton("Añadir");
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//anadirVehiculoBd(vehiculos.getModel(), vehiculos.getSelectedValue().getName());
						eliminarVehiculoBd(vehiculos.getModel(), vehiculos.getSelectedValue().getName());
					}
				});

				btnAdd.setBounds(480, 430, 200, 30);
				btnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
				contentPane.add(btnAdd);				
				
		JButton btnDelete = new JButton("Eliminar");
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				eliminarVehiculoBd(vehiculos.getModel(), vehiculos.getSelectedValue().getName());
			}
		});
		btnDelete.setBounds(115, 430, 200, 30);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnDelete);
		
		JLabel lblParking = new JLabel("PARKING");
		lblParking.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblParking.setBounds(126, 16, 229, 68);
		contentPane.add(lblParking);
		
		JLabel lblVehiculo = new JLabel("VEHICULO");
		lblVehiculo.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblVehiculo.setBounds(500, 10, 170, 31);
		contentPane.add(lblVehiculo);
		
	}
	
	/**
	 * Añade vehiculo a la BD
	 */
	public void anadirVehiculoBd(JTextField txtName, JTextField txtPrecio,
			JTextArea txtDescription) {
		if (txtName.getText().equals("") || txtName.getText().equals("Nombre") || txtPrecio.getText().equals("")
				|| txtPrecio.getText().equals("Precio") || txtDescription.getText().equals("")
				|| txtDescription.getText().equals("Descripción (max 255)")) {

			lblMessage.setText("Por favor rellena los campos!");

		} else {
			PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx = pm.currentTransaction();
			int precio = Integer.parseInt(txtPrecio.toString());
			System.out.println("Añadiendo película en la BD");

			try {
				tx.begin();
				Vehiculo vehiculo = new Vehiculo(txtName.getText().toString(),
						txtDescription.getText().toString(), precio);
				pm.makePersistent(vehiculo);

				tx.commit();
				System.out.println("Añadido una nueva película a la Base de Datos");

			} finally {
				if (tx.isActive()) {
					tx.rollback();
				}
				pm.close();

				MainWindow afw = new MainWindow();
				afw.setVisible(true);
				dispose();

			}
		}
	}
	public void eliminarVehiculoBd(ListModel<Vehiculo> listModel, String selectedVehiculo) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		System.out.println("Eliminando película de la BD");

		try {

			Query<Vehiculo> q = pm.newQuery("SELECT FROM " + Vehiculo.class.getName() + " WHERE name== '" + selectedVehiculo + "'");
			List<Vehiculo> vehiculoList = q.executeList();
			q.deletePersistentAll(vehiculoList);

			System.out.println("Eliminada película de la Base de Datos");

		} finally {
			pm.close();

			MainWindow afw = new MainWindow();
			afw.setVisible(true);
			dispose();
		}
	}
	
	public void maxLengthdesc(JTextArea txtDescription, KeyEvent e) {

		int max = 255;
		if (txtDescription.getText().length() > max + 1) {
			String shortened = txtDescription.getText().substring(0, max);
			txtDescription.setText(shortened);
			e.consume();
		} else if (txtDescription.getText().length() > max) {
			e.consume();
		}

	}
}
