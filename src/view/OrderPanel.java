package view;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class OrderPanel extends MyFrame{

    private JPanel panelMain;
    private JLabel labelName;
    private JLabel labelQuantity;
    private JLabel labelTitle;
    private JLabel labelUnitPrice;
    private JLabel labelCustomer;
    private JLabel labelProduct;
    private JLabel labelTotalPrice;
    private JTextField fieldOrderID;
    private JTextField fieldProductName;
    private JFormattedTextField fieldProductUnitPrice;
    private JFormattedTextField fieldProductQuantity;
    private JFormattedTextField fieldProductTotalPrice;
    private JButton buttonInsertOrder;
    private JButton buttonUpdateOrder;
    private JButton buttonDeleteOrder;
    private JButton buttonInsertOrderItem;
    private JButton buttonDeleteOrderItem;
    private JButton buttonDone;
    private JComboBox comboBoxCustomer;
    private JComboBox comboBoxProduct;
    private JTable tableOrder;
    private JTable tableOrderItem;
    private JScrollPane scrollPanelOrder;
    private JScrollPane scrollPanelOrderItem;

    //    private final CustomerController customerController;
    private final Vector<String> orderColumnNames = new Vector<>(List.of("Customer ID", "Name", "Phone Number", "Email"));
    private final Vector<String> orderItemColumnNames = new Vector<>(List.of("Customer ID", "Name", "Phone Number", "Email"));

    public OrderPanel() {


//        customerController = new CustomerController(this);
//        setTableModel(customerController.getAllCustomers());
//
//        buttonInsert.addActionListener(e -> {
//            String name = fieldName.getText();
//            String phoneNumber = fieldPhoneNumber.getText();
//            String email = fieldEmail.getText();
//            if (customerController.addCustomer(name, phoneNumber, email)) {
//                clearAllFields();
//            }
//            setTableModel(customerController.getAllCustomers());
//        });
//
//        buttonUpdate.addActionListener(e -> {
//            String id = fieldID.getText();
//            String name = fieldName.getText();
//            String phoneNumber = fieldPhoneNumber.getText();
//            String email = fieldEmail.getText();
//            if (customerController.updateCustomer(id, name, phoneNumber, email)) {
//                clearAllFields();
//                buttonUpdate.setEnabled(false);
//                buttonInsert.setEnabled(true);
//                buttonDone.setEnabled(false);
//            }
//            setTableModel(customerController.getAllCustomers());
//        });
//
//        buttonDelete.addActionListener(e -> {
//            String id = fieldID.getText();
//            customerController.deleteCustomer(id);
//            clearAllFields();
//            setTableModel(customerController.getAllCustomers());
//        });
//
//        tableCustomer.getSelectionModel().addListSelectionListener(e -> {
//            if (!e.getValueIsAdjusting()) {
//                int selectedRow = tableCustomer.getSelectedRow();
//                if (selectedRow >= 0) {
//                    String customerId = "" + (int) tableCustomer.getValueAt(selectedRow, 0);
//
//                    ResultSet rs = customerController.getCustomer(customerId);
//                    if (rs == null) {
//                        return;
//                    }
//
//                    if (!buttonDone.isEnabled()) {
//                        buttonInsert.setEnabled(false);
//                        buttonUpdate.setEnabled(true);
//                        buttonDelete.setEnabled(true);
//                        buttonDone.setEnabled(true);
//                    }
//                    fieldID.setText(customerId);
//                    setFieldTexts(rs);
//                }
//            }
//        });
//
//        buttonDone.addActionListener(e -> {
//            clearAllFields();
//            setTableModel(customerController.getAllCustomers());
//            buttonInsert.setEnabled(true);
//            buttonUpdate.setEnabled(false);
//            buttonDelete.setEnabled(false);
//            buttonDone.setEnabled(false);
//        });

        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
//
//    public void setTableModel(final ResultSet rs) {
//        if (rs == null) return;
//
//        try {
//            tableCustomer.setModel(buildTableModel(rs, customerColumnNames));
//            tableCustomer.getColumnModel().getColumn(2).setCellRenderer(new PhoneNumberCellRenderer());
//            rs.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void setFieldTexts(final ResultSet rs) {
//        if (rs == null) return;
//
//        try {
//            if (!rs.next()) return;
//            fieldName.setText(rs.getString("name"));
//            fieldPhoneNumber.setText(rs.getString("phoneNumber"));
//            fieldEmail.setText(rs.getString("email"));
//            rs.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void clearAllFields() {
//        fieldName.setText("");
//        fieldPhoneNumber.setText("");
//        fieldEmail.setText("");
//        fieldID.setText("");
//    }
//
//    private void createUIComponents() {
//        MaskFormatter phoneFormatter = null;
//        String pattern = "(**)*****-****";
//        char placeholder = '_';
//        try {
//            phoneFormatter = new MaskFormatter(pattern);
//            phoneFormatter.setPlaceholderCharacter(placeholder);
//        } catch (ParseException e) {
//            System.err.println("ParseException: " + e.getMessage());
//            showErrorMessage("A Phone Number might not be well formatted");
//        }
//        fieldPhoneNumber = new JFormattedTextField(phoneFormatter);
//    }
}
