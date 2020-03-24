package fun.epoch.learn.design.principle.singleresponsibility.methoddemo;

public class Demo {
    // 该方法职责不单一，需要经常修改，且容易引入风险
    public static void doSomething(boolean flag) {
        if (flag) {
            System.out.println("do something 1...");
        } else {
            System.out.println("do something 2...");
        }
    }
}
