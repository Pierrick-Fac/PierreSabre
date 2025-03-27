package personnages;

public class Ronin extends Humain {
	private int honneur = 1;

	public Ronin(String nom, String boissonPref, int argent) {
		super(nom, boissonPref, argent);
	}
	
	public void donner(Commercant beneficiaire) {
		int don = this.getArgent()/10;
		parler(String.format("%s prend ces %d sous.",beneficiaire.getNom(),don));
		this.perdreArgent(don);
		beneficiaire.recevoir(don);
	}
}
