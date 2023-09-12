package dominossanspizza;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Domino joker = new Domino();
		Domino snakeEye = new Domino(1, 1);
		Domino oneTwo = new Domino(2, 1);
		Domino threeFour = new Domino(3, 4);
		
		boolean test1 =  joker.voisinValide(joker);
		boolean test2 = joker.voisinValide(snakeEye);
		boolean test3 = joker.voisinValide(oneTwo);
		boolean test4 = joker.voisinValide(threeFour);
		boolean test5 = snakeEye.voisinValide(oneTwo);
		boolean test6 = oneTwo.voisinValide(snakeEye);
		boolean test7 = threeFour.voisinValide(joker);
		boolean test8 = !threeFour.voisinValide(oneTwo);
		if (test1 && test2 && test3 && test4 && test5 && test6 && test7 && test8) {
			System.out.println("test concluant.");
		}
		else {
			System.out.println("problème (bonne chance).");
		}
	}

}
