package sistema.promociones;

import org.junit.Assert;

import org.junit.Test;

import sistema.atracciones.Atraccion;

public class TestcompareTo {
	Atraccion a1 = new Atraccion("Montania rusa", 350.20, 1.30, 20, "Aventura");
	Atraccion a2 = new Atraccion("Glaciar Perito Moreno", 600.50, 2.00, 15, "Paisaje");
	Atraccion a3 = new Atraccion("Sierras Cordobesas", 400, 1.00, 30, "Paisaje");
	Atraccion a4 = new Atraccion("Parrilla", 245.10, 3.00, 40, "Degustacion");
	Atraccion a5 = new Atraccion("Cerro Catedral", 650.0, 2.30, 20, "Paisaje");
	Atraccion a6 = new Atraccion("Escalada", 500.0, 3.00, 20, "Aventura");
	Atraccion a7 = new Atraccion("Fogon", 200.0, 3.00, 10, "Aventura");
	Atraccion a8 = new Atraccion("Fogon", 200.0, 3.00, 10, "Aventura");
	Atraccion a9 = new Atraccion("Fogon", 200.0, 5.00, 10, "Degustacion");
	Atraccion a10 = new Atraccion("Fogon", 200.0, 3.00, 10, "Degustacion");

	@Test
	public void promo1Mayor() { 
		Atraccion[] atraccionesPaisaje = new Atraccion[2];
		atraccionesPaisaje[0] = a2;
		atraccionesPaisaje[1] = a3;
		
		Atraccion[] atraccionesDegustacion = new Atraccion[2];
		atraccionesDegustacion[0] = a4;
		atraccionesDegustacion[1] = a9;
		PromocionAbsoluta promoPaisaje = new PromocionAbsoluta("La gran promo", atraccionesPaisaje, "Paisaje", 900);
		PromocionAbsoluta promoDegustacion = new PromocionAbsoluta("Promo Gourmet", atraccionesDegustacion,
				"Degustacion", 380);

		Assert.assertEquals(promoPaisaje.compareTo(promoDegustacion), -1);
		// El compareTo ordena de mayor a menor, por eso este test debe devolver -1.
		// (Paisaje es mayor en precio que Degustacion)
	}

	@Test
	public void promosPreciosIguales() {
		Atraccion[] atraccionesAventura = new Atraccion[2];
		atraccionesAventura[0] = a7;
		atraccionesAventura[1] = a8;
		// Duracion: 6 hs
		Atraccion[] atraccionesDegustacion = new Atraccion[2];
		atraccionesDegustacion[0] = a9;
		atraccionesDegustacion[1] = a10;
		// Duracion: 8 hs
		PromocionAbsoluta promoAventura = new PromocionAbsoluta("La gran promo", atraccionesAventura, "Aventura", 100);
		PromocionAbsoluta promoDegustacion = new PromocionAbsoluta("Promo Gourmet", atraccionesDegustacion,
				"Degustacion", 100);

		Assert.assertEquals(promoAventura.compareTo(promoDegustacion), 1);
		// El compareTo ordena de mayor a menor, por eso este test debe devolver 1.
		// (Aventura es menor en duracion que Degustacion)
	}

	@Test
	public void promo1Menor() {

		Atraccion[] atraccionesDegustacion = new Atraccion[2];
		atraccionesDegustacion[0] = a4;
		atraccionesDegustacion[1] = a10;
		// Costo: $445
		Atraccion[] atraccionesAventura = new Atraccion[2];
		atraccionesAventura[0] = a1;
		atraccionesAventura[1] = a7;
		// Costo: $550
		PromocionAbsoluta promoDegustacion = new PromocionAbsoluta("Promo Gourmet", atraccionesDegustacion,
				"Degustacion", 350);
		PromocionAbsoluta promoAventura = new PromocionAbsoluta("La gran promo", atraccionesAventura, "Aventura", 490);

		Assert.assertEquals(promoDegustacion.compareTo(promoAventura), 1);
		// El compareTo ordena de mayor a menor, por eso este test debe devolver 1.
		// (Degustacion es menor en precio que Aventura)
	}
}
