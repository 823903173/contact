package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @ClassName: DateUtils   
 * @Description: 日期对象工作类
 */
public class DateUtils {

	/**
	 * 
	 * @Title: stringToDate
	 * @param @param date 需要进行转化的字符串对象
	 * @param @param pattern 格式化格式 如:yyyy-MM-dd
	 * @param @return      
	 * @return Date  转化后的日期对象
	 * @Description: 将字符串转化为日期Date对象(自己输入格式化格式)默认严格
	 */
	public static Date stringToDate(String date, String pattern){
		return stringToDate(date,pattern,null);
	}
	
	/**
	 * 
	 * @Title: stringToDate
	 * @param @param date 需要进行转化的字符串对象
	 * @param @param pattern 格式化格式 如:yyyy-MM-dd
	 * @param @param lenient 是否严格
	 * @param @return      
	 * @return Date  转化后的日期对象  
	 * @Description:将字符串转化为日期Date对象(自己输入格式化格式) 并确认是否严格
	 */
	public static Date stringToDate(String date, String pattern, Boolean lenient){
		return stringToDate(date, new SimpleDateFormat(pattern), lenient);
	}
	
	
	/**
	 * 
	 * @Title: stringToDate
	 * @param @param date 需要进行格式化的字符串对象
	 * @param @param df 格式化对象
	 * @param @return      
	 * @return Date   转化后的日期对象(null表示转化出问题)
	 * @Description: 将字符串转化为日期Date对象(输入格式化格式对象) 默认严格
	 */
	public static Date stringToDate(String date, SimpleDateFormat df){
		return stringToDate(date, df, null);
	}
	
	/**
	 * 
	 * @Title: stringToDate
	 * @param @param date 字符串
	 * @param @param df 格式化对象
	 * @param @param lenient 是否严格
	 * @param @return      
	 * @return Date 
	 * @Description: 将字符串转化为日期Date对象(输入格式化格式对象),是否需要严格化 
	 */
	public static Date stringToDate(String date, SimpleDateFormat df, Boolean lenient){
		try {
			df.setLenient(lenient==null?true:lenient);
			return df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @Title: dateToString
	 * @param @param date 日期对象
	 * @param @param pattern 格式 如yyyy-MM-dd
	 * @param @return      
	 * @return String  格式化后的字符串   
	 * @Description:将日期转化为字符串(根据格式化字符串)
	 */
	public static String dateToString(Date date, String pattern){
		return dateToString(date, new SimpleDateFormat(pattern));
	}
	
	/**
	 * 
	 * @Title: dateToString
	 * @param @param date 日期对象
	 * @param @param pattern 格式 如yyyy-MM-dd
	 * @param @return      
	 * @return String  格式化后的字符串   
	 * @Description:将日期转化为字符串(根据格式化字符串)
	 */
	public static String dateToString(Date date){
		String pattern = "yyyy-MM-dd";
		return dateToString(date, new SimpleDateFormat(pattern));
	}
	
	/**
	 * 
	 * @Title: dateToString
	 * @param @param date 日期对象
	 * @param @param df 格式化对象
	 * @param @return   格式化后的字符串
	 * @return String      
	 * @Description:将日期转化为字符串(根据格式化对象)
	 */
	public static String dateToString(Date date, SimpleDateFormat df){
		try {
			return df.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 
	 * @Title: addDays
	 * @param @param date 原始日期
	 * @param @param days 增加的数目
	 * @param @return      
	 * @return Date  增加后的结果     
	 * @Description:日期增加天
	 */
	public static Date addDays(Date date, int days){
		return addTime(date, Calendar.DAY_OF_YEAR, days);
	}
	
	
	/**
	 * 
	 * @Title: addMinutes
	 * @param @param date 原始日期
	 * @param @param minutes 增加的数目
	 * @param @return      
	 * @return Date  增加后的结果       
	 * @Description:日期增加分钟
	 */
	public static Date addMinutes(Date date, int minutes){
		return addTime(date, Calendar.MINUTE, minutes);
	}
	
	/**
	 * 
	 * @Title: addMonths
	 * @param @param date 原始日期
	 * @param @param months 增加的数目
	 * @param @return      
	 * @return Date  增加后的结果   
	 * @Description:日期增加月
	 */
	public static Date addMonths(Date date, int months){
		return addTime(date, Calendar.MONTH, months);
	}
	
	
	/**
	 * 
	 * @Title: addTime
	 * @param @param date 原始日期
	 * @param @param types Calendar的枚举数据
	 * @param @param number 增加的数目
	 * @param @return      
	 * @return Date  增加后的结果    
	 * @Description:进行自定义的日期增加
	 */
	public static Date addTime(Date date, int types, int number){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(types, number);
		return calendar.getTime();
	}
	
	
}
