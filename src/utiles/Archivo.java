package utiles;

import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public abstract class Archivo {

	public void leerArchivo(String ruta, Datos carga) {
		Scanner scanner = null;

		try {
			File file = new File(ruta);
			scanner = new Scanner(file);

			scanner.useLocale(new Locale("es_AR"));
			
			int cant = scanner.nextInt();
			scanner.nextLine();
			
			cargarFormato(cant, carga, scanner);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			scanner.close();
		}
	}
	
	protected abstract void cargarFormato(int cant, Datos carga, Scanner scanner);
}
