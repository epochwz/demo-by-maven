package fun.epoch.learn.design.pattern.creational.singleton.broken;

import fun.epoch.learn.design.pattern.creational.singleton.HungrySingleton;

/**
 * 破坏单例模式：克隆调用
 */
public class BreakByClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton cloneInstance = (HungrySingleton) instance.clone();

        System.out.println(instance);
        System.out.println(cloneInstance);
        System.out.println(instance == cloneInstance);
    }
}
