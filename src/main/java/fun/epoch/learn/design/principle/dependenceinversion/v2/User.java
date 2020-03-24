package fun.epoch.learn.design.principle.dependenceinversion.v2;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void study(Course course) {
        System.out.println(this.name + " " + course.studyCourse());
    }
}
