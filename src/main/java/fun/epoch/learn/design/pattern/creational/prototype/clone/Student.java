package fun.epoch.learn.design.pattern.creational.prototype.clone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Student implements Cloneable {
    private String name;
    private String sex;
    private Date birthday;

    public static void main(String[] args) throws CloneNotSupportedException {
        Date birthday = new Date();
        Student student1 = new Student("小明", "男", birthday);
        Student student2 = (Student) student1.clone();

        System.out.println(student1); // 2019
        System.out.println(student2); // 2019

        student2.setName("小王");
        // 由于默认的克隆方法是浅拷贝，因此 student1 的引用类型变量 birthday 属性也会被更改
        student2.getBirthday().setTime(666666666666L);

        System.out.println(student1); // 1990
        System.out.println(student2); // 1990
    }
}
