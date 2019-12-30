package fun.epoch.learn.design.pattern.behavioral.observer;

public class Test {
    public static void main(String[] args) {
        // 被观察者
        Course course = new Course("《Java 从入门到放弃》");
        // 添加观察者
        course.addObserver(new Teacher("小明"));
        course.addObserver(new Teacher("小王"));

        // 触发事件
        course.addQuestion(new Question("epoch", "......"));
    }
}
