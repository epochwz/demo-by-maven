package fun.epoch.learn.design.pattern.creational.abstractfactory.factory;

import fun.epoch.learn.design.pattern.creational.abstractfactory.articles.Article;
import fun.epoch.learn.design.pattern.creational.abstractfactory.articles.GoArticle;
import fun.epoch.learn.design.pattern.creational.abstractfactory.videos.GoVideo;
import fun.epoch.learn.design.pattern.creational.abstractfactory.videos.Video;

public class GoCourseFactory implements CourseFactory {
    @Override
    public Video getVideo() {
        return new GoVideo();
    }

    @Override
    public Article getArticle() {
        return new GoArticle();
    }
}
