package DAO;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import Common.Constantes;
import Views.MainView;

/**

 * Esta clase define el objeto AbstractDAO de la aplicación.
 * En ella están todos los métodos para conectar y crear la BD, 
 * @author Roque Flores Naranjo
 * 
 * @version 27/10/2020-1.0

 * @see <a href = "https://www.linkedin.com/in/roque-flores-naranjo/" /> Mi LinkEdin :) </a>

 */


public class IniDAO extends Thread {
	
	// ESTADOS**********************
	protected MainView mainview=null;

	
	public void run() {
		//Thread.sleep(500);
        creaBD();;
		// join();
	}
	// COMPORTAMIENTOS *******************
	public IniDAO(MainView mainView) {
		this.mainview=mainView;
	}
    
    /**
     * crea la Base de datos si no existe
     */
	protected void creaBD() {
		// crea la BD si es necesario
        try {
        	Connection cn = DriverManager.getConnection(Constantes.URLMYSQL, Constantes.USUARIO, Constantes.CLAVE);
        	Statement stm = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            stm.execute("use " +Constantes.BDMYSQL);
        	// crea la BD si no existe
            stm.execute("CREATE database IF NOT exists " + Constantes.dataBaseD);
        	// comprueba que existe la tabla elegida
            String strsql=" SELECT * "
            		+ " FROM " + Constantes.BDMYSQL +".tables"
            		+ " WHERE table_name = '" + Constantes.defaultTable+"'"
            		+ " and table_schema='"+Constantes.dataBaseD+"'";
            ResultSet rs= stm.executeQuery(strsql);
            // si existe la abre y lo muestra en la view
			if (rs.next()) {
				ejecutaSQL("use "+Constantes.dataBaseD);
				showMsg ("Base de datos "+ Constantes.dataBaseD+" abierta correctamente.");

			} else {
			// si no existe ejecuta el fichero sql de creación y el de carga de datos.
				showMsg("La base de datos "+Constantes.dataBaseD+" no existe. Creando Base de datos.");
				ejecutaSQL("use " + Constantes.dataBaseD);
				ejecutaSentencias(Constantes.SQLCREATE);
			    // carga los datos Dummies
				ejecutaSentencias(Constantes.SQLCARGA);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // change enable on button
    	JButton button = mainview.getBtComenzar();
    	button.setEnabled(true);
    	// ends msg
    	showMsg("Acabado");
    	// change label
    	JLabel label = mainview.getLblMensajes();
    	label.setText("Esperando");
	}
	
	/**
	 * muestra un mensaje en la lista de la view y 
	 * refresca el label de mensajes
	 * @param string
	 */
	private void showMsg(String string) {
		//adds msg to list
		DefaultListModel<String> listModel = mainview.getLsLog();
		listModel.add(0,string);
		
		//change label
		JLabel label = mainview.getLblMensajes();
		switch (label.getText().substring(label.getText().length()-1,label.getText().length())) 
		{
		case "/":
			label.setText("Procesando -");
			break;
		case "-":
			label.setText("Procesando \\");
			break;
		case "\\":
			label.setText("Procesando /");
			break;
		default:
			label.setText("Procesando /");
			break;
		}
		
	}
	/**
	 * Define el objeto connection para conectar con una BD MySQL
	 * @param cn 
	 */
    protected Connection conectar(Connection cn) {
        try {
           Class.forName(Constantes.CONTROLADOR);
            cn = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CLAVE);
        } catch (ClassNotFoundException e) {
        	showMsg("Error al cargar el controlador");
            e.printStackTrace();

        } catch (SQLException e) {
        	showMsg("Error en la conexión");
            
            e.printStackTrace();
        }	
        return cn;
	}

	
	/**
	 * ejecuta sentencias desde un fichero SQL
	 * @param fileSQL fichero con las sentencias
	 */
	public void ejecutaSentencias(String fileSQL) {
		//lee el fichero
		String lineas= leeFichero(fileSQL);
		String [] sentencias=lineas.split(";");
		// recorre el array y ejecuta las sentencias 
		for (int i=0;i<sentencias.length;i++) {
			ejecutaSQL(sentencias[i]);
		}
	}
	
	/**
	 * lee un fichero SQL y devuelve un String con los datos
	 * @return
	 */
	private String leeFichero(String fileSQL) {
		String lineas=" ";
		BufferedReader lector = null;

		try {
			lector = new BufferedReader(new FileReader(fileSQL));
			String linea=lector.readLine();
			while(linea!=null) {
				if (linea!=null) lineas=lineas+linea.trim();
				linea=lector.readLine();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			try {
				lector.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lineas;
	}
	
	/**
	 * Ejecuta un statement 
	 * @param strSQL el statement SQL a ejecutar
	 * @return 
	 */
	protected boolean ejecutaSQL(String strSQL) {
		boolean resultado=true;
		Statement stm=null;
		Connection cn = null;
		cn=conectar(cn);
		try {
			// ejecuta Statement
            stm= cn.createStatement();
            stm.execute(strSQL);
            showMsg(strSQL);
            
            
        } catch (SQLException e) {
			e.printStackTrace();
			showMsg("Error: "+e.getMessage());
			resultado=false;
		} finally {
			
		}
        
		return resultado;
	}
	
	/**
	 * ejecuta una consulta SQL dado un String
	 * @param strSql
	 * @return un Resulset con los resultados
	 */
	protected ResultSet consultaSQL(String strSql) {
		Statement stm=null;
		Connection cn = null;
		cn=conectar(cn);
		ResultSet rst=null;
		try {
            stm= cn.createStatement();
			rst = stm.executeQuery(strSql);
				return rst;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return null;
	}
	
	//*************** fin
}
