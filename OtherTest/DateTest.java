package app.xupt;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) throws ParseException {
		Date a = new Date();
		long t = System.currentTimeMillis();
		System.out.println(t);
		System.out.println(1970 + t / 365 / 24 / 60 / 1000 / 60);
		System.out.println(t / 1000 % 60);
		System.out.println(a.getTime());
		
		
		DateFormat a1 = new SimpleDateFormat("yyyy -- MM -- dd , HH : mm : ss : SS");
		
		Date a2 =1000;
				
		System.out.println(a1.format(a2));
		
		System.out.println(a1.parse("2018 -- 06 -- 22 , 15 : 33 : 31 : 376"));
		
	}
}
