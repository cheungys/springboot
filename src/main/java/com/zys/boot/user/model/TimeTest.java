package com.zys.boot.user.model;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;



public class TimeTest {
    Timer timer;

    public TimeTest() {
        Date time = getTIme();
        System.out.println("开始执行");

        timer = new Timer();
        timer.schedule(new TestTimeTask(), time);
    }

    public Date getTIme() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 36);
        calendar.set(Calendar.SECOND, 00);
        Date time = calendar.getTime();
        return time;
    }

    public static void main(String args[]) {
        System.out.println("...........开始执行。。。。。。。。。。。。。");
        new TimeTest();
    }
}
