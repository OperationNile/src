package com.myNile.leet;

import java.util.Calendar;


public class CompareBoth {

	public static void main(String[] args) {

		String low="1";
		String high="100";
		
		STRBGCountInRange stg1=new STRBGCountInRange();
		if(!StrobogramaticUtil.validate(low,high)){
			System.out.println("invalid input");
			return;
		}
		
		long l3=Calendar.getInstance().getTimeInMillis();
		System.out.println("===>"+stg1.count(low,high)+"<<<");
		long l4=Calendar.getInstance().getTimeInMillis();
		System.out.println("time taken for MINE>>"+(l4-l3)+" milli seconds");
		
		
		
		
	}

}
