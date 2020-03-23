package fun.epoch.learn.design.pattern.behavioral.mediator;

import java.util.Date;

public class StudyGroup {
    public static void showMessage(User user, String message) {
        System.out.println(String.format("[%s] [%s]: %s", new Date(), user.getName(), message));
    }
}
