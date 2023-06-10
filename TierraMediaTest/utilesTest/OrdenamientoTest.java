package utilesTest;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import sistema.atracciones.Atraccion;
import sistema.promociones.Promocion;
import sistema.promociones.PromocionAbsoluta;
import sistema.promociones.PromocionCombo;
import sistema.promociones.PromocionPorcentual;

public class OrdenamientoTest {

	Atraccion a1 = new Atraccion("Montania rusa",350.20,1.30,20,"Aventura");
	Atraccion a2 = new Atraccion("Glaciar Perito Moreno",600.50,2.00,15,"Paisaje");
	Atraccion a3 = new Atraccion("Sierras Cordobesas",400,1.00,30,"Paisaje");
	Atraccion a4 = new Atraccion("Parrilla",245.10,3.00,40,"Degustacion");
	Atraccion a5=  new Atraccion("Cerro Catedral",650.0,2.30,20,"Paisaje");
	Atraccion a6 = new Atraccion("Escalada",500.0,3.00,20,"Aventura");
	Atraccion a7 = new Atraccion("Fogon",200.0,3.00,10,"Aventura");
	Atraccion a8 = new Atraccion("Paracaidismo",200.0,3.00,10,"Aventura");
	Atraccion a9 = new Atraccion("Fogon",200.0,5.00,10,"Degustacion");
	Atraccion a10 = new Atraccion("Fogon",200.0,3.00,10,"Degustacion");
	
	
	
	
	
	@Test
	public void ordenamientoAtracciones() { //Se prueba que el ordenamiento en una estructura de Atracciones sea el correcto.
		
		ArrayList<Atraccion> ordenamientoAtraccionEsperado = new ArrayList<Atraccion>();
		ArrayList <Atraccion> ordenamientoAtraccionReal = new ArrayList<Atraccion>();
		
		ordenamientoAtraccionEsperado.add(a5);
		ordenamientoAtraccionEsperado.add(a2);
		ordenamientoAtraccionEsperado.add(a3);
		ordenamientoAtraccionEsperado.add(a1);
		ordenamientoAtraccionEsperado.add(a4);
		ordenamientoAtraccionEsperado.add(a9);
		ordenamientoAtraccionEsperado.add(a10);
		
		
		ordenamientoAtraccionReal.add(a1);
		ordenamientoAtraccionReal.add(a2);
		ordenamientoAtraccionReal.add(a3);
		ordenamientoAtraccionReal.add(a4);
		ordenamientoAtraccionReal.add(a5);
		ordenamientoAtraccionReal.add(a9);
		ordenamientoAtraccionReal.add(a10);
		
		for(int i= 0; i < ordenamientoAtraccionReal.size(); i++) {
			System.out.println(ordenamientoAtraccionReal.get(i));	
		}
		
		System.out.println("----------Ordenando----------");
		Collections.sort(ordenamientoAtraccionReal);
		
		
		for(int i= 0; i < ordenamientoAtraccionReal.size(); i++) {
			System.out.println(ordenamientoAtraccionReal.get(i));	
		}
		
		Assert.assertEquals(ordenamientoAtraccionEsperado,ordenamientoAtraccionReal);
		
	}
	
	@Test
	public void ordenamientoPromociones() { //Se prueba que el ordenamiento en una estructura de Promociones de un tipo especifico sea el correcto.
		ArrayList<PromocionAbsoluta> ordenamientoPromocionReal = new ArrayList<PromocionAbsoluta>();
		ArrayList<PromocionAbsoluta> ordenamientoPromocionEsperado = new ArrayList<PromocionAbsoluta>();
		
		
		
		Atraccion [] atr_paisaje = new Atraccion[2];
		atr_paisaje[0] = a2;
		atr_paisaje[1] = a3;
		
		Atraccion [] atr_degustacion = new Atraccion[2];
		atr_degustacion[0] = a4;
		atr_degustacion[1] = a9;
		
		Atraccion[] atr_aventura = new Atraccion[2];
		atr_aventura[0] = a1;
		atr_aventura[1] = a7;
		
		PromocionAbsoluta p1 = new PromocionAbsoluta("Alta montania", 2, atr_paisaje, "Paisaje", 200);
		PromocionAbsoluta p2 = new PromocionAbsoluta("Ruta los 7 lagos", 2, atr_degustacion, "Paisaje", 100);
		PromocionAbsoluta p3 = new PromocionAbsoluta("Kick Buttowski", 2, atr_aventura, "Paisaje", 300);
		
		ordenamientoPromocionEsperado.add(p1);
		ordenamientoPromocionEsperado.add(p2);
		ordenamientoPromocionEsperado.add(p3);
		
		
		ordenamientoPromocionReal.add(p3);
		ordenamientoPromocionReal.add(p1);
		ordenamientoPromocionReal.add(p2);
		
		for(int i = 0; i < ordenamientoPromocionReal.size(); i++) {
			System.out.println(ordenamientoPromocionReal.get(i));
		}
		
		System.out.println("----------Ordenando----------");
		Collections.sort(ordenamientoPromocionReal);

		for(int i = 0; i < ordenamientoPromocionReal.size(); i++) {
			System.out.println(ordenamientoPromocionReal.get(i));
		}
		
		Assert.assertEquals(ordenamientoPromocionReal, ordenamientoPromocionEsperado);
	}
}
