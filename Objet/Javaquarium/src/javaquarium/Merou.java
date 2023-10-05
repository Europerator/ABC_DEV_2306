package javaquarium;

/**
 * Représente un poisson carnivore de la famille des serranidés (Epinephelus marginatus).
 */
public class Merou extends Carnivore {
	/**
	 * Constructeur de Merou sans sexe précisé.
	 * @param _nom (String) Nom du mérou introduit.
	 * @param _age (int) âge en tours d'exécution du mérou introduit.
	 */
	Merou(String _nom, int _age) {
		super(_nom, _age, 2);
	}
	/**
	 * Constructeur de Merou avec sexe précisé.
	 * @param _nom (String) Nom du mérou introduit.
	 * @param _age (int) âge en tours d'exécution du mérou introduit.
	 * @param _sexe (boolean) true=femelle, false=mâle (sera ignoré à cause du type de sexuation du mérou)
	 */
	Merou(String _nom, int _age, boolean _sexe) {
		super(_nom, _age, 2, _sexe);
	}
	public String toString() {
		String retour = super.toString() + ",espece=Merou|";
		return retour;
	}
}
