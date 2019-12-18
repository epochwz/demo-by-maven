package fun.epoch.learn.design.principle.compositionaggregation.v1;

public class ProductDao extends MySQLDBConnection {
    public void addProduct() {
        String connection = super.getConnection();
        System.out.println("使用 " + connection + " 添加商品");
    }
}
