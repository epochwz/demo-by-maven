package fun.epoch.learn.design.pattern.creational.factorymethod.videos;

import fun.epoch.learn.design.pattern.creational.factorymethod.Video;

public class PythonVideo implements Video {
    @Override
    public void record() {
        System.out.println("录制 Python 视频...");
    }
}
