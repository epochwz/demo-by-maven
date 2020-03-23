package fun.epoch.learn.design.pattern.behavioral.visitor;

import lombok.Getter;
import lombok.Setter;

public abstract class Course {
    @Getter
    @Setter
    private String name;

    public abstract void accept(IVisitor visitor);
}
