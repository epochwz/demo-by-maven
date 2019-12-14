package fun.epoch.learn.javase.jmm;

/**
 * 描述：演示 可见性 问题
 */
public class FieldVisibility {
    private int x = 1;
    private volatile int y = 2;

    private void change() {
        x = 3;
        y = x;
    }

    // 当 x=1,y=3 时，证明出现了可见性问题
    private boolean output() {
        // volatile 变量 y 可以作为轻量级的内存同步触发器
        // 1. 程序在读取 y 之前会将对 y 进行的赋值操作及其之前的所有操作 (对 x 进行赋值) 的结果同步回主内存
        // 2. 因此当该线程看见 y=x=3 时，必然也能看见 x=3 这个操作
        // 因此此处的判断条件永远不可能成功，也就是不存在可见性问题了
        if (y == 3 && x == 1) {
            System.out.println(String.format("出现了可见性问题：(%s,%s)", x, y));
            return false;
        }
        return true;
    }

    private static boolean noVisibilityIssues = true;

    public static void main(String[] args) throws InterruptedException {
        while (noVisibilityIssues) {
            FieldVisibility instance = new FieldVisibility();
            Thread A = new Thread(instance::change);
            Thread B = new Thread(() -> noVisibilityIssues = instance.output());
            A.start();
            B.start();
            A.join();
            B.join();
        }
    }
}
