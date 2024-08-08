package dao;

import java.sql.ResultSet;


public interface ProductDAO {

    public boolean insertProduct(Product product);

    public boolean updateProduct(Product product);

    public boolean deleteProduct(int productId);

    public ResultSet listProduct(int productId);

    public ResultSet listAllProduct();

     public Product mapResultSetToProduct (ResultSet rs);
}
