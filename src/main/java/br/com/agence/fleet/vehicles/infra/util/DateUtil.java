package br.com.agence.fleet.vehicles.infra.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {
	
	public static String dateTimeToString(final LocalDateTime localDateTime, final String format) {
		if (localDateTime == null) {
			return null;
		}
		return new SimpleDateFormat(format).format(converteLocalDateTimeParaDate(localDateTime));
	}
	
	public static Date converteLocalDateTimeParaDate(final LocalDateTime localDateTime) {
		if (localDateTime == null) {
			return null;
		}
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}
	
}
