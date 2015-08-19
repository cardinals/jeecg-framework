package com.buss.common;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.jeecgframework.core.util.StringUtil;

public class DateService {
	
	public static String GetSchoolYearRange(Integer schoolYear){
		if (schoolYear == null)
			return "";
		
		int schoolYearStart = schoolYear.intValue();
		
		int schoolYearEnd = schoolYearStart + 1;
		
		return String.valueOf(schoolYearStart) + "-" + String.valueOf(schoolYearEnd);
		
	}
	
	public static String GetTotalSalary(String jobSalary, String rankSalary, String extraSalary){
		Double dJobSalary = 0.0;
		Double dRankSalary = 0.0;
		Double dExtraSalary = 0.0;
		
		java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("#.00");  
		
		
		
		if (StringUtil.isNotEmpty(jobSalary)){
			try{
				dJobSalary = Double.parseDouble(jobSalary);
				decimalFormat.format(dJobSalary);
			}catch(Exception exp){
				
			}
		}
		
		if (StringUtil.isNotEmpty(rankSalary)){
			try{
				dRankSalary = Double.parseDouble(rankSalary);
				decimalFormat.format(dRankSalary);
			}catch(Exception exp){
				
			}
		}
		
		if (StringUtil.isNotEmpty(extraSalary)){
			try{
				dExtraSalary = Double.parseDouble(extraSalary);
				decimalFormat.format(extraSalary);
			}catch(Exception exp){
				
			}
		}
		
		return decimalFormat.format(dJobSalary + dRankSalary + dExtraSalary);
	}
	
	public static int GetCurrentSchoolYear(){		
		return 	GetSchoolYear(Calendar.getInstance());
	}
	
	public static boolean NearRetire(String age, String sex){
		if (StringUtil.isNotEmpty(age) && StringUtil.isNotEmpty(sex)){
			int currentAge = Integer.parseInt(age);
			if (sex.equals("女") && currentAge > 54){
				return true;
			}
			
			if (sex.equals("男") && currentAge > 59){
				return true;
			}
		}
		return false;
	}
	
	//学年：从去年9月1到今年到今年8月31日。
	public static int GetSchoolYear(Calendar calendar){
		
		if (calendar == null)
			return -1;
		
		int currentYear = calendar.get(Calendar.YEAR);
		int currentMonth = calendar.get(Calendar.MONTH) + 1;
		
		if (currentMonth > 8){
			return currentYear;
		}else{
			return currentYear - 1;
		}
	}
	
	public static Date GetNextYearFirstDay(){
		Calendar calendar = Calendar.getInstance();
		int effectiveYear = calendar.get(Calendar.YEAR) + 1;
		calendar.set(Calendar.YEAR, effectiveYear);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DATE, 1);
		
		return calendar.getTime();		
	}
	
	public static Date GetNextMonthFirstDay(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DATE, 1);
		return calendar.getTime();
	}
	
	public static Date GetDate(String dateTime){
		if (dateTime == null)
			return null;
		try{
			return new SimpleDateFormat("yyyy-MM-dd").parse(dateTime);
		}catch(Exception exp){
			return Calendar.getInstance().getTime();
		}
		
	}

	public static String getAge(Date birthday) {
		// TODO Auto-generated method stub
		if (birthday == null)
			return "";
		
		//Date currentDate = Calendar.getInstance().getTime();
		
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		int birthdayYear = birthday.getYear() + 1900;
		
		int age = thisYear - birthdayYear;
		
		return String.valueOf(age).toString();
	}
	
	public static String getWorkAge(Date startWorkDate){
		
		if (startWorkDate == null)
			return "";
		
		Calendar startCalendar = new GregorianCalendar();
		startCalendar.setTime(Calendar.getInstance().getTime());
		
		Calendar endCalendar = new GregorianCalendar();
		endCalendar.setTime(startWorkDate);
		
		int diffYear = startCalendar.get(Calendar.YEAR) - endCalendar.get(Calendar.YEAR);
		int diffMonth = (diffYear * 12 + startCalendar.get(Calendar.MONTH) - endCalendar.get(Calendar.MONTH))%12;
		
		return String.valueOf(diffYear).toString() + "年" + String.valueOf(diffMonth).toString() + "月";
	}

	public static String GetToday() {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		return year +"年" + month + "月" + day + "日";
	}
}
