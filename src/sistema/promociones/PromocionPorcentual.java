package sistema.promociones;

import sistema.atracciones.Atraccion;

public class PromocionPorcentual extends Promocion {
	private double porcentaje;
	private double descuento;

	public PromocionPorcentual(String nombre, Atraccion[] atracciones, String tipo_promocion, double porcentaje) {
		super(nombre, atracciones, tipo_promocion);
		this.descuento = this.precio_original * porcentaje / 100;
		this.precio_mostrar = this.precio_original - this.descuento;
		this.porcentaje = porcentaje;
	}

	@Override
	public String toString() {
		return super.toString() + "Porcentaje de descuento: % " + this.porcentaje + "\nAhorro: $"
				+ String.format("%.2f", this.descuento) + "\nPrecio final: $" + this.precio_mostrar;
	}

}
