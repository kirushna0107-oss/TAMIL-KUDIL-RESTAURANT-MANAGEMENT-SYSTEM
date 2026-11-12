import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.*;

public class KitchenDashboard extends JFrame {

    private JPanel ordersPanel;

    private JLabel waitingCount;
    private JLabel preparingCount;
    private JLabel readyCount;
    private JLabel completedCount;

    // =========================================================
    // COLOUR PALETTE
    // =========================================================

    private final Color COFFEE = new Color(78, 48, 32);
    private final Color DARK_BROWN = new Color(55, 35, 25);
    private final Color TEXT_BROWN = new Color(105, 78, 58);

    private final Color CARAMEL = new Color(196, 137, 76);

    private final Color IVORY = new Color(250, 247, 240);
    private final Color CREAM = new Color(247, 241, 232);
    private final Color WHITE = Color.WHITE;

    private final Color BORDER = new Color(224, 208, 190);

    // WAITING
    private final Color WAITING = new Color(184, 123, 48);
    private final Color WAITING_BG = new Color(252, 245, 232);

    // PREPARING
    private final Color PREPARING = new Color(196, 137, 76);
    private final Color PREPARING_BG = new Color(250, 239, 224);

    // READY
    private final Color READY = new Color(72, 128, 79);
    private final Color READY_BG = new Color(236, 246, 237);

    // COMPLETED - NAVY BLUE
    private final Color NAVY = new Color(31, 55, 86);
    private final Color NAVY_LIGHT = new Color(235, 241, 248);

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public KitchenDashboard() {

        setTitle(
                "TAMIL KUDIL - Kitchen Dashboard"
        );

        setSize(
                1200,
                850
        );

        setMinimumSize(
                new Dimension(
                        1000,
                        700
                )
        );

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        buildUI();

        loadOrders();
    }

    // =========================================================
    // BUILD UI
    // =========================================================

    private void buildUI() {

        JPanel main =
                new JPanel(
                        new BorderLayout()
                );

        main.setBackground(IVORY);

        // =====================================================
        // HEADER
        // =====================================================

        JPanel header =
                new JPanel(
                        new BorderLayout()
                );

        header.setBackground(COFFEE);

        header.setBorder(
                new EmptyBorder(
                        22,
                        32,
                        22,
                        32
                )
        );

        // -----------------------------------------------------
        // HEADER LEFT
        // -----------------------------------------------------

        JPanel titleArea =
                new JPanel();

        titleArea.setLayout(
                new BoxLayout(
                        titleArea,
                        BoxLayout.Y_AXIS
                )
        );

        titleArea.setBackground(COFFEE);

        JLabel logo =
                new JLabel(
                        "TAMIL KUDIL"
                );

        logo.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        32
                )
        );

        logo.setForeground(
                Color.WHITE
        );

        JLabel system =
                new JLabel(
                        "SMART KITCHEN MANAGEMENT SYSTEM"
                );

        system.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        12
                )
        );

        system.setForeground(
                new Color(
                        245,
                        225,
                        195
                )
        );

        JLabel section =
                new JLabel(
                        "KITCHEN CONTROL CENTER"
                );

        section.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        14
                )
        );

        section.setForeground(
                CARAMEL
        );

        titleArea.add(logo);

        titleArea.add(
                Box.createVerticalStrut(3)
        );

        titleArea.add(system);

        titleArea.add(
                Box.createVerticalStrut(9)
        );

        titleArea.add(section);

        header.add(
                titleArea,
                BorderLayout.WEST
        );

        // -----------------------------------------------------
        // HEADER RIGHT
        // -----------------------------------------------------

        JPanel headerRight =
                new JPanel();

        headerRight.setLayout(
                new BoxLayout(
                        headerRight,
                        BoxLayout.Y_AXIS
                )
        );

        headerRight.setBackground(COFFEE);

        JLabel live =
                new JLabel(
                        "●  LIVE KITCHEN"
                );

        live.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        12
                )
        );

        live.setForeground(
                new Color(
                        214,
                        230,
                        190
                )
        );

        live.setAlignmentX(
                Component.RIGHT_ALIGNMENT
        );

        JButton refresh =
                new JButton(
                        "↻  REFRESH ORDERS"
                );

        refresh.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        13
                )
        );

        refresh.setForeground(
                Color.WHITE
        );

        refresh.setBackground(
                CARAMEL
        );

        refresh.setFocusPainted(false);

        refresh.setBorder(
                new EmptyBorder(
                        12,
                        24,
                        12,
                        24
                )
        );

        refresh.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        refresh.setAlignmentX(
                Component.RIGHT_ALIGNMENT
        );

        refresh.addActionListener(
                e -> loadOrders()
        );

        headerRight.add(live);

        headerRight.add(
                Box.createVerticalStrut(10)
        );

        headerRight.add(refresh);

        header.add(
                headerRight,
                BorderLayout.EAST
        );

        main.add(
                header,
                BorderLayout.NORTH
        );

        // =====================================================
        // BODY
        // =====================================================

        JPanel body =
                new JPanel(
                        new BorderLayout()
                );

        body.setBackground(IVORY);

        body.setBorder(
                new EmptyBorder(
                        22,
                        28,
                        24,
                        28
                )
        );

        // =====================================================
        // TITLE SECTION
        // =====================================================

        JPanel titleSection =
                new JPanel(
                        new BorderLayout()
                );

        titleSection.setBackground(IVORY);

        JPanel titleText =
                new JPanel();

        titleText.setLayout(
                new BoxLayout(
                        titleText,
                        BoxLayout.Y_AXIS
                )
        );

        titleText.setBackground(IVORY);

        JLabel heading =
                new JLabel(
                        "Today's Kitchen Orders"
                );

        heading.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        26
                )
        );

        heading.setForeground(
                DARK_BROWN
        );

        JLabel description =
                new JLabel(
                        "Manage confirmed orders from preparation to completion"
                );

        description.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        12
                )
        );

        description.setForeground(
                TEXT_BROWN
        );

        titleText.add(heading);

        titleText.add(
                Box.createVerticalStrut(4)
        );

        titleText.add(description);

        titleSection.add(
                titleText,
                BorderLayout.WEST
        );

        body.add(
                titleSection,
                BorderLayout.NORTH
        );

        // =====================================================
        // CENTER
        // =====================================================

        JPanel center =
                new JPanel(
                        new BorderLayout()
                );

        center.setBackground(IVORY);

        center.setBorder(
                new EmptyBorder(
                        18,
                        0,
                        0,
                        0
                )
        );

        // =====================================================
        // STATUS SUMMARY
        // =====================================================

        JPanel statusPanel =
                new JPanel(
                        new GridLayout(
                                1,
                                4,
                                14,
                                0
                        )
                );

        statusPanel.setBackground(IVORY);

        waitingCount =
                createStatusCard(
                        statusPanel,
                        "WAITING",
                        "Orders waiting",
                        WAITING,
                        WAITING_BG
                );

        preparingCount =
                createStatusCard(
                        statusPanel,
                        "PREPARING",
                        "Currently cooking",
                        PREPARING,
                        PREPARING_BG
                );

        readyCount =
                createStatusCard(
                        statusPanel,
                        "READY",
                        "Ready to serve",
                        READY,
                        READY_BG
                );

        completedCount =
                createStatusCard(
                        statusPanel,
                        "COMPLETED",
                        "Finished orders",
                        NAVY,
                        NAVY_LIGHT
                );

        center.add(
                statusPanel,
                BorderLayout.NORTH
        );

        // =====================================================
        // ORDERS PANEL
        // =====================================================

        ordersPanel =
                new JPanel();

        ordersPanel.setLayout(
                new BoxLayout(
                        ordersPanel,
                        BoxLayout.Y_AXIS
                )
        );

        ordersPanel.setBackground(
                new Color(
                        246,
                        241,
                        234
                )
        );

        ordersPanel.setBorder(
                new EmptyBorder(
                        18,
                        12,
                        18,
                        12
                )
        );

        // =====================================================
        // MAIN SCROLL PANE
        // =====================================================

        JScrollPane scroll =
                new JScrollPane(
                        ordersPanel
                );

        scroll.setBorder(
                BorderFactory.createLineBorder(
                        BORDER
                )
        );

        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );

        // Make the main scrollbar easier to use.

        JScrollBar verticalBar =
                scroll.getVerticalScrollBar();

        verticalBar.setUnitIncrement(
                18
        );

        verticalBar.setBlockIncrement(
                120
        );

        verticalBar.setPreferredSize(
                new Dimension(
                        18,
                        0
                )
        );

        center.add(
                scroll,
                BorderLayout.CENTER
        );

        body.add(
                center,
                BorderLayout.CENTER
        );

        main.add(
                body,
                BorderLayout.CENTER
        );

        setContentPane(main);
    }

    // =========================================================
    // STATUS CARD
    // =========================================================

    private JLabel createStatusCard(
            JPanel parent,
            String title,
            String description,
            Color accent,
            Color background) {

        JPanel card =
                new JPanel(
                        new BorderLayout()
                );

        card.setBackground(
                background
        );

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                15,
                                18,
                                15,
                                18
                        )
                )
        );

        // =====================================================
        // ACCENT BAR
        // =====================================================

        JPanel bar =
                new JPanel();

        bar.setBackground(
                accent
        );

        bar.setPreferredSize(
                new Dimension(
                        7,
                        78
                )
        );

        card.add(
                bar,
                BorderLayout.WEST
        );

        // =====================================================
        // TEXT AREA
        // =====================================================

        JPanel textWrapper =
                new JPanel(
                        new BorderLayout()
                );

        textWrapper.setBackground(
                background
        );

        // Proper distance from accent bar.

        textWrapper.setBorder(
                new EmptyBorder(
                        0,
                        16,
                        0,
                        0
                )
        );

        JPanel text =
                new JPanel();

        text.setLayout(
                new BoxLayout(
                        text,
                        BoxLayout.Y_AXIS
                )
        );

        text.setBackground(
                background
        );

        // =====================================================
        // STATUS TITLE - 15PX
        // =====================================================

        JLabel titleLabel =
                new JLabel(
                        title
                );

        titleLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        15
                )
        );

        titleLabel.setForeground(
                DARK_BROWN
        );

        // =====================================================
        // NUMBER
        // =====================================================

        JLabel number =
                new JLabel(
                        "0"
                );

        number.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        30
                )
        );

        number.setForeground(
                accent
        );

        // =====================================================
        // DESCRIPTION
        // =====================================================

        JLabel descriptionLabel =
                new JLabel(
                        description
                );

        descriptionLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        11
                )
        );

        descriptionLabel.setForeground(
                TEXT_BROWN
        );

        // =====================================================
        // VERTICAL SPACING
        // =====================================================

        text.add(
                titleLabel
        );

        text.add(
                Box.createVerticalStrut(3)
        );

        text.add(
                number
        );

        text.add(
                Box.createVerticalStrut(2)
        );

        text.add(
                descriptionLabel
        );

        textWrapper.add(
                text,
                BorderLayout.CENTER
        );

        card.add(
                textWrapper,
                BorderLayout.CENTER
        );

        parent.add(
                card
        );

        return number;
    }

    // =========================================================
    // LOAD ORDERS
    // =========================================================

    private void loadOrders() {

        ordersPanel.removeAll();

        int waiting = 0;
        int preparing = 0;
        int ready = 0;
        int completed = 0;

        String sql =
                "SELECT ko.kitchen_order_id, " +
                "ko.order_id, " +
                "ko.kitchen_status, " +
                "c.customer_name, " +
                "c.table_number, " +
                "o.total_amount " +
                "FROM kitchen_orders ko " +
                "JOIN orders o " +
                "ON ko.order_id = o.order_id " +
                "JOIN customer c " +
                "ON o.customer_id = c.customer_id " +
                "WHERE o.order_status IN " +
                "('CONFIRMED','PREPARING','READY','COMPLETED') " +
                "ORDER BY ko.kitchen_order_id DESC";

        try (
                Connection con =
                        DBConnection.getConnection();

                PreparedStatement ps =
                        con.prepareStatement(sql);

                ResultSet rs =
                        ps.executeQuery()
        ) {

            boolean found = false;

            while (rs.next()) {

                found = true;

                int kitchenOrderId =
                        rs.getInt(
                                "kitchen_order_id"
                        );

                int orderId =
                        rs.getInt(
                                "order_id"
                        );

                String status =
                        rs.getString(
                                "kitchen_status"
                        );

                String customerName =
                        rs.getString(
                                "customer_name"
                        );

                int tableNumber =
                        rs.getInt(
                                "table_number"
                        );

                double total =
                        rs.getDouble(
                                "total_amount"
                        );

                if (status == null) {
                    status = "WAITING";
                }

                status =
                        status.toUpperCase();

                if (status.equals("WAITING")) {
                    waiting++;
                }

                if (status.equals("PREPARING")) {
                    preparing++;
                }

                if (status.equals("READY")) {
                    ready++;
                }

                if (status.equals("COMPLETED")) {
                    completed++;
                }

                addOrderCard(
                        kitchenOrderId,
                        orderId,
                        status,
                        customerName,
                        tableNumber,
                        total
                );
            }

            if (!found) {
                showEmptyMessage();
            }

        } catch (SQLException e) {

            showDatabaseError(
                    e.getMessage()
            );
        }

        waitingCount.setText(
                String.valueOf(waiting)
        );

        preparingCount.setText(
                String.valueOf(preparing)
        );

        readyCount.setText(
                String.valueOf(ready)
        );

        completedCount.setText(
                String.valueOf(completed)
        );

        ordersPanel.revalidate();
        ordersPanel.repaint();
    }

    // =========================================================
    // ORDER CARD
    // =========================================================

    private void addOrderCard(
            int kitchenOrderId,
            int orderId,
            String status,
            String customerName,
            int tableNumber,
            double total) {

        JPanel outer =
                new JPanel(
                        new BorderLayout()
                );

        outer.setBackground(
                new Color(
                        246,
                        241,
                        234
                )
        );

        outer.setBorder(
                new EmptyBorder(
                        0,
                        2,
                        16,
                        2
                )
        );

        JPanel card =
                new JPanel(
                        new BorderLayout()
                );

        card.setBackground(
                WHITE
        );

        card.setBorder(
                BorderFactory.createLineBorder(
                        BORDER,
                        1
                )
        );

        // =====================================================
        // STATUS STRIP
        // =====================================================

        JPanel strip =
                new JPanel();

        strip.setBackground(
                getStatusColor(status)
        );

        strip.setPreferredSize(
                new Dimension(
                        10,
                        7
                )
        );

        card.add(
                strip,
                BorderLayout.NORTH
        );

        // =====================================================
        // CARD CONTENT
        // =====================================================

        JPanel content =
                new JPanel(
                        new BorderLayout()
                );

        content.setBackground(
                WHITE
        );

        content.setBorder(
                new EmptyBorder(
                        18,
                        20,
                        18,
                        20
                )
        );

        // =====================================================
        // ORDER HEADER
        // =====================================================

        JPanel orderHeader =
                new JPanel(
                        new BorderLayout()
                );

        orderHeader.setBackground(
                WHITE
        );

        JPanel customerArea =
                new JPanel();

        customerArea.setLayout(
                new BoxLayout(
                        customerArea,
                        BoxLayout.Y_AXIS
                )
        );

        customerArea.setBackground(
                WHITE
        );

        JLabel orderNumber =
                new JLabel(
                        "ORDER #" + orderId
                );

        orderNumber.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        24
                )
        );

        orderNumber.setForeground(
                DARK_BROWN
        );

        JLabel customerLabel =
                new JLabel(
                        customerName +
                        "   •   TABLE " +
                        tableNumber
                );

        customerLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        13
                )
        );

        customerLabel.setForeground(
                TEXT_BROWN
        );

        customerArea.add(
                orderNumber
        );

        customerArea.add(
                Box.createVerticalStrut(5)
        );

        customerArea.add(
                customerLabel
        );

        orderHeader.add(
                customerArea,
                BorderLayout.WEST
        );

        // =====================================================
        // STATUS BADGE
        // =====================================================

        JPanel statusBadge =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                18,
                                10
                        )
                );

        statusBadge.setBackground(
                getStatusColor(status)
        );

        JLabel statusText =
                new JLabel(
                        status
                );

        statusText.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        12
                )
        );

        statusText.setForeground(
                Color.WHITE
        );

        statusBadge.add(
                statusText
        );

        orderHeader.add(
                statusBadge,
                BorderLayout.EAST
        );

        content.add(
                orderHeader,
                BorderLayout.NORTH
        );

        // =====================================================
        // ORDER ITEMS
        // NO INNER SCROLLBAR
        // =====================================================

        JPanel itemsContainer =
                new JPanel(
                        new BorderLayout()
                );

        itemsContainer.setBackground(
                CREAM
        );

        itemsContainer.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                12,
                                14,
                                12,
                                14
                        )
                )
        );

        JLabel itemsTitle =
                new JLabel(
                        "ORDER ITEMS"
                );

        itemsTitle.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        11
                )
        );

        itemsTitle.setForeground(
                TEXT_BROWN
        );

        itemsContainer.add(
                itemsTitle,
                BorderLayout.NORTH
        );

        // =====================================================
        // ITEM LIST
        // =====================================================

        JPanel itemList =
                new JPanel();

        itemList.setLayout(
                new BoxLayout(
                        itemList,
                        BoxLayout.Y_AXIS
                )
        );

        itemList.setBackground(
                CREAM
        );

        loadItemsForOrder(
                itemList,
                orderId
        );

        itemsContainer.add(
                itemList,
                BorderLayout.CENTER
        );

        JPanel middle =
                new JPanel(
                        new BorderLayout()
                );

        middle.setBackground(
                WHITE
        );

        middle.setBorder(
                new EmptyBorder(
                        15,
                        0,
                        15,
                        0
                )
        );

        middle.add(
                itemsContainer,
                BorderLayout.CENTER
        );

        content.add(
                middle,
                BorderLayout.CENTER
        );

        // =====================================================
        // BOTTOM SECTION
        // =====================================================

        JPanel bottom =
                new JPanel(
                        new BorderLayout()
                );

        bottom.setBackground(
                WHITE
        );

        // -----------------------------------------------------
        // TOTAL
        // -----------------------------------------------------

        JPanel totalArea =
                new JPanel();

        totalArea.setLayout(
                new BoxLayout(
                        totalArea,
                        BoxLayout.Y_AXIS
                )
        );

        totalArea.setBackground(
                WHITE
        );

        JLabel totalTitle =
                new JLabel(
                        "ORDER TOTAL"
                );

        totalTitle.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        10
                )
        );

        totalTitle.setForeground(
                TEXT_BROWN
        );

        JLabel totalValue =
                new JLabel(
                        String.format(
                                "₹ %.2f",
                                total
                        )
                );

        totalValue.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        22
                )
        );

        totalValue.setForeground(
                COFFEE
        );

        totalArea.add(
                totalTitle
        );

        totalArea.add(
                Box.createVerticalStrut(2)
        );

        totalArea.add(
                totalValue
        );

        bottom.add(
                totalArea,
                BorderLayout.WEST
        );

        // -----------------------------------------------------
        // ACTION
        // -----------------------------------------------------

        JPanel actionArea =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                0,
                                4
                        )
                );

        actionArea.setBackground(
                WHITE
        );

        addStatusButtons(
                actionArea,
                kitchenOrderId,
                orderId,
                status
        );

        bottom.add(
                actionArea,
                BorderLayout.EAST
        );

        content.add(
                bottom,
                BorderLayout.SOUTH
        );

        card.add(
                content,
                BorderLayout.CENTER
        );

        outer.add(
                card,
                BorderLayout.CENTER
        );

        ordersPanel.add(
                outer
        );
    }

    // =========================================================
    // LOAD ORDER ITEMS
    // =========================================================

    private void loadItemsForOrder(
            JPanel panel,
            int orderId) {

        String sql =
                "SELECT f.food_name, " +
                "oi.quantity " +
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

                String food =
                        rs.getString(
                                "food_name"
                        );

                int quantity =
                        rs.getInt(
                                "quantity"
                        );

                JPanel row =
                        new JPanel(
                                new BorderLayout()
                        );

                row.setBackground(
                        CREAM
                );

                row.setBorder(
                        new EmptyBorder(
                                5,
                                0,
                                5,
                                0
                        )
                );

                JLabel foodLabel =
                        new JLabel(
                                "•  " + food
                        );

                foodLabel.setFont(
                        new Font(
                                "SansSerif",
                                Font.BOLD,
                                13
                        )
                );

                foodLabel.setForeground(
                        DARK_BROWN
                );

                JLabel quantityLabel =
                        new JLabel(
                                "× " + quantity
                        );

                quantityLabel.setFont(
                        new Font(
                                "SansSerif",
                                Font.BOLD,
                                13
                        )
                );

                quantityLabel.setForeground(
                        COFFEE
                );

                row.add(
                        foodLabel,
                        BorderLayout.WEST
                );

                row.add(
                        quantityLabel,
                        BorderLayout.EAST
                );

                panel.add(
                        row
                );
            }

            if (!found) {

                JLabel none =
                        new JLabel(
                                "No items found"
                        );

                none.setFont(
                        new Font(
                                "SansSerif",
                                Font.PLAIN,
                                12
                        )
                );

                none.setForeground(
                        TEXT_BROWN
                );

                panel.add(
                        none
                );
            }

            rs.close();

        } catch (SQLException e) {

            JLabel error =
                    new JLabel(
                            "Unable to load order items"
                    );

            error.setForeground(
                    Color.RED
            );

            panel.add(
                    error
            );
        }
    }

    // =========================================================
    // STATUS BUTTONS
    // =========================================================

    private void addStatusButtons(
            JPanel panel,
            int kitchenOrderId,
            int orderId,
            String status) {

        if (status.equals("WAITING")) {

            JButton button =
                    createActionButton(
                            "START PREPARING",
                            PREPARING
                    );

            button.addActionListener(
                    e -> updateStatus(
                            kitchenOrderId,
                            orderId,
                            "PREPARING"
                    )
            );

            panel.add(
                    button
            );

        } else if (
                status.equals("PREPARING")) {

            JButton button =
                    createActionButton(
                            "MARK READY",
                            READY
                    );

            button.addActionListener(
                    e -> updateStatus(
                            kitchenOrderId,
                            orderId,
                            "READY"
                    )
            );

            panel.add(
                    button
            );

        } else if (
                status.equals("READY")) {

            JButton button =
                    createActionButton(
                            "COMPLETE ORDER",
                            NAVY
                    );

            button.addActionListener(
                    e -> updateStatus(
                            kitchenOrderId,
                            orderId,
                            "COMPLETED"
                    )
            );

            panel.add(
                    button
            );

        } else {

            JPanel completedPanel =
                    new JPanel(
                            new FlowLayout(
                                    FlowLayout.CENTER,
                                    10,
                                    7
                            )
                    );

            completedPanel.setBackground(
                    NAVY_LIGHT
            );

            completedPanel.setBorder(
                    BorderFactory.createLineBorder(
                            new Color(
                                    200,
                                    212,
                                    228
                            )
                    )
            );

            JLabel completed =
                    new JLabel(
                            "✓  ORDER COMPLETED"
                    );

            completed.setFont(
                    new Font(
                            "SansSerif",
                            Font.BOLD,
                            12
                    )
            );

            completed.setForeground(
                    NAVY
            );

            completedPanel.add(
                    completed
            );

            panel.add(
                    completedPanel
            );
        }
    }

    // =========================================================
    // ACTION BUTTON
    // =========================================================

    private JButton createActionButton(
            String text,
            Color color) {

        JButton button =
                new JButton(
                        text
                );

        button.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        12
                )
        );

        button.setForeground(
                Color.WHITE
        );

        button.setBackground(
                color
        );

        button.setFocusPainted(false);

        button.setBorder(
                new EmptyBorder(
                        12,
                        22,
                        12,
                        22
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        return button;
    }

    // =========================================================
    // UPDATE STATUS
    // =========================================================

    private void updateStatus(
            int kitchenOrderId,
            int orderId,
            String newStatus) {

        String kitchenSQL =
                "UPDATE kitchen_orders " +
                "SET kitchen_status = ?, " +
                "completed_time = " +
                "CASE WHEN ? = 'COMPLETED' " +
                "THEN CURRENT_TIMESTAMP " +
                "ELSE completed_time END " +
                "WHERE kitchen_order_id = ?";

        String orderSQL =
                "UPDATE orders " +
                "SET order_status = ? " +
                "WHERE order_id = ?";

        try (
                Connection con =
                        DBConnection.getConnection();

                PreparedStatement kitchenPS =
                        con.prepareStatement(
                                kitchenSQL
                        );

                PreparedStatement orderPS =
                        con.prepareStatement(
                                orderSQL
                        )
        ) {

            con.setAutoCommit(false);

            kitchenPS.setString(
                    1,
                    newStatus
            );

            kitchenPS.setString(
                    2,
                    newStatus
            );

            kitchenPS.setInt(
                    3,
                    kitchenOrderId
            );

            kitchenPS.executeUpdate();

            orderPS.setString(
                    1,
                    newStatus
            );

            orderPS.setInt(
                    2,
                    orderId
            );

            orderPS.executeUpdate();

            con.commit();

            loadOrders();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Unable to update order status.\n\n"
                    + e.getMessage(),
                    "Kitchen Update Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =========================================================
    // STATUS COLOUR
    // =========================================================

    private Color getStatusColor(
            String status) {

        if (status.equals("WAITING")) {
            return WAITING;
        }

        if (status.equals("PREPARING")) {
            return PREPARING;
        }

        if (status.equals("READY")) {
            return READY;
        }

        return NAVY;
    }

    // =========================================================
    // EMPTY STATE
    // =========================================================

    private void showEmptyMessage() {

        JPanel empty =
                new JPanel();

        empty.setLayout(
                new BoxLayout(
                        empty,
                        BoxLayout.Y_AXIS
                )
        );

        empty.setBackground(
                new Color(
                        246,
                        241,
                        234
                )
        );

        JLabel icon =
                new JLabel(
                        "✓"
                );

        icon.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        48
                )
        );

        icon.setForeground(
                READY
        );

        icon.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel title =
                new JLabel(
                        "Kitchen is All Clear"
                );

        title.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        24
                )
        );

        title.setForeground(
                DARK_BROWN
        );

        title.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel message =
                new JLabel(
                        "Confirmed orders will appear here."
                );

        message.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        13
                )
        );

        message.setForeground(
                TEXT_BROWN
        );

        message.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        empty.add(
                Box.createVerticalStrut(
                        60
                )
        );

        empty.add(icon);

        empty.add(
                Box.createVerticalStrut(
                        10
                )
        );

        empty.add(title);

        empty.add(
                Box.createVerticalStrut(
                        6
                )
        );

        empty.add(message);

        ordersPanel.add(
                empty
        );
    }

    // =========================================================
    // DATABASE ERROR
    // =========================================================

    private void showDatabaseError(
            String message) {

        JLabel error =
                new JLabel(
                        "<html><center>"
                        + "Unable to load kitchen orders."
                        + "<br><br>"
                        + message
                        + "</center></html>"
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

        ordersPanel.add(
                error
        );
    }

    // =========================================================
    // TEST MAIN
    // =========================================================

    public static void main(
            String[] args) {

        SwingUtilities.invokeLater(
                () -> {

                    KitchenDashboard dashboard =
                            new KitchenDashboard();

                    dashboard.setVisible(true);
                }
        );
    }
}