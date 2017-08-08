package FacadeEMain;

public class Facade {
	
	private Sistema sistema = new Sistema();;
	
	public void iniciarSistema() {
		
	}
	
	public void cadastrarUsuario(String nome, String telefone, String email) {
		sistema.cadastrarUsuario(nome, telefone, email);
	}
	
	public void removerUsuario(String nome, String telefone) {
		sistema.removerUsuario(nome, telefone);
	}
	
	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		sistema.atualizarUsuario(nome, telefone, atributo, valor);
	}
	
	public String getInfoUsuario(String nome, String telefone, String atributo) {
		return sistema.getInfoUsuario(nome, telefone, atributo);
	}
	
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		sistema.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		sistema.cadastrarJogoTabuleiro(nome, telefone, nomeItem, preco);
	}
	
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		sistema.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}
	
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao, String genero, String classificacao, int anoLancamento) {
		sistema.cadastrarBluRayFilme(nome, telefone, nomeItem, preco, duracao, genero, classificacao, anoLancamento);
	}
	
	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao, int nomeroFaixas, String artista, String classificacao) {
		sistema.cadastrarBluRayShow(nome, telefone, nomeItem, preco, duracao, nomeroFaixas, artista, classificacao);
	}
	
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao, int duracao, String classificacao, String genero, int temporada) {
		sistema.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
	}
	
	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao){
		sistema.adicionarBluRay(nome, telefone, nomeBlurayTemporada, duracao);
	}
	
	public void removerItem(String nome, String telefone, String nomeItem) {
		sistema.removerItem(nome, telefone, nomeItem);
	}
	
	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		sistema.atualizarItem(nome, telefone, nomeItem, atributo, valor);
	}
	
	public String getInfoItem(String nome, String telefone, String nomeItem,String atributo) {
		return sistema.getInfoItem(nome, telefone, nomeItem, atributo);
	}
	
	public String listarItensOrdenadosPorNome() {
		return sistema.listarItensOrdenadosPorNome();
	}

//	public String listarItensOrdenadosPorValor() {
//		return sistema.listarItensOrdenadosPorValor();
//	}
	
//	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {
//		return sistema.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, periodo);
//	}
	
//	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, String nomeItem, String dataEmprestimo, String dataDevolucao) {
//		return sistema.devolverItem(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, dataDevolucao);
//	}
	
	public void fecharSistema() {
		
	}
	
	

}
