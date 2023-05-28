package sistema.promociones;

import sistema.atracciones.Atraccion;

public class PromocionAbsoluta extends Promocion{
	private double precioFinal;
	
	public PromocionAbsoluta(Atraccion[] atracciones, double duracion, double precioOriginal, double montoDescuento) {
		super(atracciones, duracion, precioOriginal);
		this.precioFinal = this.precioOriginal - montoDescuento;
	}
	
	public double getPrecioFinal() {
		return this.precioFinal;
	}
}
