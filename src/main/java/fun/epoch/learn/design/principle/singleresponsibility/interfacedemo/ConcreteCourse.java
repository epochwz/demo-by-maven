package fun.epoch.learn.design.principle.singleresponsibility.interfacedemo;

// 接口隔离、职责清晰，因此实现类可以自由选择实现单个或多个接口
public class ConcreteCourse implements CourseContent, CourseManage {
    @Override
    public void getName() {

    }

    @Override
    public void getVideo() {

    }

    @Override
    public void buy() {

    }

    @Override
    public void refund() {

    }
}
