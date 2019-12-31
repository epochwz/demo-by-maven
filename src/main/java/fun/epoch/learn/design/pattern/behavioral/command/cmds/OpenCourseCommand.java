package fun.epoch.learn.design.pattern.behavioral.command.cmds;

import fun.epoch.learn.design.pattern.behavioral.command.Course;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OpenCourseCommand implements Command {
    private Course course;

    @Override
    public void execute() {
        course.open();
    }
}
