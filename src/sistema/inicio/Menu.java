package sistema.inicio;

import java.util.LinkedList;
import java.util.TreeSet;

import sistema.atracciones.Atraccion;
import sistema.promociones.Promocion;
import sistema.usuarios.Usuario;
import utiles.Datos;

public class Menu {
	public void mostrar(Datos carga) {
		
		LinkedList<Usuario> lista_usuarios = new LinkedList<Usuario>();
		
		for ( Usuario usuario_actual : lista_usuarios) {
			TreeSet<Promocion> promos_preferidas = carga.getMapa_promos_tipos().get(usuario_actual.getPreferencia());
			TreeSet<Atraccion> atracciones_preferidas = carga.getMapa_atracciones_tipos().get(usuario_actual.getPreferencia());
			
			TreeSet<Promocion> promos_no_preferidas = carga.getMapa_no_preferencia_promociones().get(usuario_actual.getPreferencia());
			TreeSet<Atraccion> atracciones_no_preferidas = carga.getMapa_no_preferencia_atraccion().get(usuario_actual.getPreferencia());
			
			this.ofrecerPromociones(usuario_actual, promos_preferidas);
			this.ofrecerAtracciones(usuario_actual, atracciones_preferidas);
			this.ofrecerPromociones(usuario_actual, promos_no_preferidas);
			this.ofrecerAtracciones(usuario_actual, atracciones_no_preferidas);
		}
		
	}
	
	private void ofrecerPromociones(Usuario usuario_actual, TreeSet<Promocion> arbol) {
		for (Promocion promocion_actual : arbol) {
			if(usuario_actual.puedeComprarPromocion(promocion_actual)) {
				usuario_actual.agregarPromocion(promocion_actual);
			}
		}
	}
	
	private void ofrecerAtracciones(Usuario usuario_actual, TreeSet<Atraccion> arbol) {
		for (Atraccion atraccion_actual : arbol) {
			if(usuario_actual.puedeComprarAtraccion(atraccion_actual)) {
				usuario_actual.agregarAtraccion(atraccion_actual);
			}
		}
	}
}
