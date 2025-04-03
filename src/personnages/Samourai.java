package personnages;

public class Samourai extends Ronin {
	protected String seigneur;

	public Samourai(String seigneur, String nom, String boissonPref, int argent) {
		super(nom, boissonPref, argent);
		this.seigneur = seigneur;
	}
	
	@Override
	public void direBonjour() {
		parler(String.format("Bonjour ! Je m'appelle %s et j'aime boire du %s.",this.getNom(),this.getBoissonPref()));
		parler(String.format("Je suis fier de servir le seigneur %s.", seigneur));
	}
	
	public void boire(String boisson) {
		parler(String.format("Qu'est ce que je vais choisir comme boisson ? Tiens je vais prendre du %s.", boisson));
	}
}
