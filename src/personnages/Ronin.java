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
	
	public void provoquer(Yakuza adversaire) {
		int force = honneur*2;
		if (force >= adversaire.getReputation()) {
			parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand !");
			honneur++;
			parler("Je t'ai eu petit yakusa !");
			this.gagnerArgent(adversaire.perdre());
		}
		else {
			honneur -= 1;
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			adversaire.gagner(this.getArgent());
			this.perdreArgent(this.getArgent());
		}
	}
}
