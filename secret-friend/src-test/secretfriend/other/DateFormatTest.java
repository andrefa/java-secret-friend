package secretfriend.other;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

/**
 * 
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class DateFormatTest {

	/**
	 * 
	 */
	@Test
	public void testFormat1() {
		DateFormat dateFormat = DateFormat.getDateInstance();

		Date date = new Date();

		System.out.println(dateFormat.format(date));
		System.out.println(dateFormat.getCalendar().get(Calendar.MONTH));
		System.out.println(date);

		DateFormat dfmt = new SimpleDateFormat("d 'de' MMMM 'de' yyyy");
		Date hoje = Calendar.getInstance(Locale.getDefault()).getTime();
		System.out.println(dfmt.format(hoje));
	}

}