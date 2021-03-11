package Common;

import java.util.ArrayList;

import Common.Constantes.DigitoDni;

public abstract class Constantes{
	//estados
	public static String dataBaseD = "conthoras";
	public static String defaultTable = "user";
	public static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	public static final  String URL = "jdbc:mysql://localhost:3306/"+ dataBaseD + "?allowPublicKeyRetrieval=true&useSSL=false";
	//public static final String USUARIO = "root";
	// public static final String CLAVE = "AdminMysql1211$";
	public static final String USUARIO = "usuario_hibernate";
	public static final String CLAVE = "1234";

	public static final String SQLCREATE = "src/Scripts/scriptBD.sql";
	public static final String SQLCARGA = "src/Scripts/rellenaDummy.sql";
	public static final String BDMYSQL = "information_schema";
	public static final  String URLMYSQL = "jdbc:mysql://localhost:3306/"+ BDMYSQL + "?allowPublicKeyRetrieval=true&useSSL=false";
	public static int idCliGlobal=0;
	public static int idVehGlobal=0;

	//comportamientos
	public Constantes() {}
	/**
	 * enumerado para los meses
	 * @author Roque
	 *
	 */
	public enum Meses {
		enero, febrero, marzo, abril, mayo, junio, julio, agosto, septiembre, octubre, noviembre, diciembre
		}
	/**
	 * enumerado para usar en el cálculo de DNI
	 * @author Roque
	 *
	 */
	public enum DigitoDni {
		T,R,W,A,G,M,Y,F,P,D,X,B,N,J,Z,S,Q,V,H,L,C,K,E
		}
	/**
	 * enumerado permitidos en un NIE
	 * @author Roque
	 *
	 */
	public enum DigitoNie {
		X,Y,Z
		}
	/**
	 * enumerado tipos de vehículos
	 * 	 * @author Roque
	 *
	 */
	public enum TiposVeh {
		COCHE,MOTOCICLETA,CICLOMOTOR
		}
	
	/**
	 * Encripta una cadena de char en SHA256
	 * @param texto cadena de char a encriptar
	 * @return String de 64 caracteres encriptados
	 */
	public static String encriptar(char[] texto) {
		// convierte la cadena de char en String
		String cifrarTexto=String.valueOf(texto[0]);
		for (int i=1;i<texto.length;i++){
			cifrarTexto= String.valueOf(texto[i]);
		}
		try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
            byte[] array = md.digest(cifrarTexto.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            //System.out.println(sb.toString());
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;
	}
	
	/**
	 * Comprueba un DNI/NIE correcto
	 * @return
	 */
	public static boolean comprobarDNI(String DNI) {
		boolean resultado = true;
		String dni = DNI;

		
		// el dni tiene que tener 9 dígitos
		if ((dni.length()>9) || (dni.length()<9)) {
			resultado= false;
			System.out.println("El NIF/NIE debe tener 9 dígitos");
		} else {
		// comprueba que los formatos DNI/NIE sean correctos
			if (
					(dni.substring(8, 9).matches("[a-zA-Z]")
					&& dni.substring(0, 8).matches("[0-9]{8}")) 
					|| (dni.substring(0, 1).matches("[x-zX-Z]") 
					&& dni.substring(8, 9).matches("[a-zA-Z]") 
					&& dni.substring(1, 8).matches("[0-9]{7}")))  {
		// Es un NIE
				if (dni.substring(0, 1).matches("[x-zX-Z]")) {
		// cambiamos el primer dígito por el número correspondiente de un NIE
					switch (dni.substring(0, 1).toUpperCase()) {
						case "X":
							dni = "0" + dni.substring(1, 9);
							break;
						case "Y":
							dni = "1" + dni.substring(1, 9);
							break;
						case "Z":
							dni = "2" + dni.substring(1, 9);
							break;
						default:
							System.out.println("algo ha ido fatal");
							resultado=false;
					}
		// calculamos la letra del NIE
					resultado=comprueba(dni);
		// Es un DNI
				} else {
		// calculamos la letra del DNI
					resultado=comprueba(dni);
				}
			} else {
				System.out.println("El DNI debe tener 8 números y una letra./n"
						+ " el NIE debe tener una letra (X, Y o Z), 7 números y una letra final."
						+ "O no ha introducido todos los datos requeridos.");
				resultado = false;
			}
		}
		
		return resultado;
	}

	/**
	 * Comprueba que la letra del DNI/NIE sea correcta
	 * @param dni
	 * @return
	 */
	private static boolean comprueba(String dni) {
		boolean resultado=true;
		// divide entre 23 y extrae el resto
		int resto = (Integer.parseInt(dni.substring(1,8))%23)+1;
		// carga la lista de letras del dni
		ArrayList<String> miArray = new ArrayList<String>();
		// guarda el enum en un array
		for (DigitoDni d: DigitoDni.values()) {
			miArray.add(d.toString());
		};
		// comprueba la letra 
		if (!miArray.get(resto).equals(dni.substring(8,9))) {
			System.out.println("Letra errónea. " + miArray.get(resto));
			resultado=false;
		}	
		return resultado;
	}


}
