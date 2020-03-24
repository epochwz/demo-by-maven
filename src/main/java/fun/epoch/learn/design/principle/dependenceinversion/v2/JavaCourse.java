package fun.epoch.learn.design.principle.dependenceinversion.v2;

public class JavaCourse implements Course {
    @Override
    public String studyCourse() {
        return "学习 Java 课程";
    }
}
