package item;

public enum Plataforma {

	PC ("PC"),
	MAC ("MAC"),
	PS3 ("PS3"),
	PS4 ("PS4"),
	XBOX360 ("XBOX360"),
	XBOX_ONE ("XBOX ONE"),
	NINTENDO_3DS ("NINTENDO 3DS"),
	OUTRO ("OUTRO");
	
	private String plataforma;
	
	private Plataforma(String plataforma) {
		this.plataforma = plataforma.toUpperCase();
	}
	
	public String getPlataforma() {
		return this.plataforma; 
	}
	
	@Override
	public String toString() {
		return this.plataforma;
	}
}
