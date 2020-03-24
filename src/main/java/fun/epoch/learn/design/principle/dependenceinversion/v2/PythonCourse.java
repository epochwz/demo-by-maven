package fun.epoch.learn.design.principle.dependenceinversion.v2;

public class PythonCourse implements Course {
    @Override
    public String studyCourse() {
        return "学习 Python 课程";
    }
}
