package Views;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.OptionPaneUI;

import Common.Constantes;
import DAO.IniDAO;

public class MainView {

	public JFrame frame;
	private JTextField tfTabla;

	private static String CARPETA="C:\\Users\\Roque\\Desktop\\Bettergy\\Salesforce\\csv";
	private static String CARPETAD="C:\\Users\\Roque\\Desktop\\Bettergy\\Salesforce";
	private static String FOUT="\\salida.csv";
	private static boolean primero=true;
	private final JPanel pnMensaje = new JPanel();
	private JTextField tfBD;
	private JList<String> lsLog;
	private DefaultListModel<String> listModel;

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel pnBD = new JPanel();
		FlowLayout fl_pnBD = (FlowLayout) pnBD.getLayout();
		fl_pnBD.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(pnBD);
		
		JLabel lbBD = new JLabel("Base de datos");
		lbBD.setForeground(Color.BLUE);
		pnBD.add(lbBD);
		
		tfBD = new JTextField();
		tfBD.setText("conthoras");
		tfBD.setColumns(10);
		pnBD.add(tfBD);
		
		JPanel pnTabla = new JPanel();
		FlowLayout fl_pnTabla = (FlowLayout) pnTabla.getLayout();
		fl_pnTabla.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(pnTabla);
		
		JLabel lbTabla = new JLabel("Tabla por defecto");
		lbTabla.setForeground(Color.BLUE);
		pnTabla.add(lbTabla);
		
		tfTabla = new JTextField();
		tfTabla.setText("user");
		pnTabla.add(tfTabla);
		tfTabla.setColumns(10);
		
		// botón Comenzar
		JButton btComenzar = new JButton("Comenzar");
		pnTabla.add(btComenzar);
		btComenzar.addActionListener (new ActionListener()
	       {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				comenzar();
			}
	       });
		
		JScrollPane scLog = new JScrollPane();
		frame.getContentPane().add(scLog);
		
		lsLog = new JList<String>();
		listModel = new DefaultListModel<String>();
		lsLog.setModel(listModel);
		scLog.setViewportView(lsLog);
		FlowLayout fl_pnMensaje = (FlowLayout) pnMensaje.getLayout();
		fl_pnMensaje.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(pnMensaje);
		
		JLabel lblMensajes = new JLabel("Esperando");
		lblMensajes.setForeground(Color.BLUE);
		pnMensaje.add(lblMensajes);
	}
/**
 * comenzar la creación de la base de datos
 * @return
 */
	private ActionListener comenzar() {
		
		if (tfTabla.getText().length()>0 && tfBD.getText().length()>0) {
			Constantes.defaultTable=tfTabla.getText();
			Constantes.dataBaseD = tfBD.getText();
		} else {
			JOptionPane.showMessageDialog(frame, "Debe rellenar ambos textos", "Error",JOptionPane.ERROR_MESSAGE);
		}

		IniDAO inidao = new IniDAO(listModel);
		
		addListLine ("Acabado.");
		return null;
	}
	
	
	/**
	 * Adds a line to the list results
	 * @param line
	 */
	private void addListLine(String line) {
		listModel.addElement(line);
	
	}

	/**
	 * get frame de la vista
	 * @return
	 */
	public JFrame getFrame() {
		return frame;
	}
	

// fin
}
