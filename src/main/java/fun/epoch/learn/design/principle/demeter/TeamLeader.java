package fun.epoch.learn.design.principle.demeter;

import java.util.List;

public class TeamLeader {
    public void checkNumberOfCourse(List<Course> courses) {
        System.out.println(String.format("统计结果：一共有 %s 个在线课程", courses.size()));
    }
}
