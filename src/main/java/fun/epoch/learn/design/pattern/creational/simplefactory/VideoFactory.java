package fun.epoch.learn.design.pattern.creational.simplefactory;

import fun.epoch.learn.design.pattern.creational.simplefactory.videos.JavaVideo;
import fun.epoch.learn.design.pattern.creational.simplefactory.videos.PythonVideo;

public class VideoFactory {
    public static Video getVideo(int day) {
        switch (day % 7) {
            case 0:
                return new PythonVideo();
            case 1:
                return new JavaVideo();
            default:
                return null;
        }
    }
}
