package cn.mikeal.utils;

import cn.mikeal.constants.TimeEnum;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间日期工具类
 *
 * @author Michael Hu <13035144322@163.com>
 * @version 1.0.0
 */
public class DateUtils {
    public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat MINUTE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd_HHmm");
    public static final SimpleDateFormat DATEKEY_FORMAT = new SimpleDateFormat("yyyyMMdd");

    /**
     * 字符串转时间
     *
     * @param timeStr
     * @return
     */
    public static Date str2Date(String timeStr, TimeEnum timeEnum) {
        try {
            switch (timeEnum) {
                case DATE_FORMAT_ENUM:
                    return DATE_FORMAT.parse(timeStr);
                case TIME_FORMAT_ENUM:
                    return TIME_FORMAT.parse(timeStr);
                case MINUTE_TIME_FORMAT_ENUM:
                    return MINUTE_TIME_FORMAT.parse(timeStr);
                default:
                    return new Date();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Date();
    }

    /**
     * 判断一个时间是否在另一个时间之前
     *
     * @param time1
     * @param time2
     * @return
     */
    public static boolean isBefore(String time1, String time2) {
        Date dateTime1 = str2Date(time1, TimeEnum.DATE_FORMAT_ENUM);
        Date dateTime2 = str2Date(time2, TimeEnum.DATE_FORMAT_ENUM);
        if (dateTime1.before(dateTime2)) {
            return true;
        } else {
            return false;
        }
    }
}
