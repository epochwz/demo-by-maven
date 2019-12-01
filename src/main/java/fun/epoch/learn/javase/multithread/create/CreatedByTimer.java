package fun.epoch.learn.javase.multithread.create;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 描述：演示使用定时器创建线程
 */
public class CreatedByTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }, 1000, 1000);
    }
}
