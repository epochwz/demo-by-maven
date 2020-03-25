package fun.epoch.learn.design.principle.liskovsubsitution;

public class Test {
    // 需求描述：当宽度小于等于长度时，宽度 +1
    public static void resize(Rectangle rectangle) {
        while (rectangle.getWidth() <= rectangle.getLength()) {
            rectangle.setWidth(rectangle.getWidth() + 1);
            System.out.println(rectangle);
        }
    }

    public static void main(String[] args) {
        resize(new Square(10)); // 将造成死循环：使用子类替换父类后，程序逻辑被改变，违背了里氏替换原则
    }
}
