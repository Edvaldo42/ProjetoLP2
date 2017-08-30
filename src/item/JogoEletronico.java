package item;

/**
 * 
 *
 */
public class JogoEletronico extends Item {
	
	private Plataforma plataforma;
	
	/**
	 * Creator de jogo eletronico
	 *  
	 * @param nomeItem O nome do jogo
	 * @param preco O preco do jogo
	 * @param plataforma A plataforma do jogo
	 */
	public JogoEletronico(String nomeItem, double preco, String plataforma) {
		super(nomeItem, preco);
		this.plataforma = Plataforma.valueOf(plataforma);		
	}

	/**
	 * Retorna a plataforma do jogo
	 * 
	 * @return A plataforma do jogo
	 */
	public String getPlataforma() {
		return plataforma.getPlataforma();
	}
	
	/**
	 * Estabelece a plataforma do jogo
	 */
	public void setPlataforma(String plataforma) {
		this.plataforma = Plataforma.valueOf(plataforma);
	}
	
	/**
	 * Retorna uma representacao textual do jogo eletronico
	 */
	@Override
	public String toString() {
		return "JOGO ELETRONICO: " + super.toString() + ", " +  plataforma.getPlataforma();
	}

	/**
	 * HashCode de JogoEletronico
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
		return result;
	}

	/**
	 * Equals de JogoEletronico
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		JogoEletronico other = (JogoEletronico) obj;
		if (plataforma != other.plataforma)
			return false;
		return true;
	}	
	
}
