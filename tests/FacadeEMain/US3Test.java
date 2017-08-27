package FacadeEMain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exceptionsComplementares.ItemCadastradoException;
import exceptionsComplementares.ItemNaoEncontradoException;
import exceptionsComplementares.StringInvalidaException;
import exceptionsComplementares.UsuarioCadastradoException;
import exceptionsUsuario.UsuarioInvalidoException;
import facadeEMain.Facade;

public class US3Test {

	Facade facade;

	@Before
	public void setUp() throws StringInvalidaException, UsuarioCadastradoException, IllegalArgumentException, ItemCadastradoException {
		facade = new Facade();
		facade.cadastrarUsuario("Joao", "98888-8888", "joao@email.com");
		facade.cadastrarUsuario("Andre", "99999-9999", "andre@email.com");
		facade.cadastrarUsuario("Gabryelle", "99999-8888", "gabs@email.com");
	}


	// ------------------------------------------US3--------------------------------------------------
	// listarItensOrdenadosPorNome, listarItensOrdenadosPorValor, pesquisarDetalhesItem


	@Test
	public void testListarItensOrdenadosPorNomeVazio() {
		assertEquals(facade.listarItensOrdenadosPorNome(), "Nenhum item");
	}
	
	@Test
	public void testListarItensOrdenadosPorValorVazio() {
		assertEquals(facade.listarItensOrdenadosPorValor(), "Nenhum item");
	}
	
	@Test
	public void testListarItensOrdenadosPorNome() throws StringInvalidaException, IllegalArgumentException, ItemCadastradoException {		
		String itens = "SHOW: Aurora, R$ 150.0, Nao emprestado, 110 min, DOZE_ANOS, Aurora, 13 faixas|SHOW: Beatles, R$ 180.0, Nao emprestado," +
				" 75 min, DEZ_ANOS, John, Paul, Ringo e George, 12 faixas|FILME: Crepusculo, R$ 1.99, Nao emprestado, 120 min, QUATORZE_ANOS, " +
				"ROMANCE, 2008|SERIE: HIMYM, R$ 20.0, Nao emprestado, 880 min, LIVRE, OUTRO, Temporada 1|";
		
		facade.cadastrarBluRayShow("Gabryelle", "99999-8888", "Beatles", 180.00, 75, 12, "John, Paul, Ringo e George", "DEZ_ANOS");
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "Crepusculo", 1.99, 120, "ROMANCE", "QUATORZE_ANOS", 2008);
		facade.cadastrarBluRayShow("Gabryelle", "99999-8888", "Aurora", 150, 110, 13, "Aurora", "DOZE_ANOS");
		facade.cadastrarBluRaySerie("Joao", "98888-8888", "HIMYM", 20.00, "Essa eh a historia de como eu conheci sua mae", 880, "LIVRE", "HUMOR", 1);
		
		assertEquals(facade.listarItensOrdenadosPorNome(), itens);
	}
	
	@Test
	public void testListarItensOrdenadosPorValor() throws StringInvalidaException, IllegalArgumentException, ItemCadastradoException {		
		String itens = "FILME: Crepusculo, R$ 1.99, Nao emprestado, 120 min, QUATORZE_ANOS, ROMANCE, 2008|SERIE: HIMYM, R$ 20.0, " +
				"Nao emprestado, 880 min, LIVRE, OUTRO, Temporada 1|SHOW: Aurora, R$ 150.0, Nao emprestado, 110 min, DOZE_ANOS, Aurora," +
				" 13 faixas|SHOW: Beatles, R$ 180.0, Nao emprestado, 75 min, DEZ_ANOS, John, Paul, Ringo e George, 12 faixas|";
		
		facade.cadastrarBluRayShow("Gabryelle", "99999-8888", "Beatles", 180.00, 75, 12, "John, Paul, Ringo e George", "DEZ_ANOS");
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "Crepusculo", 1.99, 120, "ROMANCE", "QUATORZE_ANOS", 2008);
		facade.cadastrarBluRayShow("Gabryelle", "99999-8888", "Aurora", 150, 110, 13, "Aurora", "DOZE_ANOS");
		facade.cadastrarBluRaySerie("Joao", "98888-8888", "HIMYM", 20.00, "Essa eh a historia de como eu conheci sua mae", 880, "LIVRE", "HUMOR", 1);
		
		assertEquals(facade.listarItensOrdenadosPorValor(), itens);
	}
	
	@Test
	public void testPesquisarDetalhesItem() throws ItemNaoEncontradoException, StringInvalidaException, IllegalArgumentException, ItemCadastradoException {		
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "Rota De Fuga", 12.00, 132, "ACAO", "QUATORZE_ANOS", 2012);
		facade.pesquisarDetalhesItem("Joao", "98888-8888", "Rota De Fuga");
	}
	
	@Test (expected= UsuarioInvalidoException.class)
	public void testPesquisarDetalhesItemUsuarioInvalido() throws UsuarioInvalidoException, ItemNaoEncontradoException  {		
		facade.pesquisarDetalhesItem("Maria", "96666-6666", "Crepusculo");
	}
	
	@Test (expected= ItemNaoEncontradoException.class)
	public void testPesquisarDetalhesItemInexistente() throws UsuarioInvalidoException, ItemNaoEncontradoException  {		
		facade.pesquisarDetalhesItem("Joao", "98888-8888", "Sem Limites");
	}
}
