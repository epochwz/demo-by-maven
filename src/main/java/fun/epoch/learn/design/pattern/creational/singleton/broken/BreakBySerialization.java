package fun.epoch.learn.design.pattern.creational.singleton.broken;

import fun.epoch.learn.design.pattern.creational.singleton.HungrySingleton;

import java.io.*;

/**
 * 破坏单例模式：反序列化
 */
public class BreakBySerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HungrySingleton instance = HungrySingleton.getInstance();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton"));
        oos.writeObject(instance);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton"));
        HungrySingleton newInstance = (HungrySingleton) ois.readObject();
        
        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);
    }
}
