package fun.epoch.learn.design.pattern.creational.simplefactory;

import fun.epoch.learn.design.pattern.creational.simplefactory.videos.GoVideo;
import fun.epoch.learn.design.pattern.creational.simplefactory.videos.HtmlVideo;
import fun.epoch.learn.design.pattern.creational.simplefactory.videos.JavaVideo;
import fun.epoch.learn.design.pattern.creational.simplefactory.videos.PythonVideo;

public class VideoFactory {
    private static final String[] classNames = new String[7];

    static {
        classNames[0] = PythonVideo.class.getName();
        classNames[1] = JavaVideo.class.getName();
        classNames[2] = GoVideo.class.getName();
        classNames[3] = HtmlVideo.class.getName();
    }

    // 某些场景下可以适当使用反射技术来减少简单工厂类选择逻辑的改动
    public static Video getVideo(int day) {
        return getVideo(classNames[day % 7]);
    }

    public static Video getVideo(String className) {
        try {
            if (className != null && className.length() > 0) {
                return (Video) Class.forName(className).newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
