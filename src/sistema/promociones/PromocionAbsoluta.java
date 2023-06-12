package sistema.promociones;

import sistema.atracciones.Atraccion;

public class PromocionAbsoluta extends Promocion{
	
    public PromocionAbsoluta(String nombre, Atraccion[] atracciones, String tipo_promocion, double precio_absoluto) {
        super(nombre, atracciones, tipo_promocion);
        this.precio_mostrar = precio_absoluto;
    }
	
	@Override
	public String toString() {
		return super.toString() +"Precio original: $"+ this.precio_original + "\nDescuento aplicado: $" + String.format("%,.2f", (this.precio_original - this.precio_mostrar)) + "\nPrecio final: $" + this.precio_mostrar  + "\n";
	}
	
}
