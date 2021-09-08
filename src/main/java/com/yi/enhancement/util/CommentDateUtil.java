package com.yi.enhancement.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: lyric
 * @date: 2021/8/13 14:34
 * @description: 时间工具类
 */
public class CommentDateUtil {

    public static final Long MINUTE = 1000 * 60L;
    public static final Long HOUR = 1000 * 60 * 60L;
    public static final Long DAY = 1000 * 60 * 60 * 24L;
    public static final Long WEEK = 1000 * 60 * 60 * 24 * 7L;
    public static final Long MONTH = 1000 * 60 * 60 * 24 * 30L;

    /**
     * 个性化评论时间
     *
     * @param currentTimeMillis 当前时间的毫秒数
     * @param date              评论的时间
     * @return 个性化的评论时间
     */
    public static String formatCommentDate(long currentTimeMillis, Date date) {
        // 评论的时间
        long commentTime = date.getTime();
        // 时间差(毫秒,+1000是因为可能时间稍有偏差)
        Long timeDifference = currentTimeMillis+1000 - commentTime;
        if (timeDifference < 0) {
            // 超过当前时间,直接return
            return date.toString();
        }
        //计算时间差的分，时，天，周，月
        long minC = timeDifference / MINUTE;
        long hourC = timeDifference / HOUR;
        long dayC = timeDifference / DAY;
        long weekC = timeDifference / WEEK;
        long monthC = timeDifference / MONTH;

        String strDateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        String result = sdf.format(date);

        if (monthC >= 1 && monthC <= 3) {
            result = (int) monthC + " month ago";
        } else if (weekC >= 1 && weekC <= 3) {
            result = (int) weekC + " week ago";
        } else if (dayC >= 1 && dayC <= 6) {
            result = (int) dayC + " days ago";
        } else if (hourC >= 1 && hourC <= 23) {
            result = (int) hourC + " hour ago";
        } else if (minC >= 1 && minC <= 59) {
            result = (int) minC + " minute ago";
        } else if (timeDifference <= MINUTE) {
            result = "Just now";
        } else {
            // 时间太久
            return result;
        }
        return result;
    }

}
