package fun.epoch.learn.design.principle.dependenceinversion.v1;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void studyJavaCourse() {
        System.out.println(this.name + " " + "学习 Java 课程");
    }

    public void studyPythonCourse() {
        System.out.println(this.name + " " + "学习 Python 课程");
    }
}
