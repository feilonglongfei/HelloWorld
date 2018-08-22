package Demo.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Demo02 {

	@SuppressWarnings({ "unused", "deprecation" })
	public static void main(String[] args) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = simpleDateFormat.format(new Date());
		Calendar calendear = Calendar.getInstance();
		Date date = new Date(dateStr);
//		calendear.set(DateUtils.parseDate(date, "yyyy-MM-dd"));
		System.out.println(date);

	}

}
