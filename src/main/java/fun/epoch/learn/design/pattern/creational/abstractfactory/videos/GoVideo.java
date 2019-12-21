package fun.epoch.learn.design.pattern.creational.abstractfactory.videos;

public class GoVideo implements Video {
    @Override
    public void record() {
        System.out.println("录制 Go 视频...");
    }
}
