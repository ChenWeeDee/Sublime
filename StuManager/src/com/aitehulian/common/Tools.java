package com.aitehulian.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {
	//字符串到日期的转换
	public static Date stringToDate(String source,String pattern){
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		 try {
			date = sdf.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	//日期转字符串
	public static String dateToString(Date source,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(source);
	}
	
}	
