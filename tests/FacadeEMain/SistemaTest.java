package FacadeEMain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;

import FacadeEMain.Sistema;

public class SistemaTest {

	Sistema sistema;

	@Before
	public void setUp() {
		sistema = new Sistema();
		sistema.cadastrarUsuario("Joao", "98888-8888", "joao@email.com");
		sistema.cadastrarUsuario("Andre", "99999-9999", "andre@email.com");
	}

	// ----------------------------------------------------------US1----------------------------------------------------------
	@Test
	public void testCadastrarUsuario() {

		sistema.cadastrarUsuario("Pedro", "98888-8888", "pedro@email.com");
		sistema.cadastrarUsuario("Paulo", "99999-9999", "paulo@email.com");
		assertEquals("pedro@email.com", sistema.getInfoUsuario("Pedro", "98888-8888", "Email"));
		assertEquals("Paulo", sistema.getInfoUsuario("Paulo", "99999-9999", "nome"));
		assertEquals("paulo@email.com", sistema.getInfoUsuario("Paulo", "99999-9999", "email"));
		assertEquals("99999-9999", sistema.getInfoUsuario("Paulo", "99999-9999", "telefone"));
		sistema.cadastrarUsuario("Matheus", "98888-8888", "Matheus@email.com");
		assertEquals("Matheus@email.com", sistema.getInfoUsuario("Matheus", "98888-8888", "email"));
	}

	@Test
	public void testAtualizarCadastro() {
		sistema.cadastrarUsuario("Pedro", "98888-8888", "pedro@email.com");
		sistema.atualizarUsuario("Pedro", "98888-8888", "nome", "Pedrinho");
		assertEquals("Pedrinho", sistema.getInfoUsuario("Pedrinho", "98888-8888", "nome"));
		sistema.atualizarUsuario("Pedrinho", "98888-8888", "telefone", "11111-1111");
		assertEquals("11111-1111", sistema.getInfoUsuario("Pedrinho", "11111-1111", "telefone"));
		sistema.atualizarUsuario("Pedrinho", "11111-1111", "email", "Pedrinho@email.com.br");
		assertEquals("Pedrinho@email.com.br", sistema.getInfoUsuario("Pedrinho", "11111-1111", "email"));
		sistema.atualizarUsuario("Andre", "99999-9999", "nome", "Deco");
		assertEquals("Deco", sistema.getInfoUsuario("Deco", "99999-9999", "nome"));
	}

	@Test
	public void testRemoverUsuario() {
		sistema.removerUsuario("Joao", "98888-8888");
		sistema.removerUsuario("Andre", "99999-9999");
	}

	// ----------------------------------------------------------US2----------------------------------------------------------

	@Test
	public void testCadastrarEletronico() {
		sistema.cadastrarEletronico("Joao", "98888-8888", "Pokemon", 9.99, "PC");
		sistema.cadastrarEletronico("Andre", "99999-9999", "FUNCIONA", 1.11, "PC");
		assertEquals("9.99", sistema.getInfoItem("Joao", "98888-8888", "Pokemon", "preco"));
		assertEquals("1,11", sistema.getInfoItem("Andre", "99999-9999", "FUNCIONA", "preco"));
	}

	@Test
	public void testCadastrarJogoTabuleiro() {
		sistema.cadastrarJogoTabuleiro("Andre", "99999-9999", "War", 99.99);
		assertEquals("99,99", sistema.getInfoItem("Andre", "99999-9999", "War", "Preco"));
	}
	
	@Test
	public void testAdicionarPecaPerdida(){
		sistema.cadastrarJogoTabuleiro("Joao", "98888-8888", "Monopoly", 115.90);
		sistema.adicionarPecaPerdida("Joao", "98888-8888", "Monopoly", "Carrinho");
		//assertEquals()
	}

}
