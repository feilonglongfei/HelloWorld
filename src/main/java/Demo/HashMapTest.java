package Demo;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {

		Map m=new HashMap();
		
		m.put("key1", "value1");
		m.put("key1", "value2");
		
		System.out.println(m);
	}

}
