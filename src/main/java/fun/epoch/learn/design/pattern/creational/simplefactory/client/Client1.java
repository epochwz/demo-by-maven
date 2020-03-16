package fun.epoch.learn.design.pattern.creational.simplefactory.client;

import fun.epoch.learn.design.pattern.creational.simplefactory.Video;
import fun.epoch.learn.design.pattern.creational.simplefactory.videos.JavaVideo;
import fun.epoch.learn.design.pattern.creational.simplefactory.videos.PythonVideo;

public class Client1 {
    public static void main(String[] args) {
        for (int day = 0; day < 3; day++) {
            Video video = null;
            if (day % 7 == 0) {
                video = new JavaVideo();
            }
            if (day % 7 == 1) {
                video = new PythonVideo();
            }
            if (video != null) {
                video.record();
            }
        }
    }
}
