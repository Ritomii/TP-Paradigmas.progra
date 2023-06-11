package sistema.promociones;

import sistema.atracciones.Atraccion;

public class PromocionAbsoluta extends Promocion{
	private double descuento;// NO DEBERÍA IR PERO SI LO NECESITO PARA ALGO...
	
    public PromocionAbsoluta(String nombre, Atraccion[] atracciones, String tipo_promocion, double precio_absoluto) {
        // No viene un descuento sino un precio absoluto por todo el paquete
        super(nombre, atracciones, tipo_promocion);
        // this.descuento = descuento;
        // this.precio_mostrar = this.precio_original - descuento;
        this.descuento = this.precio_original - precio_absoluto;//...LO CALCULO ASI
        this.precio_mostrar = precio_absoluto;
    }
	
	public double getDescuento() {
		return this.descuento;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Descuento: $" + this.descuento + "\n";
	}
	
}
