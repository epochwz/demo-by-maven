package fun.epoch.learn.design.principle.openclose.v1;

/**
 * 需求描述：输出课程信息
 * <p>
 * 需求扩展：输出课程折扣价格
 * <p>
 * 直接修改现有接口，违背开闭原则：接口的所有实现类都必须随之修改，容易引入风险
 */
public class Test {
    public static void main(String[] args) {
        printCourse(new JavaCourse(96, "《Java 从入门到放弃》", 348d));
        System.out.println();
        printCourse(new PythonCourse(97, "《Python 从入门到放弃》", 299d));
    }

    private static void printCourse(Course course) {
        System.out.println(String.format("课程  ID: %s\n课程名称: %s", course.getId(), course.getName()));
        System.out.println(String.format("折扣价格: %s\n课程原价: %s", course.getDiscountPrice(0.8), course.getPrice()));
    }
}
