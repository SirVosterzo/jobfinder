package jobfinder.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DateUtil {

	public static String toISO(DateTime date) {
		DateTimeFormatter formatter = ISODateTimeFormat.date();
		return date.toString(formatter);
	}

}
