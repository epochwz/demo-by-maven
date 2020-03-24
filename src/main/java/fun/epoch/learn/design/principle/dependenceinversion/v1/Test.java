package fun.epoch.learn.design.principle.dependenceinversion.v1;

/**
 * 需求描述：epoch 同学需要学习各种课程
 */
public class Test {
    public static void main(String[] args) {
        User user = new User("epoch");
        user.studyJavaCourse();
        user.studyPythonCourse();
    }
}
