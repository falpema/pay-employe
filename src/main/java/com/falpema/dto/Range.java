package com.falpema.dto;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * to compare range of Times
 * 
 * @author falpema
 *
 */
public class Range {
	private List<String> days;
	private Date hourStart;
	private Date hourFinish;

	public List<String> getDays() {
		return days;
	}

	public void setDays(List<String> days) {
		this.days = days;
	}

	public Date getHourStart() {
		return hourStart;
	}

	public void setHourStart(Date hourStart) {
		this.hourStart = hourStart;
	}

	public Date getHourFinish() {
		return hourFinish;
	}

	public void setHourFinish(Date hourFinish) {
		this.hourFinish = hourFinish;
	}

	public Range() {

	}

	public boolean contains(String day, Date hour) {
		if (days.contains(day) && hour.compareTo(hourStart) >= 0 && hour.before(hourFinish)) {
			return true;
		}
		return false;
	}

	public void parseDays(String strDays) {
		this.days = Arrays.asList(strDays.split(","));
	}

}
