package fun.epoch.learn.design.pattern.creational.builder.v2;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class Course {
    private String courseName;
    private String coursePPT;
    private String courseVideo;
    private String courseArticle;
    private String courseQA;

    public static CourseBuilder builder() {
        return new CourseBuilder();
    }

    public static class CourseBuilder {
        private Course course = new Course();

        public CourseBuilder buildCourseName(String courseName) {
            course.setCourseName(courseName);
            return this;
        }

        public CourseBuilder buildCoursePPT(String coursePPT) {
            course.setCoursePPT(coursePPT);
            return this;
        }

        public CourseBuilder buildCourseVideo(String courseVideo) {
            course.setCourseVideo(courseVideo);
            return this;
        }

        public CourseBuilder buildCourseArticle(String courseArticle) {
            course.setCourseArticle(courseArticle);
            return this;
        }

        public CourseBuilder buildCourseQA(String courseQA) {
            course.setCourseQA(courseQA);
            return this;
        }

        public Course build() {
            return course;
        }
    }
}
