package fun.epoch.learn.javase.multithread.stop;

/**
 * 描述：演示处理中断异常的正确方式 -- 传递异常：在低层次的方法中直接 “抛出” 中断异常，交由 (迫使) 上层调用者自行处理
 */
public class RightWayToHandleInterruptedException {
    public static void main(String[] args) throws InterruptedException {
        Thread T = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("正在保存数据...");
                // 低层次方法抛出异常后，上层调用者便能够正确感知并捕获中断异常，然后作出相应的处理
                try {// 由于 run 方法已经是线程的顶级方法，所以无法再向上抛出异常了，只能正确处理该异常
                    methodWouldBeInterrupted();
                } catch (InterruptedException e) {
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
        // 取消保存数据...
        // 正在保存日志...
        // 生成邮件通知...
        // 线程正确停止
    }

    // 直接向上 “抛出” 中断异常，交由 (迫使) 上层调用者自行处理
    private static void methodWouldBeInterrupted() throws InterruptedException {
        Thread.sleep(1000);
    }
}
