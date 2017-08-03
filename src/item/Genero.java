package item;

public enum Genero {

	ACAO ("ACAO"),
	ANIMACAO ("ANIMACAO"),
	AVENTURA ("AVENTURA"),
	COMEDIA ("COMEDIA"),
	DOCUMENTARIO ("DOCUMENTARIO"),
	DRAMA ("DRAMA"),
	EROTICO ("EROTICO"),
	FAROESTE ("FAROESTE"),
	FICCAO ("FICCAO"),
	MUSICAL ("MUSICAL"),
	POLICIAL ("POLICIAL"),
	ROMANCE ("ROMANCE"),
	SUSPENSE ("SUSPENSE"),
	TERROR ("TERROR"),
	OUTRO ("OUTRO");
	
	
	private String genero;
	
	private Genero(String genero) {
		this.genero = genero;
	}
	
	public String getGenero() {
		return this.genero; 
	}
	

}


