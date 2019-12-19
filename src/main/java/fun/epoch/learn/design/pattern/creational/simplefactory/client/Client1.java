package fun.epoch.learn.design.pattern.creational.simplefactory.client;

import fun.epoch.learn.design.pattern.creational.simplefactory.Video;
import fun.epoch.learn.design.pattern.creational.simplefactory.VideoFactory;

public class Client1 {
    public static void main(String[] args) {
        for (int day = 0; day < 3; day++) {
            Video video = VideoFactory.getVideo(day);
            if (video != null) {
                video.record();
            }
        }
    }
}
