package Demo;

import java.util.Random;
import java.util.UUID;

public class RandomTest {

	public static void main(String[] args) {

		
		Random random = new Random();
		
		int i = random.nextInt(1000);
		
		System.out.println(i);
		
		String u = UUID.randomUUID().toString();
		
		System.out.println(u);
	}

}
