package javaquarium;

//import java.util.ArrayList;

public class App {

	public static void main(String[] args) throws Exception {
		Moniteur moni = new Moniteur(1, false, false, true,  true,  true, false, 1, 1);
		Aquarium plouf = new Aquarium(moni);
		plouf.peupler(10, 5, 5, 5, 5, 5, 5);
		plouf.executer(10);
	}
}
/*
Ouverture du programme :
- Choix du moniteur
- Instanciation de l'aquarium
- tour x, que voulez-vous faire ?
  > exécuter y tours,
  > ajouter un poisson
  > ajouter des algues
  > peuplement aléatoire (poissons)
  > peuplement aléatoire (par espèce)
  > afficher un poisson aléatoire
  > afficher un poisson (avec nom)
*/