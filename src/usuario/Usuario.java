package usuario;

public class Usuario {

	private String nome;
	private String email;
	private String telefone;

	public Usuario(String nome, String telefone, String email) {
		if (!validaNome(nome)) {
			throw new IllegalArgumentException("Nome invalido");
		}

		if (!validaEmail(email)) {
			throw new IllegalArgumentException("Email invalido");
		}
		if (!validaTelefone(telefone)) {
			throw new IllegalArgumentException("Telefone invalido");
		}
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	private boolean validaNome(String nome) {
		if (nome == null) {
			throw new IllegalArgumentException("Usuario nao pode ser null.");
		}
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Usuario nao pode ser vazio.");
		}
		return true;
	}

	private boolean validaTelefone(String telefone) {
		int hifen = 0;
		if (telefone == null) {
			throw new IllegalArgumentException("Telefone nao pode ser null.");
		}
		if (telefone.trim().equals("")) {
			throw new IllegalArgumentException("telefone nao pode ser vazio.");
		}
		if ((telefone.length()) > 10 || telefone.length() < 9) {
			throw new IllegalArgumentException("Telefone invalido");
		}
		if (!(telefone.charAt(5) == '-')) {
			throw new IllegalArgumentException("Telefone invalido");
		}
		if (telefone.charAt(0) == '-' || telefone.charAt(telefone.length() - 1) == '-') {
			throw new IllegalArgumentException("Telefone invalido");
		}
		if (telefone.charAt(5) == '-') {
			hifen++;
		}
		for (int i = 0; i < telefone.length() - 1; i++) {
			if (telefone.charAt(i) == ' ') {
				throw new IllegalArgumentException("Telefone invalido");
			}
			if (telefone.charAt(i) == '-' && i != 5) {
				throw new IllegalArgumentException("Telefone invalido");
			}
		}

		if (hifen != 1) {
			return false;
		}
		return true;
	}

	private boolean validaEmail(String email) {
		int arrobas = 0;
		int pontos = 0;

		if (email.charAt(0) == '@' || email.charAt(email.length() - 1) == '@'
				|| email.charAt(email.length() - 1) == '.')
			return false;
		for (int i = 0; i < email.length() - 1; i++) {
			if (email.charAt(i) == ' ') {
				return false;
			} else if (email.charAt(i) == '@') {
				arrobas++;
				if (email.charAt(i + 1) == '@')
					return false;
			} else if (email.charAt(i) == '.' && arrobas == 1) {
				pontos++;
				if (email.charAt(i + 1) == '.')
					return false;
			}

		}
		if (arrobas != 1 || pontos < 1)
			return false;

		return true;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		validaEmail(email);
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (validaNome(nome)) {
			this.nome = nome;
		}

	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if (validaTelefone(telefone)) {
			this.telefone = telefone;
		}

	}

	@Override
	public String toString() {
		return nome + ", " + email + ", " + telefone;
	}

}