package fun.epoch.learn.design.principle.compositionaggregation.v1;

/**
 * 需求变更：需要使用不同的数据库
 * <p>
 * 继承复用：违背开闭原则 -- 扩展时需要修改应用层以外的其他现有代码
 */
public class ProductDao extends PostgreSQLDBConnection {
    public void addProduct() {
        String connection = super.getConnection();
        System.out.println("使用 " + connection + " 添加商品");
    }
}
