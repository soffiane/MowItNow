package fr.publicissapient.deplacement.modele;

public enum Deplacement {
	D("DROITE"),
	G("GAUCHE"),
	A("AVANCE");

	private String name = "";

	Deplacement(String name){
		this.name = name;
	}

	@Override
	public String toString(){
		return name;
	}

}
