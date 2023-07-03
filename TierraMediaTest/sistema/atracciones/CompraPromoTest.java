package sistema.atracciones;

import org.junit.Assert;
import org.junit.Test;

import sistema.promociones.Promocion;
import sistema.promociones.PromocionCombo;
import sistema.usuarios.Usuario;

public class CompraPromoTest {

	Atraccion a1 = new Atraccion("Glaciar Perito Moreno", 600.50, 2.00, 15, "Paisaje");
	Atraccion a2 = new Atraccion("Tafy del Valle", 500, 1.00, 30, "Paisaje");

	Atraccion atraccionesPaisaje[] = { a1 };

	Promocion promocion = new PromocionCombo("Paseo del cielo extendido", atraccionesPaisaje, "Paisaje", a2);

	Usuario uss = new Usuario("Juan", "Paisaje", 2000, 15);

	@Test
	public void reduceCupoCompraPromo() {

		this.uss.agregarPromocion(promocion);
		int esperado = 14;
		int real = a1.getCupoDiario();

		Assert.assertEquals(esperado, real);
	}
	
	@Test
	public void reduceCupoAtrFreeCompraPromo() {

		this.uss.agregarPromocion(promocion);
		int esperado = 29;
		int real = a2.getCupoDiario();

		Assert.assertEquals(esperado, real);
	}

}
