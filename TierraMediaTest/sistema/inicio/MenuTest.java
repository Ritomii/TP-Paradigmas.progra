package sistema.inicio;

import java.util.TreeSet;

//import static org.junit.Assert.*;

import org.junit.Test;

import sistema.atracciones.Atraccion;
import sistema.promociones.Promocion;
import sistema.usuarios.Usuario;
import utiles.Datos;
import utiles.Lector;

public class MenuTest {

	public Datos cargarDatos() {
		Lector lectura = new Lector();
		return lectura.leerDatos();
	}

	@Test
	public void mostrarDatos() {
		Datos carga = cargarDatos();
		System.out.println("Lista de Visitantes");
		System.out.println(carga.getLista_usuarios());
		System.out.println("Mapa de Atracciones");
		System.out.println(carga.getMapa_atracciones());
		System.out.println("Mapa de Tipos y Atracciones");
		System.out.println(carga.getMapa_atracciones_tipos());
		System.out.println("Mapa de Tipos y Promociones");
		System.out.println(carga.getMapa_promos_tipos());
	}

	@Test
	public void mostrarOrdenDeDatosCargados() {
		Datos carga = cargarDatos();
		System.out.println("-------------ORDEN DE PROMOCIONES-----------------");
		for(String tipo_atraccion : carga.getMapa_promos_tipos().keySet()) {
			System.out.println("Para el tipo: "+ tipo_atraccion);
			for(Promocion p : carga.getMapa_promos_tipos().get(tipo_atraccion)) {
				System.out.println(p);
				System.out.println("-------------------------------------------");
			}
		}
		System.out.println("-------------ORDEN DE ATRACCIONES-----------------");
		for(String tipo_atraccion : carga.getMapa_atracciones_tipos().keySet()) {
			System.out.println("Para el tipo: "+ tipo_atraccion);
			for(Atraccion a : carga.getMapa_atracciones_tipos().get(tipo_atraccion)) {
				System.out.println(a);
				System.out.println("-------------------------------------------");
			}
		}
	}
	
	@Test
	public void mostrarPreferenciasDelVisitante() {
		Datos carga = cargarDatos();
		String preferencia;
		for (Usuario u : carga.getLista_usuarios()) {
			preferencia = u.getPreferencia();
			System.out.println(u.getNombre() + " con preferencia: " + preferencia);
			TreeSet<Promocion> promos_preferidas = carga.getMapa_promos_tipos().get(preferencia);
			TreeSet<Atraccion> atracciones_preferidas = carga.getMapa_atracciones_tipos().get(preferencia);
			System.out.println("Promos de su interes:");
			System.out.println(promos_preferidas);
			System.out.println("Atracciones de su interes:");
			System.out.println(atracciones_preferidas);
			System.out.println("------------------------------------------------------");
		}
	}

	@Test
	public void mostrarNoPreferenciasDelVisitante() {
		Datos carga = cargarDatos();
		String preferencia;
		for (Usuario u : carga.getLista_usuarios()) {
			preferencia = u.getPreferencia();
			System.out.println(u.getNombre() + " con preferencia: " + preferencia);
			TreeSet<Promocion> promos_no_preferidas = carga.getMapa_no_preferencia_promociones().get(preferencia);
			TreeSet<Atraccion> atracciones_no_preferidas = carga.getMapa_no_preferencia_atraccion().get(preferencia);
			System.out.println("Promos que NO son de su interes:");
			System.out.println(promos_no_preferidas);
			System.out.println("------------------------------------------------------");
			System.out.println("Atracciones que NO son de su interes:");
			System.out.println(atracciones_no_preferidas);
			System.out.println("------------------------------------------------------");
		}
	}
}
