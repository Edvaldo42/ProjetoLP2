package item;

public enum Genero {

	ACAO ("Acao"),
	ANIMACAO ("Animacao"),
	AVENTURA ("Aventura"),
	COMEDIA ("Comedia"),
	DOCUMENTARIO ("Documentario"),
	DRAMA ("Drama"),
	EROTICO ("Erotico"),
	FAROESTE ("Faroeste"),
	FICCAO ("Ficcao"),
	MUSICAL ("Musical"),
	POLICIAL ("Policial"),
	ROMANCE ("Romance"),
	SUSPENSE ("Suspense"),
	TERROR ("Terror"),
	OUTRO ("Outro");
	
	
	private String genero;
	
	private Genero(String genero) {
		this.genero = genero;
	}
	
	public String getGenero() {
		return this.genero; 
	}
	

}


