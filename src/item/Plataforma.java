package item;

public enum Plataforma {

	PC ("PC"),
	MAC ("Mac"),
	PS3 ("PS3"),
	PS4 ("PS4"),
	XBOX360 ("Xbox360"),
	XBOX_ONE ("Xbox One"),
	NINTENDO_3DS ("Nintendo 3DS"),
	OUTRO ("Outro");
	
	private String plataforma;
	
	private Plataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
	public String getPlataforma() {
		return this.plataforma; 
	}
}
