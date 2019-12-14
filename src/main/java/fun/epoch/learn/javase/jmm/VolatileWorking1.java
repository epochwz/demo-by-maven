package fun.epoch.learn.javase.jmm;

/**
 * 描述：演示 volatile 适用的场景一 -- 纯赋值操作
 */
public class VolatileWorking1 {
    private static boolean flag = true;

    private static void setFlag() {
        flag = false;
    }

    public static final Runnable runnable = () -> {
        for (int i = 0; i < 10000; i++) {
            setFlag();
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(runnable);
        Thread B = new Thread(runnable);
        A.start();
        B.start();
        A.join();
        B.join();

        System.out.println(flag);
    }
}
