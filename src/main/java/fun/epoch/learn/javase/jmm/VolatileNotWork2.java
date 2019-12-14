package fun.epoch.learn.javase.jmm;

/**
 * 描述：演示 volatile 不适用的场景：操作依赖于共享变量先前的状态
 */
public class VolatileNotWork2 {
    private static volatile boolean flag = true;

    // 操作依赖于共享变量先前的状态，volatile 不能保证其原子性
    private static void setFlag() {
        flag = !flag;
    }

    private static final Runnable runnable = () -> {
        for (int i = 0; i < 10000; i++) {
            setFlag();
        }
    };

    public static void main(String[] args) throws InterruptedException {
        while (flag) {
            Thread A = new Thread(runnable);
            Thread B = new Thread(runnable);
            A.start();
            B.start();
            A.join();
            B.join();
            System.out.println("预期执行结果：" + true);
            System.out.println("实际执行结果：" + flag);
        }
    }
}
