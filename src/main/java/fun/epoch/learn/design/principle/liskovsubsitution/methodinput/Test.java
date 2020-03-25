package fun.epoch.learn.design.principle.liskovsubsitution.methodinput;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        // 父类方法被执行：符合里氏替换原则，子类的方法入参比父类更宽松
        // 子类方法被执行：违背里氏替换原则，子类的方法入参比父类更严格
        new Child().method(new HashMap<>());
    }
}
