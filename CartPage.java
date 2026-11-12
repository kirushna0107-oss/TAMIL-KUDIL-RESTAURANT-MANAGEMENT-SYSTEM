import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CartPage extends JFrame {

    // =========================================================
    // COLOURS
    // =========================================================

    private static final Color COFFEE =
        new Color(78, 49, 37);

    private static final Color DEEP_COFFEE =
        new Color(55, 34, 26);

    private static final Color CARAMEL =
        new Color(214, 166, 93);

    private static final Color PALE_GOLD =
        new Color(245, 224, 183);

    private static final Color IVORY =
        new Color(250, 247, 238);

    private static final Color CARD =
        new Color(255, 253, 247);

    private static final Color TEXT =
        new Color(58, 43, 35);

    private static final Color MUTED =
        new Color(128, 105, 88);

    private static final Color RED =
        new Color(170, 65, 55);


    // =========================================================
    // COMPONENTS
    // =========================================================

    private JPanel itemsPanel;

    private JLabel itemCountLabel;

    private JLabel subtotalLabel;

    private JLabel totalLabel;


    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public CartPage() {

        setTitle("TAMIL KUDIL - Your Cart");

        setSize(1180, 800);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE
        );

        buildInterface();

        refreshCart();
    }


    // =========================================================
    // BUILD INTERFACE
    // =========================================================

    private void buildInterface() {

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
                15,
                28,
                15,
                28
            )
        );


        // BRAND

        JPanel brand =
            new JPanel();

        brand.setOpaque(false);

        brand.setLayout(
            new BoxLayout(
                brand,
                BoxLayout.Y_AXIS
            )
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
                "YOUR CART  •  REVIEW YOUR ORDER"
            );

        subtitle.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                10
            )
        );

        subtitle.setForeground(
            PALE_GOLD
        );


        brand.add(title);

        brand.add(
            Box.createVerticalStrut(2)
        );

        brand.add(subtitle);


        header.add(
            brand,
            BorderLayout.WEST
        );


        // BACK BUTTON

        JButton backButton =
            createButton(
                "← BACK TO MENU",
                PALE_GOLD,
                DEEP_COFFEE
            );


        backButton.addActionListener(
            e -> openMenu()
        );


        header.add(
            backButton,
            BorderLayout.EAST
        );


        add(
            header,
            BorderLayout.NORTH
        );


        // =====================================================
        // MAIN
        // =====================================================

        JPanel main =
            new JPanel(
                new BorderLayout(
                    18,
                    18
                )
            );

        main.setBackground(
            IVORY
        );

        main.setBorder(
            BorderFactory.createEmptyBorder(
                22,
                25,
                22,
                25
            )
        );


        // =====================================================
        // LEFT SECTION
        // =====================================================

        JPanel left =
            new JPanel(
                new BorderLayout(
                    0,
                    12
                )
            );

        left.setOpaque(false);


        // TITLE

        JPanel titleRow =
            new JPanel(
                new BorderLayout()
            );

        titleRow.setOpaque(false);


        JLabel cartTitle =
            new JLabel(
                "YOUR ORDER"
            );

        cartTitle.setFont(
            new Font(
                "Serif",
                Font.BOLD,
                27
            )
        );

        cartTitle.setForeground(
            TEXT
        );


        itemCountLabel =
            new JLabel(
                "0 ITEMS"
            );

        itemCountLabel.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                12
            )
        );

        itemCountLabel.setForeground(
            CARAMEL
        );


        titleRow.add(
            cartTitle,
            BorderLayout.WEST
        );

        titleRow.add(
            itemCountLabel,
            BorderLayout.EAST
        );


        left.add(
            titleRow,
            BorderLayout.NORTH
        );


        // ITEMS

        itemsPanel =
            new JPanel();

        itemsPanel.setBackground(
            IVORY
        );

        itemsPanel.setLayout(
            new BoxLayout(
                itemsPanel,
                BoxLayout.Y_AXIS
            )
        );


        JScrollPane scrollPane =
            new JScrollPane(
                itemsPanel
            );

        scrollPane.setBorder(
            BorderFactory.createEmptyBorder()
        );

        scrollPane.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        scrollPane
            .getVerticalScrollBar()
            .setUnitIncrement(15);


        left.add(
            scrollPane,
            BorderLayout.CENTER
        );


        main.add(
            left,
            BorderLayout.CENTER
        );


        // =====================================================
        // SUMMARY
        // =====================================================

        JPanel summary =
            new RoundedPanel(
                CARD,
                28
            );

        summary.setPreferredSize(
            new Dimension(
                315,
                0
            )
        );

        summary.setBorder(
            BorderFactory.createEmptyBorder(
                22,
                22,
                22,
                22
            )
        );

        summary.setLayout(
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
                22
            )
        );

        summaryTitle.setForeground(
            TEXT
        );


        summaryTop.add(
            summaryTitle
        );

        summaryTop.add(
            Box.createVerticalStrut(22)
        );


        // SUBTOTAL

        JPanel subtotalRow =
            new JPanel(
                new BorderLayout()
            );

        subtotalRow.setOpaque(false);


        JLabel subtotalText =
            new JLabel(
                "Subtotal"
            );

        subtotalText.setFont(
            new Font(
                "SansSerif",
                Font.PLAIN,
                14
            )
        );

        subtotalText.setForeground(
            MUTED
        );


        subtotalLabel =
            new JLabel(
                "₹0.00"
            );

        subtotalLabel.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                14
            )
        );

        subtotalLabel.setForeground(
            TEXT
        );


        subtotalRow.add(
            subtotalText,
            BorderLayout.WEST
        );

        subtotalRow.add(
            subtotalLabel,
            BorderLayout.EAST
        );


        summaryTop.add(
            subtotalRow
        );

        summaryTop.add(
            Box.createVerticalStrut(18)
        );


        JSeparator separator =
            new JSeparator();

        separator.setForeground(
            PALE_GOLD
        );


        summaryTop.add(
            separator
        );

        summaryTop.add(
            Box.createVerticalStrut(18)
        );


        // TOTAL

        JPanel totalRow =
            new JPanel(
                new BorderLayout()
            );

        totalRow.setOpaque(false);


        JLabel totalText =
            new JLabel(
                "TOTAL"
            );

        totalText.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                18
            )
        );

        totalText.setForeground(
            TEXT
        );


        totalLabel =
            new JLabel(
                "₹0.00"
            );

        totalLabel.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                22
            )
        );

        totalLabel.setForeground(
            COFFEE
        );


        totalRow.add(
            totalText,
            BorderLayout.WEST
        );

        totalRow.add(
            totalLabel,
            BorderLayout.EAST
        );


        summaryTop.add(
            totalRow
        );


        summary.add(
            summaryTop,
            BorderLayout.NORTH
        );


        // =====================================================
        // CONFIRM BUTTON
        // =====================================================

        JButton confirmButton =
            createButton(
                "CONFIRM ORDER  →",
                COFFEE,
                Color.WHITE
            );


        confirmButton.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                13
            )
        );


        confirmButton.addActionListener(
            e -> confirmOrder()
        );


        summary.add(
            confirmButton,
            BorderLayout.SOUTH
        );


        main.add(
            summary,
            BorderLayout.EAST
        );


        add(
            main,
            BorderLayout.CENTER
        );
    }


    // =========================================================
    // REFRESH CART
    // =========================================================

    private void refreshCart() {

        itemsPanel.removeAll();


        ArrayList<CartManager.CartItem> cart =
            CartManager.getCart();


        int totalItems = 0;


        for (
            CartManager.CartItem item :
            cart
        ) {

            totalItems =
                totalItems
                + item.quantity;


            JPanel card =
                createItemCard(
                    item
                );


            itemsPanel.add(
                card
            );


            itemsPanel.add(
                Box.createVerticalStrut(12)
            );
        }


        itemCountLabel.setText(
            totalItems
            + (
                totalItems == 1
                ? " ITEM"
                : " ITEMS"
            )
        );


        double total =
            CartManager.getTotal();


        subtotalLabel.setText(
            String.format(
                "₹%.2f",
                total
            )
        );


        totalLabel.setText(
            String.format(
                "₹%.2f",
                total
            )
        );


        if (
            cart.size() == 0
        ) {

            showEmptyCart();
        }


        itemsPanel.revalidate();

        itemsPanel.repaint();
    }


    // =========================================================
    // ITEM CARD
    // =========================================================

    private JPanel createItemCard(
        CartManager.CartItem item
    ) {

        JPanel card =
            new RoundedPanel(
                CARD,
                25
            );


        card.setLayout(
            new BorderLayout(
                15,
                0
            )
        );


        card.setBorder(
            BorderFactory.createEmptyBorder(
                16,
                18,
                16,
                18
            )
        );


        // =====================================================
        // ITEM INFORMATION
        // =====================================================

        JPanel info =
            new JPanel();

        info.setOpaque(false);

        info.setLayout(
            new BoxLayout(
                info,
                BoxLayout.Y_AXIS
            )
        );


        JLabel itemName =
            new JLabel(
                item.foodName
            );

        itemName.setFont(
            new Font(
                "Serif",
                Font.BOLD,
                19
            )
        );

        itemName.setForeground(
            TEXT
        );


        JLabel eachPrice =
            new JLabel(
                String.format(
                    "₹%.2f each",
                    item.price
                )
            );

        eachPrice.setFont(
            new Font(
                "SansSerif",
                Font.PLAIN,
                12
            )
        );

        eachPrice.setForeground(
            MUTED
        );


        double itemTotal =
            item.price
            * item.quantity;


        JLabel itemTotalLabel =
            new JLabel(
                String.format(
                    "₹%.2f",
                    itemTotal
                )
            );

        itemTotalLabel.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                15
            )
        );

        itemTotalLabel.setForeground(
            CARAMEL
        );


        info.add(
            itemName
        );

        info.add(
            Box.createVerticalStrut(5)
        );

        info.add(
            eachPrice
        );

        info.add(
            Box.createVerticalStrut(8)
        );

        info.add(
            itemTotalLabel
        );


        card.add(
            info,
            BorderLayout.CENTER
        );


        // =====================================================
        // CONTROLS
        // =====================================================

        JPanel controls =
            new JPanel();

        controls.setOpaque(false);


        // IMPORTANT:
        // Use the simple constructor directly.
        // This avoids the previous BlueJ parsing issue.

        controls.setLayout(
            new FlowLayout(
                FlowLayout.RIGHT,
                5,
                0
            )
        );


        JButton minusButton =
            createSmallButton(
                "−"
            );


        JButton plusButton =
            createSmallButton(
                "+"
            );


        JLabel quantity =
            new JLabel(
                String.valueOf(
                    item.quantity
                )
            );


        quantity.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                15
            )
        );


        quantity.setForeground(
            TEXT
        );


        quantity.setHorizontalAlignment(
            SwingConstants.CENTER
        );


        quantity.setPreferredSize(
            new Dimension(
                30,
                30
            )
        );


        minusButton.addActionListener(
            e -> {

                if (
                    item.quantity > 1
                ) {

                    item.quantity--;

                } else {

                    CartManager
                        .getCart()
                        .remove(item);
                }


                refreshCart();
            }
        );


        plusButton.addActionListener(
            e -> {

                item.quantity++;

                refreshCart();
            }
        );


        controls.add(
            minusButton
        );

        controls.add(
            quantity
        );

        controls.add(
            plusButton
        );


        // =====================================================
        // REMOVE BUTTON
        // =====================================================

        JButton removeButton =
            new JButton(
                "REMOVE"
            );


        removeButton.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                10
            )
        );


        removeButton.setForeground(
            RED
        );


        removeButton.setBackground(
            Color.WHITE
        );


        removeButton.setFocusPainted(
            false
        );


        removeButton.setBorder(
            BorderFactory.createLineBorder(
                RED,
                1
            )
        );


        removeButton.setCursor(
            new Cursor(
                Cursor.HAND_CURSOR
            )
        );


        removeButton.addActionListener(
            e -> {

                CartManager
                    .getCart()
                    .remove(item);

                refreshCart();
            }
        );


        // =====================================================
        // CONTROL CONTAINER
        // =====================================================

        JPanel right =
            new JPanel();


        right.setOpaque(false);


        right.setLayout(
            new BoxLayout(
                right,
                BoxLayout.Y_AXIS
            )
        );


        right.add(
            controls
        );


        right.add(
            Box.createVerticalStrut(10)
        );


        right.add(
            removeButton
        );


        card.add(
            right,
            BorderLayout.EAST
        );


        return card;
    }


    // =========================================================
    // EMPTY CART
    // =========================================================

    private void showEmptyCart() {

        itemsPanel.removeAll();


        JPanel empty =
            new RoundedPanel(
                CARD,
                28
            );


        empty.setLayout(
            new BoxLayout(
                empty,
                BoxLayout.Y_AXIS
            )
        );


        empty.setBorder(
            BorderFactory.createEmptyBorder(
                45,
                30,
                45,
                30
            )
        );


        JLabel icon =
            new JLabel(
                "CART"
            );

        icon.setFont(
            new Font(
                "Serif",
                Font.BOLD,
                24
            )
        );

        icon.setForeground(
            CARAMEL
        );

        icon.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );


        JLabel emptyTitle =
            new JLabel(
                "YOUR CART IS EMPTY"
            );

        emptyTitle.setFont(
            new Font(
                "Serif",
                Font.BOLD,
                23
            )
        );

        emptyTitle.setForeground(
            TEXT
        );

        emptyTitle.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );


        JLabel message =
            new JLabel(
                "Add something delicious from our menu."
            );

        message.setFont(
            new Font(
                "SansSerif",
                Font.PLAIN,
                12
            )
        );

        message.setForeground(
            MUTED
        );

        message.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );


        empty.add(
            icon
        );

        empty.add(
            Box.createVerticalStrut(10)
        );

        empty.add(
            emptyTitle
        );

        empty.add(
            Box.createVerticalStrut(6)
        );

        empty.add(
            message
        );


        itemsPanel.add(
            empty
        );
    }


    // =========================================================
    // CONFIRM ORDER
    // =========================================================

    private void confirmOrder() {

        if (
            CartManager
                .getCart()
                .size() == 0
        ) {

            JOptionPane.showMessageDialog(
                this,
                "Your cart is empty.\n"
                + "Please add items before confirming.",
                "Empty Cart",
                JOptionPane.WARNING_MESSAGE
            );

            return;
        }


        CustomerDetails customerDetails =
            new CustomerDetails();


        customerDetails.setVisible(
            true
        );


        dispose();
    }


    // =========================================================
    // OPEN MENU
    // =========================================================

    private void openMenu() {

        MenuPage menuPage =
            new MenuPage();


        menuPage.setVisible(
            true
        );


        dispose();
    }


    // =========================================================
    // MAIN BUTTON
    // =========================================================

    private JButton createButton(
        String text,
        Color background,
        Color foreground
    ) {

        JButton button =
            new JButton(
                text
            );


        button.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                11
            )
        );


        button.setBackground(
            background
        );


        button.setForeground(
            foreground
        );


        button.setFocusPainted(
            false
        );


        button.setBorder(
            BorderFactory.createEmptyBorder(
                12,
                19,
                12,
                19
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
    // SMALL BUTTON
    // =========================================================

    private JButton createSmallButton(
        String text
    ) {

        JButton button =
            new JButton(
                text
            );


        button.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                17
            )
        );


        button.setForeground(
            COFFEE
        );


        button.setBackground(
            PALE_GOLD
        );


        button.setFocusPainted(
            false
        );


        button.setBorder(
            BorderFactory.createEmptyBorder(
                4,
                9,
                4,
                9
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

            this.color = color;

            this.radius = radius;

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

                    CartPage cartPage =
                        new CartPage();

                    cartPage.setVisible(
                        true
                    );
                }
            }
        );
    }
}