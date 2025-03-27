package personnages;

public class Commercant extends Humain {
	public Commercant(String nom, int argent) {
		super(nom, "thé", argent);
	}
	
	public int seFaireExtorquer() {
		int temp = getArgent();
		perdreArgent(getArgent());
		parler("J'ai tout perdu! Le monde est trop injuste...");
		return temp;
	}
	
	public void recevoir(int argent) {
		gagnerArgent(argent);
		parler(String.format("%d sous! Je te remercie généreux donateur!",argent));
	}
}