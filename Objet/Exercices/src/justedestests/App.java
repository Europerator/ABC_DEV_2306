package justedestests;

public class App {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		maClasseA test = new maClasseB("yay", 2);
		test.faire();
		Object[] arg = new Object[] {"yay", 3};
		Class[] clarg = new Class[] {String.class, int.class};
		Object test2 = test.getClass().getDeclaredConstructor(clarg).newInstance(arg);
		System.out.println(test2.getClass());
	}
}