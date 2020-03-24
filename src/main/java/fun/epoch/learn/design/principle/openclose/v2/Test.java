package fun.epoch.learn.design.principle.openclose.v2;

/**
 * 需求描述：输出课程信息
 */
public class Test {
    public static void main(String[] args) {
        printCourse(new JavaCourse(96, "《Java 从入门到放弃》", 348d));
        System.out.println();
        printCourse(new PythonCourse(97, "《Python 从入门到放弃》", 299d));
    }

    private static void printCourse(Course course) {
        System.out.println(String.format("课程  ID: %s\n课程名称: %s\n课程价格: %s", course.getId(), course.getName(), course.getPrice()));
    }
}
