package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import static utils.DbConnection.getConnection;

public class OrderItemDAOImpl implements OrderItemDAO {

    private PreparedStatement ps;
    private final Connection con = getConnection();

    @Override
    public boolean insertOrderItem(OrderItem orderItem) {

        String sql = "INSERT INTO orderitems (order_id, product_id, quantity, unitPrice) values (?, ?, ?, ?);";

        try {
            ps = Objects.requireNonNull(con).prepareStatement(sql);
            ps.setInt(1, orderItem.getOrderId());
            ps.setInt(2, orderItem.getProductId());
            ps.setInt(3, orderItem.getQuantity());
            ps.setFloat(4, orderItem.getUnitPrice());
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
            System.err.println("SQL Exception: " + ex.getMessage());
            throw new RuntimeException("Failed to insert order", ex);
        }
    }

    @Override
    public boolean updateOrderItem(OrderItem orderItem) {

        String sql = "UPDATE orderitems SET quantity = ? WHERE order_id = ? AND product_id = ?";

        try {
            ps = Objects.requireNonNull(con).prepareStatement(sql);
            ps.setInt(1, orderItem.getQuantity());
            ps.setInt(2, orderItem.getOrderId());
            ps.setInt(3, orderItem.getProductId());
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
            System.err.println("SQL Exception: " + ex.getMessage());
            throw new RuntimeException("Failed to delete order", ex);
        }
    }

    @Override
    public boolean deleteOrderItem(int orderId, int productId) {

        String sql = "DELETE FROM orderitems WHERE order_id = ? AND product_id = ?";

        try {
            ps = Objects.requireNonNull(con).prepareStatement(sql);
            ps.setInt(1, orderId);
            ps.setInt(2, productId);
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
            System.err.println("SQL Exception: " + ex.getMessage());
            throw new RuntimeException("Failed to delete order", ex);
        }
    }

    @Override
    public ResultSet listOrderItem(int orderId, int productId) {

        String sql = "SELECT product_id, quantity, unitPrice, totalPrice FROM orderitems WHERE order_id = ? AND product_id = ?";

        try {
            ps = Objects.requireNonNull(con).prepareStatement(sql);
            ps.setInt(1, orderId);
            ps.setInt(2, productId);
            return ps.executeQuery();
        } catch (SQLException ex) {
            System.err.println("SQL Exception: " + ex.getMessage());
            throw new RuntimeException("Failed to list order", ex);
        }
    }

    @Override
    public ResultSet listAllOrderItems() {

        String sql = "SELECT product_id, products.name AS productName, orderitems.quantity, unitPrice, totalPrice FROM orderitems " +
                "JOIN products on (orderitems.product_id = products.id) ";

        try {
            ps = Objects.requireNonNull(con).prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException ex) {
            System.err.println("SQL Exception: " + ex.getMessage());
            throw new RuntimeException("Failed to list all orders", ex);
        }
    }
}
