package fun.epoch.learn.design.principle.openclose.v1;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PythonCourse implements Course {
    private Integer id;
    private String name;
    private Double price;
}
