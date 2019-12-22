package fun.epoch.learn.design.pattern.creational.builder.v2;

public class Client {
    public static void main(String[] args) {
        Course course = Course.builder()
                .buildCourseName("Java")
                .buildCoursePPT("Java PPT")
                .buildCourseVideo("Java Video")
                .buildCourseArticle("Java Article")
                .buildCourseQA("Java Q & A")
                .build();

        System.out.println(course);

        System.out.println(Course.builder()
                .buildCourseName("Python")
                .buildCourseVideo("Python Video")
                .buildCoursePPT("Python PPT")
                .build()
        );
    }
}
