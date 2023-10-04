package javaquarium;
//import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Aquarium {
	private ArrayList<EtreVivant> habitants;
	private final static String[] noms = new String[] {"Aldy", "Byron", "Coda", "Deli", "Edgy", "Frankie", "Gers", "Hal", "Illy", "Jackie", "Khan", "Lee", "Marilyn", "Nifty", "Orca", "Percy", "Qalam", "Richie", "Sandy", "Tempest", "Ursa", "Valor", "Wabbajack", "Xerxes", "Zindy"};
	private int[] usageNoms;
	
	Aquarium() {
		this.habitants = new ArrayList<EtreVivant>();
		usageNoms = new int[noms.length];
		for (int i = 0; i < usageNoms.length; i++) { usageNoms[i] = 0; }
	}
	public String toString() {
		String retour = "Aquarium (p=" + this.habitants.size() + ")\n";
		for (int i = 0; i < this.habitants.size(); i++) { retour = retour + this.habitants.get(i).toString() + "\n"; }
		return retour;
	}

	void ajouter_algue(int quantite, int age) {
		for (int i = 0; i < quantite; i++) { this.habitants.add(new Algue(age, 10)); }
	}
	void ajouter_poisson(int espece, String nom, int age, boolean sexe) {
		Poisson arrivant;
		switch (espece) {
		case 0: arrivant = new Bar(nom, age, sexe);
		case 1: arrivant = new Carpe(nom, age, sexe);
		case 2: arrivant = new Merou(nom, age, sexe);
		case 3: arrivant = new PoissonClown(nom, age, sexe);
		case 4: arrivant = new Sole(nom, age, sexe);
		default: System.out.println("default hit"); arrivant = new Thon(nom, age, sexe);
		}
		this.habitants.add(arrivant);
	}
	void ajouter_poisson(int espece, String nom, int age) {
		Poisson arrivant;
		switch (espece) {
		case 0: arrivant = new Bar(nom, age);
		case 1: arrivant = new Carpe(nom, age);
		case 2: arrivant = new Merou(nom, age);
		case 3: arrivant = new PoissonClown(nom, age);
		case 4: arrivant = new Sole(nom, age);
		default: arrivant = new Thon(nom, age);
		}
		this.habitants.add(arrivant);
	}
	void ajouter_poisson(Class<Poisson> espece, String nom, int age, boolean sexe) throws Exception {
		Poisson arrivant;
		Class[] clarg = new Class[] {String.class, int.class, boolean.class};
		Object[] arg = new Object[] {nom, age, sexe};
		arrivant = espece.getDeclaredConstructor(clarg).newInstance(arg);
		this.habitants.add(arrivant);
	}
	void ajouter_poisson(Class<Poisson> espece, String nom, int age) throws Exception {
		Poisson arrivant;
		Class[] clarg = new Class[] {String.class, int.class, boolean.class};
		Object[] arg = new Object[] {nom, age};
		arrivant = espece.getDeclaredConstructor(clarg).newInstance(arg);
		this.habitants.add(arrivant);
	}
	private String nouveau_nom() {
		int choix = (int)(Math.random()*noms.length);
		usageNoms[choix]++;
		if (usageNoms[choix] == 1) { return noms[choix]; }
		else { return noms[choix] + usageNoms[choix]; }
	}
	void ajouter_poisson() {
		int espece = (int)(Math.random()*6);
		int age = (int)(Math.random()*20);
		this.ajouter_poisson(espece, this.nouveau_nom(), age);
	}
	void peupler(int algues, int bars, int carpes, int merous, int poissonClowns, int soles, int thons) {
		this.ajouter_algue(algues, 10);
		int age;
		for (int b = 0; b < bars; b++) { age = (int)(Math.random()*20); this.ajouter_poisson(0, this.nouveau_nom(), age); }
		for (int c = 0; c < carpes; c++) { age = (int)(Math.random()*20); this.ajouter_poisson(1, this.nouveau_nom(), age); }
		for (int m = 0; m < merous; m++) { age = (int)(Math.random()*20); this.ajouter_poisson(2, this.nouveau_nom(), age); }
		for (int pc = 0; pc < poissonClowns; pc++) { age = (int)(Math.random()*20); this.ajouter_poisson(3, this.nouveau_nom(), age); }
		for (int s = 0; s < soles; s++) { age = (int)(Math.random()*20); this.ajouter_poisson(4, this.nouveau_nom(), age); }
		for (int t = 0; t < thons; t++) { age = (int)(Math.random()*20); this.ajouter_poisson(5, this.nouveau_nom(), age); }
	}
	void peupler(int algues, int poissons) {
		this.ajouter_algue(algues, 10);
		for (int i = 0; i < poissons; i++) { this.ajouter_poisson(); }
	}
}
