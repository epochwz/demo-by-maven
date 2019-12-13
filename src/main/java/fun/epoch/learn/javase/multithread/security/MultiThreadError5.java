package fun.epoch.learn.javase.multithread.security;

/**
 * 描述：演示 线程安全问题 -- 对象逸出 -- 初始化逸出
 * <p>
 * 在构造器中注册监听器
 */
public class MultiThreadError5 {
    int counter;

    public MultiThreadError5(Source source) {
        // 监听器是一个匿名内部类，因此总是持有外部类实例的引用，从而间接的导致外部类实例的逸出 (对象尚未初始化完成就使用其属性)
        //
        // 注册监听器
        source.registerListener((e) -> System.out.println("我得到的数值是：" + counter));
        // 初始化其他
        sleep(50);
        // 初始化数值
        counter = 100;
    }

    public static void main(String[] args) {
        Source source = new Source();
        new Thread(() -> {
            sleep(10);
            source.eventCome(new Event() {
            });
        }).start();
        new Thread(() -> {
            sleep(100);
            source.eventCome(new Event() {
            });
        }).start();
        new MultiThreadError5(source);
        // 执行结果如下：
        // 我得到的数值是：0
        // 我得到的数值是：100
    }

    private static class Source {
        private EventListener listener;

        void registerListener(EventListener listener) {
            this.listener = listener;
        }

        void eventCome(Event event) {
            if (listener != null) {
                listener.onEvent(event);
            } else {
                System.out.println("尚未初始化完毕！");
            }
        }
    }

    private interface EventListener {
        void onEvent(Event event);
    }

    private interface Event {

    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
