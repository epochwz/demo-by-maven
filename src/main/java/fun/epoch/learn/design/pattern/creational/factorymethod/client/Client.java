package fun.epoch.learn.design.pattern.creational.factorymethod.client;

import fun.epoch.learn.design.pattern.creational.factorymethod.Video;
import fun.epoch.learn.design.pattern.creational.factorymethod.VideoFactory;

/**
 * 描述：一星期中的每一天都需要录制不同的视频
 * <p>
 * 实现一：直接在应用层中根据条件创建不同视频类的对象，导致应用层多处代码直接依赖具体的实现类
 * 需求变更：需要交换 Java & Python 视频的录制条件 -- 由于多处应用层代码直接依赖于具体的实现类，因此全部都需要改动
 * 实现二：将 “根据条件创建不同视频类的对象” 的逻辑转移到工厂类，使得所有应用层代码只需要依赖于同一个工厂类即可
 * 需求变更：需要交换 Java & Python 视频的录制条件 -- 由于所有应用层代码只依赖于工厂类，因此只需改动工厂类即可
 */
public class Client {
    public static void main(String[] args) {
        for (int day = 0; day < 7; day++) {
            VideoFactory videoFactory = VideoFactory.getVideoFactory(day);
            if (videoFactory == null) continue;
            Video video = videoFactory.getVideo();
            if (video != null) {
                video.record();
            }
        }
    }
}
