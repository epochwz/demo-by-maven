package fun.epoch.learn.design.pattern.creational.singleton.broken;

import fun.epoch.learn.design.pattern.creational.singleton.HungrySingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.security.AccessController;
import java.security.PrivilegedAction;

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

            // 反射获取单例类唯一实例 (private static final)
            Field singletonInstance = HungrySingleton.class.getDeclaredField("instance");
            // 反射打开 private 权限
            singletonInstance.setAccessible(true);
            // 反射打开 final 权限
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            AccessController.doPrivileged((PrivilegedAction<Object>) () -> {
                modifiersField.setAccessible(true);
                return null;
            });
            modifiersField.setInt(singletonInstance, singletonInstance.getModifiers() & ~Modifier.FINAL);
            // 反射绕开单例类构造器中的防御逻辑
            singletonInstance.set(singletonInstance, null);
            // 反射创建单例类新的实例
            HungrySingleton newInstance = constructor.newInstance();
            // 重新给单例类唯一实例 instance 赋值
            singletonInstance.set(singletonInstance, newInstance);

            return newInstance;
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}
