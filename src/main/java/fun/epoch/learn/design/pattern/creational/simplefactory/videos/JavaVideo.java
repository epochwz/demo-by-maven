package fun.epoch.learn.design.pattern.creational.simplefactory.videos;

import fun.epoch.learn.design.pattern.creational.simplefactory.Video;

public class JavaVideo implements Video {
    @Override
    public void record() {
        System.out.println("录制 Java 视频...");
    }
}
