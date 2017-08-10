package usuario;

import java.util.HashSet;
import java.util.Set;

import FacadeEMain.Validacoes;
import exception.AtributoInvalidoException;
import exception.ItemNaoEncontradoException;
import exception.PecaPerdidaException;
import exception.StringInvalidaException;
import exception.UsuarioCadastradoException;
import exception.UsuarioInvalidoException;
import item.Item;

public class CrudUsuario {
	
	private Set<Usuario> usuarios;
	
	public CrudUsuario() {
		usuarios = new HashSet<>();
	}

	public void cadastraUsuario(String nome, String telefone, String email) throws UsuarioCadastradoException, StringInvalidaException {
		Validacoes.validaCadastrarUsuario(nome, telefone, email);

		if (buscaUsuario(nome, telefone) != null) {
			throw new UsuarioCadastradoException();
		}
		Usuario usuario = new Usuario(nome, telefone, email);
		usuarios.add(usuario);			
	}
	
	public void removerUsuario(String nome, String telefone) throws UsuarioInvalidoException {
		Usuario user = buscaUsuario(nome, telefone);
		if (user == null) {
			throw new UsuarioInvalidoException();
		}
		
		usuarios.remove(user);
	}
	
	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) throws StringInvalidaException {
		Validacoes.validaAtualizarUsuario(atributo, valor);

		Usuario user = buscaUsuario(nome, telefone);
		
		if (user == null) {
			throw new UsuarioInvalidoException();
		}
		
		if (atributo.trim().equalsIgnoreCase("nome")) {
			user.setNome(valor);
		}
		else if (atributo.trim().equalsIgnoreCase("telefone")) {
			user.setTelefone(valor);
		}
		
		else if (atributo.trim().equalsIgnoreCase("email")) {
			user.setEmail(valor);
		}
	}
	
	public String getInfoUsuario(String nome, String telefone, String atributo) throws StringInvalidaException {
		Usuario user = buscaUsuario(nome, telefone);
		
		if (user == null) {
			throw new UsuarioInvalidoException();
		}
		String info = null;
		if (atributo.trim().equalsIgnoreCase("nome")) {
			info = user.getNome();
		}
		else if (atributo.trim().equalsIgnoreCase("telefone")) {
			info = user.getTelefone();
		}
		else if (atributo.trim().equalsIgnoreCase("email")) {
			info = user.getEmail();
		}
		else {
			throw new AtributoInvalidoException();
		}

		return info;
	}
	
	public void cadastrarEletronico(String nome, String telefone, Item item ) throws UsuarioInvalidoException {
		Usuario usuario = buscaUsuario(nome, telefone);
		if (usuario == null) {
			throw new UsuarioInvalidoException();
		}         
		
		usuario.cadastraEletronico(item);
	}
	
	public void cadastrarJogoTabuleiro(String nome, String telefone,Item item) throws UsuarioInvalidoException {
		Usuario usuario = buscaUsuario(nome, telefone);
		if (usuario == null) {
			throw new UsuarioInvalidoException();
		}
		
		usuario.cadastraJogoTabuleiro(item);
	}
	
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) throws Exception {
		Usuario usuario = buscaUsuario(nome, telefone);
		if (usuario == null) {
			throw new PecaPerdidaException();
		}

		usuario.adicionarPecaPerdida(nomeItem, nomePeca);
	}
	
	public void cadastrarBluRayFilme(String nome, String telefone, Item item) {
		Usuario usuario = buscaUsuario(nome, telefone);
		
		if (usuario == null) {
			throw new NullPointerException("Erro no cadastro de BluRay de filme");
		}
		
		usuario.cadastrarBluRayFilme(item);
	}
	
	public void cadastrarBluRayShow(String nome, String telefone,Item item) throws UsuarioInvalidoException {
		Usuario usuario = buscaUsuario(nome, telefone);
		if (usuario == null) {
			throw new UsuarioInvalidoException();
		}

		usuario.cadastrarBluRayShow(item);
	}
	
	public void cadastrarBluRaySerie(String nome, String telefone, Item item) throws UsuarioInvalidoException {
		Usuario usuario = buscaUsuario(nome, telefone);
		
		if (usuario == null) {
			throw new UsuarioInvalidoException();
		}
		
		usuario.cadastrarBluRaySerie(item);
	}

	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao) throws UsuarioInvalidoException, ItemNaoEncontradoException {
		Usuario usuario = buscaUsuario(nome, telefone);
		
		if (usuario == null) {
			throw new UsuarioInvalidoException();
		}
		
		usuario.adicionarBluRay(nomeBlurayTemporada, duracao);
	}
	
	public void removerItem(String nome, String telefone, String nomeItem) throws UsuarioInvalidoException, ItemNaoEncontradoException {
		Usuario usuario = buscaUsuario(nome, telefone);
		
		if (usuario == null) {
			throw new UsuarioInvalidoException();
		}
		
		usuario.removerItem(nomeItem);
	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) throws UsuarioInvalidoException, ItemNaoEncontradoException {
		Usuario usuario = buscaUsuario(nome, telefone);
		
		if (usuario == null) {
			throw new UsuarioInvalidoException();
		}
		
		Validacoes.validaAtualizarItem(atributo, valor);
		
		usuario.atualizarItem(nomeItem, atributo, valor);
	}
	
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) throws UsuarioInvalidoException, ItemNaoEncontradoException {
		Usuario usuario = buscaUsuario(nome, telefone);
		
		if (usuario == null) {
			throw new UsuarioInvalidoException();
		}
		
		return usuario.getInfoItem(nomeItem, atributo);
	}
	
	public String pesquisarDetalhesItem(String nomeItem, String nomeDono, String telefoneDono) throws UsuarioInvalidoException, ItemNaoEncontradoException {
		Usuario user = buscaUsuario(nomeDono, telefoneDono);
		
		if (user == null) {
			throw new UsuarioInvalidoException();
		}
		
		return user.detalhesItem(nomeItem);
	}

	private Usuario buscaUsuario(String nome, String telefone) {
		Usuario user = null;
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().equals(nome) && usuario.getTelefone().equals(telefone)) {
				user = usuario;
			}
		}

		return user;
	}
	
}