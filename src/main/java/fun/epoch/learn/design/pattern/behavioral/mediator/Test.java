package fun.epoch.learn.design.pattern.behavioral.mediator;

public class Test {
    public static void main(String[] args) {
        User user1 = new User("小明");
        User user2 = new User("小红");

        user1.sendMessage("Hello, 小红");
        user2.sendMessage("Hi, 小明");
    }
}
