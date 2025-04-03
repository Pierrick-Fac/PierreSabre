package personnages;

public class Yakuza extends Humain {
	private int reputation = 4;
	private String clan;

	public Yakuza(String nom, String boissonPref, int argent, String clan) {
		super(nom, boissonPref, argent);
		this.clan = clan;
	}
	public int getReputation() {
		return reputation;
	}

	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par l� ?");
		parler(String.format("%s, si tu tiens � la vie donne moi ta bourse!",victime.getNom()));
		int gain = victime.seFaireExtorquer();
		gagnerArgent(gain);
		reputation++;
		parler(String.format("J'ai piqu� les %d sous de %s, ce qui me fait %d sous dans ma poche. Hi ! Hi !", gain,victime.getNom(),this.getArgent()));
	}
	
	public int perdre() {
		reputation -= 1;
		int temp = this.getArgent();
		parler(String.format("J'ai perdu mon duel et mes %d sous, snif... J'ai déshonoré le clan de %s.", this.getArgent(),clan));
		this.perdreArgent(temp);
		return temp;
	}
	public void gagner(int gain) {
		this.gagnerArgent(gain);
		reputation += 1;
		parler(String.format("Ce ronin pensait vraiment battre %s du clan %s ? Je l'ai dépouillé de ses %d sous.", this.getNom(),clan,gain));
	}
	
	@Override
	public void direBonjour() {
		parler(String.format("Bonjour ! Je m'appelle %s et j'aime boire du %s.",this.getNom(),this.getBoissonPref()));
		parler(String.format("Mon clan est celui de %s.", clan));
	}
}