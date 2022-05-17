package com.falpema.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PayCalculationStrategyFactory {
	private final PayCalculationStrategy payHoursMonToFriday0To9 = new PayHoursMondayFridayCalculationFrom0To9();
	private final PayCalculationStrategy payHoursMonToFriday9To18 = new PayHoursMondayFridayCalculationFrom9To18();
	private final PayCalculationStrategy payHoursMonToFriday18To24 = new PayHoursMondayFridayCalculationFrom18To24();
	private final PayCalculationStrategy payHoursSatToSunday0To9 = new PayHoursSaturdaySundayCalculationFrom0To9();
	private final PayCalculationStrategy payHoursSatToSunday9To18 = new PayHoursSaturdaySundayCalculationFrom9To18();
	private final PayCalculationStrategy payHoursSatToSunday18To24 = new PayHoursSaturdaySundayCalculationFrom18To24();
	private final PayCalculationStrategy nopayCalculationStrategy = new NoPayCalculation();

	public PayCalculationStrategy getPayHourStrategy(String day, String time) throws ParseException {
		String time1 = "00:00";
		String time2 = "09:00";
		String time3 = "18:00";
		String time4 = "24:00";
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date date1 = sdf.parse(time1);
		Date date2 = sdf.parse(time2);
		Date date3 = sdf.parse(time3);
		Date date4 = sdf.parse(time4);
		Date dini = sdf.parse(time.split("-")[0]);
		if (day.compareTo("MO") == 0 || day.compareTo("TU") == 0 || day.compareTo("WE") == 0 || day.compareTo("TH") == 0
				|| day.compareTo("FR") == 0) {
			if (dini.compareTo(date1) >= 0 && dini.after(date2)) {
				return payHoursMonToFriday0To9;
			} else if (dini.compareTo(date2) >= 0 && dini.after(date3)) {
				return payHoursMonToFriday9To18;
			} else if (dini.compareTo(date3) >= 0 && dini.after(date4)) {
				return payHoursMonToFriday18To24;
			} else {
				return nopayCalculationStrategy;
			}
		} else if (day.compareTo("SA") == 0 || day.compareTo("SU") == 0) {
			if (dini.compareTo(date1) >= 0 && dini.after(date2)) {
				return payHoursSatToSunday0To9;
			} else if (dini.compareTo(date2) >= 0 && dini.after(date3)) {
				return payHoursSatToSunday9To18;
			} else if (dini.compareTo(date3) >= 0 && dini.after(date4)) {
				return payHoursSatToSunday18To24;
			} else {
				return nopayCalculationStrategy;
			}
		} else {
			return nopayCalculationStrategy;
		}

	};
}
