package utiles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

import sistema.atracciones.Atraccion;
import sistema.promociones.Promocion;
import sistema.usuarios.Usuario;

public class Datos {
	LinkedList<Usuario> lista_usuarios;
	
	HashMap<String, Atraccion> mapa_atracciones = new HashMap<String, Atraccion>();
	HashMap<String, TreeSet<Atraccion>> mapa_atracciones_tipos = new HashMap<String, TreeSet<Atraccion>>();
	HashMap<Promocion, ArrayList<Atraccion>> relaciones_promociones = new HashMap<Promocion, ArrayList<Atraccion>>();
	HashMap<String, TreeSet<Promocion>> mapa_promos_tipos = new HashMap<String, TreeSet<Promocion>>();
	
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
	public HashMap<Promocion, ArrayList<Atraccion>> getRelaciones_promociones() {
		return relaciones_promociones;
	}
	public void setRelaciones_promociones(HashMap<Promocion, ArrayList<Atraccion>> relaciones_promociones) {
		this.relaciones_promociones = relaciones_promociones;
	}
	public HashMap<String, TreeSet<Promocion>> getMapa_promos_tipos() {
		return mapa_promos_tipos;
	}
	public void setMapa_promos_tipos(HashMap<String, TreeSet<Promocion>> mapa_promos_tipos) {
		this.mapa_promos_tipos = mapa_promos_tipos;
	}
	
}
