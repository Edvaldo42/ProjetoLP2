package FacadeEMain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SistemaTest {
	
	Sistema sistema;
	
	@Before
	public void setUp() {
		sistema = new Sistema();
	}

	@Test
	public void test() {
		sistema.cadastrarUsuario("Joao", "98888-8888", "joao@email.com");
		assertEquals("joao@email.com", sistema.getInfoUsuario("Joao", "98888-8888", "email"));
	}

}
