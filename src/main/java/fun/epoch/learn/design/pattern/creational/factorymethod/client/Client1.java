package fun.epoch.learn.design.pattern.creational.factorymethod.client;

import fun.epoch.learn.design.pattern.creational.factorymethod.Video;
import fun.epoch.learn.design.pattern.creational.factorymethod.VideoFactory;

public class Client1 {
    public static void main(String[] args) {
        for (int day = 0; day < 3; day++) {
            VideoFactory videoFactory = VideoFactory.getVideoFactory(day);
            if (videoFactory == null) continue;
            Video video = videoFactory.getVideo();
            if (video != null) {
                video.record();
            }
        }
    }
}
