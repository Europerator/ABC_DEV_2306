package voiture;

public class Voiture {
	String marque;
	double prix;
	public Voiture() {
		this.marque = "inconnue";
		this.prix = -1d;
	}
	public void setMarque(String uneMarque) {
		this.marque = uneMarque;
	}
	public void setPrix(double unPrix) {
		this.prix = unPrix;
	}
	public String getMarque() {
		return this.marque;
	}
	public double getPrix() {
		return this.prix;
	}
	public void afficher() {
		System.out.println("Cette voiture de marque " + this.marque + " coûte " + this.prix);
	}
}
