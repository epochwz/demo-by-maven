package fun.epoch.learn.design.pattern.creational.abstractfactory.videos;

public class PythonVideo implements Video {
    @Override
    public void record() {
        System.out.println("录制 Python 视频...");
    }
}
