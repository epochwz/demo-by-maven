package fun.epoch.learn.design.pattern.creational.abstractfactory.articles;

public class JavaArticle implements Article {
    @Override
    public void write() {
        System.out.println("编写 Java 手记...");
    }
}
