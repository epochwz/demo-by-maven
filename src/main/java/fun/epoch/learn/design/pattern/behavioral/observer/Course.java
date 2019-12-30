package fun.epoch.learn.design.pattern.behavioral.observer;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Observable;

@Getter
@AllArgsConstructor
public class Course extends Observable {
    private String courseName;

    public void addQuestion(Question question) {
        System.out.println(String.format("%s 同学在课程 %s 上提了一个问题：%s", question.getUsername(), this.courseName, question.getContent()));
        setChanged();
        notifyObservers(question);
    }
}
