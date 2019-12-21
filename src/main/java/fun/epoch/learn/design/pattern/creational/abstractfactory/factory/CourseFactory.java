package fun.epoch.learn.design.pattern.creational.abstractfactory.factory;

import fun.epoch.learn.design.pattern.creational.abstractfactory.articles.Article;
import fun.epoch.learn.design.pattern.creational.abstractfactory.ppt.PPT;
import fun.epoch.learn.design.pattern.creational.abstractfactory.videos.Video;

public interface CourseFactory {
    Video getVideo();

    Article getArticle();

    PPT getPPT();
}
