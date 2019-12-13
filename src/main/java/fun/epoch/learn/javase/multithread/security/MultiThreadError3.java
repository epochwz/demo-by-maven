package fun.epoch.learn.javase.multithread.security;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：演示 线程安全问题 -- 对象逸出 -- 发布逸出
 */
public class MultiThreadError3 {
    private static class Dictionary {
        private Map<String, String> map = new HashMap<>();

        public Dictionary() {
            map.put("星期一", "Monday");
            map.put("星期二", "Tuesday");
            map.put("星期三", "Wednesday");
            map.put("星期四", "Thursday");
            map.put("星期五", "Friday");
            map.put("星期六", "Saturday");
            map.put("星期日", "Sunday");
        }

        // 发布 private 对象
        public Map<String, String> getAll() {
            return map;
        }
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        System.out.println(dictionary.getAll().get("星期一"));
        dictionary.getAll().remove("星期一");
        System.out.println(dictionary.getAll().get("星期一")); // null --> private 对象逸出，导致内容被外部程序随意篡改
    }
}
