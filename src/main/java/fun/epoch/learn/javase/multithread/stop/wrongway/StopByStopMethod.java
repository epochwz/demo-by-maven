package fun.epoch.learn.javase.multithread.stop.wrongway;

/**
 * 描述：停止线程的错误方式 -- 使用 stop 方法：导致线程运行一半突然停止，造成脏数据
 * <p>
 * 演示：模拟军队领取装备，以一个连队为单位，要么整个连队都领取，要么都不领取
 */
public class StopByStopMethod {

    public static void main(String[] args) throws InterruptedException {
        Thread receiveEquipment = new Thread(() -> {
            for (int i = 1; i < 5; i++) {
                System.out.println("连队 " + i + " 整队领取装备开始");
                for (int j = 0; j < 10; j++) {
                    try {
                        Thread.sleep(80);
                    } catch (InterruptedException e) {
                        // 确保发生中断异常时，仍然让当前正在领取装备的连队整队领取完毕
                        while (j < 10) {
                            System.out.println("连队 " + i + " 的第 " + j++ + " 个士兵已经成功领取装备");
                        }
                        System.out.println("连队 " + i + " 整队领取装备完毕");
                        return;
                    }
                    System.out.println("连队 " + i + " 的第 " + j + " 个士兵已经成功领取装备");
                }
                System.out.println("连队 " + i + " 整队领取装备完毕");
            }
        });
        receiveEquipment.start();
        Thread.sleep(2000);
        // 正在领取装备的连队必须继续完成整队领取，尚未开始领取装备的连队则不再开始领取
        System.out.println("战事告急，要求军队立即开赴前线");
        // receiveEquipment.interrupt(); // 停止线程的正确方式：通过请求中断让线程从容的完成整个连队的领取工作之后再结束
        receiveEquipment.stop();// 停止线程的错误方式：线程直接停止，无法确保完成整个连队的领取工作
    }
}
