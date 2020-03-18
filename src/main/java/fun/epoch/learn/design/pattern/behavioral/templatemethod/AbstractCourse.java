package fun.epoch.learn.design.pattern.behavioral.templatemethod;

public abstract class AbstractCourse {
    // 算法流程
    public final void makeCourse() {
        System.out.println("开始制作：" + getClass().getSimpleName());
        makePPT();
        recordVideo();
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
}
