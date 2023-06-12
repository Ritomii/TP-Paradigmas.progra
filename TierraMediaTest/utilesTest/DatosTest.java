package utilesTest;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.TreeSet;

import org.junit.Test;

import sistema.atracciones.Atraccion;
import sistema.promociones.Promocion;
import sistema.promociones.PromocionAbsoluta;
import utiles.Datos;

public class DatosTest {

	@Test
	public void noPreferenciasAtraccionTest() {
		Datos datos_testing = new Datos();
		
		Atraccion A = new Atraccion("AtrA", 70.0, 10.0, 10, "Pref A");
		Atraccion B = new Atraccion("AtrB", 100.0, 10.0, 10, "Pref A");
		Atraccion C = new Atraccion("AtrC", 20.0, 10.0, 10, "Pref A");
		Atraccion[] vector_prueba = new Atraccion[3];
		
		vector_prueba[0] = A;
		vector_prueba[1] = B;
		vector_prueba[2] = C;
		TreeSet<Atraccion> arbo_pref_A = new TreeSet<Atraccion>();
		arbo_pref_A.add(A);
		arbo_pref_A.add(B);
		arbo_pref_A.add(C);
		
		TreeSet<Atraccion> arbo_pref_B = new TreeSet<Atraccion>();
		arbo_pref_B.add(new Atraccion("AtrD", 15.0, 10.0, 10, "Pref B"));
		arbo_pref_B.add(new Atraccion("AtrE", 35.0, 10.0, 10, "Pref B"));
		arbo_pref_B.add(new Atraccion("AtrF", 80.0, 10.0, 10, "Pref B"));
		
		TreeSet<Atraccion> arbo_pref_C = new TreeSet<Atraccion>();
		arbo_pref_C.add(new Atraccion("AtrG", 150.0, 10.0, 10, "Pref C"));
		arbo_pref_C.add(new Atraccion("AtrH", 5.0, 10.0, 10, "Pref C"));
		arbo_pref_C.add(new Atraccion("AtrI", 200.0, 10.0, 10, "Pref C"));
		
		HashMap<String, TreeSet<Atraccion>> mapa_atracciones_tipos = new HashMap<>();
		
		HashMap<String, TreeSet<Promocion>> mapa_promos_tipos = new HashMap<>();
		
		TreeSet<Promocion> arbol_promo = new TreeSet<>();
		arbol_promo.add(new PromocionAbsoluta("PromoInutil", vector_prueba, "Absoluta", 50));
		
		mapa_atracciones_tipos.put("Pref A", arbo_pref_A);
		mapa_atracciones_tipos.put("Pref B", arbo_pref_B);
		mapa_atracciones_tipos.put("Pref C", arbo_pref_C);
		
		mapa_promos_tipos.put("Pref A", arbol_promo);
		
		datos_testing.setMapa_atracciones_tipos(mapa_atracciones_tipos);
		datos_testing.setMapa_promos_tipos(mapa_promos_tipos);
		
		datos_testing.ordenarNoPreferencias();
		
		TreeSet<Atraccion> obtenido = datos_testing.getMapa_no_preferencia_atraccion().get("Pref A");
		
		TreeSet<Atraccion> esperado = new TreeSet<>();
		esperado.add(new Atraccion("AtrD", 15.0, 10.0, 10, "Pref B"));
		esperado.add(new Atraccion("AtrE", 35.0, 10.0, 10, "Pref B"));
		esperado.add(new Atraccion("AtrF", 80.0, 10.0, 10, "Pref B"));
		esperado.add(new Atraccion("AtrG", 150.0, 10.0, 10, "Pref C"));
		esperado.add(new Atraccion("AtrH", 5.0, 10.0, 10, "Pref C"));
		esperado.add(new Atraccion("AtrI", 200.0, 10.0, 10, "Pref C"));
		
		assertEquals(esperado, obtenido);
	}
}
