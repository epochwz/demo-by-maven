package fun.epoch.learn.design.pattern.behavioral.templatemethod;

public class FECourse extends AbstractCourse {
    @Override
    protected void packageCourse() {
        System.out.println("提供源码...");
        System.out.println("打包图片...");
    }
}
