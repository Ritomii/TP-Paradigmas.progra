package utiles;

import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class Lector {
	private static final String RUTA_USUARIOS = "./entradas/usuarios.in";
	private static final String RUTA_ATRACCIONES = "./entradas/promociones.in";
	private static final String RUTA_PAQUETES = "./entradas/paquetes.in";
	
	
	public Datos leerDatos() {
		ArchivoUsuarios arch_usuarios = new ArchivoUsuarios();
		ArchivoAtracciones arch_atracciones = new ArchivoAtracciones();
		Datos cargados = new Datos();
		
		arch_usuarios.leerArchivo(RUTA_USUARIOS, cargados);
		arch_atracciones.leerArchivo(RUTA_ATRACCIONES, cargados);
		
		return cargados;
	}
	
	
		
}
