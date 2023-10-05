package javaquarium;

/**
 * Regroupe les poissons qui se nourrissent d'autres poissons.
 */
public class Carnivore extends Poisson {
	/**
	 * Constructeur générique de poisson carnivore sans sexe précisé.
	 * @param _nom (String) Nom de l'individu.
	 * @param _age (int) âge de l'individu en tours d'exécution.
	 * @param _sexuation (int) type de sexuation de l'individu : 1=monosexué, 2=hermaphrodite avec l'âge, 3=hermaphrodite opportuniste, 0 et 4+=indéterminé.
	 */
	Carnivore(String _nom, int _age, int _sexuation) {
		super(_nom, _age, _sexuation);
	}
	/**
	 * Constructeur générique de poisson carnivore avec sexe précisé.
	 * @param _nom (String) Nom de l'individu.
	 * @param _age (int) âge de l'individu en tours d'exécution.
	 * @param _sexuation (int) type de sexuation de l'individu : 1=monosexué, 2=hermaphrodite avec l'âge, 3=hermaphrodite opportuniste, 0 et 4+=indéterminé.
	 * @param _sexe (boolean) true=femelle, false=mâle (sera ignoré si sexuation=2).
	 */
	Carnivore(String _nom, int _age, int _sexuation, boolean _sexe) {
		super(_nom, _age, _sexuation, _sexe);
	}
	/**
	 * Procédure simulant la consommation d'un autre poisson par cet individu.
	 * Un poisson ne tentera pas manger un poisson de la même espèce (l'action n'aboutit à rien).
	 * Les poissons carnivores sont nourris de 5 points de vie par bouchée.
	 * @param proie (Algue) Algue dont le poisson arrache une bouchée.
	 */
	void manger(Poisson proie) {
		if (proie.getClass() != this.getClass()) {
			super.manger(proie);
			this.points_de_vie += 5;
		}
	}
}
