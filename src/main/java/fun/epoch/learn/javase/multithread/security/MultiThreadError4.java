package fun.epoch.learn.javase.multithread.security;

/**
 * 描述：演示 线程安全问题 -- 对象逸出 -- 初始化逸出
 * <p>
 * 对象初始化未完成就进行 this 赋值
 */
public class MultiThreadError4 {
    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) throws InterruptedException {
            this.x = x;
            PointMaker.point = this;
            Thread.sleep(50);
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private static class PointMaker extends Thread {
        private static Point point;

        @Override
        public void run() {
            try {
                point = new Point(1, 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new PointMaker().start();
        Thread.sleep(10);
        System.out.println(PointMaker.point); // 1,0
        Thread.sleep(100);
        System.out.println(PointMaker.point); // 1,1
        // 对象未完成初始化就进行 this 赋值，导致对象逸出，从而导致在不同时间点获取到的对象状态不一致
    }
}
