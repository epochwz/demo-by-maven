package fun.epoch.learn.design.pattern.behavioral.mediator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private String name;

    public void sendMessage(String message) {
        StudyGroup.showMessage(this, message);
    }
}
