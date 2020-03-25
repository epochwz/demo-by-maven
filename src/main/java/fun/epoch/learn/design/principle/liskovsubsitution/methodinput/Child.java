package fun.epoch.learn.design.principle.liskovsubsitution.methodinput;

import java.util.HashMap;

public class Child extends Parent {
    public void method(HashMap<String, String> map) {
        System.out.println("子类方法被执行");
    }
}
