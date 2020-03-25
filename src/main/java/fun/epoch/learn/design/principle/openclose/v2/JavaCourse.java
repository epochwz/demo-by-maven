package fun.epoch.learn.design.principle.openclose.v2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JavaCourse implements Course {
    private Integer id;
    private String name;
    private Double price;
}
