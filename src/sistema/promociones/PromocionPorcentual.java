package sistema.promociones;

import sistema.atracciones.Atraccion;

public class PromocionPorcentual extends Promocion{
	private double descuento;

//	public PromocionPorcentual(String nombre, int cant_atracciones, Atraccion [] atracciones, String tipo_promocion,
//			double descuento) {
//		super(nombre, cant_atracciones, atracciones , tipo_promocion);
//		this.descuento = descuento;
//		this.precio_mostrar -= ((this.precio_original*descuento)/100);
//	}
	
	public PromocionPorcentual(String nombre, Atraccion[] atracciones, String tipo_promocion, double porcentaje) {
        super(nombre, atracciones, tipo_promocion);
        this.descuento = this.precio_original * porcentaje / 100;
        this.precio_mostrar = this.precio_original - this.descuento;
    }
	
	public double getDescuento() {
		return this.descuento;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Descuento: " + this.descuento + "%" + "\n";
	}
	
}
