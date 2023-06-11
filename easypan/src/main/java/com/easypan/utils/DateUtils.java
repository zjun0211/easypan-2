package com.easypan.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 王哲
 * @ClassName DateUtils
 * @Description 创建基础类 代码生成器生成
 * @Version V1.0
 */

public class DateUtils {
	private static final Object lockObj = new Object();
	private static Map<String,ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap();

	private static SimpleDateFormat getSdf(final String pattern){
		ThreadLocal<SimpleDateFormat> tl = sdfMap.get(pattern);
		if(tl == null){
			synchronized (lockObj){
				tl = sdfMap.get(pattern);
				if(tl == null){
					System.out.println("put new sdf of pattern " + pattern + " to map");
					tl = new ThreadLocal<SimpleDateFormat>(){
						@Override
						protected SimpleDateFormat initialValue(){
							System.out.println("thread: " + Thread.currentThread() + " init pattern: " + pattern);
							return new SimpleDateFormat(pattern);
						}
					};
					sdfMap.put(pattern,tl);
				}
			}
		}
		return tl.get();
	}

	public static String format(Date date, String pattern){
		return getSdf(pattern).format(date);
	}

	public static Date parse(String dateStr,String pattern){
		try {
			return getSdf(pattern).parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
