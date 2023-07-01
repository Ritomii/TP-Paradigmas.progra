package utiles;

public class Lector {
	private static final String RUTA_USUARIOS = "./entradas/usuarios.in";
	private static final String RUTA_ATRACCIONES = "./entradas/atracciones.in";
	private static final String RUTA_PROMOCIONES = "./entradas/promociones.in";

	public Datos leerDatos() {
		ArchivoUsuarios arch_usuarios = new ArchivoUsuarios();
		ArchivoAtracciones arch_atracciones = new ArchivoAtracciones();
		ArchivoPromociones arch_promociones = new ArchivoPromociones();
		Datos cargados = new Datos();

		arch_usuarios.leerArchivo(RUTA_USUARIOS, cargados);
		arch_atracciones.leerArchivo(RUTA_ATRACCIONES, cargados);
		arch_promociones.leerArchivo(RUTA_PROMOCIONES, cargados);

		cargados.ordenarNoPreferencias();

		return cargados;
	}
}
