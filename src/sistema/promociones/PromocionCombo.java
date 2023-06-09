package sistema.promociones;

import sistema.atracciones.Atraccion;

public class PromocionCombo extends Promocion {
	private String nombre_atraccion_gratis;

	public PromocionCombo(String nombre, int cant_atracciones, Atraccion[] atracciones, String tipo_promocion,
			String nombre_atraccion_gratis) {
		super(nombre, cant_atracciones, atracciones, tipo_promocion);
		this.nombre_atraccion_gratis = nombre_atraccion_gratis;
		this.precio_mostrar = this.precio_original;
	}

	public String getAtraccionGratis() {
		return this.nombre_atraccion_gratis;
	}

	@Override
	public String toString() {
		String atracciones = this.obtenerAtraccionesIncluidas();
		return "Promocion:" + nombre + "\n-Atracciones incluidas: " + atracciones + "\n-Atraccion gratuita: "
				+ nombre_atraccion_gratis + "\n-Duracion=" + duracion + "\n-Precio original: " + precio_original
				+ "\n-Precio combo: " + precio_mostrar + "\n";
	}
}
