package fun.epoch.learn.design.pattern.behavioral.visitor;

import lombok.Getter;
import lombok.Setter;

public class CodingCourse extends Course {
    @Getter
    @Setter
    private int price;

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
