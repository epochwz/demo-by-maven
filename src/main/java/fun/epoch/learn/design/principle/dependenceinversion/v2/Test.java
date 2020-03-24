package fun.epoch.learn.design.principle.dependenceinversion.v2;

/**
 * 需求描述：epoch 同学需要学习各种课程
 * <p>
 * 需求扩展：epoch 同学需要学习新的课程
 * <p>
 * 面向接口编程：高层模块 (User) 不依赖 低层模块 (Course) 的具体实现, 因此当需求扩展时，高层模块 (User) 无需修改，符合开闭原则
 */
public class Test {
    public static void main(String[] args) {
        User epoch = new User("epoch");
        epoch.study(new JavaCourse());
        epoch.study(new PythonCourse());
        epoch.study(new GoCourse());
    }
}
