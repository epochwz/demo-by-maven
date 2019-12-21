package fun.epoch.learn.design.pattern.creational.abstractfactory;

import fun.epoch.learn.design.pattern.creational.abstractfactory.factory.CourseFactory;
import fun.epoch.learn.design.pattern.creational.abstractfactory.factory.JavaCourseFactory;
import fun.epoch.learn.design.pattern.creational.abstractfactory.factory.PythonCourseFactory;

/**
 * 需求描述：一星期中的每一天都需要录制不同的视频
 */
public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            CourseFactory courseFactory = null;

            if (i % 7 == 0) {
                courseFactory = new JavaCourseFactory();
            }
            if (i % 7 == 1) {
                courseFactory = new PythonCourseFactory();
            }

            if (courseFactory == null) continue;
            courseFactory.getVideo().record();
            courseFactory.getArticle().write();
        }
    }
}
