package fun.epoch.learn.javase.multithread.exception;

/**
 * 描述：证明 无法使用传统方式 (try/catch) 在主线程中捕获子线程中的异常
 * <p>
 * 1. 不加 try/catch, 预期抛出 4 个异常
 * 2. 加了 try/catch, 预期捕获到第一个线程的异常并打印出 “捕获到子线程抛出的异常”，剩下的线程不应该再运行
 * <p>
 * 结果执行时发现并不会打印出 “捕获到子线程抛出的异常”，而且其余线程也都照常执行
 * 证明 无法使用传统方式 (try/catch) 在主线程中捕获子线程中的异常
 * <p>
 * 3. 手动在每个子线程中捕获并处理异常 (麻烦，不推荐)
 * 4. 使用 UncaughtExceptionHandler 给程序统一设置线程异常处理器
 */
public class ShowExceptionInChildThreadCantCatchDirectly {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> System.out.println("线程全局异常处理器 捕获到了子线程抛出的异常：" + e.getMessage()));

        new Thread(runnable, "A").start();
        new Thread(runnable, "B").start();
        new Thread(runnable, "C").start();
        new Thread(runnable, "D").start();
    }

    private static final Runnable runnable = () -> {
        throw new RuntimeException("线程 " + Thread.currentThread().getName() + " 抛出了异常");
    };
}
