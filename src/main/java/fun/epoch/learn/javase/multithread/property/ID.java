package fun.epoch.learn.javase.multithread.property;

/**
 * 描述：演示线程的 ID 属性
 * <p>
 * 1. 新建线程的 id 从 1 开始，不断自增 (因此主线程的 id 是 1)
 * 2. 新建线程的 id 通常已经不是 2 了 (因为在此之前 JVM 已经自动创建了其他线程)
 */
public class ID {
    public static void main(String[] args) {
        System.out.println("子线程的 id=" + new Thread().getId());              // 11
        System.out.println("主线程的 id=" + Thread.currentThread().getId());    // 1
    }
}
