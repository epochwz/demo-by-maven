package fun.epoch.learn.design.pattern.creational.abstractfactory.factory;

import fun.epoch.learn.design.pattern.creational.abstractfactory.articles.Article;
import fun.epoch.learn.design.pattern.creational.abstractfactory.articles.JavaArticle;
import fun.epoch.learn.design.pattern.creational.abstractfactory.videos.JavaVideo;
import fun.epoch.learn.design.pattern.creational.abstractfactory.videos.Video;

public class JavaCourseFactory implements CourseFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }

    @Override
    public Article getArticle() {
        return new JavaArticle();
    }
}
