package facadeEMain;

import org.junit.Before;

import exceptionsComplementares.ItemCadastradoException;
import exceptionsComplementares.StringInvalidaException;
import exceptionsComplementares.UsuarioCadastradoException;

public class US8Test {
	
	Facade facade;

	@Before
	public void setUp() throws StringInvalidaException, UsuarioCadastradoException, IllegalArgumentException, ItemCadastradoException {
		facade = new Facade();
		facade.cadastrarUsuario("Lucas", "95656-8888", "lucas@email.com");
		facade.cadastrarUsuario("Vitoria", "94444-9999", "vitoria@email.com");
		facade.cadastrarUsuario("Luan", "66909-8888", "luan@email.com");
	}

	// ------------------------------------------US8--------------------------------------------------
	// listarCaloteiros, listarTop10MelhoresUsuarios, listarTop10PioresUsuarios
	
	
}
