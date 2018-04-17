package Demo;

public class StringTest {

	public void method(int i){
		System.out.println(i);
	}
	
	public static void main(String[] args) {
		System.out.println("2017-07-01".compareToIgnoreCase("2017-06-30"));
		System.out.println("2017-06-30".compareToIgnoreCase("2017-06-30"));
		System.out.println("2017-06-29".compareToIgnoreCase("2017-06-30"));
		
		System.out.println("2016-12-06 14:57:50".substring(0, 10));

		StringTest stringTest = new StringTest();
		
//		stringTest.method(null);
		
		
	}

}
