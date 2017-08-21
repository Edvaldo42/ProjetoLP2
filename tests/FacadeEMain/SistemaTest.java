package FacadeEMain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exception.EmailInvalidoException;
import exception.ItemNaoEncontradoException;
import exception.PecaPerdidaException;
import exception.StringInvalidaException;
import exception.TelefoneInvalidoException;
import exception.UsuarioCadastradoException;
import exception.UsuarioInvalidoException;
import facadeEMain.Facade;

public class SistemaTest {

	Facade facade;

	@Before
	public void setUp() throws StringInvalidaException, UsuarioCadastradoException {
		facade = new Facade();
		facade.cadastrarUsuario("Joao", "98888-8888", "joao@email.com");
		facade.cadastrarUsuario("Andre", "99999-9999", "andre@email.com");
	}

	// -------------------------------------------US1-----------------------------------------------
	// cadastrarUsuario, atualizarUsuario, getInfoUsuario, removerUsuario
	
	@Test
	public void testCadastrarUsuario() throws Exception {
		facade.cadastrarUsuario("Pedro", "98888-8888", "pedro@email.com");
		facade.cadastrarUsuario("Paulo", "99999-9999", "paulo@email.com");	
		facade.cadastrarUsuario("Matheus", "98888-8888", "Matheus@email.com");
		
		assertEquals("pedro@email.com", facade.getInfoUsuario("Pedro", "98888-8888", "Email"));
		assertEquals("paulo@email.com", facade.getInfoUsuario("Paulo", "99999-9999", "email"));
		assertEquals("Matheus@email.com", facade.getInfoUsuario("Matheus", "98888-8888", "email"));
	}

	@Test (expected= IllegalArgumentException.class)
	public void testCadastrarUsuarioNulo() throws Exception {
		facade.cadastrarUsuario(null, "99999-9999", "email@email.com");
		facade.cadastrarUsuario("Joao", null, "email@email.com");
		facade.cadastrarUsuario("Joao", "99999-9999", null);		
	}
	
	@Test (expected= IllegalArgumentException.class)
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
	
	@Test(expected= EmailInvalidoException.class)
	public void testCadastrarUsuarioEmailInvalido() throws StringInvalidaException, UsuarioCadastradoException {
		facade.cadastrarUsuario("Jose", "400289222", "email");
		facade.cadastrarUsuario("Jose", "400289222", "email@");
		facade.cadastrarUsuario("Jose", "400289222", "@email");
		facade.cadastrarUsuario("Jose", "400289222", "email@@email.com");
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
		facade.atualizarUsuario("Andre", "99999-9999", "telefone", "telefone");
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

	
	// ------------------------------------------US2--------------------------------------------------
	// cadastrarEletronico, getInfoItem, cadastrarJogoTabuleiro, adicionarPecaPerdida, cadastrarBluRayFilme
	// cadastrarBluRayShow, cadastrarBluRaySerie, adicionarBluRay, removerItem, atualizarItem
	@Test
	public void testCadastrarEletronico() throws UsuarioCadastradoException, ItemNaoEncontradoException, UsuarioInvalidoException {
		facade.cadastrarEletronico("Joao", "98888-8888", "Uncharted 4", 79.99, "PS4");
		facade.cadastrarEletronico("Andre", "99999-9999", "Life Is Strange", 36.99, "PC");
		facade.cadastrarEletronico("Andre", "99999-9999", "Pokémon GO", 36.99, "Android");
		assertEquals("79.99", facade.getInfoItem("Joao", "98888-8888", "Uncharted 4", "preco"));
		assertEquals("36.99", facade.getInfoItem("Andre", "99999-9999", "Life Is Strange", "preco"));
		assertEquals("OUTRO", facade.getInfoItem("Andre", "99999-9999", "Pokémon GO", "plataforma"));
	}
	
	@Test (expected= IllegalArgumentException.class)
	public void testCadastrarEletronicoNulo() throws UsuarioInvalidoException, UsuarioCadastradoException {
		facade.cadastrarEletronico("Joao", "98888-8888", null, 9.99, "PC");
		facade.cadastrarEletronico("Joao", "98888-8888", "Pokemon", 9.99, "PC");
		facade.cadastrarEletronico("Joao", "98888-8888", "Pokemon", 9.99, null);
	}

	@Test (expected= IllegalArgumentException.class) 
	public void testCadastrarEletronicoVazio() throws UsuarioCadastradoException, UsuarioInvalidoException {
		facade.cadastrarEletronico("Joao", "98888-8888", "", 9.99, "PC");
		facade.cadastrarEletronico("Joao", "98888-8888", "Pokemon", 9.99, "PC");
		facade.cadastrarEletronico("Joao", "98888-8888", "Pokemon", 9.99, "");
	}
	
	@Test (expected= UsuarioInvalidoException.class)
	public void testCadastrarEletronicoUsuarioInvalido() throws UsuarioCadastradoException, UsuarioInvalidoException {
		facade.cadastrarEletronico("Mariah", "98989-8888", "CS Go", 45.99, "PC");
	}
	
	@Test (expected= IllegalArgumentException.class)
	public void testCadastrarEletronicoPrecoInvalido() throws UsuarioInvalidoException, UsuarioCadastradoException {
		facade.cadastrarEletronico("Joao", "98888-8888", "GTA V", -18.00, "XBOX360");
	}
	
	@Test
	public void testCadastrarJogoTabuleiro() throws UsuarioInvalidoException, ItemNaoEncontradoException {
		facade.cadastrarJogoTabuleiro("Andre", "99999-9999", "War", 99.99);
		assertEquals(facade.getInfoItem("Andre", "99999-9999", "War", "Preco"), "99.99");
	}
	
	@Test (expected= IllegalArgumentException.class)
	public void testCadastrarJogoTabuleiroNulo() throws UsuarioInvalidoException, ItemNaoEncontradoException {
		facade.cadastrarJogoTabuleiro("Andre", "99999-9999", null, 99.99);
	}
	
	@Test (expected= IllegalArgumentException.class)
	public void testCadastrarJogoTabuleiroVazio() throws UsuarioInvalidoException, ItemNaoEncontradoException {
		facade.cadastrarJogoTabuleiro("Andre", "99999-9999", "", 99.99);
	}
	
	@Test (expected= IllegalArgumentException.class)
	public void testCadastrarJogoTabuleiroInvalido() throws UsuarioInvalidoException, ItemNaoEncontradoException {
		facade.cadastrarJogoTabuleiro("Andre", "99999-9999", "War", -1);
	}
	
	@Test
	public void testAdicionarPecaPerdida() throws Exception  {
		facade.cadastrarJogoTabuleiro("Joao", "98888-8888", "Monopoly", 115.90);
		facade.adicionarPecaPerdida("Joao", "98888-8888", "Monopoly", "Carrinho");
		assertEquals(facade.getInfoItem("Joao", "98888-8888", "Monopoly", "peca perdida"), "Carrinho");
	}
	
	@Test (expected= PecaPerdidaException.class)
	public void testAdicionarPecaPerdidaJogoInexistente() throws Exception {
		facade.adicionarPecaPerdida("Gabs", "88888-8888", "Banco Imobiliario", "Cartão");
	}
	
	@Test
	public void testCadastrarBluRayFilme() throws UsuarioInvalidoException, ItemNaoEncontradoException {
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "O Profissional", 7.50, 103, "ACAO", "QUATORZE_ANOS", 1994);
		assertEquals(facade.getInfoItem("Joao", "98888-8888", "O Profissional", "preco"), "7.5");
		assertEquals(facade.getInfoItem("Joao", "98888-8888", "O Profissional", "duracao"), "103");
		assertEquals(facade.getInfoItem("Joao", "98888-8888", "O Profissional", "genero"), "ACAO");
		assertEquals(facade.getInfoItem("Joao", "98888-8888", "O Profissional", "classificacao"), "QUATORZE_ANOS");
		assertEquals(facade.getInfoItem("Joao", "98888-8888", "O Profissional", "ano de lancamento"), "1994");
	}
	
	@Test (expected= IllegalArgumentException.class)
	public void testCadastrarBluRayFilmeNulo() throws UsuarioInvalidoException {
		facade.cadastrarBluRayFilme("Joao", "98888-8888", null, 7.50, 103, "ACAO", "QUATORZE_ANOS", 1994);
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "O Profissional", 7.50, 103, null, "QUATORZE_ANOS", 1994);
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "O Profissional", 7.50, 103, "ACAO", null, 1994);
	}
	
	@Test (expected= IllegalArgumentException.class)
	public void testCadastrarBluRayFilmeVazio() throws UsuarioInvalidoException {
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "", 7.50, 103, "ACAO", "QUATORZE_ANOS", 1994);
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "O Profissional", 7.50, 103, "", "QUATORZE_ANOS", 1994);
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "O Profissional", 7.50, 103, "ACAO", "", 1994);
	}
	
	@Test (expected= IllegalArgumentException.class)
	public void testCadastrarBluRayFilmeInvalido() throws UsuarioInvalidoException {
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "Sniper Americano", -2.00, 132, "GUERRA", "DEZESSEIS_ANOS", 2015);
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "Sniper Americano", 6.00, -132, "GUERRA", "DEZESSEIS_ANOS", 2015);
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "Sniper Americano", 6.00, 132, "TIRO", "DEZESSEIS_ANOS", 2015);
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "Sniper Americano", 6.00, 132, "GUERRA", "NOVENTA_ANOS", 2015);
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "Sniper Americano", 6.00, 132, "GUERRA", "DEZESSEIS_ANOS", -2000);
	}
	
	// ------------------------------------------US3--------------------------------------------------
	
	@Test
	public void testPesquisarDetalhesItem() throws StringInvalidaException, UsuarioCadastradoException, ItemNaoEncontradoException {		
		facade.cadastrarUsuario("Maria", "96666-6666", "mariaS2@email.com");
		facade.cadastrarBluRayFilme("Maria", "96666-6666", "Crepusculo", 1.99, 120, "ROMANCE", "QUATORZE_ANOS", 2008);
		facade.pesquisarDetalhesItem("Maria", "96666-6666", "Crepusculo");
	}
	
	// ------------------------------------------US4--------------------------------------------------
	
	// ------------------------------------------US5--------------------------------------------------
	
	// ------------------------------------------US6--------------------------------------------------
	
	// ------------------------------------------US7--------------------------------------------------
	
	// ------------------------------------------US8--------------------------------------------------
	
	// ------------------------------------------US9--------------------------------------------------


}