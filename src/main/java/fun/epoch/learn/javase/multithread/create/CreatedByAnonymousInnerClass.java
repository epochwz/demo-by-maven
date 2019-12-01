package fun.epoch.learn.javase.multithread.create;

/**
 * 描述：演示使用匿名内部类 (Lambda) 创建线程
 */
public class CreatedByAnonymousInnerClass {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println("使用匿名内部类创建线程：继承 Thread 类");
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("使用匿名内部类创建线程：实现 Runnable 接口");
            }
        }).start();

        new Thread(() -> System.out.println("使用匿名内部类创建线程：实现 Runnable 接口 -- 使用 Lambda 表达式简化")).start();
    }
}
