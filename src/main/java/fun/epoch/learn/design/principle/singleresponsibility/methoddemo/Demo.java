package fun.epoch.learn.design.principle.singleresponsibility.methoddemo;

public class Demo {
    // 将该方法可能需要进行的修改转移到职责单一的方法中去
    public static void doSomething(boolean flag) {
        if (flag) {
            doSomething1();
        } else {
            doSomething2();
        }
    }

    // 职责单一
    public static void doSomething1() {
        System.out.println("do something 1...");
    }

    // 职责单一
    public static void doSomething2() {
        System.out.println("do something 2...");
    }

}
