package fun.epoch.learn.design.pattern.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();

        FreeCourse freeCourse = new FreeCourse();
        freeCourse.setName("《Java 从入门到放弃》");
        courses.add(freeCourse);


        CodingCourse codingCourse = new CodingCourse();
        codingCourse.setName("《Java 从入门到精通》");
        codingCourse.setPrice(100);
        courses.add(codingCourse);

        for (Course course : courses) {
            course.accept(new Visitor());
        }
    }
}
