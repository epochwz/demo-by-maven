package fun.epoch.learn.design.pattern.creational.simplefactory.client;

import fun.epoch.learn.design.pattern.creational.simplefactory.Video;
import fun.epoch.learn.design.pattern.creational.simplefactory.videos.JavaVideo;
import fun.epoch.learn.design.pattern.creational.simplefactory.videos.PythonVideo;

/**
 * 需求描述：一星期中的每一天都需要录制不同的视频
 * <p>
 * 简单实现：直接在应用层中根据条件创建不同视频类的对象，将导致应用层多处代码直接依赖具体的实现类
 */
public class Client {
    public static void main(String[] args) {
        for (int day = 0; day < 7; day++) {
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
