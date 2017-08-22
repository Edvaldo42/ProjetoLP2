package item;

public enum Plataforma {

	PC ("PC"),
	MAC ("MAC"),
	PS3 ("PS3"),
	PS4 ("PS4"),
	XBOX360 ("XBOX360"),
	XBOX_ONE ("XBOX_ONE"),
	NINTENDO_3DS ("NINTENDO_3DS"),
	OUTRO ("OUTRO");
	
	private String plataforma;
	
	/**
	 * Creator de plataforma
	 * 
	 * @param plataforma A plataforma a ser criada
	 */
	private Plataforma(String plataforma) {
		this.plataforma = plataforma.toUpperCase();
	}
	
	/**
	 * Retorna a plataforma de um jogo eletronico
	 * 
	 * @return A plataforma de um jogo eletronico
	 */
	public String getPlataforma() {
		return this.plataforma; 
	}
	
	/**
	 * Retorna a representacao textual de plataforma
	 */
	@Override
	public String toString() {
		return this.plataforma;
	}
}
