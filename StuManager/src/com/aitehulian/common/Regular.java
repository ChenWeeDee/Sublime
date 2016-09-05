package com.aitehulian.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author Daizhenwei
 * @Description	正则表达式验证
 * @Data 2016-8-31 下午08:44:39
 */
public class Regular {
	/*
	 * 
	 */
	public Regular(){
		
	}
	/*
	 * 正则验证
	 */
	public static boolean verify(String regex,String verify){
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(verify);
		boolean boo = matcher.matches();
		return boo;
	}
	/*
	 * 验证中文字符
	 */
	public boolean verifyChinese(String verify){
		String regex = "[\u4e00-\u9fa5]";
		return this.verify(regex, verify);
	}
	/*
	 * 验证Email
	 */
	public boolean verifyEmail(String verify){
		String regex = "w+([-+.]w+)*@w+([-.]w+)*.w+([-.]w+)*";
		return this.verify(regex, verify);
	}
	/*
	 * 验证手机号
	 */
	public boolean verifyPhone(String verify){
		String regex = "0?(13|14|15|18)[0-9]{9}";
		return this.verify(regex, verify);
	}
	/*
	 * 验证身份证号
	 */
	public boolean verifyIdCard(String verify){
		String regex = "\\d{17}[\\d|x]|\\d{15}";
		return this.verify(regex, verify);
	}
	/*
	 * 验证QQ号码
	 */
	public boolean verifyQQ(String verify){
		String regex = "[1-9]([0-9]{5,11})";
		return this.verify(regex, verify);
	}
}
