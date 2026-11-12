import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class CustomerDetails extends JFrame {

    // =========================================================
    // COLOURS
    // =========================================================

    private static final Color COFFEE =
        new Color(78, 49, 37);

    private static final Color DEEP_COFFEE =
        new Color(55, 34, 26);

    private static final Color CARAMEL =
        new Color(205, 157, 82);

    private static final Color LIGHT_CARAMEL =
        new Color(244, 220, 177);

    private static final Color IVORY =
        new Color(250, 247, 239);

    private static final Color WHITE =
        new Color(255, 253, 248);

    private static final Color TEXT =
        new Color(58, 43, 35);

    private static final Color MUTED =
        new Color(128, 105, 88);

    private static final Color BORDER =
        new Color(225, 199, 155);


    // =========================================================
    // FIELDS
    // =========================================================

    private JTextField nameField;
    private JTextField phoneField;
    private JTextField tableField;
    private JLabel totalLabel;


    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public CustomerDetails() {

        setTitle(
            "TAMIL KUDIL - Customer Details"
        );

        setSize(
            900,
            650
        );

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
            JFrame.DISPOSE_ON_CLOSE
        );

        buildUI();
    }


    // =========================================================
    // BUILD UI
    // =========================================================

    private void buildUI() {

        getContentPane().setBackground(
            IVORY
        );

        setLayout(
            new BorderLayout()
        );


        // =====================================================
        // HEADER
        // =====================================================

        JPanel header =
            new JPanel(
                new BorderLayout()
            );

        header.setBackground(
            COFFEE
        );

        header.setBorder(
            BorderFactory.createEmptyBorder(
                18,
                28,
                18,
                28
            )
        );


        JPanel brand =
            new JPanel();

        brand.setOpaque(false);

        brand.setLayout(
            new BoxLayout(
                brand,
                BoxLayout.Y_AXIS
            )
        );


        JLabel logo =
            new JLabel(
                "⌂"
            );

        logo.setFont(
            new Font(
                "Serif",
                Font.BOLD,
                27
            )
        );

        logo.setForeground(
            LIGHT_CARAMEL
        );


        JLabel title =
            new JLabel(
                "TAMIL KUDIL"
            );

        title.setFont(
            new Font(
                "Serif",
                Font.BOLD,
                28
            )
        );

        title.setForeground(
            Color.WHITE
        );


        JLabel subtitle =
            new JLabel(
                "SMART KITCHEN MANAGEMENT SYSTEM"
            );

        subtitle.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                10
            )
        );

        subtitle.setForeground(
            LIGHT_CARAMEL
        );


        JPanel brandLine =
            new JPanel(
                new FlowLayout(
                    FlowLayout.LEFT,
                    8,
                    0
                )
            );

        brandLine.setOpaque(false);

        brandLine.add(
            logo
        );

        brandLine.add(
            title
        );


        brand.add(
            brandLine
        );

        brand.add(
            subtitle
        );


        header.add(
            brand,
            BorderLayout.WEST
        );


        JLabel step =
            new JLabel(
                "STEP 1 OF 2  •  CUSTOMER DETAILS"
            );

        step.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                11
            )
        );

        step.setForeground(
            LIGHT_CARAMEL
        );


        header.add(
            step,
            BorderLayout.EAST
        );


        add(
            header,
            BorderLayout.NORTH
        );


        // =====================================================
        // MAIN AREA
        // =====================================================

        JPanel main =
            new JPanel(
                new BorderLayout(
                    22,
                    0
                )
            );

        main.setBackground(
            IVORY
        );

        main.setBorder(
            BorderFactory.createEmptyBorder(
                24,
                30,
                25,
                30
            )
        );


        // =====================================================
        // LEFT FORM CARD
        // =====================================================

        JPanel formCard =
            new RoundedPanel(
                WHITE,
                28
            );

        formCard.setBorder(
            BorderFactory.createCompoundBorder(
                new LineBorder(
                    BORDER,
                    1,
                    true
                ),
                BorderFactory.createEmptyBorder(
                    25,
                    28,
                    25,
                    28
                )
            )
        );

        formCard.setLayout(
            new BorderLayout(
                0,
                20
            )
        );


        // FORM HEADING

        JPanel formHeading =
            new JPanel();

        formHeading.setOpaque(false);

        formHeading.setLayout(
            new BoxLayout(
                formHeading,
                BoxLayout.Y_AXIS
            )
        );


        JLabel heading =
            new JLabel(
                "Complete Your Order"
            );

        heading.setFont(
            new Font(
                "Serif",
                Font.BOLD,
                30
            )
        );

        heading.setForeground(
            TEXT
        );


        JLabel description =
            new JLabel(
                "Tell us where to serve your order."
            );

        description.setFont(
            new Font(
                "SansSerif",
                Font.PLAIN,
                13
            )
        );

        description.setForeground(
            MUTED
        );


        formHeading.add(
            heading
        );

        formHeading.add(
            Box.createVerticalStrut(5)
        );

        formHeading.add(
            description
        );


        formCard.add(
            formHeading,
            BorderLayout.NORTH
        );


        // =====================================================
        // FORM FIELDS
        // =====================================================

        JPanel fields =
            new JPanel();

        fields.setOpaque(false);

        fields.setLayout(
            new BoxLayout(
                fields,
                BoxLayout.Y_AXIS
            )
        );


        // CUSTOMER NAME

        JLabel nameLabel =
            createLabel(
                "CUSTOMER NAME"
            );


        nameField =
            createTextField(
                "Enter your name"
            );


        fields.add(
            nameLabel
        );

        fields.add(
            Box.createVerticalStrut(7)
        );

        fields.add(
            nameField
        );

        fields.add(
            Box.createVerticalStrut(18)
        );


        // PHONE NUMBER

        JLabel phoneLabel =
            createLabel(
                "PHONE NUMBER"
            );


        phoneField =
            createTextField(
                "10-digit mobile number"
            );


        fields.add(
            phoneLabel
        );

        fields.add(
            Box.createVerticalStrut(7)
        );

        fields.add(
            phoneField
        );

        fields.add(
            Box.createVerticalStrut(18)
        );


        // TABLE NUMBER

        JLabel tableLabel =
            createLabel(
                "TABLE NUMBER"
            );


        tableField =
            createTextField(
                "Enter table number"
            );


        fields.add(
            tableLabel
        );

        fields.add(
            Box.createVerticalStrut(7)
        );

        fields.add(
            tableField
        );


        formCard.add(
            fields,
            BorderLayout.CENTER
        );


        JLabel privacy =
            new JLabel(
                "Your details are used only to process this order."
            );

        privacy.setFont(
            new Font(
                "SansSerif",
                Font.PLAIN,
                11
            )
        );

        privacy.setForeground(
            MUTED
        );


        formCard.add(
            privacy,
            BorderLayout.SOUTH
        );


        main.add(
            formCard,
            BorderLayout.CENTER
        );


        // =====================================================
        // RIGHT SUMMARY CARD
        // =====================================================

        JPanel summaryCard =
            new RoundedPanel(
                COFFEE,
                30
            );

        summaryCard.setPreferredSize(
            new Dimension(
                285,
                0
            )
        );

        summaryCard.setBorder(
            BorderFactory.createEmptyBorder(
                25,
                24,
                24,
                24
            )
        );

        summaryCard.setLayout(
            new BorderLayout()
        );


        // SUMMARY TOP

        JPanel summaryTop =
            new JPanel();

        summaryTop.setOpaque(false);

        summaryTop.setLayout(
            new BoxLayout(
                summaryTop,
                BoxLayout.Y_AXIS
            )
        );


        JLabel summaryTitle =
            new JLabel(
                "ORDER SUMMARY"
            );

        summaryTitle.setFont(
            new Font(
                "Serif",
                Font.BOLD,
                24
            )
        );

        summaryTitle.setForeground(
            Color.WHITE
        );


        JLabel summarySub =
            new JLabel(
                "Ready to confirm"
            );

        summarySub.setFont(
            new Font(
                "SansSerif",
                Font.PLAIN,
                12
            )
        );

        summarySub.setForeground(
            LIGHT_CARAMEL
        );


        summaryTop.add(
            summaryTitle
        );

        summaryTop.add(
            Box.createVerticalStrut(5)
        );

        summaryTop.add(
            summarySub
        );


        summaryTop.add(
            Box.createVerticalStrut(30)
        );


        // CART QUANTITY

        int quantity = 0;


        ArrayList<CartManager.CartItem> cart =
            CartManager.getCart();


        for (
            CartManager.CartItem item :
            cart
        ) {

            quantity =
                quantity
                + item.quantity;
        }


        JLabel items =
            new JLabel(
                quantity
                + (
                    quantity == 1
                    ? " ITEM"
                    : " ITEMS"
                )
            );

        items.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                13
            )
        );

        items.setForeground(
            LIGHT_CARAMEL
        );


        summaryTop.add(
            items
        );


        summaryTop.add(
            Box.createVerticalStrut(10)
        );


        JLabel cartMessage =
            new JLabel(
                "The Total Net Amount:"
            );

        cartMessage.setFont(
            new Font(
                "SansSerif",
                Font.PLAIN,
                12
            )
        );

        cartMessage.setForeground(
            Color.WHITE
        );


        summaryTop.add(
            cartMessage
        );


        summaryCard.add(
            summaryTop,
            BorderLayout.NORTH
        );


        // =====================================================
        // TOTAL BOX
        // =====================================================

        JPanel totalBox =
            new RoundedPanel(
                LIGHT_CARAMEL,
                22
            );

        totalBox.setBorder(
            BorderFactory.createEmptyBorder(
                17,
                17,
                17,
                17
            )
        );

        totalBox.setLayout(
            new BoxLayout(
                totalBox,
                BoxLayout.Y_AXIS
            )
        );


        JLabel totalText =
            new JLabel(
                "TOTAL AMOUNT"
            );

        totalText.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                11
            )
        );

        totalText.setForeground(
            COFFEE
        );


        totalLabel =
            new JLabel(
                String.format(
                    "₹%.2f",
                    CartManager.getTotal()
                )
            );

        totalLabel.setFont(
            new Font(
                "Serif",
                Font.BOLD,
                32
            )
        );

        totalLabel.setForeground(
            DEEP_COFFEE
        );


        totalBox.add(
            totalText
        );

        totalBox.add(
            Box.createVerticalStrut(5)
        );

        totalBox.add(
            totalLabel
        );


        summaryCard.add(
            totalBox,
            BorderLayout.CENTER
        );


        // =====================================================
        // BOTTOM CONFIRM AREA
        // =====================================================

        JPanel bottom =
            new JPanel();

        bottom.setOpaque(false);

        bottom.setLayout(
            new BoxLayout(
                bottom,
                BoxLayout.Y_AXIS
            )
        );


        JLabel noPayment =
            new JLabel(
                "✓  No online payment required"
            );

        noPayment.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                11
            )
        );

        noPayment.setForeground(
            LIGHT_CARAMEL
        );


        JButton confirmButton =
            new JButton(
                "CONFIRM ORDER   →"
            );

        confirmButton.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                13
            )
        );

        confirmButton.setForeground(
            DEEP_COFFEE
        );

        confirmButton.setBackground(
            LIGHT_CARAMEL
        );

        confirmButton.setFocusPainted(
            false
        );

        confirmButton.setBorder(
            BorderFactory.createEmptyBorder(
                14,
                18,
                14,
                18
            )
        );

        confirmButton.setCursor(
            new Cursor(
                Cursor.HAND_CURSOR
            )
        );


        confirmButton.addActionListener(
            e -> confirmOrder()
        );


        bottom.add(
            noPayment
        );

        bottom.add(
            Box.createVerticalStrut(12)
        );

        bottom.add(
            confirmButton
        );


        summaryCard.add(
            bottom,
            BorderLayout.SOUTH
        );


        main.add(
            summaryCard,
            BorderLayout.EAST
        );


        add(
            main,
            BorderLayout.CENTER
        );
    }


    // =========================================================
    // FORM LABEL
    // =========================================================

    private JLabel createLabel(
        String text
    ) {

        JLabel label =
            new JLabel(
                text
            );


        label.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                12
            )
        );


        label.setForeground(
            CARAMEL
        );


        return label;
    }


    // =========================================================
    // TEXT FIELD
    // =========================================================

    private JTextField createTextField(
        String placeholder
    ) {

        JTextField field =
            new JTextField();


        field.setFont(
            new Font(
                "SansSerif",
                Font.PLAIN,
                15
            )
        );


        field.setForeground(
            TEXT
        );


        field.setBackground(
            new Color(
                252,
                249,
                242
            )
        );


        field.setBorder(
            BorderFactory.createCompoundBorder(
                new LineBorder(
                    BORDER,
                    1,
                    true
                ),
                BorderFactory.createEmptyBorder(
                    11,
                    13,
                    11,
                    13
                )
            )
        );


        field.setMaximumSize(
            new Dimension(
                Integer.MAX_VALUE,
                47
            )
        );


        return field;
    }


    // =========================================================
    // CONFIRM ORDER
    // =========================================================

    private void confirmOrder() {

        String customerName =
            nameField
                .getText()
                .trim();


        String phone =
            phoneField
                .getText()
                .trim();


        String tableText =
            tableField
                .getText()
                .trim();


        // =====================================================
        // VALIDATE NAME
        // =====================================================

        if (
            customerName.isEmpty()
        ) {

            showError(
                "Please enter your name."
            );

            nameField.requestFocus();

            return;
        }


        // =====================================================
        // VALIDATE PHONE
        // =====================================================

        if (
            !phone.matches(
                "\\d{10}"
            )
        ) {

            showError(
                "Please enter a valid 10-digit phone number."
            );

            phoneField.requestFocus();

            return;
        }


        // =====================================================
        // VALIDATE TABLE
        // =====================================================

        int tableNumber;


        try {

            tableNumber =
                Integer.parseInt(
                    tableText
                );


            if (
                tableNumber <= 0
            ) {

                throw new NumberFormatException();
            }

        } catch (
            NumberFormatException ex
        ) {

            showError(
                "Please enter a valid table number."
            );

            tableField.requestFocus();

            return;
        }


        // =====================================================
        // VALIDATE CART
        // =====================================================

        if (
            CartManager
                .getCart()
                .isEmpty()
        ) {

            showError(
                "Your cart is empty."
            );

            return;
        }


        double total =
            CartManager.getTotal();


        Connection con = null;


        try {

            // =================================================
            // DATABASE CONNECTION
            // =================================================

            con =
                DBConnection.getConnection();


            if (
                con == null
            ) {

                showError(
                    "Database connection failed."
                );

                return;
            }


            con.setAutoCommit(
                false
            );


            // =================================================
            // INSERT CUSTOMER
            // =================================================

            String customerSQL =
                "INSERT INTO customer "
                + "(customer_name, phone, table_number) "
                + "VALUES (?, ?, ?)";


            PreparedStatement customerStatement =
                con.prepareStatement(
                    customerSQL,
                    Statement.RETURN_GENERATED_KEYS
                );


            customerStatement.setString(
                1,
                customerName
            );


            customerStatement.setString(
                2,
                phone
            );


            customerStatement.setInt(
                3,
                tableNumber
            );


            customerStatement.executeUpdate();


            ResultSet customerKeys =
                customerStatement.getGeneratedKeys();


            int customerId;


            if (
                customerKeys.next()
            ) {

                customerId =
                    customerKeys.getInt(1);

            } else {

                throw new SQLException(
                    "Customer ID was not generated."
                );
            }


            customerKeys.close();

            customerStatement.close();


            // =================================================
            // INSERT ORDER
            // =================================================

            String orderSQL =
                "INSERT INTO orders "
                + "(customer_id, total_amount, "
                + "payment_status, order_status) "
                + "VALUES (?, ?, ?, ?)";


            PreparedStatement orderStatement =
                con.prepareStatement(
                    orderSQL,
                    Statement.RETURN_GENERATED_KEYS
                );


            orderStatement.setInt(
                1,
                customerId
            );


            orderStatement.setDouble(
                2,
                total
            );


            orderStatement.setString(
                3,
                "CONFIRMED"
            );


            orderStatement.setString(
                4,
                "CONFIRMED"
            );


            orderStatement.executeUpdate();


            ResultSet orderKeys =
                orderStatement.getGeneratedKeys();


            int orderId;


            if (
                orderKeys.next()
            ) {

                orderId =
                    orderKeys.getInt(1);

            } else {

                throw new SQLException(
                    "Order ID was not generated."
                );
            }


            orderKeys.close();

            orderStatement.close();


            // =================================================
            // INSERT ORDER ITEMS
            // =================================================

            String itemSQL =
                "INSERT INTO order_items "
                + "(order_id, food_id, quantity, price) "
                + "VALUES (?, ?, ?, ?)";


            PreparedStatement itemStatement =
                con.prepareStatement(
                    itemSQL
                );


            ArrayList<CartManager.CartItem> currentCart =
                CartManager.getCart();


            for (
                CartManager.CartItem item :
                currentCart
            ) {

                itemStatement.setInt(
                    1,
                    orderId
                );


                itemStatement.setInt(
                    2,
                    item.foodId
                );


                itemStatement.setInt(
                    3,
                    item.quantity
                );


                itemStatement.setDouble(
                    4,
                    item.price
                );


                itemStatement.executeUpdate();
            }


            itemStatement.close();


            // =================================================
            // INSERT PAYMENT
            // =================================================

            String paymentSQL =
                "INSERT INTO payment "
                + "(order_id, payment_method, "
                + "amount, payment_status) "
                + "VALUES (?, ?, ?, ?)";


            PreparedStatement paymentStatement =
                con.prepareStatement(
                    paymentSQL
                );


            paymentStatement.setInt(
                1,
                orderId
            );


            paymentStatement.setString(
                2,
                "ORDER CONFIRMATION"
            );


            paymentStatement.setDouble(
                3,
                total
            );


            paymentStatement.setString(
                4,
                "CONFIRMED"
            );


            paymentStatement.executeUpdate();


            paymentStatement.close();


            // =================================================
            // SEND ORDER TO KITCHEN
            // =================================================

            String kitchenSQL =
                "INSERT INTO kitchen_orders "
                + "(order_id, kitchen_status) "
                + "VALUES (?, ?)";


            PreparedStatement kitchenStatement =
                con.prepareStatement(
                    kitchenSQL
                );


            kitchenStatement.setInt(
                1,
                orderId
            );


            kitchenStatement.setString(
                2,
                "WAITING"
            );


            kitchenStatement.executeUpdate();


            kitchenStatement.close();


            // =================================================
            // COMMIT TRANSACTION
            // =================================================

            con.commit();

            con.close();


            // =================================================
            // CLEAR CART
            // =================================================

            CartManager
                .getCart()
                .clear();


            // =================================================
            // OPEN BILL
            // =================================================

            OrderBill bill =
                new OrderBill(
                    orderId,
                    customerName,
                    tableNumber,
                    total
                );


            bill.setVisible(
                true
            );


            dispose();


        } catch (
            SQLException ex
        ) {

            try {

                if (
                    con != null
                ) {

                    con.rollback();
                }

            } catch (
                SQLException rollbackException
            ) {

                // Rollback failed.
            }


            if (
                con != null
            ) {

                try {

                    con.close();

                } catch (
                    SQLException closeException
                ) {

                    // Close failed.
                }
            }


            showError(
                "Unable to confirm the order.\n\n"
                + ex.getMessage()
            );
        }
    }


    // =========================================================
    // ERROR MESSAGE
    // =========================================================

    private void showError(
        String message
    ) {

        JOptionPane.showMessageDialog(
            this,
            message,
            "TAMIL KUDIL",
            JOptionPane.WARNING_MESSAGE
        );
    }


    // =========================================================
    // ROUNDED PANEL
    // =========================================================

    private static class RoundedPanel
        extends JPanel {

        private Color color;

        private int radius;


        public RoundedPanel(
            Color color,
            int radius
        ) {

            this.color =
                color;

            this.radius =
                radius;

            setOpaque(false);
        }


        @Override
        protected void paintComponent(
            Graphics g
        ) {

            Graphics2D g2 =
                (Graphics2D) g.create();


            g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
            );


            g2.setColor(
                color
            );


            g2.fillRoundRect(
                0,
                0,
                getWidth(),
                getHeight(),
                radius,
                radius
            );


            g2.dispose();


            super.paintComponent(
                g
            );
        }
    }


    // =========================================================
    // MAIN
    // =========================================================

    public static void main(
        String[] args
    ) {

        SwingUtilities.invokeLater(
            new Runnable() {

                public void run() {

                    CustomerDetails page =
                        new CustomerDetails();

                    page.setVisible(
                        true
                    );
                }
            }
        );
    }
}