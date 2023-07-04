package sistema.promociones;

import org.junit.Assert;
import org.junit.Test;

import sistema.atracciones.Atraccion;

public class PromocionesTest {

	/*
	 * LAS PROMOCIONES ENTRAN POR ARCHIVO CON SU TIPO Y AVENTURAS
	 * CORRESPONDIENTES* ENTRAN CON EL FORMATO: NOMBRE CATEGORIA CANTIDAD DE
	 * ATRACCIONES NOMBRE DE LAS ATRACCIONES TIPO DE PROMOCION (DESCUENTO FIJO,
	 * DESCEUNTO PORCENTUAL,ATRACCION GRATUITA) TIPO APLICADO
	 */
	Atraccion a1 = new Atraccion("Glaciar Perito Moreno", 600.50, 2.00, 15, "Paisaje");
	Atraccion a2 = new Atraccion("Sierras Cordobesas", 400, 1.00, 30, "Paisaje");
	Atraccion a3 = new Atraccion("Tafy del Valle", 500, 1.00, 30, "Paisaje");

	Atraccion atraccionPaisaje[] = { a1, a2 };
	Atraccion atraccionPaisaje2[] = { a1, a3 };

	Promocion promoPorcentualPrueba;
	Promocion promoAbsPrueba;
	Promocion promoAtrFreePrueba;

	@Test
	public void promosAbsPrecio() {

		// nombre_promocion, atracciones, tipo, precio_final
		this.promoAbsPrueba = new PromocionAbsoluta("Paseo del cielo", atraccionPaisaje, "Paisaje", 150.0);
		double precioReal = promoAbsPrueba.getPrecio_mostrar();
		double precioEsperado = 150;

		Assert.assertEquals(precioEsperado, precioReal, 0.001);
	}

	@Test
	public void promosPorcentualPrecio() {

		// nombre_promocion, atracciones, tipo, porcentaje_descontado
		this.promoPorcentualPrueba = new PromocionPorcentual("Paseo del cielo", atraccionPaisaje, "Paisaje", 10.5);
		double precioReal = promoPorcentualPrueba.getPrecio_mostrar();
		double precioEsperado = 895.4475;

		Assert.assertEquals(precioEsperado, precioReal, 0.001);
	}

	@Test
	public void promosGratisPrecio() {

		// nombre_promocion, atracciones, tipo, atraccion_gratis
		this.promoAtrFreePrueba = new PromocionCombo("Paseo del cielo extendido", atraccionPaisaje, "Paisaje", a3);
		double precioReal = promoAtrFreePrueba.getPrecio_mostrar();
		double precioEsperado = 1000.5;

		Assert.assertEquals(precioEsperado, precioReal, 0.001);
	}

}
