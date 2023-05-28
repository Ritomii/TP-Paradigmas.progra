package sistema.promociones;

import sistema.atracciones.Atraccion;

public class PromocionCombo extends Promocion{
	private Atraccion extra;
	
	public PromocionCombo(Atraccion[] atracciones, double duracion, double precioOriginal, Atraccion nueva) {
		super(atracciones, duracion, precioOriginal);
		this.extra = nueva;
	}
	
	public Atraccion getExtra() {
		return this.extra;
	}
}
