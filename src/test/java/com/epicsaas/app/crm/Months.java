package com.epicsaas.app.crm;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Months {
	public static void main(String[] args) {
		Calendar c_begin = new GregorianCalendar();
		Calendar c_end = new GregorianCalendar();
		c_begin.set(2012, 5, 30);
		c_end.set(2012, 11, 5);
		while (c_begin.before(c_end)) {
			int m = c_begin.get(Calendar.MONTH) + 1;
			System.out.println(m);
			c_begin.add(Calendar.MONTH, 1);
		}
	}
}
