package Demo.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo03 {

	public static void main(String[] args) {

//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//		Date currentDate = new Date();
//		
//		String dateStr = simpleDateFormat.format(new Date(currentDate.getTime() + 5*60*1000));
//		
//		System.out.println(currentDate);
//		
//		System.out.println(dateStr);
//		
//		
//		
//		
//		String expireTime = simpleDateFormat.format(new Date(currentDate.getTime() + Long.valueOf("10")*60*1000));
//		
//		System.out.println(expireTime);
		
		String  expireMinute = "10"; 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date currentDate = new Date();
		String expireTime = simpleDateFormat.format(new Date(currentDate.getTime() + Long.valueOf(expireMinute)*60*1000));


		System.out.println(expireTime);
		
		
		
	}

}
