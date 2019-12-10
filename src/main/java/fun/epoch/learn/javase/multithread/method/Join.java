package fun.epoch.learn.javase.multithread.method;

/**
 * 描述：演示 join 的基本用法
 * <p>
 * 演示：尝试使用和不使用 join 两种情况, 观察两种情况下输出语句的顺序
 */
public class Join {
    private static Runnable runnable = () -> {
        try {
            System.out.println(Thread.currentThread().getName() + " 初始化开始...");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " 初始化完毕...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(runnable, "线程 A");
        Thread B = new Thread(runnable, "线程 B");
        A.start();
        B.start();
        // 将线程 A & B 加入到主线程中
        A.join();
        B.join();
        // 主线程必须等待线程 A & B 执行完毕，才能接着执行
        System.out.println("子线程 A & B 执行完毕，主线程 main 开始执行...");
    }
}
