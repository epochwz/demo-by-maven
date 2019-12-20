package fun.epoch.learn.design.pattern.creational.factorymethod.client;

import fun.epoch.learn.design.pattern.creational.factorymethod.Video;
import fun.epoch.learn.design.pattern.creational.factorymethod.VideoFactory;

public class Client2 {
    public static void main(String[] args) {
        for (int day = 0; day < 4; day++) {
            Video video = VideoFactory.getVideo(day);
            if (video != null) {
                video.record();
            }
        }
    }
}
