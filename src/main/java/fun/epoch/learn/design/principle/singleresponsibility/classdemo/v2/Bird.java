package fun.epoch.learn.design.principle.singleresponsibility.classdemo.v2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Bird {
    private String birdName;

    public abstract void move();
}
