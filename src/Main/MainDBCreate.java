package Main;

import javax.swing.JFrame;

import Views.MainView;

/**

 * Esta clase define el punto de entrada de la aplicación.
 * Comprueba que existe la tabla dentro de la base de datos
 * que proporciona el usuario, 
 * si no existe ejecuta los scripts 
 * rellenaDummy.sql y 
 * ScriptBD.sql 
 *  
 * @author Roque Flores Naranjo
 * 
 * @version 11/03/2021-1.3

 * @see <a href = "https://www.linkedin.com/in/roque-flores-naranjo/" /> Mi LinkEdin :) </a>

 */
public class MainDBCreate {

	public static void main(String[] args) {
		// muestra el Login
		MainView mainView=new MainView();
		mainView.getFrame().setAlwaysOnTop(true);
		mainView.getFrame().setVisible(true);
	}
}
