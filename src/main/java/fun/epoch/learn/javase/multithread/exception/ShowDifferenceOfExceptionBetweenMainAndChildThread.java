package fun.epoch.learn.javase.multithread.exception;

/**
 * 描述：演示 在 主线程 和 子线程 中抛出未捕获异常的区别
 */
public class ShowDifferenceOfExceptionBetweenMainAndChildThread {
    public static void main(String[] args) {
        // showExceptionInMainThread(); // 可以轻易看到异常信息
        showExceptionInChildThread();   // 可能需要进行一番搜索
    }

    /**
     * 演示：运行程序，会发现当主线程发生未捕获的异常时，程序会立即终止并打印异常信息，因此可能很轻松的发现异常，查看日志
     */
    private static void showExceptionInMainThread() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
            if (i > 8000 + Math.random() * 2000) {
                throw new RuntimeException("主线程发生异常啦！！！");
            }
        }
    }

    /**
     * 演示：运行程序，会发现当子线程发生未捕获的异常时，程序 (主线程) 不会立即终止，因此子线程的异常信息可能被淹没，难以察觉
     */
    private static void showExceptionInChildThread() {
        new Thread(() -> {
            throw new RuntimeException("子线程发生异常啦！！！");
        }).start();
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }
    }
}
