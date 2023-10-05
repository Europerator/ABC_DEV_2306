package javaquarium;

/**
 * Représente un poisson végétarien de la famille des soléidés (solea solea).
 */
public class Sole extends Vegetarien {
	/**
	 * Constructeur de Sole sans sexe précisé.
	 * @param _nom (String) Nom de la sole introduite.
	 * @param _age (int) âge en tours d'exécution de la sole introduite.
	 */
	Sole(String _nom, int _age) {
		super(_nom, _age, 3);
	}
	/**
	 * Constructeur de Sole avec sexe précisé.
	 * @param _nom (String) Nom de la sole introduite.
	 * @param _age (int) âge en tours d'exécution de la sole introduite.
	 * @param _sexe (boolean) true=femelle, false=mâle
	 */
	Sole(String _nom, int _age, boolean _sexe) {
		super(_nom, _age, 3, _sexe);
	}
	public String toString() {
		String retour = super.toString() + ",espece=Sole|";
		return retour;
	}
}
