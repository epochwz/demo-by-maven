package fun.epoch.learn.design.principle.demeter;

import java.util.ArrayList;

public class TeamLeader {
    private ArrayList<Course> courses;

    {
        this.courses = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            courses.add(new Course());
        }
    }

    public void checkNumberOfCourse() {
        System.out.println(String.format("统计结果：一共有 %s 个在线课程", courses.size()));
    }
}
