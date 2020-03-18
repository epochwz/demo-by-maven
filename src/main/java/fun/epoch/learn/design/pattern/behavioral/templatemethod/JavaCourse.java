package fun.epoch.learn.design.pattern.behavioral.templatemethod;

public class JavaCourse extends AbstractCourse {
    @Override
    protected void packageCourse() {
        System.out.println("提供源码...");
    }

    // 算法实现类可以利用算法模板类提供的钩子方法灵活的扩展自身行为
    @Override
    protected boolean needWriteArticle() {
        return true;
    }
}
