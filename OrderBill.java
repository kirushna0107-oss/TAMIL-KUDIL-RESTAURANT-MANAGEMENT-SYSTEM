import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.*;

public class OrderBill extends JFrame {

    private int orderId;
    private String customerName;
    private int tableNumber;
    private double totalAmount;

    private JPanel itemsPanel;

    // ================= COLORS =================

    private final Color COFFEE = new Color(78, 48, 32);
    private final Color DARK_BROWN = new Color(55, 35, 25);
    private final Color CARAMEL = new Color(196, 137, 76);
    private final Color IVORY = new Color(250, 247, 240);
    private final Color WHITE = Color.WHITE;
    private final Color LIGHT_BROWN = new Color(225, 213, 198);
    private final Color GREEN = new Color(46, 125, 50);

    // ================= CONSTRUCTOR =================

    public OrderBill(int orderId,
                     String customerName,
                     int tableNumber,
                     double totalAmount) {

        this.orderId = orderId;
        this.customerName = customerName;
        this.tableNumber = tableNumber;
        this.totalAmount = totalAmount;

        setTitle("TAMIL KUDIL - Order Receipt");

        // Slightly taller so YOUR ORDER gets more space
        setSize(760, 850);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        buildUI();
        loadOrderItems();
    }

    // ================= MAIN UI =================

    private void buildUI() {

        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(IVORY);

        // =====================================================
        // HEADER
        // =====================================================

        JPanel header = new JPanel();

        header.setLayout(
                new BoxLayout(
                        header,
                        BoxLayout.Y_AXIS
                )
        );

        header.setBackground(COFFEE);

        header.setBorder(
                new EmptyBorder(
                        22, 30, 20, 30
                )
        );

        JLabel title = new JLabel(
                "TAMIL KUDIL"
        );

        title.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        32
                )
        );

        title.setForeground(Color.WHITE);

        title.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel subtitle = new JLabel(
                "Smart Kitchen Management System"
        );

        subtitle.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        14
                )
        );

        subtitle.setForeground(
                new Color(245, 225, 195)
        );

        subtitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel receipt = new JLabel(
                "ORDER RECEIPT"
        );

        receipt.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        19
                )
        );

        receipt.setForeground(CARAMEL);

        receipt.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        header.add(title);

        header.add(
                Box.createVerticalStrut(4)
        );

        header.add(subtitle);

        header.add(
                Box.createVerticalStrut(10)
        );

        header.add(receipt);

        main.add(
                header,
                BorderLayout.NORTH
        );

        // =====================================================
        // OUTER CONTENT
        // =====================================================

        JPanel outer = new JPanel(
                new BorderLayout()
        );

        outer.setBackground(IVORY);

        outer.setBorder(
                new EmptyBorder(
                        18, 40, 18, 40
                )
        );

        JPanel content = new JPanel();

        content.setLayout(
                new BoxLayout(
                        content,
                        BoxLayout.Y_AXIS
                )
        );

        content.setBackground(IVORY);

        // =====================================================
        // CUSTOMER INFORMATION - SMALLER
        // =====================================================

        JPanel infoCard = new JPanel(
                new GridLayout(
                        2, 4, 20, 10
                )
        );

        infoCard.setBackground(WHITE);

        infoCard.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                LIGHT_BROWN,
                                1
                        ),
                        new EmptyBorder(
                                12, 18, 12, 18
                        )
                )
        );

        infoCard.setMaximumSize(
                new Dimension(680, 105)
        );

        addInfo(
                infoCard,
                "ORDER ID",
                "#" + orderId
        );

        addInfo(
                infoCard,
                "CUSTOMER",
                customerName
        );

        addInfo(
                infoCard,
                "TABLE",
                String.valueOf(tableNumber)
        );

        addInfo(
                infoCard,
                "STATUS",
                "CONFIRMED"
        );

        content.add(infoCard);

        content.add(
                Box.createVerticalStrut(13)
        );

        // =====================================================
        // YOUR ORDER TITLE
        // =====================================================

        JLabel itemsTitle = new JLabel(
                "YOUR ORDER"
        );

        itemsTitle.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        23
                )
        );

        itemsTitle.setForeground(
                DARK_BROWN
        );

        itemsTitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        content.add(itemsTitle);

        JLabel itemsSubtitle = new JLabel(
                "Items confirmed for preparation"
        );

        itemsSubtitle.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        12
                )
        );

        itemsSubtitle.setForeground(
                new Color(125, 100, 80)
        );

        itemsSubtitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        content.add(
                Box.createVerticalStrut(2)
        );

        content.add(itemsSubtitle);

        content.add(
                Box.createVerticalStrut(8)
        );

        // =====================================================
        // LARGE ORDER ITEMS BOX
        // =====================================================

        JPanel orderBox = new JPanel(
                new BorderLayout()
        );

        orderBox.setBackground(WHITE);

        orderBox.setBorder(
                BorderFactory.createLineBorder(
                        LIGHT_BROWN,
                        1
                )
        );

        // THIS IS THE IMPORTANT CHANGE
        // YOUR ORDER BOX IS NOW MUCH LARGER

        orderBox.setPreferredSize(
                new Dimension(680, 330)
        );

        orderBox.setMinimumSize(
                new Dimension(680, 250)
        );

        orderBox.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        330
                )
        );

        // =====================================================
        // TABLE HEADER
        // =====================================================

        JPanel tableHeader = new JPanel(
                new GridBagLayout()
        );

        tableHeader.setBackground(
                COFFEE
        );

        tableHeader.setBorder(
                new EmptyBorder(
                        11, 15, 11, 15
                )
        );

        GridBagConstraints h =
                new GridBagConstraints();

        h.fill =
                GridBagConstraints.HORIZONTAL;

        h.gridy = 0;

        JLabel itemHeader =
                createHeaderLabel("ITEM");

        JLabel qtyHeader =
                createHeaderLabel("QTY");

        JLabel priceHeader =
                createHeaderLabel("PRICE");

        JLabel amountHeader =
                createHeaderLabel("AMOUNT");

        h.gridx = 0;
        h.weightx = 0.45;

        tableHeader.add(
                itemHeader,
                h
        );

        h.gridx = 1;
        h.weightx = 0.15;

        tableHeader.add(
                qtyHeader,
                h
        );

        h.gridx = 2;
        h.weightx = 0.20;

        tableHeader.add(
                priceHeader,
                h
        );

        h.gridx = 3;
        h.weightx = 0.20;

        tableHeader.add(
                amountHeader,
                h
        );

        orderBox.add(
                tableHeader,
                BorderLayout.NORTH
        );

        // =====================================================
        // ITEMS PANEL
        // =====================================================

        itemsPanel = new JPanel();

        itemsPanel.setLayout(
                new BoxLayout(
                        itemsPanel,
                        BoxLayout.Y_AXIS
                )
        );

        itemsPanel.setBackground(
                WHITE
        );

        JScrollPane scrollPane =
                new JScrollPane(
                        itemsPanel
                );

        scrollPane.setBorder(null);

        scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );

        scrollPane.getVerticalScrollBar()
                .setUnitIncrement(16);

        orderBox.add(
                scrollPane,
                BorderLayout.CENTER
        );

        content.add(orderBox);

        content.add(
                Box.createVerticalStrut(12)
        );

        // =====================================================
        // TOTAL - SMALLER
        // =====================================================

        JPanel totalCard = new JPanel(
                new BorderLayout()
        );

        totalCard.setBackground(
                COFFEE
        );

        totalCard.setBorder(
                new EmptyBorder(
                        12, 22, 12, 22
                )
        );

        totalCard.setMaximumSize(
                new Dimension(
                        680,
                        62
                )
        );

        JLabel totalLabel = new JLabel(
                "TOTAL AMOUNT"
        );

        totalLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        14
                )
        );

        totalLabel.setForeground(
                Color.WHITE
        );

        JLabel totalValue = new JLabel(
                String.format(
                        "₹ %.2f",
                        totalAmount
                )
        );

        totalValue.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        25
                )
        );

        totalValue.setForeground(
                CARAMEL
        );

        totalCard.add(
                totalLabel,
                BorderLayout.WEST
        );

        totalCard.add(
                totalValue,
                BorderLayout.EAST
        );

        content.add(totalCard);

        content.add(
                Box.createVerticalStrut(9)
        );

        // =====================================================
        // KITCHEN CONFIRMATION - SMALLER
        // =====================================================

        JPanel kitchenCard = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        8,
                        9
                )
        );

        kitchenCard.setBackground(
                new Color(
                        239, 247, 239
                )
        );

        kitchenCard.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                180, 210, 180
                        )
                )
        );

        kitchenCard.setMaximumSize(
                new Dimension(
                        680,
                        43
                )
        );

        JLabel kitchenText = new JLabel(
                "✓  ORDER CONFIRMED & SENT TO KITCHEN"
        );

        kitchenText.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        13
                )
        );

        kitchenText.setForeground(
                GREEN
        );

        kitchenCard.add(
                kitchenText
        );

        content.add(kitchenCard);

        content.add(
                Box.createVerticalStrut(9)
        );

        // =====================================================
        // THANK YOU - SMALLER
        // =====================================================

        JPanel thankYouCard = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        0,
                        8
                )
        );

        thankYouCard.setBackground(
                CARAMEL
        );

        thankYouCard.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                170, 112, 55
                        ),
                        1
                )
        );

        thankYouCard.setMaximumSize(
                new Dimension(
                        680,
                        43
                )
        );

        JLabel thankYouText =
                new JLabel(
                        "Thank you!"
                );

        thankYouText.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        16
                )
        );

        thankYouText.setForeground(
                DARK_BROWN
        );

        thankYouCard.add(
                thankYouText
        );

        content.add(thankYouCard);

        content.add(
                Box.createVerticalStrut(9)
        );

        // =====================================================
        // DONE BUTTON - SMALLER
        // =====================================================

        JPanel buttonPanel = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        0,
                        0
                )
        );

        buttonPanel.setBackground(
                IVORY
        );

        buttonPanel.setMaximumSize(
                new Dimension(
                        680,
                        48
                )
        );

        JButton doneButton =
                new JButton("DONE");

        doneButton.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        14
                )
        );

        doneButton.setForeground(
                Color.WHITE
        );

        doneButton.setBackground(
                CARAMEL
        );

        doneButton.setFocusPainted(
                false
        );

        doneButton.setBorder(
                new EmptyBorder(
                        10, 50, 10, 50
                )
        );

        doneButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        doneButton.addActionListener(
                e -> dispose()
        );

        buttonPanel.add(
                doneButton
        );

        content.add(buttonPanel);

        // =====================================================
        // OUTER
        // =====================================================

        outer.add(
                content,
                BorderLayout.CENTER
        );

        main.add(
                outer,
                BorderLayout.CENTER
        );

        setContentPane(main);
    }

    // =========================================================
    // HEADER LABEL
    // =========================================================

    private JLabel createHeaderLabel(
            String text) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        12
                )
        );

        label.setForeground(
                Color.WHITE
        );

        label.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        return label;
    }

    // =========================================================
    // CUSTOMER INFORMATION
    // =========================================================

    private void addInfo(
            JPanel panel,
            String title,
            String value) {

        JPanel box = new JPanel();

        box.setLayout(
                new BoxLayout(
                        box,
                        BoxLayout.Y_AXIS
                )
        );

        box.setBackground(
                WHITE
        );

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        10
                )
        );

        titleLabel.setForeground(
                new Color(
                        130, 105, 85
                )
        );

        JLabel valueLabel =
                new JLabel(value);

        valueLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        14
                )
        );

        valueLabel.setForeground(
                DARK_BROWN
        );

        box.add(titleLabel);

        box.add(
                Box.createVerticalStrut(3)
        );

        box.add(valueLabel);

        panel.add(box);
    }

    // =========================================================
    // LOAD ORDER ITEMS
    // =========================================================

    private void loadOrderItems() {

        itemsPanel.removeAll();

        String sql =
                "SELECT f.food_name, " +
                "oi.quantity, " +
                "oi.price " +
                "FROM order_items oi " +
                "JOIN food f " +
                "ON oi.food_id = f.food_id " +
                "WHERE oi.order_id = ? " +
                "ORDER BY oi.order_item_id";

        try (
                Connection con =
                        DBConnection.getConnection();

                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setInt(
                    1,
                    orderId
            );

            ResultSet rs =
                    ps.executeQuery();

            boolean found = false;

            while (rs.next()) {

                found = true;

                String foodName =
                        rs.getString(
                                "food_name"
                        );

                int quantity =
                        rs.getInt(
                                "quantity"
                        );

                double price =
                        rs.getDouble(
                                "price"
                        );

                addFoodRow(
                        foodName,
                        quantity,
                        price
                );
            }

            if (!found) {

                JPanel emptyPanel =
                        new JPanel(
                                new FlowLayout(
                                        FlowLayout.CENTER
                                )
                        );

                emptyPanel.setBackground(
                        WHITE
                );

                JLabel empty =
                        new JLabel(
                                "No order items found."
                        );

                empty.setFont(
                        new Font(
                                "SansSerif",
                                Font.BOLD,
                                14
                        )
                );

                empty.setForeground(
                        DARK_BROWN
                );

                emptyPanel.add(empty);

                itemsPanel.add(
                        emptyPanel
                );
            }

            rs.close();

        } catch (SQLException e) {

            JLabel error =
                    new JLabel(
                            "Unable to load order items."
                    );

            error.setFont(
                    new Font(
                            "SansSerif",
                            Font.BOLD,
                            14
                    )
            );

            error.setForeground(
                    Color.RED
            );

            error.setHorizontalAlignment(
                    SwingConstants.CENTER
            );

            itemsPanel.add(error);

            System.out.println(
                    "Order items error: "
                    + e.getMessage()
            );
        }

        itemsPanel.revalidate();
        itemsPanel.repaint();
    }

    // =========================================================
    // FOOD ROW
    // =========================================================

    private void addFoodRow(
            String foodName,
            int quantity,
            double price) {

        double itemTotal =
                quantity * price;

        JPanel row =
                new JPanel(
                        new GridBagLayout()
                );

        row.setBackground(
                WHITE
        );

        row.setBorder(
                BorderFactory.createMatteBorder(
                        0,
                        0,
                        1,
                        0,
                        LIGHT_BROWN
                )
        );

        // Larger individual item rows
        row.setPreferredSize(
                new Dimension(
                        650,
                        62
                )
        );

        row.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        62
                )
        );

        GridBagConstraints c =
                new GridBagConstraints();

        c.fill =
                GridBagConstraints.HORIZONTAL;

        c.gridy = 0;

        c.insets =
                new Insets(
                        10,
                        10,
                        10,
                        10
                );

        // =====================================================
        // ITEM
        // =====================================================

        JLabel name =
                new JLabel(
                        foodName
                );

        name.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        14
                )
        );

        name.setForeground(
                DARK_BROWN
        );

        c.gridx = 0;
        c.weightx = 0.45;

        row.add(
                name,
                c
        );

        // =====================================================
        // QTY
        // =====================================================

        JLabel qty =
                new JLabel(
                        String.valueOf(
                                quantity
                        )
                );

        qty.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        13
                )
        );

        qty.setForeground(
                DARK_BROWN
        );

        qty.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        c.gridx = 1;
        c.weightx = 0.15;

        row.add(
                qty,
                c
        );

        // =====================================================
        // PRICE
        // =====================================================

        JLabel priceLabel =
                new JLabel(
                        String.format(
                                "₹ %.2f",
                                price
                        )
                );

        priceLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        13
                )
        );

        priceLabel.setForeground(
                new Color(
                        110, 85, 65
                )
        );

        priceLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        c.gridx = 2;
        c.weightx = 0.20;

        row.add(
                priceLabel,
                c
        );

        // =====================================================
        // AMOUNT
        // =====================================================

        JLabel amount =
                new JLabel(
                        String.format(
                                "₹ %.2f",
                                itemTotal
                        )
                );

        amount.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        14
                )
        );

        amount.setForeground(
                COFFEE
        );

        amount.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        c.gridx = 3;
        c.weightx = 0.20;

        row.add(
                amount,
                c
        );

        itemsPanel.add(row);
    }

    // =========================================================
    // TEST MAIN
    // =========================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> {

                    OrderBill bill =
                            new OrderBill(
                                    1,
                                    "Test Customer",
                                    5,
                                    250.00
                            );

                    bill.setVisible(true);
                }
        );
    }
}