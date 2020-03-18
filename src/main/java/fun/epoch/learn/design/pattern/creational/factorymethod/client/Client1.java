package fun.epoch.learn.design.pattern.creational.factorymethod.client;

import fun.epoch.learn.design.pattern.creational.factorymethod.Video;
import fun.epoch.learn.design.pattern.creational.factorymethod.VideoFactory;
import fun.epoch.learn.design.pattern.creational.factorymethod.factory.JavaVideoFactory;
import fun.epoch.learn.design.pattern.creational.factorymethod.factory.PythonVideoFactory;

public class Client1 {
    public static void main(String[] args) {
        for (int day = 0; day < 3; day++) {
            VideoFactory videoFactory = null;
            if (day % 7 == 0) {
                videoFactory = new JavaVideoFactory();
            }
            if (day % 7 == 1) {
                videoFactory = new PythonVideoFactory();
            }
            if (videoFactory == null) continue;
            Video video = videoFactory.getVideo();
            if (video != null) {
                video.record();
            }
        }
    }
}
