package fun.epoch.learn.design.pattern.creational.builder.v1;

public class Client {
    public static void main(String[] args) {
        Coach coach = new Coach(new ConcreteCourseBuilder());
        Course course = coach.makeCourse("Java", "Java PPT", "Java Video", "Java Article", "Java Q & A");
        System.out.println(course);
    }
}
