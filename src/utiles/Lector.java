package utiles;

import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class Lector {
	
	private static final String RUTA_USUARIOS = "./entradas/usuarios.in";
	private static final String RUTA_ATRACCIONES = "./entradas/atracciones.in";
	private static final String RUTA_PAQUETES = "./entradas/paquetes.in";
	
	public Datos[] leerDatos() {
		
		Datos[] usuarios_datos = this.leerArchivo(RUTA_USUARIOS);
		Datos[] atracciones_datos = this.leerArchivo(RUTA_ATRACCIONES);
		Datos[] paquetes_datos = this.leerArchivo(RUTA_PAQUETES);
		
		return usuarios_datos;
	}
	
	private Datos[] leerArchivo(String ruta) {
		Scanner scanner = null;
		Datos[] datos = null;

		try {
			File file = new File(ruta);
			scanner = new Scanner(file);

			scanner.useLocale(new Locale("es_AR"));
			
			int cant = scanner.nextInt();
			scanner.nextLine();
			datos = new Datos[cant];
			
			for (int i = 0; i < cant; i++) {
				datos[i].nombre = scanner.nextLine();
				datos[i].preferencia = scanner.nextLine();
				datos[i].monedas = scanner.nextInt();
				scanner.nextLine();
				datos[i].tiempo = scanner.nextDouble();
				scanner.nextLine();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			scanner.close();
		}
		return datos;
	}
}
