package usuario;

public enum Cartao {
	
	NOOB("Noob"),
	CALOTEIRO("Caloteiro"),
	BOM_AMIGO("BomAmigo"),
	FREE_RYDER("FreeRyder");
	
	private String cartao;
	
	private Cartao(String cartao) {
		this.cartao = cartao;
	}
	
	public String getCartao() {
		return this.cartao; 
	}
		
	@Override
	public String toString() {
		return this.cartao;
	}

}
