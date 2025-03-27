package personnages;

public class Yakuza extends Humain {
	private int reputation = 0;
	private String clan;

	public Yakuza(String nom, String boissonPref, int argent, String clan) {
		super(nom, boissonPref, argent);
		this.clan = clan;
	}
	
	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(String.format("%s, si tu tiens à la vie donne moi ta bourse!",victime.getNom()));
		int gain = victime.seFaireExtorquer();
		gagnerArgent(gain);
		reputation++;
		parler(String.format("J'ai piqué les %d sous de %s, ce qui me fait %d sous dans ma poche. Hi ! Hi !", gain,victime.getNom(),this.getArgent()));
	}
}
