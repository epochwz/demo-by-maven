package fun.epoch.learn.design.principle.compositionaggregation.v2;

/**
 * 需求变更：需要使用不同的数据库
 * <p>
 * 组合复用：符合开闭原则 -- 扩展时无需修改应用层以外的其他现有代码
 */
public class Test {
    public static void main(String[] args) {
        DBConnection dbConnection = new PostgreSQLDBConnection();
        ProductDao productDao = new ProductDao(dbConnection);
        productDao.addProduct();
    }
}
