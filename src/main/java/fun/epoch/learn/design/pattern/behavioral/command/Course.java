package fun.epoch.learn.design.pattern.behavioral.command;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Course {
    private String name;

    public void open() {
        System.out.println("开放课程：" + name);
    }

    public void close() {
        System.out.println("关闭课程：" + name);
    }
}
