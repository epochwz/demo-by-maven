package fun.epoch.learn.javase.multithread.stop;

/**
 * 描述：演示处理中断异常的错误方式 -- 屏蔽异常：在低层次的方法中 “吞掉” 中断异常，从而导致上层调用者无法感知和处理中断异常
 */
public class BadWayToHandleInterruptedException {
    public static void main(String[] args) throws InterruptedException {
        Thread T = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("正在保存数据...");
                // 线程的 run 方法作为上层调用者，却无法感知该方法可能产生中断异常，也就无法在任务失败、取消时做相应的处理
                saveData();
            }
            System.out.println("成功保存数据...");
        });
        T.start();
        Thread.sleep(200);
        T.interrupt();

        // 执行结果如下：不仅无法在保存数据失败时停止线程，处理善后工作，而且异常日志也可能深深的隐藏在茫茫日志中
        // 正在保存数据...
        // 正在保存数据...
        // java.lang.InterruptedException: sleep interrupted
        // 正在保存数据...
        // 正在保存数据...
        // ......
        // 成功保存数据...
    }

    // 错误的中断异常处理方式：直接 “吞掉” 异常，从而导致上层调用者无法感知、处理中断异常
    private static void saveData() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
