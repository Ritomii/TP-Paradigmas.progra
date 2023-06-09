package sistema.promociones;

import sistema.atracciones.Atraccion;

public class PromocionPorcentual extends Promocion{
	private double descuento;

	public PromocionPorcentual(String nombre, int cant_atracciones, Atraccion [] atracciones, String tipo_promocion,
			double descuento) {
		super(nombre, cant_atracciones, atracciones , tipo_promocion);
		this.descuento = descuento;
		this.precio_mostrar -= ((this.precio_original*descuento)/100);
	}
	
	public double getDescuento() {
		return this.descuento;
	}
	
	@Override
	public String toString() {
		String atracciones = this.obtenerAtraccionesIncluidas();
		return "Promocion:" + nombre + "\n-Atracciones incluidas: " + atracciones + "\n-Duracion=" + duracion
				+ "\n-Precio original: " + precio_original + "\n-Precio con descuento: " + precio_mostrar + "\n";
	}
	
}
