package Demo;

import java.util.ArrayList;
import java.util.Arrays;

import org.jsoup.helper.StringUtil;

public class Split {

	public static void main(String[] args) {
		String[] splitResult = "prepay_id=u802345jgfjsdfgsdg888".split("=");

		System.out.println("prepay_id=u802345jgfjsdfgsdg888".split("=")[1]);
		System.out.println(Arrays.toString(splitResult));
		
		System.out.println("prepay_id=u802345jgfjsdfgsdg888".split("=")[0]);
		
		System.out.println("prepay_id=u802345jgfjsdfgsdg888".indexOf("prepay_idd"));
		
		String[] strs = "jdfkjds.jdkld".split("\\.");
		System.out.println(Arrays.toString(strs));
		strs = "jdfkjds.jdkld".split(";");
		System.out.println(Arrays.toString(strs));
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("dd");
		list.add("dd");
		
		System.out.println(StringUtil.join(list, ";"));
	}

}
