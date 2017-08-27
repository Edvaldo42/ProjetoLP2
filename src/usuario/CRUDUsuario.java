package usuario;

import java.util.Set;

import exceptionsComplementares.AtributoInvalidoException;
import exceptionsComplementares.StringInvalidaException;
import exceptionsComplementares.UsuarioCadastradoException;
import exceptionsUsuario.UsuarioInvalidoException;

public class CRUDUsuario {
	
	/**
	 * Cadastra um usuario no sistema
	 * 
	 * @param nome O nome do usuario a ser cadastrado
	 * @param telefone O telefone do usuario a ser cadastrado
	 * @param email O email do usuario a ser cadastrado
	 * @throws UsuarioCadastradoException Caso o usuario ja esteja cadastrado
	 * @throws StringInvalidaException Caso alguma String seja invalida
	 */
	public static void cadastraUsuario(String nome, String telefone, String email, Set<Usuario> usuarios)
			throws UsuarioCadastradoException, StringInvalidaException {

		Usuario user = new Usuario(nome, telefone, email);
		if (!usuarios.add(user)) {
			throw new UsuarioCadastradoException();
		}
	}

	/**
	 * Remove o usuario do sistema
	 * 
	 * @param nome O nome do usuario
	 * @param telefone O telefone do usuario 
	 * @param usuarios O conjunto onde esse usuario será adicionado
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 */
	public static void removerUsuario(String nome, String telefone, Set<Usuario> usuarios) 
			throws UsuarioInvalidoException {
		
		Usuario user = buscaUsuario(nome, telefone, usuarios);
		usuarios.remove(user);
	}

	/**
	 * Atualiza uma informacao, passada no atributo, de um usuario
	 * 
	 * @param nome O nome do usuario a ter uma informacao atualizada
	 * @param telefone O telefone do usuario a ter uma informacao atualizada
	 * @param atributo O atributo que devera ser atualizado
	 * @param valor A nova informacao a ser atualizada
	 * @param usuarios O conjunto onde esse usuario será atualizado
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 * @throws AtributoInvalidoException Caso o atributo seja invalido
	 */
	public static void atualizarUsuario(String nome, String telefone, String atributo, String valor, Set<Usuario> usuarios) throws UsuarioInvalidoException, AtributoInvalidoException {
		
		Usuario user = buscaUsuario(nome, telefone, usuarios);

		switch (atributo.toLowerCase()) {
		case "nome":
			user.setNome(valor);
			break;
			
		case "telefone":
			user.setTelefone(valor);
			break;
			
		case "email":
			user.setEmail(valor);
			break;
			
		default:
			throw new AtributoInvalidoException();
		}
	}

	/**
	 * Retorna uma informacao, passada no atributo, do usuario
	 * 
	 * @param nome O nome do usuario de que se saber alguma informacao
	 * @param telefone O telefone do usuario de que se saber alguma informacao
	 * @param atributo A informacao que se quer saber sobre um usuario
	 * @param usuarios O conjunto onde esse usuario será buscado
	 * @return A informacao desejada de um usuario
	 * @throws StringInvalidaException Caso uma string seja invalida
	 */
	public static String getInfoUsuario(String nome, String telefone, String atributo, Set<Usuario> usuarios) 
			throws StringInvalidaException {
		
		Usuario user = buscaUsuario(nome, telefone, usuarios);

		switch(atributo.toLowerCase()) {
		case "nome":
			return user.getNome();
			
		case "telefone":
			return user.getTelefone();
			
		case "email":
			return user.getEmail();
			
		case "reputacao":
			return String.valueOf(user.getReputacao());
			
		case "cartao":
			return user.getCartao();
			
		default:
			throw new AtributoInvalidoException();
		}
	}

	/**
	 * Retorna um usuario especifico do sistema
	 * 
	 * @param nome O nome do usuario que se busca
	 * @param telefone O telefone do usuario que se busca
 	 * @param usuarios O conjunto onde esse usuario será buscado
	 * @return O usuario buscado
	 * @throws UsuarioInvalidoException 
	 */
	public static Usuario buscaUsuario(String nome, String telefone, Set<Usuario> usuarios) 
			throws UsuarioInvalidoException {
		
		for (Usuario usuario: usuarios) {
			if (usuario.getNome().equals(nome) && usuario.getTelefone().equals(telefone)) {
				return usuario;
			}
		}
		
		throw new UsuarioInvalidoException();
	}
	
}
