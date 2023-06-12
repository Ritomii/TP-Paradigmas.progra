package sistema.inicio;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

import sistema.atracciones.Atraccion;
import sistema.promociones.Promocion;
import sistema.usuarios.Usuario;
import utiles.Datos;

public class Menu {
	public void mostrar(Datos carga) {
		Scanner scanner = new Scanner(System.in);
		
		LinkedList<Usuario> lista_usuarios = carga.getLista_usuarios();
		String preferencia;
		
		System.out.println("\n\tBienvenido a la Tierra Media\n");
		System.out.println("---------------------------------------------------------------------");
		
		
		for (Usuario usuario_actual : lista_usuarios) {
			System.out.println("Nombre del visitante: " + usuario_actual.getNombre() + "\n\n");
			preferencia = usuario_actual.getPreferencia();
			// Es el tipo_atraccion que le gusta al usuario
			
			TreeSet<Promocion> promos_preferidas = carga.getMapa_promos_tipos().get(preferencia);
			TreeSet<Atraccion> atracciones_preferidas = carga.getMapa_atracciones_tipos().get(preferencia);

			TreeSet<Promocion> promos_no_preferidas = carga.getMapa_no_preferencia_promociones().get(preferencia);
			TreeSet<Atraccion> atracciones_no_preferidas = carga.getMapa_no_preferencia_atraccion().get(preferencia);

			this.ofrecerPromociones(usuario_actual, promos_preferidas, scanner);
			this.ofrecerAtracciones(usuario_actual, atracciones_preferidas, scanner);
			this.ofrecerPromociones(usuario_actual, promos_no_preferidas, scanner);
			this.ofrecerAtracciones(usuario_actual, atracciones_no_preferidas, scanner);
		}
		
	}

	private void ofrecerPromociones(Usuario usuario_actual, TreeSet<Promocion> arbol, Scanner scanner) {
		if(arbol != null)
			for (Promocion promocion_actual : arbol) {
				if (usuario_actual.puedeComprarPromocion(promocion_actual)) {
					if(mostrarPromocion(promocion_actual, scanner))
						usuario_actual.agregarPromocion(promocion_actual);
				}
			}
	}

	private void ofrecerAtracciones(Usuario usuario_actual, TreeSet<Atraccion> arbol, Scanner scanner) {
		if(arbol != null)
			for (Atraccion atraccion_actual : arbol) {
				if (usuario_actual.puedeComprarAtraccion(atraccion_actual)) {
					if(mostrarAtraccion(atraccion_actual, scanner))
						usuario_actual.agregarAtraccion(atraccion_actual);
				}
			}
	}
	
	private boolean mostrarPromocion(Promocion promo, Scanner scanner) {
		String letra;
		boolean es_letra_valida;
		do {
			System.out.println("\nDesea comprar la siguiente promocion?\n");
			System.out.println(promo);
			letra = scanner.nextLine();
			es_letra_valida = letra.equalsIgnoreCase("S") || letra.equalsIgnoreCase("N"); 
		} while (!es_letra_valida);
		return letra.equalsIgnoreCase("S");
	}
	
	private boolean mostrarAtraccion(Atraccion atrac, Scanner scanner) {
		String letra;
		boolean es_letra_valida;
		do {
			System.out.println("\nDesea comprar la siguiente atraccion?\n");
			System.out.println(atrac);
			letra = scanner.nextLine();
			es_letra_valida = letra.equalsIgnoreCase("S") || letra.equalsIgnoreCase("N"); 
		} while (!es_letra_valida);
		return letra.equalsIgnoreCase("S");
	}
}
