package sistema.promociones;

import sistema.atracciones.Atraccion;

public class PromocionPorcentual extends Promocion{
	private double precioFinal;
	
	public PromocionPorcentual(Atraccion[] atracciones, double duracion, double precioOriginal,double porcentaje) {
		super(atracciones, duracion, precioOriginal);
		this.precioFinal = ((this.precioOriginal*porcentaje)/100);
	}
	
	public double getPrecioFinal() {
		return this.precioFinal;
	}
}
