package facadeEMain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exceptionsComplementares.EmprestimoNaoEncontradoException;
import exceptionsComplementares.ItemCadastradoException;
import exceptionsComplementares.ItemEmprestadoException;
import exceptionsComplementares.ItemNaoEncontradoException;
import exceptionsComplementares.StringInvalidaException;
import exceptionsComplementares.UsuarioCadastradoException;
import exceptionsUsuario.UsuarioInvalidoException;

public class US5Test {

	Facade facade;

	@Before
	public void setUp() throws StringInvalidaException, UsuarioCadastradoException, IllegalArgumentException, ItemCadastradoException, ItemNaoEncontradoException, ItemEmprestadoException, EmprestimoNaoEncontradoException {
		facade = new Facade();
		facade.cadastrarUsuario("Luisa", "99899-7777", "lulu@email.com");
		facade.cadastrarUsuario("Maria", "55555-5555", "mafe@email.com");
		facade.cadastrarUsuario("Louhane", "98855-9999", "louh@email.com");
		facade.cadastrarUsuario("Pedro", "98872-2222", "pdro@email.com");
		facade.cadastrarBluRayShow("Louhane", "98855-9999", "Evanescence", 30.00, 40, 10, "Emos", "LIVRE");
		facade.cadastrarJogoTabuleiro("Louhane", "98855-9999", "War", 60.00);
		facade.registrarEmprestimo("Louhane", "98855-9999", "Luisa", "99899-7777", "Evanescence", "30/08/2017", 7);
		facade.registrarEmprestimo("Louhane", "98855-9999", "Maria", "55555-5555", "War", "02/09/2017", 7);
		facade.devolverItem("Louhane", "98855-9999", "Maria", "55555-5555", "War", "02/09/2017", "09/09/2017");
		facade.registrarEmprestimo("Louhane", "98855-9999", "Pedro", "98872-2222", "War", "10/09/2017", 7);
		facade.cadastrarEletronico("Pedro", "98872-2222", "CS Go", 100.00, "PC");
	}

	// ------------------------------------------US5--------------------------------------------------
	// listarEmprestimosUsuarioEmprestando, listarEmprestimosUsuarioPegandoEmprestado, 
	// listarEmprestimosItem, listarItensNaoEmprestados, listarItensEmprestados
	
	@Test
	public void testListarEmprestimosUserEmprestando() throws UsuarioInvalidoException {
		assertEquals(facade.listarEmprestimosUsuarioEmprestando("Luisa", "99899-7777"), "Nenhum item emprestado");
	}
	
	@Test
	public void testListarEmprestimosUsuarioEmprestando() throws UsuarioInvalidoException {
		String s = "Emprestimos: EMPRESTIMO - De: Louhane, Para: Luisa, Evanescence, 30/08/2017, 7 dias, ENTREGA: Emprestimo em andamento" +
				"|EMPRESTIMO - De: Louhane, Para: Maria, War, 02/09/2017, 7 dias, ENTREGA: 09/09/2017|EMPRESTIMO - De: Louhane, Para: Pedro," +
				" War, 10/09/2017, 7 dias, ENTREGA: Emprestimo em andamento|";
		
		assertEquals(facade.listarEmprestimosUsuarioEmprestando("Louhane", "98855-9999"), s);
	}
	
	@Test (expected= UsuarioInvalidoException.class)
	public void testListarEmprestimosUsuarioInvalidoEmprestando() throws UsuarioInvalidoException {
		facade.listarEmprestimosUsuarioEmprestando("Paulo", "93349-9090");
	}
	
	@Test
	public void testListarEmprestimosUsuarioPegandoEmprestado() throws UsuarioInvalidoException {
		assertEquals(facade.listarEmprestimosUsuarioPegandoEmprestado("Louhane", "98855-9999"), "Nenhum item pego emprestado");
	}
	
	@Test
	public void testListarEmprestimosUserPegandoEmprestado() throws UsuarioInvalidoException {
		String s = "Emprestimos pegos: EMPRESTIMO - De: Louhane, Para: Maria, War, 02/09/2017, 7 dias, ENTREGA: 09/09/2017|";
		
		assertEquals(facade.listarEmprestimosUsuarioPegandoEmprestado("Maria", "55555-5555"), s);
	}
	
	@Test (expected= UsuarioInvalidoException.class)
	public void testListarEmprestimosUsuarioInvalidoPegandoEmprestado() throws UsuarioInvalidoException {
		facade.listarEmprestimosUsuarioPegandoEmprestado("Matheus", "93333-9999");
	}
	
	@Test
	public void testListarEmprestimosItem() {
		String s = "Emprestimos associados ao item: EMPRESTIMO - De: Louhane, Para: Maria, War, 02/09/2017, 7 dias, " +
				"ENTREGA: 09/09/2017|EMPRESTIMO - De: Louhane, Para: Pedro, War, 10/09/2017, 7 dias, ENTREGA: Emprestimo em andamento|";
		
		assertEquals(facade.listarEmprestimosItem("War"), s);
	}
	
	@Test
	public void testListarEmprestimosItemVazio() {
		assertEquals(facade.listarEmprestimosItem("CS Go"), "Nenhum emprestimos associados ao item");
	}

	@Test
	public void testListarItensEmprestados() {
		String s = "Dono do item: Louhane, Nome do item emprestado: War|Dono do item: Louhane, Nome do item emprestado: Evanescence|";

		assertEquals(facade.listarItensEmprestados(), s);
	}


	@Test
	public void testListarItensNaoEmprestados() {
		String s = "JOGO ELETRONICO: CS Go, R$ 100.0, Nao emprestado, PC|";
		
		assertEquals(facade.listarItensNaoEmprestados(), s);
	}
	
}
