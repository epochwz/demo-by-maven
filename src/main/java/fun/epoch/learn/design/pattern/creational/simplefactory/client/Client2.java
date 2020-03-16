package fun.epoch.learn.design.pattern.creational.simplefactory.client;

import fun.epoch.learn.design.pattern.creational.simplefactory.Video;
import fun.epoch.learn.design.pattern.creational.simplefactory.videos.JavaVideo;
import fun.epoch.learn.design.pattern.creational.simplefactory.videos.PythonVideo;

public class Client2 {
    public static void main(String[] args) {
        for (int day = 0; day < 4; day++) {
            Video video = null;
            if (day % 7 == 0) {
                video = new PythonVideo();
            }
            if (day % 7 == 1) {
                video = new JavaVideo();
            }
            if (video != null) {
                video.record();
            }
        }
    }
}
