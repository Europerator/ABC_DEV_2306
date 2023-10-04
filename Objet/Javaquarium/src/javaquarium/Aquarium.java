package javaquarium;
//import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Aquarium {
	private ArrayList<EtreVivant> habitants;
	private final static String[] NOMS = new String[] {"Aldy", "Byron", "Coda", "Deli",
			"Edgy", "Frankie", "Gers", "Hal", "Illy", "Jackie", "Khan", "Lee", "Marilyn",
			"Nifty", "Orca", "Percy", "Qalam", "Richie", "Sandy", "Tempest", "Ursa",
			"Valor", "Wabbajack", "Xerxes", "Yon", "Zindy"};
	private int[] usageNoms;
	
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
	
	ArrayList<Algue> get_algues() {
		ArrayList<Algue> algues = new ArrayList<Algue>();
		for (int i = 0; i < this.habitants.size(); i++) { if (this.habitants.get(i) instanceof Algue) { algues.add((Algue)this.habitants.get(i)); } }
		return algues;
	}
	Algue get_random_algue() {
		ArrayList<Algue> algues = this.get_algues();
		int random_index = (int)(Math.random()*algues.size());
		return algues.get(random_index);
	}
	ArrayList<Poisson> get_poissons() {
		ArrayList<Poisson> poissons = new ArrayList<Poisson>();
		for (int i = 0; i < this.habitants.size(); i++) { if (this.habitants.get(i) instanceof Poisson) { poissons.add((Poisson)this.habitants.get(i)); } }
		return poissons;
	}
	Poisson get_random_poisson(Poisson except) {
		ArrayList<Poisson> poissons = this.get_poissons();
		poissons.remove(except);
		int random_index = (int)(Math.random()*poissons.size());
		return poissons.get(random_index);
	}
	
	private String nouveau_nom() {
		int choix = (int)(Math.random()*NOMS.length);
		usageNoms[choix]++;
		if (usageNoms[choix] == 1) { return NOMS[choix]; }
		else { return NOMS[choix] + usageNoms[choix]; }
	}

	void ajouter_algues(int quantite, int age, int pv) {
		int random_index;
		for (int i = 0; i < quantite; i++) { random_index = (int)(Math.random()*(this.habitants.size()+1)); this.habitants.add(random_index, new Algue(age, pv)); }
	}
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
		int random_index = (int)(Math.random()*(this.habitants.size()+1));
		this.habitants.add(random_index, arrivant);
	}
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
		int random_index = (int)(Math.random()*(this.habitants.size()+1));
		this.habitants.add(random_index, arrivant);
	}
	void ajouter_poisson(Class<Poisson> espece, String nom, int age, boolean sexe) throws Exception {
		Poisson arrivant;
		Class[] clarg = new Class[] {String.class, int.class, boolean.class};
		Object[] arg = new Object[] {nom, age, sexe};
		arrivant = espece.getDeclaredConstructor(clarg).newInstance(arg);
		int random_index = (int)(Math.random()*(this.habitants.size()+1));
		this.habitants.add(random_index, arrivant);
	}
	void ajouter_poisson(Class<Poisson> espece, String nom, int age) throws Exception {
		Poisson arrivant;
		Class[] clarg = new Class[] {String.class, int.class, boolean.class};
		Object[] arg = new Object[] {nom, age};
		arrivant = espece.getDeclaredConstructor(clarg).newInstance(arg);
		int random_index = (int)(Math.random()*(this.habitants.size()+1));
		this.habitants.add(random_index, arrivant);
	}
	void ajouter_poisson() {
		int espece = (int)(Math.random()*6);
		int age = (int)(Math.random()*20);
		this.ajouter_poisson(espece, this.nouveau_nom(), age);
	}
	void peupler(int algues, int bars, int carpes, int merous, int poissonClowns, int soles, int thons) {
		this.ajouter_algues(algues, 0, 10);
		int age;
		for (int b = 0; b < bars; b++) { age = (int)(Math.random()*20); this.ajouter_poisson(0, this.nouveau_nom(), age); }
		for (int c = 0; c < carpes; c++) { age = (int)(Math.random()*20); this.ajouter_poisson(1, this.nouveau_nom(), age); }
		for (int m = 0; m < merous; m++) { age = (int)(Math.random()*20); this.ajouter_poisson(2, this.nouveau_nom(), age); }
		for (int pc = 0; pc < poissonClowns; pc++) { age = (int)(Math.random()*20); this.ajouter_poisson(3, this.nouveau_nom(), age); }
		for (int s = 0; s < soles; s++) { age = (int)(Math.random()*20); this.ajouter_poisson(4, this.nouveau_nom(), age); }
		for (int t = 0; t < thons; t++) { age = (int)(Math.random()*20); this.ajouter_poisson(5, this.nouveau_nom(), age); }
	}
	void peupler(int algues, int poissons) {
		this.ajouter_algues(algues, 0, 10);
		for (int i = 0; i < poissons; i++) { this.ajouter_poisson(); }
	}

}