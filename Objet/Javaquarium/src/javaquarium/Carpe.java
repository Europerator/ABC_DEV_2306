package javaquarium;

/**
 * Représente un poisson végétarien de la famille des cyprinidés (cyprinus carpio).
 */
public class Carpe extends Vegetarien {
	/**
	 * Constructeur de Carpe sans sexe précisé.
	 * @param _nom (String) Nom de la carpe introduite.
	 * @param _age (int) âge en tours d'exécution de la carpe introduite.
	 */
	Carpe(String _nom, int _age) {
		super(_nom, _age, 1);
	}
	/**
	 * Constructeur de Carpe avec sexe précisé.
	 * @param _nom (String) Nom de la carpe introduite.
	 * @param _age (int) âge en tours d'exécution de la carpe introduite.
	 * @param _sexe (boolean) true=femelle, false=mâle
	 */
	Carpe(String _nom, int _age, boolean _sexe) {
		super(_nom, _age, 1, _sexe);
	}
	public String toString() {
		String retour = super.toString() + ",espece=Carpe|";
		return retour;
	}
}
