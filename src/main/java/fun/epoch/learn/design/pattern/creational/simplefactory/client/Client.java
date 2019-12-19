package fun.epoch.learn.design.pattern.creational.simplefactory.client;

import fun.epoch.learn.design.pattern.creational.simplefactory.Video;
import fun.epoch.learn.design.pattern.creational.simplefactory.VideoFactory;

/**
 * 需求描述：一星期中的每一天都需要录制不同的视频
 * <p>
 * 简单实现：直接在应用层中根据条件创建不同视频类的对象，将导致应用层多处代码直接依赖具体的实现类
 * 需求变更：需要交换 Java & Python 视频的录制条件 -- 由于多处应用层代码直接依赖于具体的实现类，因此全部都需要改动
 * 简单工厂：将 “根据条件创建不同视频类的对象” 的选择逻辑转移到工厂类，使得所有应用层代码只需要依赖同一个工厂类即可
 * 需求变更：需要交换 Java & Python 视频的录制条件 -- 由于所有应用层代码都只依赖同一工厂类，因此只需改动工厂类即可
 */
public class Client {
    public static void main(String[] args) {
        for (int day = 0; day < 7; day++) {
            Video video = VideoFactory.getVideo(day);
            if (video != null) {
                video.record();
            }
        }
    }
}
