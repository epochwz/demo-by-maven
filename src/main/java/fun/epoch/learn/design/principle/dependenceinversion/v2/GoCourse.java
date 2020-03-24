package fun.epoch.learn.design.principle.dependenceinversion.v2;

public class GoCourse implements Course {
    @Override
    public String studyCourse() {
        return "学习 Go 课程";
    }
}
