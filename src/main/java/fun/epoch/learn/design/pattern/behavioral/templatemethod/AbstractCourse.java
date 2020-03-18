package fun.epoch.learn.design.pattern.behavioral.templatemethod;

public abstract class AbstractCourse {
    // 算法流程
    public final void makeCourse() {
        System.out.println("开始制作：" + getClass().getSimpleName());
        makePPT();
        recordVideo();
        if (needWriteArticle()) {
            writeArticle();
        }
        packageCourse();
        System.out.println("完成制作：" + getClass().getSimpleName());
    }

    // 可变步骤
    protected abstract void packageCourse();

    // 公共步骤
    final void makePPT() {
        System.out.println("制作 PPT...");
    }

    // 公共步骤
    final void recordVideo() {
        System.out.println("录制视频...");
    }

    // 可选步骤：子类可以按需选择是否执行该算法步骤，但不能改变该算法步骤的实现
    final void writeArticle() {
        System.out.println("\t编写手记... (使用钩子方法实现可选的算法步骤)");
    }

    // 钩子方法：向子类开放是否执行可选步骤的选择权
    protected boolean needWriteArticle() {
        return false;
    }
}
