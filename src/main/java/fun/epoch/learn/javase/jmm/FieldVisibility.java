package fun.epoch.learn.javase.jmm;

/**
 * 描述：演示 可见性 问题
 */
public class FieldVisibility {
    private int x = 1;
    private int y = 2;

    private void change() {
        x = 3;
        y = x;
    }

    // 当 x=1,y=3 时，证明出现了可见性问题
    private boolean output() {
        if (x == 1 && y == 3) {
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
