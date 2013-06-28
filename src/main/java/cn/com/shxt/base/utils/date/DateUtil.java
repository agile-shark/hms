package cn.com.shxt.base.utils.date;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateUtil {
	protected static Log logger = LogFactory.getLog(DateUtil.class);
	// 格式：年－月－日 小时：分钟：秒
	public static final String FORMAT_ONE = "yyyy-MM-dd HH:mm:ss";

	// 格式：年－月－日 小时：分钟
	public static final String FORMAT_TWO = "yyyy-MM-dd HH:mm";

	// 格式：年月日 小时分钟秒
	public static final String FORMAT_THREE = "yyyyMMdd-HHmmss";

	// 格式：年－月－日
	public static final String LONG_DATE_FORMAT = "yyyy-MM-dd";

	// 格式：月－日
	public static final String SHORT_DATE_FORMAT = "MM-dd";

	// 格式：小时：分钟：秒
	public static final String LONG_TIME_FORMAT = "HH:mm:ss";

	// 格式：年-月
	public static final String MONTG_DATE_FORMAT = "yyyy-MM";

	// 年的加减
	public static final int SUB_YEAR = Calendar.YEAR;

	// 月加减
	public static final int SUB_MONTH = Calendar.MONTH;

	// 天的加减
	public static final int SUB_DAY = Calendar.DATE;

	// 小时的加减
	public static final int SUB_HOUR = Calendar.HOUR;

	// 分钟的加减
	public static final int SUB_MINUTE = Calendar.MINUTE;

	// 秒的加减
	public static final int SUB_SECOND = Calendar.SECOND;

	static final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四",
			"星期五", "星期六" };

	@SuppressWarnings("unused")
	private static final SimpleDateFormat timeFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public DateUtil() {
	}

	/**
	 * 把符合日期格式的字符串转换为日期类型
	 */
	public static Date stringtoDate(String dateStr, String format) {
		Date d = null;
		SimpleDateFormat formater = new SimpleDateFormat(format);
		try {
			formater.setLenient(false);
			d = formater.parse(dateStr);
		} catch (Exception e) {
			d = null;
		}
		return d;
	}

	/**
	 * 把符合日期格式的字符串转换为日期类型
	 */
	public static java.util.Date stringtoDate(String dateStr, String format,
			ParsePosition pos) {
		Date d = null;
		SimpleDateFormat formater = new SimpleDateFormat(format);
		try {
			formater.setLenient(false);
			d = formater.parse(dateStr, pos);
		} catch (Exception e) {
			d = null;
		}
		return d;
	}

	/**
	 * 把日期转换为字符串
	 */
	public static String dateToString(java.util.Date date, String format) {
		String result = "";
		SimpleDateFormat formater = new SimpleDateFormat(format);
		try {
			result = formater.format(date);
		} catch (Exception e) {
			// log.error(e);
		}
		return result;
	}

	/**
	 * 获取当前时间的指定格式
	 */
	public static String getCurrDate(String format) {
		return dateToString(new Date(), format);
	}

	public static String dateSub(int dateKind, String dateStr, int amount) {
		Date date = stringtoDate(dateStr, FORMAT_ONE);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(dateKind, amount);
		return dateToString(calendar.getTime(), FORMAT_ONE);
	}

	/**
	 * 两个日期相减
	 * 
	 * @return 相减得到的秒数
	 */
	public static long timeSub(String firstTime, String secTime) {
		long first = stringtoDate(firstTime, FORMAT_ONE).getTime();
		long second = stringtoDate(secTime, FORMAT_ONE).getTime();
		return (second - first) / 1000;
	}

	/**
	 * 获得某月的天数
	 */
	public static int getDaysOfMonth(String year, String month) {
		int days = 0;
		if (month.equals("1") || month.equals("3") || month.equals("5")
				|| month.equals("7") || month.equals("8") || month.equals("10")
				|| month.equals("12")) {
			days = 31;
		} else if (month.equals("4") || month.equals("6") || month.equals("9")
				|| month.equals("11")) {
			days = 30;
		} else {
			if ((Integer.parseInt(year) % 4 == 0 && Integer.parseInt(year) % 100 != 0)
					|| Integer.parseInt(year) % 400 == 0) {
				days = 29;
			} else {
				days = 28;
			}
		}

		return days;
	}

	/**
	 * 获取某年某月的天数
	 */
	public static int getDaysOfMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获得当前日期
	 */
	public static int getToday() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.DATE);
	}

	/**
	 * 获得当前月份
	 */
	public static int getToMonth() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获得当前年份
	 */
	public static int getToYear() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 返回日期的天
	 */
	public static int getDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DATE);
	}

	/**
	 * 返回日期的年
	 */
	public static int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 返回日期的月份，1-12
	 */
	public static int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 计算两个日期相差的天数，如果date2 > date1 返回正数，否则返回负数
	 */
	public static long dayDiff(Date date1, Date date2) {
		return (date2.getTime() - date1.getTime()) / 86400000;
	}

	/**
	 * 比较两个日期的年差
	 */
	public static int yearDiff(String before, String after) {
		Date beforeDay = stringtoDate(before, LONG_DATE_FORMAT);
		Date afterDay = stringtoDate(after, LONG_DATE_FORMAT);
		return getYear(afterDay) - getYear(beforeDay);
	}

	/**
	 * 比较指定日期与当前日期的差
	 */
	public static int yearDiffCurr(String after) {
		Date beforeDay = new Date();
		Date afterDay = stringtoDate(after, LONG_DATE_FORMAT);
		return getYear(beforeDay) - getYear(afterDay);
	}

	/**
	 * 比较指定日期与当前日期的差
	 */
	public static long dayDiffCurr(String before) {
		Date currDate = DateUtil.stringtoDate(currDay(), LONG_DATE_FORMAT);
		Date beforeDate = stringtoDate(before, LONG_DATE_FORMAT);
		return (currDate.getTime() - beforeDate.getTime()) / 86400000;

	}

	/**
	 * 得到当前日期
	 * 
	 */
	public static String currDay() {
		return dateToString(new Date(), LONG_DATE_FORMAT);
	}

	/**
	 * 获取每月的第一周
	 */
	public static int getFirstWeekdayOfMonth(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.SATURDAY); // 星期天为第一天
		c.set(year, month - 1, 1);
		return c.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 获取每月的最后一周
	 */
	public static int getLastWeekdayOfMonth(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.SATURDAY); // 星期天为第一天
		c.set(year, month - 1, getDaysOfMonth(year, month));
		return c.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 获得当前日期字符串，格式"yyyy-MM-dd HH:mm:ss"
	 * 
	 * @return
	 */
	public static String getNow() {
		Calendar today = Calendar.getInstance();
		return dateToString(today.getTime(), FORMAT_ONE);
	}

	/**
	 * 把java.util.date 类型转换成java.sql.date
	 * 
	 * @param date
	 * @return
	 */
	public static java.sql.Timestamp getDate(java.util.Date date) {
		// java.sql.Date sqlDate = new java.sql.Date();
		java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
		return timestamp;
	}

	/**
	 * 判断日期是否有效,包括闰年的情况
	 * 
	 * @param date
	 *            YYYY-mm-dd
	 * @return
	 */
	public static boolean isDate(String date) {
		StringBuffer reg = new StringBuffer(
				"^((\\d{2}(([02468][048])|([13579][26]))-?((((0?");
		reg.append("[13578])|(1[02]))-?((0?[1-9])|([1-2][0-9])|(3[01])))");
		reg.append("|(((0?[469])|(11))-?((0?[1-9])|([1-2][0-9])|(30)))|");
		reg.append("(0?2-?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][12");
		reg.append("35679])|([13579][01345789]))-?((((0?[13578])|(1[02]))");
		reg.append("-?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))");
		reg.append("-?((0?[1-9])|([1-2][0-9])|(30)))|(0?2-?((0?[");
		reg.append("1-9])|(1[0-9])|(2[0-8]))))))");
		Pattern p = Pattern.compile(reg.toString());
		return p.matcher(date).matches();
	}

	/**
	 * 取得某天相加(减)後的那一天
	 * 
	 * @param date
	 * @param num
	 *            (可正可负)
	 * @return
	 */
	public static Date getAnotherDate(Date date, int num) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_YEAR, num);
		return c.getTime();
	}

	/** */
	/**
	 * 取得某月的的最后一天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getLastDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);// 年
		cal.set(Calendar.MONTH, month - 1);// 月，因为Calendar里的月是从0开始，所以要减1
		cal.set(Calendar.DATE, 1);// 日，设为一号
		cal.add(Calendar.MONTH, 1);// 月份加一，得到下个月的一号
		cal.add(Calendar.DATE, -1);// 下一个月减一为本月最后一天
		return cal.getTime();// 获得月末是几号
	}

	/** */
	/**
	 * 取得某天是一年中的多少周
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeekOfYear(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setMinimalDaysInFirstWeek(7);
		c.setTime(date);
		return c.get(Calendar.WEEK_OF_YEAR);
	}

	/** */
	/**
	 * 取得某天所在周的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
		return c.getTime();
	}

	/** */
	/**
	 * 取得某天所在周的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6);
		return c.getTime();
	}

	/** */
	/**
	 * 取得某一年共有多少周
	 * 
	 * @param year
	 * @return
	 */
	public static int getMaxWeekNumOfYear(int year) {
		Calendar c = new GregorianCalendar();
		c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
		return getWeekOfYear(c.getTime());
	}

	/**
	 * 
	 * 获取某一年某一周的日期
	 * 
	 * @description
	 * @param year
	 * @param week
	 * @return
	 */
	public static List<String> getWeekDays(int year, int week) {
		List<String> list = new ArrayList<String>();

		Date date = getFirstDayOfWeek(year, week);
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");

		for (int i = 0; i < 7; i++) {
			list.add(d.format(date));
			System.out.println(d.format(date));

			date.setDate(date.getDate() + 1);
		}
		return list;
	}

	/** */
	/**
	 * 取得某年某周的第一天 对于交叉:2008-12-29到2009-01-04属于2008年的最后一周,2009-01-05为2009年第一周的第一天
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date getFirstDayOfWeek(int year, int week) {
		Calendar calFirst = Calendar.getInstance();
		calFirst.set(year, 0, 7);
		Date firstDate = getFirstDayOfWeek(calFirst.getTime());

		Calendar firstDateCal = Calendar.getInstance();
		firstDateCal.setTime(firstDate);

		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, firstDateCal.get(Calendar.DATE));

		Calendar cal = (GregorianCalendar) c.clone();
		cal.add(Calendar.DATE, (week - 1) * 7);
		firstDate = getFirstDayOfWeek(cal.getTime());

		return firstDate;
	}

	/** */
	/**
	 * 取得某年某周的最后一天 对于交叉:2008-12-29到2009-01-04属于2008年的最后一周, 2009-01-04为
	 * 2008年最后一周的最后一天
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date getLastDayOfWeek(int year, int week) {
		Calendar calLast = Calendar.getInstance();
		calLast.set(year, 0, 7);
		Date firstDate = getLastDayOfWeek(calLast.getTime());

		Calendar firstDateCal = Calendar.getInstance();
		firstDateCal.setTime(firstDate);

		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, firstDateCal.get(Calendar.DATE));

		Calendar cal = (GregorianCalendar) c.clone();
		cal.add(Calendar.DATE, (week - 1) * 7);
		Date lastDate = getLastDayOfWeek(cal.getTime());

		return lastDate;
	}

	/**
	 * 获取当前日期的年、月、日
	 */
	public void display() {
		Calendar cal = Calendar.getInstance();
		// 年
		int year = cal.get(cal.YEAR);
		// 月
		int month = cal.get(cal.MONTH) + 1;
		// 日
		int date = cal.get(cal.DATE);
		// 星期
		int today = cal.get(cal.DAY_OF_WEEK) - 1;
	}

	
	/**
	 * 日期转化为大小写
	 * @param date
	 * @return
	 */
	public static String dataToUpper(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		int year = ca.get(Calendar.YEAR);
		int month = ca.get(Calendar.MONTH) + 1;
		int day = ca.get(Calendar.DAY_OF_MONTH);
		return numToUpper(year) + "年" + monthToUppder(month) + "月"
				+ dayToUppder(day) + "日";
	}

	/***
	 * <b>function:</b> 将数字转化为大写
	 * 
	 * @createDate 2012
	 * @param num
	 *            数字
	 * @return 转换后的大写数字
	 */

	public static String numToUpper(int num) {
		// String u[] = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
		String u[] = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
		// String u[] = {"○", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
		char[] str = String.valueOf(num).toCharArray();
		String rstr = "";
		for (int i = 0; i < str.length; i++) {
			rstr = rstr + u[Integer.parseInt(str[i] + "")];
		}
		return rstr;
	}

	/***
	 * <b>function:</b> 月转化为大写
	 * 
	 * @createDate 2012- * @param month 月份
	 * @return 返回转换后大写月份
	 */
	public static String monthToUppder(int month) {
		if (month < 10) {
			return numToUpper(month);
		} else if (month == 10) {
			return "十";
		} else {
			return "十" + numToUpper(month - 10);
		}
	}

	/***
	 * <b>function:</b> 日转化为大写
	 * 
	 * @createDate 2012-9-18 上午8:43:32
	 * @param day
	 *            日期
	 * @return 转换大写的日期格式
	 */
	public static String dayToUppder(int day) {
		if (day < 20) {
			return monthToUppder(day);
		} else {
			char[] str = String.valueOf(day).toCharArray();
			if (str[1] == '0') {
				return numToUpper(Integer.parseInt(str[0] + "")) + "十";
			} else {
				return numToUpper(Integer.parseInt(str[0] + "")) + "十"
						+ numToUpper(Integer.parseInt(str[1] + ""));
			}
		}
	}
	public static void main(String args[]) {

		List<String> listWeekDate = DateUtil.getWeekDays(2010, 52);

		for (String weeks : listWeekDate) {
			System.out.println("weeks:" + weeks);
		}
		
		System.out.println(DateUtil.dataToUpper(new Date()));  
	}
}
