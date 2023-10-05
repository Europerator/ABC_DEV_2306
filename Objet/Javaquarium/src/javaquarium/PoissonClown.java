package javaquarium;

/**
 * Représente un poisson carnivore de la famille des Amphiprioninae (amphiprion ocellaris).
 */
public class PoissonClown extends Carnivore {
	/**
	 * Constructeur de PoissonClown sans sexe précisé.
	 * @param _nom (String) Nom du poisson-clown introduit.
	 * @param _age (int) âge en tours d'exécution du poisson clown introduit.
	 */
	PoissonClown(String _nom, int _age) {
		super(_nom, _age, 3);
	}
	/**
	 * Constructeur de PoissonClown avec sexe précisé.
	 * @param _nom (String) Nom du poisson-clown introduit.
	 * @param _age (int) âge en tours d'exécution du poisson-clown introduit.
	 * @param _sexe (boolean) true=femelle, false=mâle
	 */
	PoissonClown(String _nom, int _age, boolean _sexe) {
		super(_nom, _age, 3, _sexe);
	}
	public String toString() {
		String retour = super.toString() + ",espece=PoissonClown|";
		return retour;
	}
}
