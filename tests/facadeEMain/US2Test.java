package facadeEMain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exceptionsComplementares.AtributoInvalidoException;
import exceptionsComplementares.ItemCadastradoException;
import exceptionsComplementares.ItemNaoEncontradoException;
import exceptionsComplementares.StringInvalidaException;
import exceptionsComplementares.UsuarioCadastradoException;
import exceptionsItem.DuracaoInvalidaException;
import exceptionsItem.NumeroDeFaixasMenorQue0Exception;
import exceptionsItem.PecaJaRegistrada;
import exceptionsItem.PrecoInvalidoException;
import exceptionsItem.SerieNaoValidaException;
import exceptionsItem.TemporadaMenorQue1Exception;
import exceptionsUsuario.UsuarioInvalidoException;
import facadeEMain.Facade;

public class US2Test {
	
	Facade facade;

	@Before
	public void setUp() throws StringInvalidaException, UsuarioCadastradoException, IllegalArgumentException, ItemCadastradoException {
		facade = new Facade();
		facade.cadastrarUsuario("Joao", "98888-8888", "joao@email.com");
		facade.cadastrarUsuario("Andre", "99999-9999", "andre@email.com");
		facade.cadastrarUsuario("Gabryelle", "99999-8888", "gabs@email.com");
		facade.cadastrarBluRayShow("Gabryelle", "99999-8888", "Beatles", 180.00, 75, 12, "John, Paul, Ringo e George", "DEZ_ANOS");
	}

	
	// ------------------------------------------US2--------------------------------------------------
	// cadastrarEletronico, getInfoItem, cadastrarJogoTabuleiro, adicionarPecaPerdida, cadastrarBluRayFilme
	// cadastrarBluRayShow, cadastrarBluRaySerie, adicionarBluRay, removerItem, atualizarItem
	
	
	@Test
	public void testCadastrarEletronico() throws UsuarioCadastradoException, ItemNaoEncontradoException, IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
		facade.cadastrarEletronico("Joao", "98888-8888", "Uncharted 4", 79.99, "PS4");
		facade.cadastrarEletronico("Andre", "99999-9999", "Life Is Strange", 36.99, "PC");
		facade.cadastrarEletronico("Andre", "99999-9999", "Pokémon GO", 36.99, "Android");
	
		assertEquals("79.99", facade.getInfoItem("Joao", "98888-8888", "Uncharted 4", "preco"));
		assertEquals("36.99", facade.getInfoItem("Andre", "99999-9999", "Life Is Strange", "preco"));
		assertEquals("OUTRO", facade.getInfoItem("Andre", "99999-9999", "Pokémon GO", "plataforma"));
	}
	
	
	@Test (expected= StringInvalidaException.class)
	public void testCadastrarEletronicoNulo() throws UsuarioCadastradoException, IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
		facade.cadastrarEletronico("Joao", "98888-8888", null, 9.99, "PC");
		facade.cadastrarEletronico("Joao", "98888-8888", "Pokemon", 9.99, "PC");
		facade.cadastrarEletronico("Joao", "98888-8888", "Pokemon", 9.99, null);
	}

	@Test (expected= StringInvalidaException.class)
	public void testCadastrarEletronicoVazio() throws UsuarioCadastradoException, IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
		facade.cadastrarEletronico("Joao", "98888-8888", "", 9.99, "PC");
		facade.cadastrarEletronico("Joao", "98888-8888", "Pokemon", 9.99, "PC");
		facade.cadastrarEletronico("Joao", "98888-8888", "Pokemon", 9.99, "");
	}
	
	@Test (expected= UsuarioInvalidoException.class)
	public void testCadastrarEletronicoUsuarioInvalido() throws UsuarioCadastradoException, IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
		facade.cadastrarEletronico("Mariah", "98989-8888", "CS Go", 45.99, "PC");
	}
	
	@Test (expected= PrecoInvalidoException.class)
	public void testCadastrarEletronicoPrecoInvalido() throws UsuarioCadastradoException, IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
		facade.cadastrarEletronico("Joao", "98888-8888", "GTA V", -18.00, "XBOX360");
	}
	
	@Test (expected= ItemCadastradoException.class)
	public void testCadastrarEletronicoJaCadastrado() throws IllegalArgumentException, UsuarioCadastradoException, ItemCadastradoException, StringInvalidaException {
		facade.cadastrarEletronico("Joao", "98888-8888", "Uncharted 4", 79.99, "PS4");
		facade.cadastrarEletronico("Joao", "98888-8888", "Uncharted 4", 79.99, "PS4");
	}

	@Test
	public void testCadastrarJogoTabuleiro() throws ItemNaoEncontradoException, IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
		facade.cadastrarJogoTabuleiro("Andre", "99999-9999", "War", 99.99);
		assertEquals(facade.getInfoItem("Andre", "99999-9999", "War", "Preco"), "99.99");
	}
	
	@Test (expected= StringInvalidaException.class)
	public void testCadastrarJogoTabuleiroNulo() throws ItemNaoEncontradoException, IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
		facade.cadastrarJogoTabuleiro("Andre", "99999-9999", null, 99.99);
	}
	
	@Test (expected= StringInvalidaException.class)
	public void testCadastrarJogoTabuleiroVazio() throws ItemNaoEncontradoException, IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
		facade.cadastrarJogoTabuleiro("Andre", "99999-9999", "", 99.99);
	}
	
	@Test (expected= PrecoInvalidoException.class)
	public void testCadastrarJogoTabuleiroInvalido() throws ItemNaoEncontradoException, IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
		facade.cadastrarJogoTabuleiro("Andre", "99999-9999", "War", -1);
	}
	
	@Test (expected= ItemCadastradoException.class)
	public void testCadastrarJogoTabuleiroJaCadastrado() throws IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
		facade.cadastrarJogoTabuleiro("Andre", "99999-9999", "War", 99.99);
		facade.cadastrarJogoTabuleiro("Andre", "99999-9999", "War", 99.99);
	}
	
	@Test
	public void testAdicionarPecaPerdida() throws Exception  {
		facade.cadastrarJogoTabuleiro("Joao", "98888-8888", "Monopoly", 115.90);
		facade.adicionarPecaPerdida("Joao", "98888-8888", "Monopoly", "Carrinho");
		assertEquals(facade.getInfoItem("Joao", "98888-8888", "Monopoly", "peca perdida"), "Carrinho");
	}
	
	@Test (expected= ItemNaoEncontradoException.class)
	public void testAdicionarPecaPerdidaJogoInexistente() throws Exception {
		facade.adicionarPecaPerdida("Joao", "98888-8888", "Banco Imobiliario", "Cartão");
	}
	
	@Test (expected= PecaJaRegistrada.class)
	public void testAdicionarPecaPerdidaJaRegistrada() throws Exception {
		facade.cadastrarJogoTabuleiro("Joao", "98888-8888", "Monopoly", 115.90);
		facade.adicionarPecaPerdida("Joao", "98888-8888", "Monopoly", "Carrinho");
		facade.adicionarPecaPerdida("Joao", "98888-8888", "Monopoly", "Carrinho");
	}
	
	@Test
	public void testCadastrarBluRayFilme() throws ItemNaoEncontradoException, IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "O Profissional", 7.50, 103, "ACAO", "QUATORZE_ANOS", 1994);
		assertEquals(facade.getInfoItem("Joao", "98888-8888", "O Profissional", "preco"), "7.5");
		assertEquals(facade.getInfoItem("Joao", "98888-8888", "O Profissional", "duracao"), "103");
		assertEquals(facade.getInfoItem("Joao", "98888-8888", "O Profissional", "genero"), "ACAO");
		assertEquals(facade.getInfoItem("Joao", "98888-8888", "O Profissional", "classificacao"), "QUATORZE_ANOS");
		assertEquals(facade.getInfoItem("Joao", "98888-8888", "O Profissional", "ano de lancamento"), "1994");
	}
	
	@Test (expected= StringInvalidaException.class)
	public void testCadastrarBluRayFilmeNulo() throws IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
		facade.cadastrarBluRayFilme("Joao", "98888-8888", null, 7.50, 103, "ACAO", "QUATORZE_ANOS", 1994);
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "O Profissional", 7.50, 103, null, "QUATORZE_ANOS", 1994);
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "O Profissional", 7.50, 103, "ACAO", null, 1994);
	}
	
    @Test (expected= StringInvalidaException.class)
	public void testCadastrarBluRayFilmeVazio() throws IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "", 7.50, 103, "ACAO", "QUATORZE_ANOS", 1994);
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "O Profissional", 7.50, 103, "", "QUATORZE_ANOS", 1994);
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "O Profissional", 7.50, 103, "ACAO", "", 1994);
	}
	
	@Test (expected= PrecoInvalidoException.class)
	public void testCadastrarBluRayFilmeInvalido() throws IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "Sniper Americano", -2.00, 132, "GUERRA", "DEZESSEIS_ANOS", 2015);
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "Sniper Americano", 6.00, -132, "GUERRA", "DEZESSEIS_ANOS", 2015);
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "Sniper Americano", 6.00, 132, "TIRO", "DEZESSEIS_ANOS", 2015);
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "Sniper Americano", 6.00, 132, "GUERRA", "NOVENTA_ANOS", 2015);
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "Sniper Americano", 6.00, 132, "GUERRA", "DEZESSEIS_ANOS", -2000);
	}
	@Test (expected= ItemCadastradoException.class)
	public void testCadastrarBluRayFilmeJaExistente() throws IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "O Profissional", 7.50, 103, "ACAO", "QUATORZE_ANOS", 1994);
		facade.cadastrarBluRayFilme("Joao", "98888-8888", "O Profissional", 7.50, 103, "ACAO", "QUATORZE_ANOS", 1994);
	}

    @Test
	public void testCadastrarBluRayShow() throws IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
    	facade.cadastrarBluRayShow("Gabryelle", "99999-8888", "Show de Lady Gaga", 150.00, 120, 10, "Lady Gaga", "DEZESSEIS_ANOS");
	}
    
	@Test (expected= StringInvalidaException.class)
    public void testCadastrarBluRayShowNulo() throws IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
    	facade.cadastrarBluRayShow("Gabryelle", "99999-8888", null, 150.00, 120, 10, "Lady Gaga", "DEZESSEIS_ANOS");
    	facade.cadastrarBluRayShow("Gabryelle", "99999-8888", "Show de Lady Gaga", 150.00, 120, 10, null, "DEZESSEIS_ANOS");
    	facade.cadastrarBluRayShow("Gabryelle", "99999-8888", "Show de Lady Gaga", 150.00, 120, 10, "Lady Gaga", null);
    }
    
	@Test (expected= StringInvalidaException.class)
    public void testCadastrarBluRayShowVazio() throws IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
    	facade.cadastrarBluRayShow("Gabryelle", "99999-8888", "", 150.00, 120, 10, "Lady Gaga", "DEZESSEIS_ANOS");
    }
    
	@Test (expected= StringInvalidaException.class)
    public void testCadastrarBluRayShowNomeDoArtistaVazio() throws IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
    	facade.cadastrarBluRayShow("Gabryelle", "99999-8888", "Show de Lady Gaga", 150.00, 120, 10, "", "DEZESSEIS_ANOS");
    }
    
	@Test (expected= StringInvalidaException.class)
    public void testCadastrarBluRayShowClassificacaoVazia() throws IllegalArgumentException, ItemCadastradoException, StringInvalidaException {    
    	facade.cadastrarBluRayShow("Gabryelle", "99999-8888", "Show de Lady Gaga", 150.00, 120, 10, "Lady Gaga", "");
    }
    
    @Test (expected= PrecoInvalidoException.class)
    public void testCadastrarBluRayShowPrecoInvalido() throws IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
    
    	facade.cadastrarBluRayShow("Gabryelle", "99999-8888", "Show de Lady Gaga", -1000.00, 120, 10, "Lady Gaga", "DEZESSEIS_ANOS");
    }

    @Test (expected= DuracaoInvalidaException.class)
    public void testCadastrarBluRayShowDuracaoInvalida() throws IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
    	
    	facade.cadastrarBluRayShow("Gabryelle", "99999-8888", "Show de Lady Gaga", 150.00, -120, 10, "Lady Gaga", "DEZESSEIS_ANOS");
    }
    
    @Test (expected= NumeroDeFaixasMenorQue0Exception.class)
    public void testCadastrarBluRayShowNumFaixasInvalido() throws IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
    	facade.cadastrarBluRayShow("Gabryelle", "99999-8888", "Show de Lady Gaga", 150.00, 120, -10, "Lady Gaga", "DEZESSEIS_ANOS");
    }
    
    @Test (expected= ItemCadastradoException.class)
   	public void testCadastrarBluRayShowJaExistente() throws IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
       	facade.cadastrarBluRayShow("Gabryelle", "99999-8888", "Show de Lady Gaga", 150.00, 120, 10, "Lady Gaga", "DEZESSEIS_ANOS");
       	facade.cadastrarBluRayShow("Gabryelle", "99999-8888", "Show de Lady Gaga", 150.00, 120, 10, "Lady Gaga", "DEZESSEIS_ANOS");
    }
    
    @Test
    public void testCadastrarBluRaySerie() throws IllegalArgumentException, ItemCadastradoException, ItemNaoEncontradoException, StringInvalidaException {

    	facade.cadastrarBluRaySerie("Gabryelle", "99999-8888", "Breaking Bad", 19.99, "Metanfetamina, Walt e Jesse", 1200, "DOZE_ANOS", "DRAMA", 1);
    	assertEquals(facade.getInfoItem("Gabryelle", "99999-8888", "Breaking Bad", "preco"), "19.99");
    	assertEquals(facade.getInfoItem("Gabryelle", "99999-8888", "Breaking Bad", "descricao"), "Metanfetamina, Walt e Jesse");
    	assertEquals(facade.getInfoItem("Gabryelle", "99999-8888", "Breaking Bad", "duracao"), "1200");
    	assertEquals(facade.getInfoItem("Gabryelle", "99999-8888", "Breaking Bad", "classificacao"), "DOZE_ANOS");
    	assertEquals(facade.getInfoItem("Gabryelle", "99999-8888", "Breaking Bad", "genero"), "DRAMA");
    	assertEquals(facade.getInfoItem("Gabryelle", "99999-8888", "Breaking Bad", "temporada"), "1");
    }

	@Test (expected= StringInvalidaException.class)
    public void testCadastrarBluRaySerieNomeNuloOuVazio() throws IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
    	facade.cadastrarBluRaySerie("Gabryelle", "99999-8888", null, 19.99, "Metanfetamina, Walt e Jesse", 1200, "DOZE_ANOS", "DRAMA", 1);
    	facade.cadastrarBluRaySerie("Gabryelle", "99999-8888", "", 19.99, "Metanfetamina, Walt e Jesse", 1200, "DOZE_ANOS", "DRAMA", 1);
    }
    
	@Test (expected= StringInvalidaException.class)
    public void testCadastrarBluRaySerieDescricaoNulaOuVazia() throws IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
        facade.cadastrarBluRaySerie("Gabryelle", "99999-8888", "Breaking Bad", 19.99, null, 1200, "DOZE_ANOS", "DRAMA", 1);
        facade.cadastrarBluRaySerie("Gabryelle", "99999-8888", "Breaking Bad", 19.99, "", 1200, "DOZE_ANOS", "DRAMA", 1);
    }
    
	@Test (expected= StringInvalidaException.class)
    public void testCadastrarBluRaySerieClassificacaoNulaOuVazia() throws IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
    	facade.cadastrarBluRaySerie("Gabryelle", "99999-8888", "Breaking Bad", 19.99, "Metanfetamina, Walt e Jesse", 1200, null, "DRAMA", 1);
    	facade.cadastrarBluRaySerie("Gabryelle", "99999-8888", "Breaking Bad", 19.99, "Metanfetamina, Walt e Jesse", 1200, "", "DRAMA", 1);
    }
    
	@Test (expected= StringInvalidaException.class)
    public void testCadastrarBluRaySerieGeneroNuloOuVazio() throws IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
		facade.cadastrarBluRaySerie("Gabryelle", "99999-8888", "Breaking Bad", 19.99, "Metanfetamina, Walt e Jesse", 1200, "DOZE_ANOS", null, 1);
    	facade.cadastrarBluRaySerie("Gabryelle", "99999-8888", "Breaking Bad", 19.99, "Metanfetamina, Walt e Jesse", 1200, "DOZE_ANOS", "", 1);
    }  
    
    @Test (expected= PrecoInvalidoException.class)
    public void testCadastrarBluRaySeriePrecoInvalido() throws IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
    	facade.cadastrarBluRaySerie("Gabryelle", "99999-8888", "Breaking Bad", -2.99, "Metanfetamina, Walt e Jesse", 1200, "DOZE_ANOS", "DRAMA", 1);
    }    
    
    @Test (expected= DuracaoInvalidaException.class)
    public void testCadastrarBluRaySerieDuracaoInvalida() throws IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
    	facade.cadastrarBluRaySerie("Gabryelle", "99999-8888", "Breaking Bad", 19.99, "Metanfetamina, Walt e Jesse", -1200, "DOZE_ANOS", "DRAMA", 1);
    }    
    
    @Test (expected= TemporadaMenorQue1Exception.class)
    public void testCadastrarBluRaySerieTemporadaInvalida() throws IllegalArgumentException, ItemCadastradoException, StringInvalidaException {
    	facade.cadastrarBluRaySerie("Gabryelle", "99999-8888", "Breaking Bad", 19.99, "Metanfetamina, Walt e Jesse", 1200, "DOZE_ANOS", "DRAMA", -2);
    }
    
    @Test (expected= ItemCadastradoException.class)
    public void testCadastrarBluRaySerieJaExistente() throws IllegalArgumentException, ItemCadastradoException, ItemNaoEncontradoException, StringInvalidaException {
    	facade.cadastrarBluRaySerie("Gabryelle", "99999-8888", "Breaking Bad", 19.99, "Metanfetamina, Walt e Jesse", 1200, "DOZE_ANOS", "DRAMA", 1);
    	facade.cadastrarBluRaySerie("Gabryelle", "99999-8888", "Breaking Bad", 19.99, "Metanfetamina, Walt e Jesse", 1200, "DOZE_ANOS", "DRAMA", 1);
    }
    
    @Test
    public void testAdicionarBluRaySerie() throws IllegalArgumentException, ItemNaoEncontradoException, SerieNaoValidaException, ItemCadastradoException, StringInvalidaException {
    	facade.cadastrarBluRaySerie("Andre", "99999-9999", "The Blacklist", 17.00, "A Lista Negra de Raymond Reddington", 980, "DOZE_ANOS", "POLICIAL", 1);
    	facade.adicionarBluRay("Andre", "99999-9999", "The Blacklist", 800);
    }
    
    @Test (expected= StringInvalidaException.class)
    public void testAdicionarBluRaySerieNomeInvalido() throws IllegalArgumentException, ItemCadastradoException, ItemNaoEncontradoException, SerieNaoValidaException, StringInvalidaException {
    	facade.cadastrarBluRaySerie("Andre", "99999-9999", "The Blacklist", 17.00, "A Lista Negra de Raymond Reddington", 980, "DOZE_ANOS", "POLICIAL", 1);
    	facade.adicionarBluRay("Andre", "99999-9999", "", 730);	
    	facade.adicionarBluRay("Andre", "99999-9999", null, 730);	
    }
    
    @Test (expected= DuracaoInvalidaException.class)
    public void testAdicionarBluRaySerieDuracaoInvalida() throws StringInvalidaException, IllegalArgumentException, ItemCadastradoException, ItemNaoEncontradoException, SerieNaoValidaException {
    	facade.cadastrarBluRaySerie("Andre", "99999-9999", "The Blacklist", 17.00, "A Lista Negra de Raymond Reddington", 980, "DOZE_ANOS", "POLICIAL", 1);
    	facade.adicionarBluRay("Andre", "99999-9999", "The Blacklist", -730);	
    }
    
    @Test (expected= ItemNaoEncontradoException.class)
    public void testAdicionarBluRaySerieItemNaoEncontrado() throws IllegalArgumentException, ItemCadastradoException, ItemNaoEncontradoException, SerieNaoValidaException, StringInvalidaException {
    	facade.cadastrarBluRaySerie("Andre", "99999-9999", "The Blacklist", 17.00, "A Lista Negra de Raymond Reddington", 980, "DOZE_ANOS", "POLICIAL", 1);
    	facade.adicionarBluRay("Andre", "99999-9999", "A Lista Negra", 730);	
    }

    @Test (expected= UsuarioInvalidoException.class)
    public void testAdicionarBluRaySerieUsuarioInvalido() throws IllegalArgumentException, ItemCadastradoException, ItemNaoEncontradoException, SerieNaoValidaException, StringInvalidaException {
    	facade.adicionarBluRay("Edvaldo", "98989-9999", "Jessica Jones", 810);	
    }
    
    @Test
    public void testAtualizarItem() throws IllegalArgumentException, ItemNaoEncontradoException, StringInvalidaException {
    	assertEquals(facade.getInfoItem("Gabryelle", "99999-8888", "Beatles", "nome do artista"), "John, Paul, Ringo e George");
    	facade.atualizarItem("Gabryelle", "99999-8888", "Beatles", "nome", "The Beatles");
    	assertEquals(facade.getInfoItem("Gabryelle", "99999-8888", "The Beatles", "nome do artista"), "John, Paul, Ringo e George");
    }
    
    @Test (expected= AtributoInvalidoException.class)
    public void testAtualizarItemAtributoInvalido() throws IllegalArgumentException, ItemNaoEncontradoException, StringInvalidaException {
    	facade.atualizarItem("Gabryelle", "99999-8888", "Beatles", "produtor", "Alguem");
    }
    
    @Test (expected= UsuarioInvalidoException.class)
    public void testAtualizarItemUsuarioInvalido() throws IllegalArgumentException, ItemNaoEncontradoException, StringInvalidaException {
    	facade.atualizarItem("Giovana", "99997-8888", "Beatles", "nome", "The Beatles");
    }
    
    @Test (expected= ItemNaoEncontradoException.class)
    public void testAtualizarItemInvalido() throws IllegalArgumentException, ItemNaoEncontradoException, StringInvalidaException {
    	facade.atualizarItem("Gabryelle", "99999-8888", "System Of A Down", "nome", "SOAD");
    }

    @Test (expected= ItemNaoEncontradoException.class)
    public void testRemoverItem() throws UsuarioInvalidoException, ItemNaoEncontradoException {
    	facade.removerItem("Gabryelle", "99999-8888", "Beatles");
    	facade.removerItem("Gabryelle", "99999-8888", "Beatles"); //a excecao ocorre porque o item foi removido corretamente
    }
    
    @Test (expected= ItemNaoEncontradoException.class)
    public void testRemoverItemInvalido() throws UsuarioInvalidoException, ItemNaoEncontradoException {
    	facade.removerItem("Gabryelle", "99999-8888", "SOAD");
    }
    
    @Test (expected= UsuarioInvalidoException.class)
    public void testRemoverItemUsuarioInvalido() throws UsuarioInvalidoException, ItemNaoEncontradoException {
    	facade.removerItem("Giovana", "99999-8888", "Rihanna");
    }    
}
