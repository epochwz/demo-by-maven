package fun.epoch.learn.design.principle.compositionaggregation.v2;

public class Test {
    public static void main(String[] args) {
        DBConnection dbConnection = new MySQLDBConnection();
        ProductDao productDao = new ProductDao(dbConnection);
        productDao.addProduct();
    }
}
