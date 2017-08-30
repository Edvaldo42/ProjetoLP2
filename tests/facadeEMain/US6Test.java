package facadeEMain;

import org.junit.Before;

import exceptionsComplementares.ItemCadastradoException;
import exceptionsComplementares.StringInvalidaException;
import exceptionsComplementares.UsuarioCadastradoException;

public class US6Test {

	Facade facade;

	@Before
	public void setUp() throws StringInvalidaException, UsuarioCadastradoException, IllegalArgumentException, ItemCadastradoException {
		facade = new Facade();
		facade.cadastrarUsuario("Luana", "88888-8888", "luh@email.com");
		facade.cadastrarUsuario("Mhayrlla", "99999-9999", "mhay@email.com");
	}

	
	// ------------------------------------------US6--------------------------------------------------
	// getInfoUsuario - reputacao
	
	
}
