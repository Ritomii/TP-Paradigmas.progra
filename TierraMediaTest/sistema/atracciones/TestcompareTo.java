package sistema.atracciones;

import org.junit.Assert;

import org.junit.Test;

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
	public void atraccion1menor() {
		Assert.assertEquals(a1.compareTo(a2),1);
	}
	
	@Test
	public void atraccion1mayor() {
			Assert.assertEquals(a2.compareTo(a1),-1);
	}
	
	@Test
	public void atraccionesIguales() {
			Assert.assertEquals(a7.compareTo(a8),0);
	}
	
	@Test
	public void atraccion1menorPorHoras() {
		Assert.assertEquals(a8.compareTo(a9),1);
	}
	
	@Test
	public void atraccion1mayorPorHoras() {
		Assert.assertEquals(a9.compareTo(a8),-1);
	}
}
	
	
