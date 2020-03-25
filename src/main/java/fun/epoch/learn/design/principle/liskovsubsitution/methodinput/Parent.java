package fun.epoch.learn.design.principle.liskovsubsitution.methodinput;

import java.util.Map;

public class Parent {
    public void method(Map<String, String> map) {
        System.out.println("父类方法被执行");
    }
}
