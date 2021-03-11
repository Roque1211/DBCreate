package Views;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Common.Constantes;
import DAO.IniDAO;
import javax.swing.JProgressBar;

/**

 * Esta clase define el objeto MainView de la aplicación.
 * es la vista principal de la app.
 * Comprueba que existe la tabla en la base de datos
 * que proporciona el usuario, 
 * si no existe ejecuta los scripts 
 * rellenaDummy.sql y 
 * ScriptBD.sql 
 *  
 *  AL CREAR LA BD SE BORRA EL LOG
 *  PARA RECUPERARLO VOLVER A PULSAR
 *  EL BOTÓN COMENZAR
 *  
 * @author Roque Flores Naranjo
 * 
 * @version 11/03/2021-1.3

 * @see <a href = "https://www.linkedin.com/in/roque-flores-naranjo/" /> Mi LinkEdin :) </a>

 */
public class MainView {

	public JFrame frame;
	private JTextField tfTabla;
	private JTextField tfBD;
	
	private JButton btComenzar;
	private DefaultListModel<String> listModel;
	private JProgressBar progressBar;
	private JList<String> lsLog;

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
		creaFrame();
		creaPanelBD();
		creaPanelTabla();
		creaPanelLog();		
		creaPanelPB();
	}
	
	/**
	 * Crea panel ProgressBar
	 */
	private void creaPanelPB() {
		JPanel pnMensaje = new JPanel();
		FlowLayout fl_pnMensaje = (FlowLayout) pnMensaje.getLayout();
		fl_pnMensaje.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(pnMensaje);
		
		progressBar = new JProgressBar();
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		progressBar.setString("Esperando");
		progressBar.setMinimum(0);
		progressBar.setAlignmentX(0);
		progressBar.setAlignmentY(0);
		pnMensaje.add(progressBar);		
	}

	/**
	 * Crea panel de log
	 */
	private void creaPanelLog() {
		JScrollPane scLog = new JScrollPane();
		frame.getContentPane().add(scLog);
		
		lsLog = new JList<String>();
		listModel = new DefaultListModel<String>();
		lsLog.setModel(listModel);
		scLog.setViewportView(lsLog);		
	}

	/**
	 * Crea panel linea 1, Tabla
	 */
	private void creaPanelTabla() {
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
	}

	/**
	 * Crea panel de la linea 1, BD
	 */
	private void creaPanelBD() {
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
	}

/**
 * Crea el frame principal
 */
	private void creaFrame() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));		
	}

/**
 * comenzar la creación de la base de datos
 * @return
 */
	private ActionListener comenzar() {
		// Comprueba que los textos no son nulos
		if (tfTabla.getText().length()>0 && tfBD.getText().length()>0) {
			// clear list
			listModel.add(0, "******************************************");;
			// init vars
			Constantes.defaultTable=tfTabla.getText();
			Constantes.dataBaseD = tfBD.getText();		
			// button not enabled
			btComenzar.setEnabled(false);
			// label init
			progressBar.setString("Procesando 0%");
			// starts thread
			IniDAO inidao = new IniDAO(this);
			inidao.start();
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


	public JProgressBar getProgressBar() {
		return progressBar;
	}
	

// fin
}
