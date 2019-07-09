package com.zys.boot.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;


public class TestTimeTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("执行时间为"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println("我去吃饭了");
    }

}
