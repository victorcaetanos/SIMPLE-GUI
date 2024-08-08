package dao;

import java.sql.ResultSet;

public interface OrderItemDAO {

    boolean insertOrderItem(OrderItem orderItem);

    boolean updateOrderItem(OrderItem orderItem);

    boolean deleteOrderItem(int orderId, int productId);

    ResultSet listOrderItem(int orderId, int productId);

    ResultSet listAllOrderItems();
}
