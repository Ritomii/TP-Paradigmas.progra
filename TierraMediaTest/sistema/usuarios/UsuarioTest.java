package sistema.usuarios;

import static org.junit.Assert.*;

import org.junit.Test;

import sistema.atracciones.Atraccion;
import sistema.promociones.PromocionAbsoluta;
import sistema.promociones.PromocionCombo;
import sistema.promociones.PromocionPorcentual;

public class UsuarioTest {

	@Test
	public void noOfertaAtraccionDinero() {
		Usuario usuario_test = new Usuario("Lucas", "Horror", 5, 10.0);
		Atraccion atrac_test = new Atraccion("Abismo", 20.0, 2.0, 1, "Horror");

		boolean obtenido = usuario_test.puedeComprarAtraccion(atrac_test);
		boolean esperado = false;

		assertEquals(esperado, obtenido);
	}

	@Test
	public void noOfertaAtraccionTiempo() {
		Usuario usuario_test = new Usuario("Lucas", "Horror", 5, 5.0);
		Atraccion atrac_test = new Atraccion("Abismo", 2.0, 20.0, 1, "Horror");

		boolean obtenido = usuario_test.puedeComprarAtraccion(atrac_test);
		boolean esperado = false;

		assertEquals(esperado, obtenido);
	}

	@Test
	public void noOfertaAtraccionCupo() {
		Usuario usuario_test = new Usuario("Lucas", "Horror", 20, 20.0);
		Atraccion atrac_test = new Atraccion("Abismo", 1.0, 5.0, 0, "Horror");

		boolean obtenido = usuario_test.puedeComprarAtraccion(atrac_test);
		boolean esperado = false;

		assertEquals(esperado, obtenido);
	}

	@Test
	public void noOfertaAtraccionComprada() {
		Usuario usuario_test = new Usuario("Lucas", "Horror", 20, 20.0);
		Atraccion atrac_test = new Atraccion("Abismo", 1.0, 5.0, 10, "Horror");

		usuario_test.agregarAtraccion(atrac_test);

		boolean obtenido = usuario_test.puedeComprarAtraccion(atrac_test);
		boolean esperado = false;

		assertEquals(esperado, obtenido);
	}

	@Test
	public void noOfertaPromocionAbsDinero() {
		Usuario usuario_test = new Usuario("Lucas", "Horror", 20, 20.0);

		Atraccion atrac_arr_test[] = { new Atraccion("Abismo", 10.0, 1.0, 10, "Horror"),
				new Atraccion("Supernova", 10.0, 1.0, 2, "Horror"), new Atraccion("Sombras", 20.0, 1.0, 5, "Horror") };

		PromocionAbsoluta promo_abs_test = new PromocionAbsoluta("PromoAbs", atrac_arr_test, "Horror", 30);

		boolean obtenido = usuario_test.puedeComprarPromocion(promo_abs_test);
		boolean esperado = false;

		assertEquals(esperado, obtenido);
	}

	@Test
	public void noOfertaPromocionPorcDinero() {
		Usuario usuario_test = new Usuario("Lucas", "Horror", 20, 20.0);

		Atraccion atrac_arr_test[] = { new Atraccion("Abismo", 10.0, 1.0, 10, "Horror"),
				new Atraccion("Supernova", 10.0, 1.0, 2, "Horror"), new Atraccion("Sombras", 20.0, 1.0, 5, "Horror") };

		PromocionPorcentual promo_porc_test = new PromocionPorcentual("PromoPorc", atrac_arr_test, "Horror", 10.0);

		boolean obtenido = usuario_test.puedeComprarPromocion(promo_porc_test);
		boolean esperado = false;

		assertEquals(esperado, obtenido);
	}

	@Test
	public void noOfertaPromocionComboDinero() {
		Usuario usuario_test = new Usuario("Lucas", "Horror", 20, 20.0);

		Atraccion atrac_arr_test[] = { new Atraccion("Abismo", 10.0, 1.0, 10, "Horror"),
				new Atraccion("Supernova", 10.0, 1.0, 2, "Horror"), new Atraccion("Sombras", 20.0, 1.0, 5, "Horror") };

		Atraccion atrac_gratis = new Atraccion("Solsticio", 25.0, 1.0, 5, "Horror");
		PromocionCombo promo_combo_test = new PromocionCombo("PromoCombo", atrac_arr_test, "Horror", atrac_gratis);

		boolean obtenido = usuario_test.puedeComprarPromocion(promo_combo_test);
		boolean esperado = false;

		assertEquals(esperado, obtenido);
	}

	@Test
	public void noOfertaPromocionAbsTiempo() {
		Usuario usuario_test = new Usuario("Lucas", "Horror", 20, 20.0);

		Atraccion atrac_arr_test[] = { new Atraccion("Abismo", 1.0, 20.0, 10, "Horror"),
				new Atraccion("Supernova", 1.0, 20.0, 2, "Horror"), new Atraccion("Sombras", 2.0, 20.0, 5, "Horror") };

		PromocionAbsoluta promo_abs_test = new PromocionAbsoluta("PromoAbs", atrac_arr_test, "Horror", 3);

		boolean obtenido = usuario_test.puedeComprarPromocion(promo_abs_test);
		boolean esperado = false;

		assertEquals(esperado, obtenido);
	}

	@Test
	public void noOfertaPromocionPorcTiempo() {
		Usuario usuario_test = new Usuario("Lucas", "Horror", 20, 20.0);

		Atraccion atrac_arr_test[] = { new Atraccion("Abismo", 1.0, 20.0, 10, "Horror"),
				new Atraccion("Supernova", 1.0, 20.0, 2, "Horror"), new Atraccion("Sombras", 2.0, 20.0, 5, "Horror") };

		PromocionPorcentual promo_porc_test = new PromocionPorcentual("PromoPorc", atrac_arr_test, "Horror", 10.0);

		boolean obtenido = usuario_test.puedeComprarPromocion(promo_porc_test);
		boolean esperado = false;

		assertEquals(esperado, obtenido);
	}

	@Test
	public void noOfertaPromocionComboTiempo() {
		Usuario usuario_test = new Usuario("Lucas", "Horror", 20, 20.0);

		Atraccion atrac_arr_test[] = { new Atraccion("Abismo", 1.0, 1.0, 10, "Horror"),
				new Atraccion("Supernova", 1.0, 1.0, 2, "Horror"), new Atraccion("Sombras", 2.0, 1.0, 5, "Horror") };

		Atraccion atrac_gratis = new Atraccion("Solsticio", 2.0, 30.0, 5, "Horror");
		PromocionCombo promo_combo_test = new PromocionCombo("PromoCombo", atrac_arr_test, "Horror", atrac_gratis);

		boolean obtenido = usuario_test.puedeComprarPromocion(promo_combo_test);
		boolean esperado = false;

		assertEquals(esperado, obtenido);
	}

	@Test
	public void noOfertaPromocionAbsCupo() {
		Usuario usuario_test = new Usuario("Lucas", "Horror", 20, 20.0);

		Atraccion atrac_arr_test[] = { new Atraccion("Abismo", 1.0, 2.0, 10, "Horror"),
				new Atraccion("Supernova", 1.0, 2.0, 0, "Horror"), new Atraccion("Sombras", 2.0, 2.0, 12, "Horror") };

		PromocionAbsoluta promo_abs_test = new PromocionAbsoluta("PromoAbs", atrac_arr_test, "Horror", 3);

		boolean obtenido = usuario_test.puedeComprarPromocion(promo_abs_test);
		boolean esperado = false;

		assertEquals(esperado, obtenido);
	}

	@Test
	public void noOfertaPromocionPorcCupo() {
		Usuario usuario_test = new Usuario("Lucas", "Horror", 20, 20.0);

		Atraccion atrac_arr_test[] = { new Atraccion("Abismo", 1.0, 2.0, 10, "Horror"),
				new Atraccion("Supernova", 1.0, 2.0, 0, "Horror"), new Atraccion("Sombras", 2.0, 2.0, 5, "Horror") };

		PromocionPorcentual promo_porc_test = new PromocionPorcentual("PromoPorc", atrac_arr_test, "Horror", 10.0);

		boolean obtenido = usuario_test.puedeComprarPromocion(promo_porc_test);
		boolean esperado = false;

		assertEquals(esperado, obtenido);
	}

	@Test
	public void noOfertaPromocionComboCupo() {
		Usuario usuario_test = new Usuario("Lucas", "Horror", 20, 20.0);

		Atraccion atrac_arr_test[] = { new Atraccion("Abismo", 1.0, 1.0, 10, "Horror"),
				new Atraccion("Supernova", 1.0, 1.0, 2, "Horror"), new Atraccion("Sombras", 2.0, 1.0, 5, "Horror") };

		Atraccion atrac_gratis = new Atraccion("Solsticio", 2.0, 3.0, 0, "Horror");
		PromocionCombo promo_combo_test = new PromocionCombo("PromoCombo", atrac_arr_test, "Horror", atrac_gratis);

		boolean obtenido = usuario_test.puedeComprarPromocion(promo_combo_test);
		boolean esperado = false;

		assertEquals(esperado, obtenido);
	}

	@Test
	public void noOfertaPromocionAbsComprada() {
		Usuario usuario_test = new Usuario("Lucas", "Horror", 20, 20.0);
		Atraccion atrac_repetida = new Atraccion("Sombras", 2.0, 2.0, 12, "Horror");

		Atraccion atrac_arr_test[] = { new Atraccion("Abismo", 1.0, 2.0, 10, "Horror"),
				new Atraccion("Supernova", 1.0, 2.0, 5, "Horror"), atrac_repetida };

		usuario_test.agregarAtraccion(atrac_repetida);
		PromocionAbsoluta promo_abs_test = new PromocionAbsoluta("PromoAbs", atrac_arr_test, "Horror", 3);

		boolean obtenido = usuario_test.puedeComprarPromocion(promo_abs_test);
		boolean esperado = false;

		assertEquals(esperado, obtenido);
	}

	@Test
	public void noOfertaPromocionPorcComprada() {
		Usuario usuario_test = new Usuario("Lucas", "Horror", 20, 20.0);
		Atraccion atrac_repetida = new Atraccion("Sombras", 2.0, 2.0, 12, "Horror");

		Atraccion atrac_arr_test[] = { new Atraccion("Abismo", 1.0, 2.0, 10, "Horror"),
				new Atraccion("Supernova", 1.0, 2.0, 5, "Horror"), atrac_repetida };

		usuario_test.agregarAtraccion(atrac_repetida);
		PromocionPorcentual promo_porc_test = new PromocionPorcentual("PromoPorc", atrac_arr_test, "Horror", 10.0);

		boolean obtenido = usuario_test.puedeComprarPromocion(promo_porc_test);
		boolean esperado = false;

		assertEquals(esperado, obtenido);
	}

	@Test
	public void noOfertaPromocionComboComprada() {
		Usuario usuario_test = new Usuario("Lucas", "Horror", 20, 20.0);
		Atraccion atrac_repetida_gratis = new Atraccion("Solsticio", 2.0, 3.0, 0, "Horror");

		Atraccion atrac_arr_test[] = { new Atraccion("Abismo", 1.0, 1.0, 10, "Horror"),
				new Atraccion("Supernova", 1.0, 1.0, 2, "Horror"), atrac_repetida_gratis };

		usuario_test.agregarAtraccion(atrac_repetida_gratis);
		PromocionCombo promo_combo_test = new PromocionCombo("PromoCombo", atrac_arr_test, "Horror",
				atrac_repetida_gratis);

		boolean obtenido = usuario_test.puedeComprarPromocion(promo_combo_test);
		boolean esperado = false;

		assertEquals(esperado, obtenido);
	}

	@Test
	public void compraGrupalAtrac() {

		Atraccion a1 = new Atraccion("Atraccion Linda", 300.0, 3.0, 5, "Horror");
		Usuario grupo = new Usuario("Familia Messi", "Horror", 1500, 4.0);
		grupo.setCantUsuarios(4);
		boolean esperado = true;
		boolean real = grupo.puedeComprarAtraccion(a1);
		assertEquals(esperado, real);
	}

	@Test
	public void compraGrupalPromo() {
		Usuario grupo = new Usuario("Familia Adams", "Horror", 2000, 20.0);
		grupo.setCantUsuarios(4);

		Atraccion atrac_arr_test[] = { new Atraccion("Abismo", 1.0, 1.0, 10, "Horror"),
				new Atraccion("Supernova", 1.0, 1.0, 5, "Horror"), new Atraccion("Sombras", 2.0, 1.0, 5, "Horror") };

		PromocionAbsoluta promoTest = new PromocionAbsoluta("PromoAbs", atrac_arr_test, "Horror", 10);

		boolean obtenido = grupo.puedeComprarPromocion(promoTest);
		boolean esperado = true;

		assertEquals(esperado, obtenido);

	}
}
