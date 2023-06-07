package sistema.promociones;

import sistema.atracciones.Atraccion;

public class PromocionAbsoluta extends Promocion{
	private int descuento;

	public PromocionAbsoluta(String nombre, int cant_atracciones, Atraccion [] atracciones, String tipo_promocion,
			int descuento) {
		super(nombre, cant_atracciones, atracciones , tipo_promocion);
		this.descuento = descuento;
		this.precio_mostrar = this.precio_mostrar - descuento;
	}
	
	public int getDescuento() {
		return this.descuento;
	}
	
}
