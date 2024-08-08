package dao;

import java.sql.ResultSet;

public interface OrderDAO {

    public boolean insertOrder(int customerId);

    public boolean updateOrder(int orderId, int customerId);

    public boolean deleteOrder(int orderId);

    public ResultSet listOrder(int orderId);

    public ResultSet listAllOrders();
}
