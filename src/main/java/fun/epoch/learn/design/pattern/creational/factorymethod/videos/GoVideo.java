package fun.epoch.learn.design.pattern.creational.factorymethod.videos;

import fun.epoch.learn.design.pattern.creational.factorymethod.Video;

public class GoVideo implements Video {
    @Override
    public void record() {
        System.out.println("录制 Go 视频...");
    }
}
