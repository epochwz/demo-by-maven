package fun.epoch.learn.design.pattern.creational.abstractfactory.articles;

public class PythonArticle implements Article {
    @Override
    public void write() {
        System.out.println("编写 Python 手记...");
    }
}
