package utiles;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;

import sistema.atracciones.Atraccion;
import sistema.promociones.Promocion;
import sistema.usuarios.Usuario;

public class Datos {
	LinkedList<Usuario> lista_usuarios;

	HashMap<String, Atraccion> mapa_atracciones;
	HashMap<String, TreeSet<Atraccion>> mapa_atracciones_tipos;

	HashMap<String, TreeSet<Promocion>> mapa_promos_tipos;

	HashMap<String, TreeSet<Promocion>> mapa_no_preferencia_promociones;
	HashMap<String, TreeSet<Atraccion>> mapa_no_preferencia_atraccion;

	public LinkedList<Usuario> getLista_usuarios() {
		return lista_usuarios;
	}

	public void setLista_usuarios(LinkedList<Usuario> lista_usuarios) {
		this.lista_usuarios = lista_usuarios;
	}

	public HashMap<String, Atraccion> getMapa_atracciones() {
		return mapa_atracciones;
	}

	public void setMapa_atracciones(HashMap<String, Atraccion> mapa_atracciones) {
		this.mapa_atracciones = mapa_atracciones;
	}

	public HashMap<String, TreeSet<Atraccion>> getMapa_atracciones_tipos() {
		return mapa_atracciones_tipos;
	}

	public void setMapa_atracciones_tipos(HashMap<String, TreeSet<Atraccion>> mapa_atracciones_tipos) {
		this.mapa_atracciones_tipos = mapa_atracciones_tipos;
	}

	public String obtenerTipoAtraccion(String nombre_atraccion) {
		return this.mapa_atracciones.get(nombre_atraccion).getTipo();
	}

	public HashMap<String, TreeSet<Promocion>> getMapa_promos_tipos() {
		return mapa_promos_tipos;
	}

	public void setMapa_promos_tipos(HashMap<String, TreeSet<Promocion>> mapa_promos_tipos) {
		this.mapa_promos_tipos = mapa_promos_tipos;
	}

	public HashMap<String, TreeSet<Promocion>> getMapa_no_preferencia_promociones() {
		return mapa_no_preferencia_promociones;
	}

	public HashMap<String, TreeSet<Atraccion>> getMapa_no_preferencia_atraccion() {
		return mapa_no_preferencia_atraccion;
	}

	// A partir de aca se ordenan los arboles que se usan para mostrar Promos y
	// Atracciones que no le gustan
	public void ordenarNoPreferencias() {
		this.mapa_no_preferencia_promociones = new HashMap<String, TreeSet<Promocion>>();
		this.mapa_no_preferencia_atraccion = new HashMap<String, TreeSet<Atraccion>>();
		String[] tipos = this.mapa_promos_tipos.keySet().toArray(new String[mapa_promos_tipos.size()]);
		// contiene todas las preferencias, los tipo_atraccion
		for (int i = 0; i < tipos.length; i++) {
			this.mapa_no_preferencia_promociones.put(tipos[i], this.obtenerArbolPromocionSinTipo(tipos[i]));
		}

		for (int i = 0; i < tipos.length; i++) {
			this.mapa_no_preferencia_atraccion.put(tipos[i], this.obtenerArbolAtraccionSinTipo(tipos[i]));
		}
	}

	// Recibe una preferencia, un tipo_atraccion y carga un
	// arbol con Promociones que NO sean de esa preferencia
	private TreeSet<Promocion> obtenerArbolPromocionSinTipo(String descartar_tipo) {
		TreeSet<Promocion> arbol_sin_tipo = new TreeSet<Promocion>();
		// entry contiene el par <String,TreeSet>
		for (Map.Entry<String, TreeSet<Promocion>> entry : this.mapa_promos_tipos.entrySet()) {
			// Si el tipo_atraccion != tipo_atraccion en el mapa
			if (!descartar_tipo.equals(entry.getKey())) {
				// Viaja por cada Promocion del TreeSet de ese tipo_atraccion
				for (Promocion promocion_actual : entry.getValue()) {
					arbol_sin_tipo.add(promocion_actual);
				}
			}
		}
		return arbol_sin_tipo;
	}
	// Recibe la preferencia, el tipo_atraccion y carga un
	// arbol con Atracciones que no sean de esa preferencia
	private TreeSet<Atraccion> obtenerArbolAtraccionSinTipo(String descartar_tipo) {
		TreeSet<Atraccion> arbol_sin_tipo = new TreeSet<Atraccion>();
		for (Map.Entry<String, TreeSet<Atraccion>> entry : this.mapa_atracciones_tipos.entrySet()) {
			if (!descartar_tipo.equals(entry.getKey())) {
				for (Atraccion atraccion_actual : entry.getValue()) {
					arbol_sin_tipo.add(atraccion_actual);
				}
			}
		}
		return arbol_sin_tipo;
	}

	public Atraccion obtenerAtraccion(String nombre_atraccion) {
		return this.mapa_atracciones.get(nombre_atraccion);
	}
}
