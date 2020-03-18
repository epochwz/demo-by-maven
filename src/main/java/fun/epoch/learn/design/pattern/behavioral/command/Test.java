package fun.epoch.learn.design.pattern.behavioral.command;

import fun.epoch.learn.design.pattern.behavioral.command.cmds.CloseCourseCommand;
import fun.epoch.learn.design.pattern.behavioral.command.cmds.OpenCourseCommand;

public class Test {
    public static void main(String[] args) {
        Course course = new Course("《Java 从入门到放弃》");
        OpenCourseCommand openCourseCommand = new OpenCourseCommand(course);
        CloseCourseCommand closeCourseCommand = new CloseCourseCommand(course);

        Staff staff = new Staff();
        staff.addCommand(openCourseCommand);
        staff.addCommand(closeCourseCommand);
        staff.executeCommands();
    }
}
