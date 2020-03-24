package fun.epoch.learn.design.principle.liskovsubsitution;

public class Test {
    // 需求描述：当宽度小于等于长度时，宽度 +1
    // 通过遵循里氏替换原则，对类的继承关系进行约束：
    //     由于接口 Quadrangle 并不具备设置边长的方法
    //     因此约束了该方法只能适用于其特定的实现类 Rectangle, 而无法适用于 Square
    //     从而避免随意替换实现类而带来不可预期的风险
    // public static void resize(Quadrangle rectangle) {
    public static void resize(Rectangle rectangle) {
        while (rectangle.getWidth() <= rectangle.getLength()) {
            rectangle.setWidth(rectangle.getWidth() + 1);
            System.out.println(rectangle);
        }
    }

    public static void main(String[] args) {
        // resize(new Square(10)); // 编译失败：遵循里氏替换原则，避免随意替换实现类
    }
}
