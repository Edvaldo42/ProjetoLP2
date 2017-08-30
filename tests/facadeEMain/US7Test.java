package facadeEMain;

import org.junit.Before;

import exceptionsComplementares.ItemCadastradoException;
import exceptionsComplementares.StringInvalidaException;
import exceptionsComplementares.UsuarioCadastradoException;

public class US7Test {

	Facade facade;

	@Before
	public void setUp() throws StringInvalidaException, UsuarioCadastradoException, IllegalArgumentException, ItemCadastradoException {
		facade = new Facade();
		facade.cadastrarUsuario("Jose", "98777-8888", "jose@email.com");
		facade.cadastrarUsuario("Anna", "99900-9999", "anna@email.com");
		facade.cadastrarUsuario("jessica", "66777-8888", "jessica@email.com");
	}

	
	// ------------------------------------------US7--------------------------------------------------
	// getInfoUsuario - cartao
	
	
}
