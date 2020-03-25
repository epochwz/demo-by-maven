package fun.epoch.learn.design.principle.liskovsubsitution.methodinput;

import java.util.HashMap;

public class Parent {
    public void method(HashMap<String, String> map) {
        System.out.println("父类方法被执行");
    }
}
