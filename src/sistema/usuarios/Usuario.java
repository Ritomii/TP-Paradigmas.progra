package sistema.usuarios;

import java.util.ArrayList;
import java.util.HashSet;

import sistema.atracciones.Atraccion;
import sistema.promociones.Promocion;

public class Usuario {
	private String nombre;
	private String preferencia;
	private int dinero;
	private double tiempo;

	HashSet<String> set_atracciones_aceptadas = new HashSet<String>();
	ArrayList<Promocion> lista_promociones = new ArrayList<Promocion>();
	ArrayList<Atraccion> lista_atracciones = new ArrayList<Atraccion>();
	
	public Usuario(String nombre, String preferencia, int dinero, double tiempo) {
		this.nombre = nombre;
		this.preferencia = preferencia;
		this.dinero = dinero;
		this.tiempo = tiempo;
	}

	public String getPreferencia() {
		return preferencia;
	}
	
	//A partir de aca, revisar comparaciones para ints y doubles.
	//Revisar que el filtro sea suficiente
	public boolean puedeComprarPromocion(Promocion promo) {
		return this.dinero >= promo.getPrecio_mostrar()
				&& this.tiempo >= promo.getDuracion()
				&& promo.tieneCupo()
				&& !this.tieneAceptada(promo);
	}
	
	private boolean tieneAceptada(Promocion promo) {
		boolean tiene_aceptada = false;
		String[] nombres_atracciones = promo.obtenerNombresAtracciones();
		for (int i = 0; i < nombres_atracciones.length && !tiene_aceptada; i++) {
			if(set_atracciones_aceptadas.contains(nombres_atracciones[i]))
				tiene_aceptada = true;
		}
		return tiene_aceptada;
	}
	
	public void agregarPromocion(Promocion promo) {
		this.lista_promociones.add(promo);
		String[] nombres_atracciones = promo.obtenerNombresAtracciones();
		for (int i = 0; i < nombres_atracciones.length; i++) {
			this.set_atracciones_aceptadas.add(nombres_atracciones[i]);
		}
	}
	
	public boolean puedeComprarAtraccion(Atraccion atraccion) {
		return this.dinero >= atraccion.getCosto()
				&& this.tiempo >= atraccion.getTiempoPromedio()
				&& atraccion.tieneCupo()
				&& !this.tieneAceptada(atraccion);
	}
	
	private boolean tieneAceptada(Atraccion atraccion) {
		return this.set_atracciones_aceptadas.contains(atraccion.getNombre());
	}
	
	public void agregarAtraccion(Atraccion atraccion) {
		this.set_atracciones_aceptadas.add(atraccion.getNombre());
		this.lista_atracciones.add(atraccion);
	}
}
