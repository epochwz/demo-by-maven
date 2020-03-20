package fun.epoch.learn.design.pattern.behavioral.observer;

import lombok.AllArgsConstructor;

import java.util.Observable;
import java.util.Observer;

@AllArgsConstructor
public class Teacher implements Observer {
    private String name;

    @Override
    public void update(Observable observed, Object arg) {
        Course course = (Course) observed;
        Question question = (Question) arg;
        System.out.println(String.format("教师 %s 收到了 %s 同学在课程 %s 上的提问：%s", this.name, question.getUsername(), course.getCourseName(), question.getContent()));
    }
}
