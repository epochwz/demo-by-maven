package fun.epoch.learn.design.principle.demeter;

import java.util.ArrayList;

public class Boss {
    public void commandCheckNumber(TeamLeader teamLeader) {
        // 违背迪米特法则：
        // 1. Boss 只需要与 “朋友” TeamLeader 交流，便可以得到想要的结果
        // 2. Course 并不是 Boss 的 “朋友”，因此 Boss 不应该依赖 Course
        ArrayList<Course> courses = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            courses.add(new Course());
        }
        teamLeader.checkNumberOfCourse(courses);
    }
}
