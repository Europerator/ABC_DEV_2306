package compte;

public class Compte {
	public double solde;
	public void deposer(double montant) {
		if (montant > 0) {
			this.solde += montant;
		}
	}
	public void retirer(double montant) {
		if (montant > 0) {
			this.solde -= montant;
		}
	}
	public void afficher() {
		System.out.println("Le montant du compte est de " + this.solde);
	}
	public Compte() {
		this.solde = 0;
	}
	public Compte(double unSolde) {
		this.solde = unSolde;
	}
}