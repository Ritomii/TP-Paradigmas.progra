package sistema.promociones;

import sistema.atracciones.Atraccion;

public class PromocionCombo extends Promocion{
	private String nombre_atraccion_gratis;

	public PromocionCombo(String nombre, int cant_atracciones, Atraccion [] atracciones, String tipo_promocion,
			String nombre_atraccion_gratis) {
		super(nombre, cant_atracciones, atracciones , tipo_promocion);
		this.nombre_atraccion_gratis = nombre_atraccion_gratis;
		this.precio_mostrar = this.precio_original;
	}
	
	public String getAtraccionGratis() {
		return this.nombre_atraccion_gratis;
	}
	
}
