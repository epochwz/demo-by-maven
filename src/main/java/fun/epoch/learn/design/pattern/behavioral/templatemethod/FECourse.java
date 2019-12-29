package fun.epoch.learn.design.pattern.behavioral.templatemethod;

public class FECourse extends AbstractCourse {
    private boolean needWriteArticle;

    public FECourse() {
        this(false);
    }

    public FECourse(boolean needWriteArticle) {
        this.needWriteArticle = needWriteArticle;
    }

    @Override
    protected void packageCourse() {
        System.out.println("提供源码...");
        System.out.println("打包图片...");
    }

    // 可以适当将钩子方法的使用权限开放给应用层
    @Override
    protected boolean needWriteArticle() {
        return this.needWriteArticle;
    }
}
