package sistema.inicio;

import utiles.ArchivoSalida;
import utiles.Datos;
import utiles.Lector;

public class Inicio {

	public static void main(String[] args) {
		Lector lectura = new Lector();
		ArchivoSalida arch_salida = new ArchivoSalida();
		Menu consola = new Menu();
		Datos cargados;

		cargados = lectura.leerDatos();
		consola.mostrar(cargados);
		arch_salida.escribirSalida(cargados);
	}

}
