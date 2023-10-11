package javaquarium;

import java.util.Random;

/**
 * Classe parente de tous les poissons.
 */
public class Poisson extends EtreVivant {
	/**
	 * Nom assigné à l'individu.
	 */
	protected String nom;
	/**
	 * Sexe de l'individu.
	 * true: female; false: mâle.
	 */
	protected boolean sexe;
	/**
	 * Type de sexuation de l'individu.
	 * 0: indéterminé - Le comportement ne sera pas pris en compte.
	 * 1: monosexué - l'individu naît avec un sexe donné et le gardera toute sa vie.
	 * 2: hermaphrodite avec l'âge - l'individu naît mâle et devient femelle à l'âge de 10 tours.
	 * 3: hermaphrodite opportuniste - l'individu change de sexe à l'accouplement au besoin.
	 * 4+: indéterminé.
	 */
	protected int sexuation;
	/**
	 * Générateur d'aléatoire.
	 */
	protected static Random radom_gen = new Random();
	
	/**
	 * Constructeur de poisson sans sexe précisé.
	 * @param _nom (String) Nom de l'individu.
	 * @param _age (int) âge de l'individu en tours d'exécution.
	 * @param _sexuation (int) type de sexuation de l'individu : 1=monosexué, 2=hermaphrodite avec l'âge, 3=hermaphrodite opportuniste, 0 et 4+=indéterminé.
	 */
	Poisson(String _nom, int _age, int _sexuation) {
		this(_nom, _age, _sexuation, radom_gen.nextBoolean());
	}
	/**
	 * Constructeur de poisson avec sexe précisé.
	 * @param _nom (String) Nom de l'individu.
	 * @param _age (int) âge de l'individu en tours d'exécution.
	 * @param _sexuation (int) type de sexuation de l'individu : 1=monosexué, 2=hermaphrodite avec l'âge, 3=hermaphrodite opportuniste, 0 et 4+=indéterminé.
	 * @param _sexe (boolean) true=femelle, false=mâle (sera ignoré si sexuation=2).
	 */
	Poisson(String _nom, int _age, int _sexuation, boolean _sexe) {
		super(_age);
		this.nom = _nom;
		this.sexuation = _sexuation;
		if (this.sexuation != 2) { this.sexe = _sexe; }
		else if (this.age < 10) { this.sexe = false; }
		else { this.sexe = true; }
	}
	/**
	 * Accesseur du nom de l'individu.
	 * @return (String) Nom de l'individu.
	 */
	String getNom() {
		return this.nom;
	}
	/**
	 * Accesseur du sexe de l'individu.
	 * @return (boolean) true si femelle, false si mâle.
	 */
	boolean getSexe() {
		return this.sexe;
	}
	public String toString() {
		String retour = super.toString() + ",type=Poisson,nom=" + this.nom + ",sexe=";
		if (this.sexe) { retour = retour + "f"; }
		else { retour = retour + "m"; }
		return retour;
	}

	/**
	 * Procédure vieillissant l'organisme d'un tour d'exécution s'il est vivant.
	 * Le poisson perd un point de vie par tour pour simuler le besoin de nourriture.
	 */
	void vieillir() {
		super.vieillir();
		if (this.age > 9 && this.sexuation == 2) { this.sexe = true; } 
		this.points_de_vie--;
	}
	/**
	 * Représente la satiété du poisson.
	 * @return (boolean) true si le poisson ressent la faim, false sinon.
	 */
	boolean aFaim() {
		if (this.points_de_vie < 6) {
			return true;
		}
		return false;
	}
	/**
	 * Procédure simulant la consommation d'un autre organisme par ce poisson.
	 * @param proie (EtreVivant) organisme dont le poisson arrache une bouchée.
	 */
	void manger(EtreVivant proie) {
		proie.mordre();
	}
	/**
	 * Fonction de reproduction sexuée du poisson, qu'il tente avec le partenaire donné.
	 * @param partenaire (Poisson) Individu que le poisson approche pour tenter l'accouplement.
	 * @return (boolean) true si la reproduction est un succès, false sinon.
	 */
	boolean saccoupler(Poisson partenaire) {
		if (!this.aFaim() || partenaire.getClass() != this.getClass()) { return false; }
		if (this.sexuation == 3) { this.sexe = !partenaire.getSexe(); return true; }
		else if (this.sexe == partenaire.getSexe()) { return true; }
		return false;
	}
}
