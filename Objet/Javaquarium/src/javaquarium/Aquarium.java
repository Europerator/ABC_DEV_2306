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
	 * Regroupe les individus décédés.
	 */
	private ArrayList<EtreVivant> cimetiere;
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
	 * Store le numéro du tour d'exécution courant.
	 */
	private int tourCourant;
	private Moniteur hublot;
	
	/**
	 * Constructeur générique d'Aquarium. Commence vide.
	 */
	Aquarium(Moniteur _hublot) {
		this.habitants = new ArrayList<EtreVivant>();
		this.cimetiere = new ArrayList<EtreVivant>();
		this.tourCourant = 0;
		this.hublot = _hublot;
		usageNoms = new int[NOMS.length];
		for (int i = 0; i < usageNoms.length; i++) { usageNoms[i] = 0; }
	}
	Aquarium() {
		this(new Moniteur());
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
	Algue get_random_algue() { //todo: what if get_algues() returns empty?
		ArrayList<Algue> algues = this.get_algues();
		int random_index = (int)Math.floor(Math.random()*algues.size());
		Algue elue = algues.get(random_index);
		hublot.notifier(Evenement.RANDOM, this.tourCourant, "Une algue a été prise au hasard", "index " + random_index + "parmi " + algues.size() + ": " + elue.toString(), false);
		return elue;
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
		Poisson elu = poissons.get(random_index);
		hublot.notifier(Evenement.RANDOM, this.tourCourant, "Un poisson a été pris au hasard", "(index " + random_index + " parmi " + poissons.size() + ") : " +  elu.toString(), false);
		return elu;
	}
	/**
	 * Accesseur du tour d'exécution en cours.
	 * @return (int) numéro du tour.
	 */
	int get_tourCourant() {
		return this.tourCourant;
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
	private void nouvel_habitant(EtreVivant habitant, int index) {	
		String message;
		this.habitants.add(index, habitant);
		if (habitant instanceof Poisson) { message = "Création d'un poisson."; }
		else { message = "Création d'une algue."; }
		this.hublot.notifier(Evenement.CREATION, this.tourCourant, message, habitant.toString(), false);
	}
	
	/**
	 * Procédure d'introduction d'algues à l'aquarium.
	 * @param quantite (int) nombre d'algues à introduire.
	 * @param age (int) âge des algues au moment de l'introduction.
	 * @param pv (int) points de vie initiaux des algues.
	 */
	void ajouter_algues(int quantite, int age, int pv) {
		int random_index;
		for (int i = 0; i < quantite; i++) { random_index = (int)Math.floor(Math.random()*(this.habitants.size()+1)); this.nouvel_habitant(new Algue(age, pv), random_index); }
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
		case 0: arrivant = new Bar(nom, age, sexe); break;
		case 1: arrivant = new Carpe(nom, age, sexe); break;
		case 2: arrivant = new Merou(nom, age, sexe); break;
		case 3: arrivant = new PoissonClown(nom, age, sexe); break;
		case 4: arrivant = new Sole(nom, age, sexe); break;
		default: arrivant = new Thon(nom, age, sexe);
		}
		int random_index = (int)Math.floor(Math.random()*(this.habitants.size()+1));
		this.nouvel_habitant(arrivant, random_index);
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
		case 0: arrivant = new Bar(nom, age); break;
		case 1: arrivant = new Carpe(nom, age); break;
		case 2: arrivant = new Merou(nom, age); break;
		case 3: arrivant = new PoissonClown(nom, age); break;
		case 4: arrivant = new Sole(nom, age); break;
		default: arrivant = new Thon(nom, age);
		}
		int random_index = (int)Math.floor(Math.random()*(this.habitants.size()+1));
		this.nouvel_habitant(arrivant, random_index);
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
		this.nouvel_habitant(arrivant, random_index);
	}
	/**
	 * Procédure d'ajout d'un poisson à l'aquarium avec sexe précisé.
	 * @param espece (Class<Poisson>) Classe de l'espèce de poisson spécifiée.
	 * @param nom (String) nom de l'individu.
	 * @param age (int) âge en tours d'exécution au moment de l'introduction. 
	 */
	void ajouter_poisson(Class<? extends Poisson> espece, String nom, int age) throws Exception {
		Poisson arrivant;
		Class[] clarg = new Class[] {String.class, int.class, boolean.class};
		Object[] arg = new Object[] {this.nouveau_nom(nom), age};
		arrivant = espece.getDeclaredConstructor(clarg).newInstance(arg);
		int random_index = (int)Math.floor(Math.random()*(this.habitants.size()+1));
		this.nouvel_habitant(arrivant, random_index);
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
		this.hublot.notifier(Evenement.PEUPLEMENT, this.tourCourant, "Ordre de peuplement", "Algues : " + algues
				+ ",\n bars : " + bars + ",\n carpes : " + carpes
				+ ",\n mérous : " + merous + ",\n poisson-clowns : " + poissonClowns
				+ ",\n soles : " + soles + ",\n thons : " + thons + ".", false);
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
		this.hublot.notifier(Evenement.PEUPLEMENT, this.tourCourant, "Ordre de peuplement", "Algues : " + algues + ", poissons : " + poissons + ".", false);
		this.ajouter_algues(algues, 0, 10);
		for (int i = 0; i < poissons; i++) { this.ajouter_poisson(); }
	}
	/**
	 * Procédure exécutant le nombre de tours renseigné.
	 * @param tours (int) nombre de tours d'exécution à effectuer.
	 */
	void executer(int tours) throws Exception {
		for (int t = 0; t < tours; t++) { //1) poissons : mange, sinon reproduire. 2) algues. 3) vieillir
			this.tourCourant++;
			ArrayList<Poisson> poissons = this.get_poissons(); 
			for (int p = 0; p < poissons.size(); p++) {
				Poisson poisson = poissons.get(p);
				if (poisson.aFaim()) {
					//c'est le moment de manger
					int pv_prerepas = poisson.getPointsDeVie();
					boolean reussite = false;
					String message;
					String details = "acteur : " + poisson.toString() + "\ncible : ";
					if (poisson instanceof Vegetarien) {
						Algue aproie = this.get_random_algue();
						message = poisson.getNom() + " tente de manger une algue.";
						details = details + aproie.toString();
						((Vegetarien) poisson).manger(aproie);
					}
					else {
						Poisson pproie = this.get_random_poisson(poisson);
						message = poisson.getNom() + "tente de manger" + pproie.getNom() + ".";
						details = details + pproie.toString();
						((Carnivore)poisson).manger(pproie);
					}
					if (poisson.getPointsDeVie() > pv_prerepas) { reussite = true; message = message + " Iel réussit !"; }
					else { message = message + " Iel échoue."; }
					hublot.notifier(Evenement.MANGER, this.tourCourant, message, details, reussite);
				}
				else {
					//c'est le moment de séduire
					Poisson ppartenaire = this.get_random_poisson(poisson);
					String message = poisson.getNom() + " tente de se reproduire avec " + ppartenaire.getNom();  
					String details = "acteur : " + poisson.toString() + "\ncible : " + ppartenaire.toString();
					boolean reussite = poisson.saccoupler(ppartenaire);
					if (reussite) {
						message = message + " Iel réussit !";
						this.ajouter_poisson(poisson.getClass(), this.nouveau_nom(), 0);
					}
					else {
						message = message + " Iel échoue. ";
					}
					this.hublot.notifier(Evenement.REPRODUIRE, this.tourCourant, message, details, reussite);
				}
			}
			ArrayList<Algue> algues = this.get_algues();
			for (int a = 0; a < algues.size(); a++) {
				//la mitose fort morose
				if (algues.get(a).sereproduire()) {
					String message = "Une algue se reproduit.";
					String details = algues.get(a).toString();
					this.ajouter_algues(1, 0, algues.get(a).getPointsDeVie());
					this.hublot.notifier(Evenement.REPRODUIRE, this.tourCourant, message, details, true);
				}
			}
			for (int e = 0; e < this.habitants.size(); e++) { this.habitants.get(e).vieillir();	}
			//ici les morts vont au cimetière.
			for (int l = 0; l < this.habitants.size(); l++) {
				if (!this.habitants.get(l).estVivant()) {
					String message;
					String details = this.habitants.get(l).toString();
					if (this.habitants.get(l) instanceof Poisson) { message = ((Poisson) this.habitants.get(l)).getNom() + " est mort. "; }
					else { message = "Une algue est morte. "; }
					if (this.habitants.get(l).getPointsDeVie() <= 0) {
						message = message + "Cause probable : prédation.";
					}
					else if (this.habitants.get(l).getAge() >= 20) {
						message = message + "Cause probable : senescence.";
					}
					else { message = message + "Cause inconnue."; }
					this.hublot.notifier(Evenement.MORT, this.tourCourant, message, details, false);
					this.cimetiere.add(this.habitants.get(l));
					this.habitants.remove(l);
				}
			}
			this.hublot.notifier(Evenement.STATUT, this.tourCourant, "L'aquarium est peuplé de " + this.habitants.size() + " individus.", this.toString(), false);
		}
	}
}