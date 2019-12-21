package fun.epoch.learn.design.pattern.creational.abstractfactory.factory;

import fun.epoch.learn.design.pattern.creational.abstractfactory.articles.Article;
import fun.epoch.learn.design.pattern.creational.abstractfactory.articles.PythonArticle;
import fun.epoch.learn.design.pattern.creational.abstractfactory.ppt.PPT;
import fun.epoch.learn.design.pattern.creational.abstractfactory.ppt.PythonPPT;
import fun.epoch.learn.design.pattern.creational.abstractfactory.videos.PythonVideo;
import fun.epoch.learn.design.pattern.creational.abstractfactory.videos.Video;

public class PythonCourseFactory implements CourseFactory {
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }

    @Override
    public Article getArticle() {
        return new PythonArticle();
    }

    @Override
    public PPT getPPT() {
        return new PythonPPT();
    }
}
