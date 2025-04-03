package personnages;

public class Humain {
	static final int TAILLE_MEMOIRE = 30;
	private String nom;
	private String boissonPref;
	private int argent;
	protected int nbConnaissance = 0;
	protected Humain[] memoire = new Humain[TAILLE_MEMOIRE];
	
	public String getNom() {
		return nom;
	}
	public int getArgent() {
		return argent;
	}
	public String getBoissonPref() {
		return boissonPref;
	}
	
	public Humain(String nom, String boissonPref, int argent) {
		super();
		this.nom = nom;
		this.boissonPref = boissonPref;
		this.argent = argent;
	}
	
	protected void gagnerArgent(int gain) {
		argent += gain;
	}
	
	protected boolean perdreArgent(int perte) {
		if (argent < perte) {
			return false;
		}
		else {
			argent -= perte;
			return true;
		}
	}
	
	protected void parler(String texte) {
		System.out.printf("(%s) - %s\n",nom,texte);
	}
	
	public void direBonjour() {
		parler(String.format("Bonjour ! Je m'appelle %s et j'aime boire du %s.",nom,boissonPref));
	}
	
	public void boire() {
		parler(String.format("Mmm, un bon verre de %s! GLOUPS !",boissonPref));
	}
	
	public void acheter(String bien, int prix) {
		if (perdreArgent(prix)) {
			parler(String.format("J'ai %d sous en poche. Je vais pouvoir m'offrir une %s � %d sous.",argent+prix,bien,prix));
		}
		else {
			parler(String.format("Je n'ai plus que %d sous en poche. Je ne peux m�me pas m'offrir un %s � %d sous.",argent,bien,prix));
		}
	}
	
	public void faireConnaissanceAvec(Humain homme2) {
		this.direBonjour();
		homme2.repondre(this);
		this.memoriser(homme2);
	}
	
	private void repondre(Humain homme1) {
		this.direBonjour();
		this.memoriser(homme1);
	}
	
	private void memoriser(Humain homme) {
		if (nbConnaissance < TAILLE_MEMOIRE) {
			memoire[nbConnaissance] = homme;
			nbConnaissance++;
		}
		else {
			for (int i = 0; i < nbConnaissance-1; i++) {
				memoire[i] = memoire[i+1];
			}
			memoire[nbConnaissance-1] = homme;
		}
	}
	
	public void listerConnaissance() {
		String texte = "";
		for (int i = 0; i < this.nbConnaissance; i++) {
			texte = texte + memoire[i].nom + ", ";
		}
		parler("Je connais beaucoup de monde dont : " + texte);
	}
}