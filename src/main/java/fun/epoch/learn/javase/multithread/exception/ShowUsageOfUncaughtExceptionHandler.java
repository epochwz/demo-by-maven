package fun.epoch.learn.javase.multithread.exception;

/**
 * 描述：演示 如何使用 未捕获异常处理器 (UncaughtExceptionHandler) 统一处理线程的未捕获异常
 */
public class ShowUsageOfUncaughtExceptionHandler {
    private static final Runnable runnable = () -> {
        throw new RuntimeException("我故意抛出了一个未捕获的异常，啦啦啦！！！");
    };

    public static void main(String[] args) {
        Thread A = new Thread(runnable, "A");
        Thread B = new Thread(runnable, "B");

        // 全局异常处理器：可以给所有线程统一设置未捕获异常处理器
        // 所有未设置异常处理器的线程所发生的未捕获异常最终都会被该处理器所捕获 (包括主线程)
        Thread.setDefaultUncaughtExceptionHandler(new CustomGlobalUncaughtExceptionHandler("全局异常处理器"));
        // 线程异常处理器：可以给每个线程单独设置未捕获异常处理器
        B.setUncaughtExceptionHandler(new CustomGlobalUncaughtExceptionHandler("B 线程异常处理器"));

        A.start();
        B.start();
        runnable.run();
        // 运行结果如下：
        // 全局异常处理器 捕获了线程 main 抛出的未捕获异常：我故意抛出了一个未捕获的异常，啦啦啦！！！
        // 全局异常处理器 捕获了线程 A 抛出的未捕获异常：我故意抛出了一个未捕获的异常，啦啦啦！！！
        // B 线程异常处理器 捕获了线程 B 抛出的未捕获异常：我故意抛出了一个未捕获的异常，啦啦啦！！！
    }

    /**
     * 自定义未捕获异常处理器
     */
    private static class CustomGlobalUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        private String name;

        public CustomGlobalUncaughtExceptionHandler(String name) {
            this.name = name;
        }

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(name + " 捕获了线程 " + t.getName() + " 抛出的未捕获异常：" + e.getMessage());
            // 保存日志
            // 告警通知
            // 等等善后处理工作
        }
    }
}
