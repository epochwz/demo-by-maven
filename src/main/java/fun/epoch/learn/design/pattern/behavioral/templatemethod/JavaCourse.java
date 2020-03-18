package fun.epoch.learn.design.pattern.behavioral.templatemethod;

public class JavaCourse extends AbstractCourse {
    @Override
    protected void packageCourse() {
        System.out.println("提供源码...");
    }
}
