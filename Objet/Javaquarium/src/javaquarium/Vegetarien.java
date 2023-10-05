package javaquarium;

/**
 * Regroupe les poissons qui ne se nourrissent que de végétaux.
 */
public class Vegetarien extends Poisson {
	/**
	 * Constructeur générique de poisson végétarien sans sexe précisé.
	 * @param _nom (String) Nom de l'individu.
	 * @param _age (int) âge de l'individu en tours d'exécution.
	 * @param _sexuation (int) type de sexuation de l'individu : 1=monosexué, 2=hermaphrodite avec l'âge, 3=hermaphrodite opportuniste, 0 et 4+=indéterminé.
	 */
	Vegetarien(String _nom, int _age, int _sexuation) {	super(_nom, _age, _sexuation); }
	/**
	 * Constructeur générique de poisson végétarien avec sexe précisé.
	 * @param _nom (String) Nom de l'individu.
	 * @param _age (int) âge de l'individu en tours d'exécution.
	 * @param _sexuation (int) type de sexuation de l'individu : 1=monosexué, 2=hermaphrodite avec l'âge, 3=hermaphrodite opportuniste, 0 et 4+=indéterminé.
	 * @param _sexe (boolean) true=femelle, false=mâle (sera ignoré si sexuation=2).
	 */
	Vegetarien(String _nom, int _age, int _sexuation, boolean _sexe) { super (_nom, _age, _sexuation, _sexe); }
	
	/**
	 * Procédure simulant la consommation d'une algue par cet individu.
	 * Les poissons végétariens sont nourris de 3 points de vie par bouchée.
	 * @param proie (Algue) Algue dont le poisson arrache une bouchée.
	 */
	void manger(Algue proie) {
		super.manger(proie);
		this.points_de_vie += 3;
	}
}
