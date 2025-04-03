package personnages;
import java.util.Random;

public class Traitre extends Samourai {
	private int niveauTraitrise = 0;

	public Traitre(String seigneur, String nom, String boissonPref, int argent) {
		super(seigneur, nom, boissonPref, argent);
	}
	
	@Override
	public void direBonjour() {
		parler(String.format("Bonjour ! Je m'appelle %s et j'aime boire du %s.",this.getNom(),this.getBoissonPref()));
		parler(String.format("Je suis fier de servir le seigneur %s.", this.seigneur));
		parler(String.format("Mais je suis un traître et mon niveau de traîtrise est : %d. Chut !", niveauTraitrise));
	}
	
	public void ranconner(Commercant commercant) {
		if (niveauTraitrise < 3) {
			int argentCommercant = commercant.getArgent();
			int argentRanconner = argentCommercant * 2 / 10;
			commercant.perdreArgent(argentRanconner);
			this.gagnerArgent(argentRanconner);
			niveauTraitrise++;
			parler(String.format("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi %d sous ou gare à toi !", argentRanconner));
			commercant.parler(String.format("Tout de suite %s.", this.getNom()));
		}
		else {
			parler("Mince je ne peux plus rançonner personne sinon un samouraï risque de me démasquer !");
		}
	}
	
	public void faireLeGentil() {
		if (nbConnaissance < 1) {
			parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif.");
		}
		else {
			int don = this.getArgent() * 1 / 20;
			Random randomNumbers = new Random();
			Humain humainAmi = memoire[randomNumbers.nextInt(nbConnaissance)];
			String nomAmi = humainAmi.getNom();
			parler(String.format("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec %s.", nomAmi));
			parler(String.format("Bonjour l'ami ! Je voudrais vous aider en vous donnant %d sous.", don));
			humainAmi.gagnerArgent(don);
			this.perdreArgent(don);
			humainAmi.parler(String.format("Merci %s. Vous êtes quelqu'un de bien.", this.getNom()));
			if (niveauTraitrise > 1) {
				niveauTraitrise -= 1;
			}
		}
	}
}
