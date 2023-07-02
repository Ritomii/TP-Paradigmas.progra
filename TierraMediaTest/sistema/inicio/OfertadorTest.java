package sistema.inicio;

import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

import sistema.atracciones.Atraccion;
import sistema.promociones.Promocion;
import sistema.promociones.PromocionAbsoluta;
import sistema.promociones.PromocionPorcentual;
import sistema.usuarios.Usuario;
import utiles.ArchivoUsuarios;
import utiles.ArchivoAtracciones;
import utiles.ArchivoPromociones;
import utiles.Datos;

public class OfertadorTest {

	Atraccion re_loco_1 = new Atraccion("Re loco 1", 500, 3.0, 35, "Aventura");
	Atraccion glaciar_p_moreno = new Atraccion("Glaciar Perito Moreno", 690, 2.0, 20, "Paisaje");
	Atraccion parrillada = new Atraccion("Parrillada", 300, 2.0, 20, "Degustacion");
	Atraccion escalada = new Atraccion("Escalada", 700, 3.0, 35, "Aventura");
	Atraccion cerro_catedral = new Atraccion("Cerro Catedral", 800, 4.0, 20, "Paisaje");
	Atraccion re_loco_2 = new Atraccion("Re loco 2", 300, 2.0, 10, "Aventura");

	Atraccion[] vector_p_aventura_esperado;
	Atraccion[] vector_p_degustacion_esperado;
	Atraccion[] vector_p_paisaje_esperado;

	/*
	 * TESTEA QUE EL ALGORITMO CREE LOS ARBOLES DE PROMOCIONES Y ATRACCIONES
	 * CORRECTOS PARA UN USUARIO CON UNA DETERMINADA PREFERENCIA
	 */

	@Test
	public void testOfertador() {

		/// *** LECTURA DE ARCHIVOS Y ARMADO DE ARBOLES REALES ***
		Datos cargados = new Datos();

		ArchivoUsuarios arch_usuarios = new ArchivoUsuarios();
		ArchivoAtracciones arch_atracciones = new ArchivoAtracciones();
		ArchivoPromociones arch_promociones = new ArchivoPromociones();

		arch_usuarios.leerArchivo("./archivosTest/usuariosTest.in", cargados);
		arch_atracciones.leerArchivo("./archivosTest/atraccionesTest.in", cargados);
		arch_promociones.leerArchivo("./archivosTest/promocionesTest.in", cargados);

		cargados.ordenarNoPreferencias();

		Usuario user = cargados.getLista_usuarios().get(0);

		TreeSet<Promocion> promos_preferidas_real = cargados.getMapa_promos_tipos().get(user.getPreferencia());
		TreeSet<Atraccion> atracciones_preferidas_real = cargados.getMapa_atracciones_tipos()
				.get(user.getPreferencia());

		TreeSet<Promocion> promos_no_preferidas_real;
		TreeSet<Atraccion> atracciones_no_preferidas_real;

		if (cargados.getMapa_no_preferencia_promociones().containsKey(user.getPreferencia()))
			promos_no_preferidas_real = cargados.getMapa_no_preferencia_promociones().get(user.getPreferencia());
		else
			promos_no_preferidas_real = cargados.getMapa_no_preferencia_promociones().get("SinPreferencia");

		if (cargados.getMapa_no_preferencia_atraccion().containsKey(user.getPreferencia()))
			atracciones_no_preferidas_real = cargados.getMapa_no_preferencia_atraccion().get(user.getPreferencia());
		else
			atracciones_no_preferidas_real = cargados.getMapa_no_preferencia_atraccion().get("SinPreferencia");

		// *** ARMADO PROMOS PREFERIDAS ESPERADAS ***
		Atraccion[] atracciones_incluidas_promoAventura = new Atraccion[2];
		Atraccion[] atracciones_incluidas_promoHola = new Atraccion[1];

		atracciones_incluidas_promoAventura[0] = re_loco_1;
		atracciones_incluidas_promoAventura[1] = escalada;
		atracciones_incluidas_promoHola[0] = re_loco_2;

		Promocion[] promos_preferidas_esperado = new Promocion[2];

		PromocionAbsoluta promo_aventura = new PromocionAbsoluta("Promo Aventura", atracciones_incluidas_promoAventura,
				"Absoluta", 1000);
		PromocionPorcentual promo_hola = new PromocionPorcentual("Promo Hola", atracciones_incluidas_promoHola,
				"Porcentual", 10.0);

		promos_preferidas_esperado[0] = promo_aventura;
		promos_preferidas_esperado[1] = promo_hola;

		// *** ARMADO ATRACCIONES PREFERIDAS ESPERADAS ***
		Atraccion[] atrac_preferidas_esperado = new Atraccion[3];

		atrac_preferidas_esperado[0] = escalada;
		atrac_preferidas_esperado[1] = re_loco_1;
		atrac_preferidas_esperado[2] = re_loco_2;

		// *** ARMADO PROMOS NO PREFERIDAS ESPERADAS ***
		Promocion[] promos_no_preferidas_esperado = new Promocion[1];
		Atraccion[] atracciones_incluidas_promoPaisaje = new Atraccion[2];
		atracciones_incluidas_promoPaisaje[0] = glaciar_p_moreno;
		atracciones_incluidas_promoPaisaje[1] = cerro_catedral;

		PromocionPorcentual promo_paisaje = new PromocionPorcentual("Promo Paisaje", atracciones_incluidas_promoPaisaje,
				"Porcentual", 20.0);

		promos_no_preferidas_esperado[0] = promo_paisaje;

		// *** ARMADO ATRACCIONES NO PREFERIDAS ESPERADAS ***
		Atraccion[] atrac_no_preferidas_esperado = new Atraccion[3];
		atrac_no_preferidas_esperado[0] = cerro_catedral;
		atrac_no_preferidas_esperado[1] = glaciar_p_moreno;
		atrac_no_preferidas_esperado[2] = parrillada;

		// *** "TEST" DE ARBOL DE PROMOS PREFERIDAS DEL USUARIO ***
		boolean resultado = (promos_preferidas_real.size() == promos_preferidas_esperado.length);
		int i = 0;
		if (resultado) {
			for (Promocion actual : promos_preferidas_real) {
				if (actual.compareTo(promos_preferidas_esperado[i]) != 0)
					resultado = false;
				i++;
			}
		}

		// *** "TEST" DE ARBOL DE ATRACCIONES PREFERIDAS DEL USUARIO ***
		if (resultado) {
			resultado = (atracciones_preferidas_real.size() == atrac_preferidas_esperado.length);
			i = 0;
			for (Atraccion actual : atracciones_preferidas_real) {
				if (actual.compareTo(atrac_preferidas_esperado[i]) != 0) {
					resultado = false;
				}
				i++;
			}
		}

		// *** "TEST" DE ARBOL DE PROMOS NO PREFERIDAS DEL USUARIO ***
		if (resultado) {
			resultado = (promos_no_preferidas_real.size() == promos_no_preferidas_esperado.length);
			i = 0;
			for (Promocion actual : promos_no_preferidas_real) {
				if (actual.compareTo(promos_no_preferidas_esperado[i]) != 0) {
					resultado = false;
				}
				i++;
			}
		}

		// *** "TEST" DE ARBOL DE ATRACCIONES NO PREFERIDAS DEL USUARIO ***
		if (resultado) {
			resultado = (atracciones_no_preferidas_real.size() == atrac_no_preferidas_esperado.length);
			i = 0;
			for (Atraccion actual : atracciones_no_preferidas_real) {
				if (actual.compareTo(atrac_no_preferidas_esperado[i]) != 0) {
					resultado = false;
				}
				i++;
			}
		}

		/*
		 * EL CORRECTO ARMADO DE TODOS LOS ARBOLES ES EL UNICO CASO DONDE EL ASSERT DEBE
		 * DAR TRUE
		 */
		Assert.assertTrue(resultado);

	}
}
