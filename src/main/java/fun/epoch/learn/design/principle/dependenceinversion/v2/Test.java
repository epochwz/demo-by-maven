package fun.epoch.learn.design.principle.dependenceinversion.v2;

/**
 * 需求描述：epoch 同学需要学习各种课程
 */
public class Test {
    public static void main(String[] args) {
        User epoch = new User("epoch");
        epoch.study(new JavaCourse());
        epoch.study(new PythonCourse());
    }
}
