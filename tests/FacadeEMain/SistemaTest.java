package FacadeEMain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exception.ItemNaoEncontradoException;
import exception.StringInvalidaException;
import exception.UsuarioCadastradoException;
import exception.UsuarioInvalidoException;
import facadeEMain.Sistema;

public class SistemaTest {

	Sistema sistema;

	@Before
	public void setUp() throws StringInvalidaException, UsuarioCadastradoException {
		sistema = new Sistema();
		sistema.cadastrarUsuario("Joao", "98888-8888", "joao@email.com");
		sistema.cadastrarUsuario("Andre", "99999-9999", "andre@email.com");
	}

	// -------------------------------------------US1-----------------------------------------------
	@Test
	public void testCadastrarUsuario() throws Exception {
		sistema.cadastrarUsuario("Pedro", "98888-8888", "pedro@email.com");
		sistema.cadastrarUsuario("Paulo", "99999-9999", "paulo@email.com");	
		sistema.cadastrarUsuario("Matheus", "98888-8888", "Matheus@email.com");
		
		assertEquals("pedro@email.com", sistema.getInfoUsuario("Pedro", "98888-8888", "Email"));
		assertEquals("paulo@email.com", sistema.getInfoUsuario("Paulo", "99999-9999", "email"));
		assertEquals("Matheus@email.com", sistema.getInfoUsuario("Matheus", "98888-8888", "email"));
	}

	@Test (expected= IllegalArgumentException.class)
	public void testCadastrarUsuarioNulo() throws Exception {
		sistema.cadastrarUsuario(null, "99999-9999", "email@email.com");
		sistema.cadastrarUsuario("Joao", null, "email@email.com");
		sistema.cadastrarUsuario("Joao", "99999-9999", null);		
	}
	
	@Test (expected= IllegalArgumentException.class)
	public void testCadastrarUsuarioVazio() throws Exception {
		sistema.cadastrarUsuario("", "99999-9999", "email@email.com");
		sistema.cadastrarUsuario("Joao", "", "email@email.com");
		sistema.cadastrarUsuario("Joao", "99999-9999", "");		
	}
	
	/**@Test (expected= UsuarioCadastradoException.class)
	public void testCadastrarUsuarioJaCadastrado() throws Exception {
		sistema.cadastrarUsuario("Fernanda", "99998-9898", "feh.12@email.com");
		sistema.cadastrarUsuario("Fernanda", "99998-9898", "fernandinha@email.com");
	}*/
	
	@Test
	public void testAtualizarCadastro() throws Exception  {
		sistema.cadastrarUsuario("Pedro", "98888-8888", "pedro@email.com");
		assertEquals(sistema.getInfoUsuario("Pedro", "98888-8888", "email"), "pedro@email.com");
		
		sistema.atualizarUsuario("Pedro", "98888-8888", "nome", "Pedrinho");
		assertEquals(sistema.getInfoUsuario("Pedrinho", "98888-8888", "email"), "pedro@email.com");
		
		sistema.atualizarUsuario("Pedrinho", "98888-8888", "telefone", "11111-1111");
		assertEquals(sistema.getInfoUsuario("Pedrinho", "11111-1111", "email"), "pedro@email.com");
		
		sistema.atualizarUsuario("Pedrinho", "11111-1111", "email", "pedrinho@email.com.br");
		assertEquals(sistema.getInfoUsuario("Pedrinho", "11111-1111", "email"), "pedrinho@email.com.br");
		
		sistema.atualizarUsuario("Andre", "99999-9999", "nome", "Deco");
		assertEquals(sistema.getInfoUsuario("Deco", "99999-9999", "nome"), "Deco");
	}
	
	@Test (expected= UsuarioInvalidoException.class)
	public void testAtualizarCadastroNulo() throws Exception {
		sistema.cadastrarUsuario("Pedro", "98888-8888", "pedro@email.com");
		sistema.atualizarUsuario(null, "98888-8888", "nome", "Drope");
		sistema.atualizarUsuario("Pedro", null, "nome", "Drope");
		sistema.atualizarUsuario("Pedro", "98888-8888", null, "Drope");
		sistema.atualizarUsuario("Pedro", "98888-8888", "nome", null);
	}

	@Test (expected= UsuarioInvalidoException.class)
	public void testAtualizarCadastroVazio() throws Exception {
		sistema.cadastrarUsuario("Pedro", "98888-8888", "pedro@email.com");
		sistema.atualizarUsuario("", "98888-8888", "nome", "Drope");
		sistema.atualizarUsuario("Pedro", "", "nome", "Drope");
		sistema.atualizarUsuario("Pedro", "98888-8888", "", "Drope");
		sistema.atualizarUsuario("Pedro", "98888-8888", "nome", "");
	}

	@Test (expected= UsuarioInvalidoException.class)
	public void testAtualizarCadastroInexistente() throws Exception {
		sistema.atualizarUsuario("Gabryelle", "99999-9999", "email", "gabsinha.123@email.com");
	}
	
	@Test (expected= UsuarioInvalidoException.class)
	public void testRemoverUsuario() throws Exception {
		sistema.removerUsuario("Joao", "98888-8888");
		sistema.removerUsuario("Andre", "99999-9999");
		sistema.getInfoUsuario("Joao", "98888-8888", "email");
	}
	
	@Test (expected= UsuarioInvalidoException.class)
	public void testRemoverUsuarioInexistente() throws UsuarioInvalidoException {
		sistema.removerUsuario("Augusto", "99999-9999");
	}

	// ------------------------------------------US2--------------------------------------------------

	@Test
	public void testCadastrarEletronico() throws UsuarioCadastradoException, ItemNaoEncontradoException, UsuarioInvalidoException {
		sistema.cadastrarEletronico("Joao", "98888-8888", "Pokemon", 9.99, "PC");
		sistema.cadastrarEletronico("Andre", "99999-9999", "FUNCIONA", 1.11, "PC");
		assertEquals("9.99", sistema.getInfoItem("Joao", "98888-8888", "Pokemon", "preco"));
		assertEquals("1.11", sistema.getInfoItem("Andre", "99999-9999", "FUNCIONA", "preco"));
	}
	
	@Test (expected= UsuarioInvalidoException.class)
	public void testCadastrarEletronicoNulo() throws UsuarioInvalidoException {
		sistema.cadastrarEletronico(null, "98888-8888", "Pokemon", 9.99, "PC");
		sistema.cadastrarEletronico("Joao", null, "Pokemon", 9.99, "PC");
		sistema.cadastrarEletronico("Joao", "98888-8888", null, 9.99, "PC");
		sistema.cadastrarEletronico("Joao", "98888-8888", "Pokemon", 9.99, "PC");
		sistema.cadastrarEletronico("Joao", "98888-8888", "Pokemon", 9.99, null);
	}

	@Test (expected= UsuarioInvalidoException.class)
	public void testCadastrarEletronicoVazio() throws UsuarioCadastradoException, UsuarioInvalidoException {
		sistema.cadastrarEletronico("", "98888-8888", "Pokemon", 9.99, "PC");
		sistema.cadastrarEletronico("Joao", "", "Pokemon", 9.99, "PC");
		sistema.cadastrarEletronico("Joao", "98888-8888", "", 9.99, "PC");
		sistema.cadastrarEletronico("Joao", "98888-8888", "Pokemon", 9.99, "PC");
		sistema.cadastrarEletronico("Joao", "98888-8888", "Pokemon", 9.99, "");
	}
	
	@Test (expected= UsuarioInvalidoException.class)
	public void testCadastrarEletronicoUsuarioInvalido() throws UsuarioCadastradoException, UsuarioInvalidoException {
		sistema.cadastrarEletronico("Mariah", "98989-8888", "CS Go", 45.99, "PC");
		
	}
	@Test
	public void testCadastrarJogoTabuleiro() throws UsuarioInvalidoException, ItemNaoEncontradoException {
		sistema.cadastrarJogoTabuleiro("Andre", "99999-9999", "War", 99.99);
		assertEquals("99.99", sistema.getInfoItem("Andre", "99999-9999", "War", "Preco"));
	}
	
	@Test
	public void testAdicionarPecaPerdida() throws Exception{
		sistema.cadastrarJogoTabuleiro("Joao", "98888-8888", "Monopoly", 115.90);
		sistema.adicionarPecaPerdida("Joao", "98888-8888", "Monopoly", "Carrinho");
	}
	
	// US3
	
	@Test
	public void testPesquisarDetalhesItem() throws StringInvalidaException, UsuarioCadastradoException, ItemNaoEncontradoException {		
		sistema.cadastrarUsuario("Maria", "96666-6666", "mariaS2@email.com");
		sistema.cadastrarBluRayFilme("Maria", "96666-6666", "Crepusculo", 1.99, 120, "ROMANCE", "QUATORZE_ANOS", 2008);
		sistema.pesquisarDetalhesItem("Maria", "96666-6666", "Crepusculo");
	}
	
	// US4
	

}