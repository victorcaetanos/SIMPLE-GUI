package controller;

import dao.Customer;
import dao.CustomerDAOImpl;
import dao.Order;
import dao.OrderDAOImpl;
import utils.ParseUtils;
import utils.ValidationUtils;
import view.MyFrame;

import java.sql.ResultSet;

public class OrderController {
    private final MyFrame panel;
    private final OrderDAOImpl orderDAO;

    public OrderController(MyFrame panel) {
        this.panel = panel;
        orderDAO = new OrderDAOImpl();
    }

    public boolean addOrder(final String customerId) {

        Integer parsedId = ParseUtils.parseId(customerId, panel);
        if (parsedId == null) return false;

        String validationResult = ValidationUtils.validateId(parsedId);
        if (!validationResult.isEmpty()) {
            panel.showErrorMessage(validationResult);
            return false;
        }


        if (!orderDAO.insertOrder(parsedId)) {
            panel.showErrorMessage("Inserting Order failed!");
            return false;
        }
        return true;
    }


    public boolean updateOrder(final String orderId, String customerId) {

        Integer parsedOrderID = ParseUtils.parseId(orderId, panel);
        if (parsedOrderID == null) return false;
        Integer parsedCustomerID = ParseUtils.parseId(customerId, panel);
        if (parsedCustomerID == null) return false;

        String validationResult = ValidationUtils.validateId(parsedOrderID);
        if (!validationResult.isEmpty()) {
            panel.showErrorMessage(validationResult);
            return false;
        } validationResult = ValidationUtils.validateId(parsedCustomerID);
        if (!validationResult.isEmpty()) {
            panel.showErrorMessage(validationResult);
            return false;
        }


        if (!orderDAO.updateOrder(parsedOrderID, parsedCustomerID)) {
            panel.showErrorMessage("Updating Order failed!");
            return false;
        }
        return true;
    }

    public void deleteOrder(final String orderId) {

        Integer parsedOrderId = ParseUtils.parseId(orderId, panel, false);
        if (parsedOrderId == null) return;

        String validationResult = ValidationUtils.validateId(parsedOrderId);
        if (!validationResult.isEmpty()) {
            panel.showErrorMessage(validationResult);
            return;
        }

        if (!orderDAO.deleteOrder(parsedOrderId)) {
            panel.showErrorMessage("Deleting Order failed!");
        }
    }

    public ResultSet getOrder(String orderId) {
        Integer parsedOrderId = ParseUtils.parseId(orderId, panel);
        ResultSet rs = orderDAO.listOrder(parsedOrderId);
        if (rs == null) {
            panel.showErrorMessage("Listing Order failed!");
        }
        return rs;
    }

    public ResultSet getAllOrder() {
        ResultSet rs = orderDAO.listAllOrders();
        if (rs == null) {
            panel.showErrorMessage("Listing all Orders failed!");
        }
        return rs;
    }
}

