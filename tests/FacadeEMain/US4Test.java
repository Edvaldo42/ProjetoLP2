package FacadeEMain;

import org.junit.Before;
import org.junit.Test;

import exceptionsComplementares.EmprestimoNaoEncontradoException;
import exceptionsComplementares.ItemCadastradoException;
import exceptionsComplementares.ItemEmprestadoException;
import exceptionsComplementares.ItemNaoEncontradoException;
import exceptionsComplementares.StringInvalidaException;
import exceptionsComplementares.UsuarioCadastradoException;
import exceptionsUsuario.UsuarioInvalidoException;
import facadeEMain.Facade;

public class US4Test {

	Facade facade;

	@Before
	public void setUp() throws StringInvalidaException,
			UsuarioCadastradoException, IllegalArgumentException,
			ItemCadastradoException {
		facade = new Facade();
		facade.cadastrarUsuario("Joao", "98888-8888", "joao@email.com");
		facade.cadastrarUsuario("Andre", "99999-9999", "andre@email.com");
		facade.cadastrarUsuario("Gabryelle", "99999-8888", "gabs@email.com");
		facade.cadastrarBluRayShow("Gabryelle", "99999-8888", "Beatles",
				180.00, 75, 12, "John, Paul, Ringo e George", "DEZ_ANOS");
	}

	// ------------------------------------------US4--------------------------------------------------
	// registrarEmprestimo, devolverItem

	@Test
	public void testRegistrarEmprestimo() throws UsuarioInvalidoException,
			ItemNaoEncontradoException, ItemEmprestadoException {
		
		facade.registrarEmprestimo("Gabryelle", "99999-8888", "Joao", "98888-8888", "Beatles", "28/08/2017", 7);
	}

	@Test(expected = UsuarioInvalidoException.class)
	public void testRegistrarEmprestimoUsuarioInexistente() throws UsuarioInvalidoException, 
		ItemNaoEncontradoException, ItemEmprestadoException {
		
		facade.registrarEmprestimo("Pedro", "99992-8868", "Gabryelle", "99999-8888", "Rick and Morty", "30/08/2017", 5);
		facade.registrarEmprestimo("Gabryelle", "99999-8888", "Pedro", "99992-8868", "Rick and Morty", "30/08/2017", 5);
	}

	@Test(expected = ItemNaoEncontradoException.class)
	public void testRegistrarEmprestimoItemInvalido() throws UsuarioInvalidoException, 
		ItemNaoEncontradoException, ItemEmprestadoException {
		
		facade.registrarEmprestimo("Gabryelle", "99999-8888", "Joao", "98888-8888", "SOAD", "28/08/2017", 7);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRegistrarEmprestimoPeriodoInvalido() throws UsuarioInvalidoException,
		ItemNaoEncontradoException, ItemEmprestadoException {
		facade.registrarEmprestimo("Gabryelle", "99999-8888", "Joao", "98888-8888", "Beatles", "28/08/2017", 20);
		facade.registrarEmprestimo("Gabryelle", "99999-8888", "Joao", "98888-8888", "Beatles", "28/08/2017", 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRegistrarEmprestimoPeriodoNegativo() throws UsuarioInvalidoException,
		ItemNaoEncontradoException, ItemEmprestadoException {
		facade.registrarEmprestimo("Gabryelle", "99999-8888", "Joao", "98888-8888", "Beatles", "28/08/2017", -2);
	}

	@Test(expected = ItemEmprestadoException.class)
	public void testRegistrarEmprestimoInvalido() throws UsuarioInvalidoException,
		ItemNaoEncontradoException, ItemEmprestadoException {
		
		facade.registrarEmprestimo("Gabryelle", "99999-8888", "Joao", "98888-8888", "Beatles", "28/08/2017", 7);
		facade.registrarEmprestimo("Gabryelle", "99999-8888", "Andre", "99999-9999", "Beatles", "28/08/2017", 7);
	}

	@Test
	public void testDevolverEmprestimo() throws UsuarioInvalidoException, ItemNaoEncontradoException,
		ItemEmprestadoException, EmprestimoNaoEncontradoException {
		
		facade.registrarEmprestimo("Gabryelle", "99999-8888", "Andre","99999-9999", "Beatles", "28/08/2017", 7);
		facade.devolverItem("Gabryelle", "99999-8888", "Andre", "99999-9999", "Beatles", "28/08/2017", "03/09/2017");
	}

	@Test(expected = UsuarioInvalidoException.class)
	public void testDevolverEmprestimoUsuarioInvalido() throws UsuarioInvalidoException, 
		ItemNaoEncontradoException, ItemEmprestadoException, EmprestimoNaoEncontradoException {

		facade.registrarEmprestimo("Gabryelle", "99999-8888", "Andre", "99999-9999", "Beatles", "28/08/2017", 7);
		facade.devolverItem("Gabryelle", "99999-8888", "Mariah", "95289-9999", "Beatles", "28/08/2017", "03/09/2017");
	}

	@Test(expected = EmprestimoNaoEncontradoException.class)
	public void testDevolverEmprestimoInvalido() throws UsuarioInvalidoException, ItemNaoEncontradoException,
		ItemEmprestadoException, EmprestimoNaoEncontradoException {
		
		facade.devolverItem("Gabryelle", "99999-8888", "Andre", "99999-9999", "Prison Break", "28/08/2017", "03/09/2017");
	}

	/*
	 * Quando alguem ajeitar essas coisinhas, "descomenta" os testes e ve se
	 * funcionou corretamente 
	 * 
	 * OBS linha 39 Emprestimo, coloca isso em Validacoes tb
	 * OBS2 A data precisa ser verificada tb
	 * 
	 * 
	 * @Test // esse teste n deveria deixar nenhuma string ser nula 
	 * public void testRegistrarEmprestimoNulo() throws UsuarioInvalidoException,
	 * ItemNaoEncontradoException, ItemEmprestadoException {
	 * 
	 * 		facade.registrarEmprestimo(null, "99999-8888", "Joao", "98888-8888", "Beatles", "28/08/2017", 7);
	 * 		facade.registrarEmprestimo("Gabryelle", null, "Joao", "98888-8888", "Beatles", "28/08/2017", 7);
	 * 		facade.registrarEmprestimo("Gabryelle", "99999-8888", null, "98888-8888", "Beatles", "28/08/2017", 7);
	 * 		facade.registrarEmprestimo("Gabryelle", "99999-8888", "Joao", null, "Beatles", "28/08/2017", 7);
	 * 		facade.registrarEmprestimo("Gabryelle", "99999-8888", "Joao", "98888-8888", null, "28/08/2017", 7);
	 * 		facade.registrarEmprestimo("Gabryelle", "99999-8888", "Joao", "98888-8888", "Beatles", null, 7); 
	 * }
	 * 
	 * @Test // esse teste n deveria deixar nenhuma string ser vazia 
	 * public void testRegistrarEmprestimoVazio() throws UsuarioInvalidoException,
	 * ItemNaoEncontradoException, ItemEmprestadoException {
	 * 
	 *		facade.registrarEmprestimo("", "99999-8888", "Joao", "98888-8888", "Beatles", "28/08/2017", 7);
	 *		facade.registrarEmprestimo("Gabryelle", "", "Joao", "98888-8888", "Beatles", "28/08/2017", 7);
	 *		facade.registrarEmprestimo("Gabryelle", "99999-8888", "", "98888-8888", "Beatles", "28/08/2017", 7);
	 *		facade.registrarEmprestimo("Gabryelle", "99999-8888", "Joao", "", "Beatles", "28/08/2017", 7);
	 *		facade.registrarEmprestimo("Gabryelle", "99999-8888", "Joao", "98888-8888", "", "28/08/2017", 7);
	 *		facade.registrarEmprestimo("Gabryelle", "99999-8888", "Joao", "98888-8888", "Beatles", "", 7); 
	 * }
	 * 
	 * @Test // data do emprestimo
	 * public void testRegistrarEmprestimoDataInvalida() throws UsuarioInvalidoException,
	 * ItemNaoEncontradoException, ItemEmprestadoException {
	 * 
	 * 		facade.registrarEmprestimo("Gabryelle", "99999-8888", "Joao", "98888-8888", "Beatles", "39/13/-200", 7); 
	 * }
	 */
}
