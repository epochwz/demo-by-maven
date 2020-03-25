package fun.epoch.learn.design.principle.liskovsubsitution.methodinput;

import java.util.Map;

public class Child extends Parent {
    public void method(Map<String, String> map) {
        System.out.println("子类方法被执行");
    }
}
