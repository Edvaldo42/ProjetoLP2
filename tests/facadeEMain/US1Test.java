package facadeEMain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exceptionsComplementares.AtributoInvalidoException;
import exceptionsComplementares.ItemCadastradoException;
import exceptionsComplementares.StringInvalidaException;
import exceptionsComplementares.UsuarioCadastradoException;
import exceptionsUsuario.EmailInvalidoException;
import exceptionsUsuario.TelefoneInvalidoException;
import exceptionsUsuario.UsuarioInvalidoException;
import facadeEMain.Facade;

public class US1Test {

	Facade facade;

	@Before
	public void setUp() throws StringInvalidaException, UsuarioCadastradoException, IllegalArgumentException, ItemCadastradoException {
		facade = new Facade();
		facade.cadastrarUsuario("Joao", "98888-8888", "joao@email.com");
		facade.cadastrarUsuario("Andre", "99999-9999", "andre@email.com");
		facade.cadastrarUsuario("Gabryelle", "99999-8888", "gabs@email.com");
		facade.cadastrarBluRayShow("Gabryelle", "99999-8888", "Beatles", 180.00, 75, 12, "John, Paul, Ringo e George", "DEZ_ANOS");
	}

	// -------------------------------------------US1-----------------------------------------------
	// cadastrarUsuario, atualizarUsuario, getInfoUsuario, removerUsuario
	
	@Test
	public void testCadastrarUsuario() throws StringInvalidaException, UsuarioCadastradoException {
		facade.cadastrarUsuario("Pedro", "98888-8888", "pedro@email.com");
		facade.cadastrarUsuario("Paulo", "99999-9999", "paulo@email.com");	
		facade.cadastrarUsuario("Matheus", "98888-8888", "Matheus@email.com");
		
		assertEquals("pedro@email.com", facade.getInfoUsuario("Pedro", "98888-8888", "Email"));
		assertEquals("paulo@email.com", facade.getInfoUsuario("Paulo", "99999-9999", "email"));
		assertEquals("Matheus@email.com", facade.getInfoUsuario("Matheus", "98888-8888", "email"));
	}

	@Test (expected= StringInvalidaException.class)
	public void testCadastrarUsuarioNulo() throws Exception {
		facade.cadastrarUsuario(null, "99999-9999", "email@email.com");
		facade.cadastrarUsuario("Joao", null, "email@email.com");
		facade.cadastrarUsuario("Joao", "99999-9999", null);		
	}

	@Test (expected= StringInvalidaException.class)
	public void testCadastrarUsuarioVazio() throws Exception {
		facade.cadastrarUsuario("", "99999-9999", "email@email.com");
		facade.cadastrarUsuario("Joao", "", "email@email.com");
		facade.cadastrarUsuario("Joao", "99999-9999", "");		
	}
	
	@Test (expected= UsuarioCadastradoException.class)
	public void testCadastrarUsuarioJaCadastrado() throws Exception {
		facade.cadastrarUsuario("Fernanda", "99998-9898", "feh.12@email.com");
		facade.cadastrarUsuario("Fernanda", "99998-9898", "fernandinha@email.com");
	}

	@Test (expected= TelefoneInvalidoException.class)
	public void testCadastrarUsuarioTelefoneInvalido() throws StringInvalidaException, UsuarioCadastradoException {
		facade.cadastrarUsuario("Jose", "0800PHONE", "email@email.com");
		facade.cadastrarUsuario("Jose", "0", "email@email.com");
		facade.cadastrarUsuario("Jose", "telefone", "email@email.com");
	}
	
	@Test (expected= EmailInvalidoException.class)
	public void testCadastrarUsuarioEmailInvalido() throws StringInvalidaException, UsuarioCadastradoException {
		facade.cadastrarUsuario("Jose", "40028-9222", "email");
		facade.cadastrarUsuario("Jose", "40028-9222", "email@");
		facade.cadastrarUsuario("Jose", "40028-9222", "@email");
		facade.cadastrarUsuario("Jose", "40028-9222", "email@@email.com");
	}

	@Test
	public void testAtualizarCadastro() throws StringInvalidaException, UsuarioCadastradoException {
		facade.cadastrarUsuario("Pedro", "98888-8888", "pedro@email.com");
		assertEquals(facade.getInfoUsuario("Pedro", "98888-8888", "email"), "pedro@email.com");
		
		facade.atualizarUsuario("Pedro", "98888-8888", "nome", "Pedrinho");
		assertEquals(facade.getInfoUsuario("Pedrinho", "98888-8888", "email"), "pedro@email.com");
		
		facade.atualizarUsuario("Pedrinho", "98888-8888", "telefone", "11111-1111");
		assertEquals(facade.getInfoUsuario("Pedrinho", "11111-1111", "email"), "pedro@email.com");
		
		facade.atualizarUsuario("Pedrinho", "11111-1111", "email", "pedrinho@email.com.br");
		assertEquals(facade.getInfoUsuario("Pedrinho", "11111-1111", "email"), "pedrinho@email.com.br");
		
		facade.atualizarUsuario("Andre", "99999-9999", "nome", "Deco");
		assertEquals(facade.getInfoUsuario("Deco", "99999-9999", "nome"), "Deco");
	}
	
	@Test (expected= UsuarioInvalidoException.class)
	public void testAtualizarCadastroNulo() throws StringInvalidaException, UsuarioCadastradoException {
		facade.cadastrarUsuario("Pedro", "98888-8888", "pedro@email.com");
		facade.atualizarUsuario(null, "98888-8888", "nome", "Drope");
		facade.atualizarUsuario("Pedro", null, "nome", "Drope");
		facade.atualizarUsuario("Pedro", "98888-8888", null, "Drope");
		facade.atualizarUsuario("Pedro", "98888-8888", "nome", null);
	}

	@Test (expected= UsuarioInvalidoException.class)
	public void testAtualizarCadastroVazio() throws StringInvalidaException, UsuarioCadastradoException {
		facade.cadastrarUsuario("Pedro", "98888-8888", "pedro@email.com");
		facade.atualizarUsuario("", "98888-8888", "nome", "Drope");
		facade.atualizarUsuario("Pedro", "", "nome", "Drope");
		facade.atualizarUsuario("Pedro", "98888-8888", "", "Drope");
		facade.atualizarUsuario("Pedro", "98888-8888", "nome", "");
	}

	@Test (expected= UsuarioInvalidoException.class)
	public void testAtualizarCadastroInexistente() throws StringInvalidaException {
		facade.atualizarUsuario("Gabryelle", "99999-9999", "email", "gabsinha.123@email.com");
	}
	
	@Test (expected= EmailInvalidoException.class)
	public void testAtualizarCadastroEmailInvalido() throws StringInvalidaException, UsuarioCadastradoException {
		facade.atualizarUsuario("Andre", "99999-9999", "email", "email@");
	}
	
	@Test (expected= TelefoneInvalidoException.class)
	public void testAtualizarCadastroTelefoneInvalido() throws StringInvalidaException, UsuarioCadastradoException {
		facade.atualizarUsuario("Andre", "99999-9999", "telefone", "-8888999");
	}
	
	@Test (expected= AtributoInvalidoException.class)
	public void testAtualizarCadastroAtributoInvalido() throws StringInvalidaException {
		facade.atualizarUsuario("Andre", "99999-9999", "dinheiro", "email@email.com");
    }
	
	@Test (expected= UsuarioInvalidoException.class) //a excecao ocorre porque o usuario realmente foi excluido
	public void testRemoverUsuario() throws StringInvalidaException  {
		facade.removerUsuario("Joao", "98888-8888");
		facade.removerUsuario("Andre", "99999-9999");
		facade.getInfoUsuario("Joao", "98888-8888", "email");
	}
	
	@Test (expected= UsuarioInvalidoException.class)
	public void testRemoverUsuarioInexistente() throws UsuarioInvalidoException {
		facade.removerUsuario("Augusto", "99999-9999");
	}

}