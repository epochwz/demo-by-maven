package fun.epoch.learn.design.pattern.creational.builder.v1;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Coach {
    private CourseBuilder courseBuilder;

    public Course makeCourse(String courseName, String coursePPT, String courseVideo, String courseArticle, String courseQA) {
        courseBuilder.buildCourseName(courseName);
        courseBuilder.buildCoursePPT(coursePPT);
        courseBuilder.buildCourseVideo(courseVideo);
        courseBuilder.buildCourseArticle(courseArticle);
        courseBuilder.buildCourseQA(courseQA);
        return courseBuilder.build();
    }
}
