package fun.epoch.learn.design.pattern.creational.singleton.broken;

import fun.epoch.learn.design.pattern.creational.singleton.HungrySingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 破坏单例模式：反射调用
 */
public class BreakByReflection {
    public static void main(String[] args) {
        HungrySingleton instance = HungrySingleton.getInstance();

        HungrySingleton newInstance = invokeSingleton();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);
    }

    public static HungrySingleton invokeSingleton() {
        try {
            Constructor<HungrySingleton> constructor = HungrySingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
