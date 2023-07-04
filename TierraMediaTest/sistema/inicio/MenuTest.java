package sistema.inicio;

import java.util.Scanner;

import org.junit.Test;

import org.junit.Assert;
import sistema.usuarios.Usuario;

public class MenuTest {

	Menu menu = new Menu();
	Usuario uss = new Usuario("Prueba", "Aventura", 2000, 15.0);

	@Test
	public void ingresaNumero() {

		Scanner scanner = new Scanner(System.in);

		this.menu.ingresaParticipantes(uss, scanner);
		int expected = 8;
		int actual = uss.getCantUsuarios();

		Assert.assertEquals(expected, actual);

	}

}