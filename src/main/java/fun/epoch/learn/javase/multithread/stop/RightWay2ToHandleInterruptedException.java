package fun.epoch.learn.javase.multithread.stop;

/**
 * 描述：演示处理中断异常的正确方式
 * <p>
 * 恢复中断：在低层次的方法中捕获中断异常后恢复中断标记，使得上层调用者依然可以检查到线程的中断状态
 */
public class RightWay2ToHandleInterruptedException {
    public static void main(String[] args) throws InterruptedException {
        Thread T = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("正在保存数据...");
                saveData();
                // 低层次方法恢复线程中断状态后，上层调用者便能够正确检查线程的中断状态，然后作出相应的处理
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("取消保存数据...");
                    System.out.println("正在保存日志...");
                    System.out.println("生成邮件通知...");
                    System.out.println("线程正确停止");
                    return;
                }
            }
            System.out.println("成功保存数据...");
        });
        T.start();
        Thread.sleep(2000);
        T.interrupt();

        // 执行结果如下：
        // 正在保存数据...
        // 正在保存数据...
        // 正在保存数据...
        // java.lang.InterruptedException: sleep interrupted
        // 取消保存数据...
        // 正在保存日志...
        // 生成邮件通知...
        // 正确停止线程
    }

    // 在低层次的方法中捕获中断异常后恢复中断标记，使得上层调用者依然可以检查到线程的中断状态
    private static void saveData() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt(); // 恢复线程中断状态标记
        }
    }
}
