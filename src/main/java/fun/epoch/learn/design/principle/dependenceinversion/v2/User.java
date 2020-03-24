package fun.epoch.learn.design.principle.dependenceinversion.v2;

public class User {
    private String name;
    private Course course;

    public User(String name) {
        this.name = name;
    }

    public User(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public void study() {
        System.out.println(this.name + " " + course.studyCourse());
    }
}
