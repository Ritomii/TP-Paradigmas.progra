package sistema.promociones;

import sistema.atracciones.Atraccion;

public class PromocionCombo extends Promocion {
	private Atraccion atraccion_gratis;

	public PromocionCombo(String nombre, Atraccion[] atracciones, String tipo_promocion, Atraccion atraccion_gratis) {
		super(nombre, atracciones, tipo_promocion);
		this.atraccion_gratis = atraccion_gratis;
		this.precio_mostrar = this.precio_original;
	}

	public Atraccion getAtraccion_gratis() {
		return atraccion_gratis;
	}

	@Override
	public double getDuracion() {
		return duracion + this.atraccion_gratis.getTiempoPromedio();
	}
	
	@Override
	public boolean tieneCupo() {
		return super.tieneCupo() && this.atraccion_gratis.tieneCupo();
	}

	@Override
	public void comprar() {
		super.comprar();
		this.atraccion_gratis.comprar();
	}

	@Override
	public String toString() {
		return super.toString() + "Atraccion gratis: " + this.atraccion_gratis.getNombre() + "\nAhorro: $"
				+ atraccion_gratis.getCosto() + "\nPrecio final: $" + this.precio_mostrar;
	}
}
