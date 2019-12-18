package fun.epoch.learn.design.principle.compositionaggregation.v1;

public class Test {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        productDao.addProduct();
    }
}
