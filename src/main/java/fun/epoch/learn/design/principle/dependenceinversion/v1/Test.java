package fun.epoch.learn.design.principle.dependenceinversion.v1;

/**
 * 需求描述：epoch 同学需要学习各种课程
 * <p>
 * 需求扩展：epoch 同学需要学习新的课程
 * <p>
 * 面向实现编程：高层模块 (Test) 依赖 低层模块 (User) 的具体实现, 因此当需求扩展时，两者都必须同时修改
 */
public class Test {
    public static void main(String[] args) {
        User user = new User("epoch");
        user.studyJavaCourse();
        user.studyPythonCourse();
        user.studyGoCourse();
    }
}
