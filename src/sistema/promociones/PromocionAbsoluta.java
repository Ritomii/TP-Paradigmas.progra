package sistema.promociones;

import sistema.atracciones.Atraccion;

public class PromocionAbsoluta extends Promocion{
	private int descuento;
	// en el otro no hay cant_atracciones
	public PromocionAbsoluta(String nombre, int cant_atracciones, Atraccion [] atracciones, String tipo_promocion,
			int descuento) {
		super(nombre, cant_atracciones, atracciones , tipo_promocion);
		this.descuento = descuento;
		this.precio_mostrar = this.precio_original - descuento;
	}
	
	public int getDescuento() {
		return this.descuento;
	}
	
	@Override
	public String toString() {
		String atracciones = this.obtenerAtraccionesIncluidas();
		return "Promocion:" + nombre + "\n-Atracciones incluidas: " + atracciones + "\n-Duracion=" + duracion
				+ "\n-Precio original: " + precio_original + "\n-Por todo el paquete: " + precio_mostrar + "\n";
	}
	
}
