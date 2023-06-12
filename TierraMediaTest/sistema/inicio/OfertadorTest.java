package sistema.inicio;

import static org.junit.Assert.*;

import org.junit.Test;

import utiles.ArchivoUsuarios;
import utiles.ArchivoAtracciones;
import utiles.ArchivoPromociones;
import utiles.Datos;
public class OfertadorTest {
	
	@Test
	public void ofertador() {
		
		Datos cargados = new Datos();
		Menu consola = new Menu();
		
		ArchivoUsuarios arch_usuarios = new ArchivoUsuarios();
		ArchivoAtracciones arch_atracciones = new ArchivoAtracciones();
		ArchivoPromociones arch_promociones = new ArchivoPromociones();
		
		arch_usuarios.leerArchivo("./archivosTest/usuariosTest.in", cargados);
		arch_atracciones.leerArchivo("./archivosTest/atraccionesTest.in", cargados);
		arch_promociones.leerArchivo("./archivosTest/promocionesTest.in", cargados);
		
		cargados.ordenarNoPreferencias();
			
		consola.mostrar(cargados);
		
		
	}

}
