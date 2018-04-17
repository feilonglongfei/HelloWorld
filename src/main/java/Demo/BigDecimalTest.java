package Demo;

import java.math.BigDecimal;

public class BigDecimalTest {

	public static void main(String[] args) {
		
		BigDecimal de = new BigDecimal("50.00");
		System.out.println(de.toString());
		
		System.out.println(de.compareTo(BigDecimal.ZERO));		
		
	}

}
