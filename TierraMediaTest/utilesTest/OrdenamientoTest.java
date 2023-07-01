package utilesTest;

import org.junit.Assert;

import java.util.TreeSet;

import org.junit.Test;

import sistema.atracciones.Atraccion;
import sistema.promociones.Promocion;
import sistema.promociones.PromocionAbsoluta;
import sistema.promociones.PromocionCombo;
import sistema.promociones.PromocionPorcentual;

public class OrdenamientoTest {

	Atraccion a1 = new Atraccion("Montania rusa", 350.20, 1.30, 20, "Aventura");
	Atraccion a2 = new Atraccion("Glaciar Perito Moreno", 600.50, 2.00, 15, "Paisaje");
	Atraccion a3 = new Atraccion("Sierras Cordobesas", 400, 1.00, 30, "Paisaje");
	Atraccion a4 = new Atraccion("Parrilla", 245.10, 3.00, 40, "Degustacion");
	Atraccion a5 = new Atraccion("Cerro Catedral", 650.0, 2.30, 20, "Paisaje");
	Atraccion a6 = new Atraccion("Escalada", 500.0, 3.00, 20, "Aventura");
	Atraccion a7 = new Atraccion("Fogon", 200.0, 3.00, 10, "Aventura");
	Atraccion a8 = new Atraccion("Paracaidismo", 200.0, 3.00, 10, "Aventura");
	Atraccion a9 = new Atraccion("Fogon", 200.0, 5.00, 10, "Degustacion");
	Atraccion a10 = new Atraccion("Fogon", 200.0, 3.00, 10, "Degustacion");

	@Test
	public void ordenamientoAtracciones() { // Testea que los arboles de atracciones
		// se generen con un orden correcto y ademas testea el toString de Atraccion
		TreeSet<Atraccion> arbolAtracciones = new TreeSet<Atraccion>();
		Atraccion[] atraccionesOrdenadas = new Atraccion[10];
		atraccionesOrdenadas[0] = a5;
		atraccionesOrdenadas[1] = a2;
		atraccionesOrdenadas[2] = a6;
		atraccionesOrdenadas[3] = a3;
		atraccionesOrdenadas[4] = a1;
		atraccionesOrdenadas[5] = a4;
		atraccionesOrdenadas[6] = a9;
		atraccionesOrdenadas[7] = a7;
		atraccionesOrdenadas[8] = a10;
		atraccionesOrdenadas[9] = a8;

		arbolAtracciones.add(a1);
		arbolAtracciones.add(a2);
		arbolAtracciones.add(a3);
		arbolAtracciones.add(a4);
		arbolAtracciones.add(a5);
		arbolAtracciones.add(a6);
		arbolAtracciones.add(a7);
		arbolAtracciones.add(a8);
		arbolAtracciones.add(a9);
		arbolAtracciones.add(a10);

		System.out.println(arbolAtracciones);
		Assert.assertArrayEquals(atraccionesOrdenadas, arbolAtracciones.toArray());
	}

	@Test
	public void ordenamientoPromociones() { // Testea que los arboles de promociones se generen
		// con un orden correcto y ademas testea el toString de Promocion y sus
		// derivadas.
		TreeSet<Promocion> arbolPromociones = new TreeSet<Promocion>();
		Promocion[] promocionesOrdenadas = new Promocion[3];

		Atraccion[] atr_paisaje = new Atraccion[2];
		atr_paisaje[0] = a2;
		atr_paisaje[1] = a3;
		// $1000
		Atraccion[] atr_degustacion = new Atraccion[2];
		atr_degustacion[0] = a4;
		atr_degustacion[1] = a9;
		// $445.10
		Atraccion[] atr_aventura = new Atraccion[2];
		atr_aventura[0] = a1;
		atr_aventura[1] = a7;
		// $550.20
		PromocionCombo p1 = new PromocionCombo("Ruta los 7 lagos", atr_degustacion, "Degustacion", a10);// $445.10
		PromocionAbsoluta p2 = new PromocionAbsoluta("Alta montania", atr_paisaje, "Paisaje", 700);// $700
		PromocionPorcentual p3 = new PromocionPorcentual("Kick Buttowski", atr_aventura, "Aventura", 20);// $440.16

		promocionesOrdenadas[0] = p2;
		promocionesOrdenadas[1] = p1;
		promocionesOrdenadas[2] = p3;

		arbolPromociones.add(p1);
		arbolPromociones.add(p2);
		arbolPromociones.add(p3);

		System.out.println(arbolPromociones);
		Assert.assertArrayEquals(promocionesOrdenadas, arbolPromociones.toArray());
	}
}
