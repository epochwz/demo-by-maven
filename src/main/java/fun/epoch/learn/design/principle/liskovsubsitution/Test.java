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
        resize(new Rectangle(20, 10));
    }
}
