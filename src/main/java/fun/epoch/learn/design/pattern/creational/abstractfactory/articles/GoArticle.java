package fun.epoch.learn.design.pattern.creational.abstractfactory.articles;

public class GoArticle implements Article {
    @Override
    public void write() {
        System.out.println("编写 Go 手记...");
    }
}
