package com.comcast.crm.webdriverutility;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility
{
	public int getRandomNumber(int limit)
	{
		Random rn=new Random();
		int num=rn.nextInt(limit);
		return num;
	}
    public String getDateFromSystem()
    {
    	Date d=new Date();
    	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
    	String date=sim.format(d);
    	return date;
    }
    public String getEndDate(int duration)
    {

    	Date d=new Date();
    	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
    	String date=sim.format(d);
    	Calendar cal=sim.getCalendar();
    	cal.add(Calendar.DAY_OF_MONTH,duration);
    	String enddate=sim.format(cal.getTime());
    	return enddate;
    }
    public String getLocalDateAndTime()
    {
    	String timestamp=LocalDateTime.now().toString().replace(':', '-');
    	return timestamp;
    }
    public StringBuilder getRandomAlphaNumericValue()
    {
    	int n=20;
    	StringBuilder sb=new StringBuilder();
    	String alphanum="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
    	for(int i=0;i<n;i++)
    	{
    		int index=(int)(alphanum.length()*Math.random());
    		sb.append(alphanum.charAt(index));
    	}
    	return sb;
    }
}
