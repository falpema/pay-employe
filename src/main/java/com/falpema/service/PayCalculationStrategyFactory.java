package com.falpema.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.falpema.dto.Range;

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
		Range rangMoToFr0To9 = new Range() ;
		rangMoToFr0To9.parseDays("MO,TU,WE,TH,FR");
		rangMoToFr0To9.setHourStart(date1);
		rangMoToFr0To9.setHourFinish(date2);
		Range rangMoToFr9To18 = new Range() ;
		rangMoToFr9To18.parseDays("MO,TU,WE,TH,FR");
		rangMoToFr9To18.setHourStart(date2);
		rangMoToFr9To18.setHourFinish(date3);
		Range rangMoToFr18To24 = new Range() ;
		rangMoToFr18To24.parseDays("MO,TU,WE,TH,FR");
		rangMoToFr18To24.setHourStart(date3);
		rangMoToFr18To24.setHourFinish(date4);
		Range rangSaSu0To9 = new Range() ;
		rangSaSu0To9.parseDays("SA,SU");
		rangSaSu0To9.setHourStart(date1);
		rangSaSu0To9.setHourFinish(date2);
		Range rangSaSu9To18 = new Range() ;
		rangSaSu9To18.parseDays("SA,SU");
		rangSaSu9To18.setHourStart(date2);
		rangSaSu9To18.setHourFinish(date3);
		Range rangSaSu18To24 = new Range() ;
		rangSaSu18To24.parseDays("SA,SU");
		rangSaSu18To24.setHourStart(date3);
		rangSaSu18To24.setHourFinish(date4);
		
		Date dini = sdf.parse(time.split("-")[0]);
		
		if(rangMoToFr0To9.contains(day, dini)){
			return payHoursMonToFriday0To9;
		}else if(rangMoToFr9To18.contains(day, dini)){
			return payHoursMonToFriday9To18;
		} else if(rangMoToFr18To24.contains(day, dini)){
			return payHoursMonToFriday18To24;
		} else if(rangSaSu0To9.contains(day, dini)){
			return payHoursSatToSunday0To9;
		} else if(rangSaSu9To18.contains(day, dini)){
			return payHoursSatToSunday9To18;
		} else if(rangSaSu18To24.contains(day, dini)){
			return payHoursSatToSunday18To24;
		}  else {
			return nopayCalculationStrategy;
		}
			
			
		

	};
}
