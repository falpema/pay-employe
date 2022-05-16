package com.falpema.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class PayCalculator {
	
	public static final Logger log = LoggerFactory.getLogger(PayCalculator.class) ;  
	
	//Strategies of calculating of pay hours
	
	private final PayCalculationStrategy payHoursMonToFriday0To9 = new PayHoursMondayFridayCalculationFrom0To9();
	private final PayCalculationStrategy payHoursMonToFriday9To18 =  new PayHoursMondayFridayCalculationFrom9To18();
	private final PayCalculationStrategy payHoursMonToFriday18To24 =  new PayHoursMondayFridayCalculationFrom18To24();
	private final PayCalculationStrategy payHoursSatToSunday0To9 = new PayHoursSaturdaySundayCalculationFrom0To9();
	private final PayCalculationStrategy payHoursSatToSunday9To18 =  new PayHoursSaturdaySundayCalculationFrom9To18();
	private final PayCalculationStrategy payHoursSatToSunday18To24 =  new PayHoursSaturdaySundayCalculationFrom18To24();
	
	
	public double calculatePay(String schedule) {
		String[] days = schedule.split(",");
		double pay=0D;
		for(String dayHours:days) {
			String day=dayHours.substring(0,1);
			String[] hours=getHoursbetween(dayHours.substring(2, dayHours.length()-1));
			
		}
		return pay;
	}
	
	private String[] getHoursbetween(String hours) {
		// TODO Auto-generated method stub
		return null;
	}

	public void main(String args[]) {
		String input = "RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00";
		double pay = 0d;
		String name = input.split("=")[0];
		String schedule = input.split("=")[1];
		try {
			pay = calculatePay(schedule);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("OUTPUT /n The amount to pay {} is : {} ", name, pay);

	}
	
	
}
