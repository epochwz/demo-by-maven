package fun.epoch.learn.design.pattern.creational.singleton.related;

import java.util.HashMap;
import java.util.Map;

/**
 * 容器单例：适合在应用程序启动时就将多个单例类初始化并放入容器进行统一管理
 */
public class ContainerSingleton {
    private static final Map<String, Object> instances = new HashMap<>();

    // 此处存在线程安全问题：不同线程可能重复放入相同 key 的不同对象
    public static void putInstance(String key, Object instance) {
        if (isNotBlank(key) && instance != null) {
            if (!instances.containsKey(key)) {
                instances.put(key, instance);
            }
        }
    }

    public static Object getInstance(String key) {
        return instances.get(key);
    }

    private static boolean isNotBlank(String str) {
        return str != null && str.replaceAll("\\s", "").length() > 0;
    }

    public static void main(String[] args) {
        Runnable runnable = () -> {
            ContainerSingleton.putInstance("key", new Object());
            System.out.println(ContainerSingleton.getInstance("key"));
        };
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
