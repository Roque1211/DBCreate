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
import java.awt.Container;

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
	private JTextField tfBD;
	
	private JButton btComenzar;
	private JLabel lblMensajes;
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
		btComenzar = new JButton("Comenzar");
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
		
		JList <String> lsLog = new JList<String>();
		listModel = new DefaultListModel<String>();
		lsLog.setModel(listModel);
		scLog.setViewportView(lsLog);
		JPanel pnMensaje = new JPanel();
		FlowLayout fl_pnMensaje = (FlowLayout) pnMensaje.getLayout();
		fl_pnMensaje.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(pnMensaje);
		
		lblMensajes = new JLabel("Esperando");
		lblMensajes.setForeground(Color.BLUE);
		pnMensaje.add(lblMensajes);
	}
/**
 * comenzar la creación de la base de datos
 * @return
 */
	private ActionListener comenzar() {
		
		if (tfTabla.getText().length()>0 && tfBD.getText().length()>0) {
			// clear list
			listModel.clear();
			// strats thread
			Constantes.defaultTable=tfTabla.getText();
			Constantes.dataBaseD = tfBD.getText();
			IniDAO inidao = new IniDAO(this);		
			inidao.start();
			// button not enabled
			btComenzar.setEnabled(false);
			// label init
			lblMensajes.setText("Procesando");
		} else {
			JOptionPane.showMessageDialog(frame, "Debe rellenar ambos textos", "Error",JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}

	/**
	 * getters 
	 * @return
	 */
	public JFrame getFrame() {
		return frame;
	}

	public DefaultListModel<String> getLsLog() {
		return listModel;
	}

	public JButton getBtComenzar() {
		return btComenzar;
	}

	public JLabel getLblMensajes() {
		return lblMensajes;
	}
	

// fin
}
