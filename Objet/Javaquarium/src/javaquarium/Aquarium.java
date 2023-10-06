package javaquarium;
//import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Représente un environnement aquatique dans lequel évoluent des poissons et des algues.
 */
public class Aquarium {
	/**
	 * Regroupe la population (végétale comme animale) de l'aquarium.
	 */
	private ArrayList<EtreVivant> habitants;
	/**
	 * Banque de noms par défaut pour les nouveaux poissons.
	 */
	private final static String[] NOMS = new String[] {"Aldy", "Byron", "Coda", "Deli",
			"Edgy", "Frankie", "Gers", "Hal", "Illy", "Jackie", "Khan", "Lee", "Marilyn",
			"Nifty", "Orca", "Percy", "Qalam", "Richie", "Sandy", "Tempest", "Ursa",
			"Valor", "Wabbajack", "Xerxes", "Yon", "Zindy"};
	/**
	 * Suit l'usage des noms de la banque parmi les habitants de l'aquarium.
	 */
	private int[] usageNoms;
	
	/**
	 * Constructeur générique d'Aquarium. Commence vide.
	 */
	Aquarium() {
		this.habitants = new ArrayList<EtreVivant>();
		usageNoms = new int[NOMS.length];
		for (int i = 0; i < usageNoms.length; i++) { usageNoms[i] = 0; }
	}
	public String toString() {
		String retour = "Aquarium (p=" + this.habitants.size() + ")\n";
		for (int i = 0; i < this.habitants.size(); i++) { retour = retour + this.habitants.get(i).toString() + "\n"; }
		return retour;
	}
	
	/**
	 * Accesseur retournant l'ensemble des algues contenues dans l'aquarium.
	 * @return (ArrayList<Algue>) liste de toutes les algues de l'aquarium.
	 */
	ArrayList<Algue> get_algues() {
		ArrayList<Algue> algues = new ArrayList<Algue>();
		for (int i = 0; i < this.habitants.size(); i++) { if (this.habitants.get(i) instanceof Algue) { algues.add((Algue)this.habitants.get(i)); } }
		return algues;
	}
	/**
	 * Accesseur d'une algue aléatoire parmi la population de l'aquarium.
	 * @return (Algue) une algue prise au hasard.
	 */
	Algue get_random_algue() {
		ArrayList<Algue> algues = this.get_algues();
		int random_index = (int)Math.floor(Math.random()*algues.size());
		return algues.get(random_index);
	}
	/**
	 * Accesseur retournant l'ensemble des poissons contenus dans l'aquarium.
	 * @return (ArrayList<Poisson>) liste de tous les poissons de l'aquarium.
	 */
	ArrayList<Poisson> get_poissons() {
		ArrayList<Poisson> poissons = new ArrayList<Poisson>();
		for (int i = 0; i < this.habitants.size(); i++) { if (this.habitants.get(i) instanceof Poisson) { poissons.add((Poisson)this.habitants.get(i)); } }
		return poissons;
	}
	/**
	 * Accesseur d'un poisson aléatoire parmi la population de l'aquarium.
	 * @param except (Poisson) Individu à exclure des candidats au retour (peut être null).
	 * @return (Poisson) Un poisson pris au hasard (compte tenu de l'exception).
	 */
	Poisson get_random_poisson(Poisson except) {
		ArrayList<Poisson> poissons = this.get_poissons();
		poissons.remove(except);
		int random_index = (int)Math.floor(Math.random()*poissons.size());
		return poissons.get(random_index);
	}
	
	/**
	 * Retourne un nom unique pris parmi la banque de noms locale.
	 * @return (String) Un nom aléatoire unique.
	 */
	private String nouveau_nom() {
		int choix = (int)Math.floor(Math.random()*NOMS.length);
		//this.usageNoms[choix]++;
		if (this.usageNoms[choix] == 1) { return NOMS[choix]; }
		return NOMS[choix] + this.usageNoms[choix];
	}
	/**
	 * Vérifie que le nom renseigné n'est pas dans la banque de nom,
	 * sinon il sera traité comme tel.
	 * @param _nom (String) Nom à vérifier.
	 * @return un nom unique valide.
	 */
	private String nouveau_nom(String _nom) {
		//todo: banque de nom évolutive (et prenant en compte les petits malins
		//qui ajouteraient Aldy2 sans qu'il soit pris en compte
		int trouve = -1;
		for (int i = 0; i < NOMS.length && trouve > 0; i++) { if (_nom.equalsIgnoreCase(NOMS[i])) { trouve = i;} }
		if (trouve < 0) { return _nom; }
		this.usageNoms[trouve]++;
		if (this.usageNoms[trouve] == 1) { return _nom; }
		return _nom + this.usageNoms[trouve];
	}
	
	/**
	 * Procédure d'introduction d'algues à l'aquarium.
	 * @param quantite (int) nombre d'algues à introduire.
	 * @param age (int) âge des algues au moment de l'introduction.
	 * @param pv (int) points de vie initiaux des algues.
	 */
	void ajouter_algues(int quantite, int age, int pv) {
		int random_index;
		for (int i = 0; i < quantite; i++) { random_index = (int)Math.floor(Math.random()*(this.habitants.size()+1)); this.habitants.add(random_index, new Algue(age, pv)); }
	}
	/**
	 * Procédure d'ajout d'un poisson à l'aquarium avec sexe précisé.
	 * @param espece (int) espèce du poisson. 0=bar, 1=carpe, 3=mérou, 4=poisson-clown, 5+=thon.
	 * @param nom (String) nom de l'individu.
	 * @param age (int) âge en tours d'exécution au moment de l'introduction. 
	 * @param sexe (boolean) true=femelle, false=mâle (ignoré pour les espèces hermaphrodites avec l'âge)
	 */
	void ajouter_poisson(int espece, String nom, int age, boolean sexe) {
		Poisson arrivant;
		switch (espece) {
		case 0: arrivant = new Bar(this.nouveau_nom(nom), age, sexe); break;
		case 1: arrivant = new Carpe(this.nouveau_nom(nom), age, sexe); break;
		case 2: arrivant = new Merou(this.nouveau_nom(nom), age, sexe); break;
		case 3: arrivant = new PoissonClown(this.nouveau_nom(nom), age, sexe); break;
		case 4: arrivant = new Sole(this.nouveau_nom(nom), age, sexe); break;
		default: arrivant = new Thon(this.nouveau_nom(nom), age, sexe);
		}
		int random_index = (int)Math.floor(Math.random()*(this.habitants.size()+1));
		this.habitants.add(random_index, arrivant);
	}
	/**
	 * Procédure d'ajout d'un poisson à l'aquarium sans sexe précisé.
	 * @param espece (int) espèce du poisson. 0=bar, 1=carpe, 3=mérou, 4=poisson-clown, 5+=thon.
	 * @param nom (String) nom de l'individu.
	 * @param age (int) âge en tours d'exécution au moment de l'introduction. 
	 */
	void ajouter_poisson(int espece, String nom, int age) {
		Poisson arrivant;
		switch (espece) {
		case 0: arrivant = new Bar(this.nouveau_nom(nom), age); break;
		case 1: arrivant = new Carpe(this.nouveau_nom(nom), age); break;
		case 2: arrivant = new Merou(this.nouveau_nom(nom), age); break;
		case 3: arrivant = new PoissonClown(this.nouveau_nom(nom), age); break;
		case 4: arrivant = new Sole(this.nouveau_nom(nom), age); break;
		default: arrivant = new Thon(this.nouveau_nom(nom), age);
		}
		int random_index = (int)Math.floor(Math.random()*(this.habitants.size()+1));
		this.habitants.add(random_index, arrivant);
	}
	/**
	 * Procédure d'ajout d'un poisson à l'aquarium avec sexe précisé.
	 * @param espece (Class<Poisson>) Classe de l'espèce de poisson spécifiée.
	 * @param nom (String) nom de l'individu.
	 * @param age (int) âge en tours d'exécution au moment de l'introduction. 
	 * @param sexe (boolean) true=femelle, false=mâle (ignoré pour les espèces hermaphrodites avec l'âge)
	 */
	void ajouter_poisson(Class<Poisson> espece, String nom, int age, boolean sexe) throws Exception {
		Poisson arrivant;
		/* On fait la liste des types des paramètres du constructeur qu'on souhaite
		 * appeler :
		*/ Class[] clarg = new Class[] {String.class, int.class, boolean.class};
		/* Puis on prépare un tableau (arg) listant les paramètres proprement dits
		 * à passer au constructeur :
		*/ Object[] arg = new Object[] {this.nouveau_nom(nom), age, sexe};
		/* Enfin, on demande à la classe le constructeur correspondant à clarg
		 * et on lui passe les arguments arg : */
		arrivant = espece.getDeclaredConstructor(clarg).newInstance(arg);
		//Félicitations, nous avons créé un objet d'une classe sans savoir laquelle.
		
		int random_index = (int)Math.floor(Math.random()*(this.habitants.size()+1));
		this.habitants.add(random_index, arrivant);
	}
	/**
	 * Procédure d'ajout d'un poisson à l'aquarium avec sexe précisé.
	 * @param espece (Class<Poisson>) Classe de l'espèce de poisson spécifiée.
	 * @param nom (String) nom de l'individu.
	 * @param age (int) âge en tours d'exécution au moment de l'introduction. 
	 */
	void ajouter_poisson(Class<Poisson> espece, String nom, int age) throws Exception {
		Poisson arrivant;
		Class[] clarg = new Class[] {String.class, int.class, boolean.class};
		Object[] arg = new Object[] {this.nouveau_nom(nom), age};
		arrivant = espece.getDeclaredConstructor(clarg).newInstance(arg);
		int random_index = (int)Math.floor(Math.random()*(this.habitants.size()+1));
		this.habitants.add(random_index, arrivant);
	}
	/**
	 * Procédure d'ajout d'un nouveau poisson aléatoire à l'aquarium.
	 */
	void ajouter_poisson() {
		int espece = (int)Math.floor(Math.random()*6);
		int age = (int)Math.floor(Math.random()*20);
		this.ajouter_poisson(espece, this.nouveau_nom(), age);
	}
	/**
	 * Procédure d'ajout de masse d'organismes dans l'aquarium.
	 * Les algues sont introduites à l'âge 0. Les poissons à un âge aléatoire.
	 * @param algues (int) nombre d'algues à ajouter.
	 * @param bars (int) nombre de bars à ajouter.
	 * @param carpes (int) nombre de carpes à ajouter.
	 * @param merous (int) nombre de mérous à ajouter.
	 * @param poissonClowns (int) nombre de poissons-clowns à ajouter.
	 * @param soles (int) nombre de soles à ajouter.
	 * @param thons (int) nombre de thons à ajouter.
	 */
	void peupler(int algues, int bars, int carpes, int merous, int poissonClowns, int soles, int thons) {
		this.ajouter_algues(algues, 0, 10);
		int age;
		for (int b = 0; b < bars; b++) { age = (int)Math.floor(Math.random()*20); this.ajouter_poisson(0, this.nouveau_nom(), age); }
		for (int c = 0; c < carpes; c++) { age = (int)Math.floor(Math.random()*20); this.ajouter_poisson(1, this.nouveau_nom(), age); }
		for (int m = 0; m < merous; m++) { age = (int)Math.floor(Math.random()*20); this.ajouter_poisson(2, this.nouveau_nom(), age); }
		for (int pc = 0; pc < poissonClowns; pc++) { age = (int)Math.floor(Math.random()*20); this.ajouter_poisson(3, this.nouveau_nom(), age); }
		for (int s = 0; s < soles; s++) { age = (int)Math.floor(Math.random()*20); this.ajouter_poisson(4, this.nouveau_nom(), age); }
		for (int t = 0; t < thons; t++) { age = (int)Math.floor(Math.random()*20); this.ajouter_poisson(5, this.nouveau_nom(), age); }
	}
	/**
	 * Procédure d'ajout de masse d'organismes dans l'aquarium.
	 * Les algues sont introduites à l'àge 0. Les poissons à un âge aléatoire.
	 * L'espèce des poissons est choisie aléatoirement pour chaque individu.
	 * @param algues nombre d'algues à ajouter.
	 * @param poissons nombre de poissons à ajouter.
	 */
	void peupler(int algues, int poissons) {
		this.ajouter_algues(algues, 0, 10);
		for (int i = 0; i < poissons; i++) { this.ajouter_poisson(); }
	}
	
	
}