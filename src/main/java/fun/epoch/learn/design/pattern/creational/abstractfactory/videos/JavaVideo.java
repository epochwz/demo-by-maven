package fun.epoch.learn.design.pattern.creational.abstractfactory.videos;

public class JavaVideo implements Video {
    @Override
    public void record() {
        System.out.println("录制 Java 视频...");
    }
}
