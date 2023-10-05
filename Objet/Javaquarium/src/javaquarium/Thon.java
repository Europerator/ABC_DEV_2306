package javaquarium;

/**
 * Représente un poisson carnivore de la famille des scombridés (thunnus atlanticus).
 */
public class Thon extends Carnivore {
	/**
	 * Constructeur de Thon sans sexe précisé.
	 * @param _nom (String) Nom du thon introduit.
	 * @param _age (int) âge en tours d'exécution du thon introduit.
	 */
	Thon(String _nom, int _age) {
		super(_nom, _age, 1);
	}
	/**
	 * Constructeur de Thon avec sexe précisé.
	 * @param _nom (String) Nom du thon introduit.
	 * @param _age (int) âge en tours d'exécution du thon introduit.
	 * @param _sexe (boolean) true=femelle, false=mâle
	 */
	Thon(String _nom, int _age, boolean _sexe) {
		super(_nom, _age, 1, _sexe);
	}
	public String toString() {
		String retour = super.toString() + ",espece=Thon|";
		return retour;
	}
}
