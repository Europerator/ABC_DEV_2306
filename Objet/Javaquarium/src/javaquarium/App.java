package javaquarium;

//import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		Aquarium plouf = new Aquarium();
		plouf.peupler(0, 1000);
		System.out.println(plouf.toString());
	}
}
