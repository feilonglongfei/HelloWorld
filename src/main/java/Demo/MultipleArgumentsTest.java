package Demo;

public class MultipleArgumentsTest {
	
	static public void method01(String... str){
		System.out.println(str.length);
	}

	public static void main(String[] args) {
		MultipleArgumentsTest.method01("01","02");
	}

}
