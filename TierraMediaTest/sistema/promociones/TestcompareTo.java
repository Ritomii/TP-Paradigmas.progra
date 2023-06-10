package sistema.promociones;

import  org.junit.Assert;

import org.junit.Test;

import sistema.atracciones.Atraccion;

public class TestcompareTo {
	Atraccion a1 = new Atraccion("Montania rusa",350.20,1.30,20,"Aventura");
	Atraccion a2 = new Atraccion("Glaciar Perito Moreno",600.50,2.00,15,"Paisaje");
	Atraccion a3 = new Atraccion("Sierras Cordobesas",400,1.00,30,"Paisaje");
	Atraccion a4 = new Atraccion("Parrilla",245.10,3.00,40,"Degustacion");
	Atraccion a5=  new Atraccion("Cerro Catedral",650.0,2.30,20,"Paisaje");
	Atraccion a6 = new Atraccion("Escalada",500.0,3.00,20,"Aventura");
	Atraccion a7 = new Atraccion("Fogon",200.0,3.00,10,"Aventura");
	Atraccion a8 = new Atraccion("Fogon",200.0,3.00,10,"Aventura");
	Atraccion a9 = new Atraccion("Fogon",200.0,5.00,10,"Degustacion");
	Atraccion a10 = new Atraccion("Fogon",200.0,3.00,10,"Degustacion");

	@Test
	public void promo1Mayor() {  //El compareTo ordena de mayor a menor, por eso este test debe devolver -1.
			Atraccion [] atraccionesPaisaje = new Atraccion[2];
			atraccionesPaisaje[0] = a2; 
			atraccionesPaisaje[1] = a3;
			
			Atraccion [] atraccionesDegustacion = new Atraccion[2];
			atraccionesDegustacion[0] = a4;
			atraccionesDegustacion[1] = a7;
			PromocionAbsoluta promoPaisaje = new PromocionAbsoluta("La gran promo",2,atraccionesPaisaje,"Paisaje",100); //precio: 1000.50 horas: 3
			PromocionAbsoluta promoDegustacion = new PromocionAbsoluta("Promo Gourmet",2,atraccionesDegustacion,"Degustacion",100); //precio 445.10 horas: 6
			
			Assert.assertEquals(promoPaisaje.compareTo(promoDegustacion), -1);
	}
	
	@Test
	public void promosPreciosIguales() {
			Atraccion [] atraccionesPaisaje = new Atraccion[2];
			atraccionesPaisaje[0] = a7; 
			atraccionesPaisaje[1] = a8;
			
			Atraccion [] atraccionesDegustacion = new Atraccion[2];
			atraccionesDegustacion[0] = a9;
			atraccionesDegustacion[1] = a10;
			PromocionAbsoluta promoPaisaje = new PromocionAbsoluta("La gran promo",2,atraccionesPaisaje,"Paisaje",100); //precio: 1000.50 horas: 3
			PromocionAbsoluta promoDegustacion = new PromocionAbsoluta("Promo Gourmet",2,atraccionesDegustacion,"Degustacion",100); //precio 445.10 horas: 6
			
			Assert.assertEquals(promoPaisaje.compareTo(promoDegustacion), -1);
	}
	
	@Test
	public void promo1Menor() {  //El compareTo ordena de mayor a menor, por eso este test debe devolver 1.
			
			Atraccion [] atraccionesDegustacion = new Atraccion[2];
			atraccionesDegustacion[0] = a4;
			atraccionesDegustacion[1] = a7;
			
			Atraccion [] atraccionesAventura = new Atraccion[2];
			atraccionesAventura[0] = a1; 
			atraccionesAventura[1] = a7;
			PromocionAbsoluta promoDegustacion = new PromocionAbsoluta("Promo Gourmet",2,atraccionesDegustacion,"Degustacion",100); //precio 445.10 horas: 6
			PromocionAbsoluta promoAventura = new PromocionAbsoluta("La gran promo",2,atraccionesAventura,"Paisaje",100); //precio: 1000.50 horas: 3
			
			Assert.assertEquals(promoDegustacion.compareTo(promoAventura), 1);
	}
}
