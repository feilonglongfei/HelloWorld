package Demo.date;

import java.util.Calendar;
import java.util.Date;

public class Demo01 {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		Calendar calendarCurrent = Calendar.getInstance();
		
		calendar.setTime(new Date());
		calendarCurrent.setTime(new Date());
		
		calendar.add(Calendar.DATE, -90);
		
		System.out.println(calendarCurrent.toString());
		System.out.println(calendar.toString());
		
		System.out.println(calendar.equals(calendarCurrent));
		System.out.println(calendar.before(calendarCurrent));
		System.out.println(calendar.after(calendarCurrent));
		
			
	}

}
