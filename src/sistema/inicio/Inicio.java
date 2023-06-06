package sistema.inicio;

import utiles.Datos;
import utiles.Lector;

public class Inicio {

	public static void main(String[] args) {
		Lector lectura = new Lector();
		Menu consola = new Menu();
		Datos cargados;
		
		cargados = lectura.leerDatos();
		consola.mostrar(cargados);
		
	}

}
