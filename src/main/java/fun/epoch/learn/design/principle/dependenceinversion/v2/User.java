package fun.epoch.learn.design.principle.dependenceinversion.v2;

public class User {
    private String name;
    private Course course;

    public User(String name) {
        this.name = name;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void study() {
        System.out.println(this.name + " " + course.studyCourse());
    }
}
