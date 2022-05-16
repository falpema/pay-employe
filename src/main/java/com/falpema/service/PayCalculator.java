package com.falpema.service;

public class PayCalculator {
	
	//Strategies of calculating of pay hours
	
	private final PayCalculationStrategy payHoursMonToFriday0To9 = new PayHoursMondayFridayCalculationFrom0To9();
	private final PayCalculationStrategy payHoursMonToFriday9To18 =  new PayHoursMondayFridayCalculationFrom9To18();
	private final PayCalculationStrategy payHoursMonToFriday18To24 =  new PayHoursMondayFridayCalculationFrom18To24();
	private final PayCalculationStrategy payHoursSatToSunday0To9 = new PayHoursSaturdaySundayCalculationFrom0To9();
	private final PayCalculationStrategy payHoursSatToSunday9To18 =  new PayHoursSaturdaySundayCalculationFrom9To18();
	private final PayCalculationStrategy payHoursSatToSunday18To24 =  new PayHoursSaturdaySundayCalculationFrom18To24();
	
}
