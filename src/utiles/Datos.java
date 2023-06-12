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

	/* A partir de aca se cargan los arboles ordenados que se usaran para las
	 * no preferencias de los usuarios.*/
	public void ordenarNoPreferencias() {
		this.mapa_no_preferencia_promociones = new HashMap<String, TreeSet<Promocion>>();
		this.mapa_no_preferencia_atraccion = new HashMap<String, TreeSet<Atraccion>>();
		
		String[] tipos_promos = this.mapa_promos_tipos.keySet().toArray(new String[mapa_promos_tipos.size()]);
		String[] tipos_atraccion = this.mapa_atracciones_tipos.keySet().toArray(new String[mapa_atracciones_tipos.size()]);
		
		// contiene todas las preferencias, los tipo_atraccion
		if(!this.mapa_promos_tipos.isEmpty())
			for (int i = 0; i < tipos_promos.length; i++) {
				this.mapa_no_preferencia_promociones.put(tipos_promos[i], this.obtenerArbolPromocionSinTipo(tipos_promos[i]));
			}

		for (int i = 0; i < tipos_atraccion.length; i++) {
			this.mapa_no_preferencia_atraccion.put(tipos_atraccion[i], this.obtenerArbolAtraccionSinTipo(tipos_atraccion[i]));
		}
		
		this.mapa_no_preferencia_atraccion.put("SinPreferencia", this.calcularArbolTotalAtraccion());
		this.mapa_no_preferencia_promociones.put("SinPreferencia", this.calcularArbolTotalPromocion());
	}

	private TreeSet<Promocion> calcularArbolTotalPromocion(){
		TreeSet<Promocion> arbol_sin_tipo = new TreeSet<Promocion>();
		// entry contiene el par <String,TreeSet>
		for (Map.Entry<String, TreeSet<Promocion>> entry : this.mapa_promos_tipos.entrySet()) {
			// Si el tipo_atraccion != tipo_atraccion en el mapa
				// Viaja por cada Promocion del TreeSet de ese tipo_atraccion
			for (Promocion promocion_actual : entry.getValue()) {
				arbol_sin_tipo.add(promocion_actual);
			}

		}
		return arbol_sin_tipo;
	}
	
	private TreeSet<Atraccion> calcularArbolTotalAtraccion(){
		TreeSet<Atraccion> arbol_sin_tipo = new TreeSet<Atraccion>();
		for (Map.Entry<String, TreeSet<Atraccion>> entry : this.mapa_atracciones_tipos.entrySet()) {
			for (Atraccion atraccion_actual : entry.getValue()) {
				arbol_sin_tipo.add(atraccion_actual);
			}
		}
		return arbol_sin_tipo;
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
