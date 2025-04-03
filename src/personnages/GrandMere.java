package personnages;
import java.util.Random;

public class GrandMere extends Humain {
	static final int TAILLE_MEMOIRE = 5;

	public GrandMere(String nom, int argent) {
		super(nom, "tisane", argent);
	}
	
	@Override
	protected void memoriser(Humain homme) {
		if (nbConnaissance < TAILLE_MEMOIRE) {
			memoire[nbConnaissance] = homme;
			nbConnaissance++;
		}
		else {
			parler("Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire");
		}
	}
	
	private enum TypeHumain {
		R("ronin"), Y("yakuza"), C("commercant"), H("habitant"), S("samourai");
		
		private String affichage;
		
		private TypeHumain(String affichage) {
			this.affichage = affichage;
		}
		
		public String getString() {
			return affichage;
		}
	}
	
	private String humainHasard() {
		Random randomNumbers = new Random();
		TypeHumain[] types = TypeHumain.values();
		return types[randomNumbers.nextInt(types.length)].getString();
	}
	
	public void ragoter() {
		for (int i = 0; i < nbConnaissance; i++) {
			Humain humain = memoire[i];
			if (humain instanceof Traitre) {
				parler(String.format("Je sais que %s est un traître. Petit Chenapan !", humain.getNom()));
			}
			else {
				parler(String.format("Je crois que %s est un %s.", humain.getNom(),humainHasard()));
			}
		}
	}
}
