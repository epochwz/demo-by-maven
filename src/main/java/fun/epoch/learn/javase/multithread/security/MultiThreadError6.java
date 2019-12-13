package fun.epoch.learn.javase.multithread.security;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：演示 线程安全问题 -- 对象逸出 -- 初始化逸出
 * <p>
 * 在构造器中启动新线程
 */
public class MultiThreadError6 {
    private static class Configurations {
        private Map<String, String> configurations;

        public Configurations() {
            new Thread(() -> {
                // 模拟耗时的初始化工作
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 初始化系统配置
                configurations = new HashMap<>();
            }).start();
        }

        public Map<String, String> getAll() {
            return configurations;
        }
    }

    public static void main(String[] args) {
        Configurations configurations = new Configurations();
        configurations.getAll().get("ip"); // 空指针异常
    }
}
