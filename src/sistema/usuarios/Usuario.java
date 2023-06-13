package sistema.usuarios;

import java.util.ArrayList;
import java.util.HashSet;

import sistema.atracciones.Atraccion;
import sistema.promociones.Promocion;
import sistema.promociones.PromocionCombo;

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
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String salidaUsuario() {
		String info_usuario = this.toString();
		
		String separador_informacion = "\n---------------------------------------\n";
		
		boolean compro_promociones = !this.lista_promociones.isEmpty();
		String promociones_compradas = 
				compro_promociones ? 
						"Compro las siguientes promociones:\n":
							"El usuario no registra promociones compradas\n";
		
		if(compro_promociones)
			for (Promocion promocion : this.lista_promociones) {
				promociones_compradas += promocion.toString();
			}
		
		boolean compro_atracciones = !this.lista_atracciones.isEmpty();
		String atracciones_compradas = 
				compro_atracciones ?
						"Compro las siguientes atracciones:\n":
							"El usuario no registra atracciones compradas\n";
		
		if(compro_atracciones)
			for (Atraccion atraccion : lista_atracciones) {
				atracciones_compradas += atraccion.toString();
			}
		
		return info_usuario +
				separador_informacion +
				promociones_compradas +
				separador_informacion +
				atracciones_compradas +
				separador_informacion;
	}
	
	@Override
	public String toString() {
		return	"Usuario: " + nombre + 
				"\nPreferencia: " + preferencia + 
				"\nPresupuesto restante: " + dinero + 
				"\nTiempo restante: " + tiempo + "\n";
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
		Atraccion[] atracciones_promo = promo.getVector_atracciones();
		
		for (int i = 0; i < atracciones_promo.length && !tiene_aceptada; i++) {
			if(set_atracciones_aceptadas.contains(atracciones_promo[i].getNombre()))
				tiene_aceptada = true;
		}
		return tiene_aceptada;
	}
	
	public void agregarPromocion(Promocion promo) {
		this.lista_promociones.add(promo);
		Atraccion[] atracciones_promo = promo.getVector_atracciones();
		
		for (int i = 0; i < atracciones_promo.length; i++) {
			this.set_atracciones_aceptadas.add(atracciones_promo[i].getNombre());
		}
		
		if(promo.getTipo_promocion().equals("Gratis")) {
			Atraccion gratis_incluida = ((PromocionCombo) promo).getAtraccion_gratis();
			this.set_atracciones_aceptadas.add(gratis_incluida.getNombre());
		}
		
		this.dinero -= promo.getPrecio_mostrar();
		this.tiempo -= promo.getDuracion();
		promo.comprar();
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
		this.dinero -= atraccion.getCosto();
		this.tiempo -= atraccion.getTiempoPromedio();
		atraccion.comprar();
	}
}
