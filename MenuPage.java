import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuPage extends JFrame {

    // =========================================================
    // COLOURS
    // =========================================================

    private static final Color COFFEE = new Color(78, 49, 37);
    private static final Color DEEP_COFFEE = new Color(55, 34, 26);
    private static final Color CARAMEL = new Color(214, 166, 93);
    private static final Color PALE_GOLD = new Color(245, 224, 183);
    private static final Color IVORY = new Color(250, 247, 238);
    private static final Color CARD = new Color(255, 253, 247);
    private static final Color TEXT = new Color(58, 43, 35);
    private static final Color MUTED = new Color(128, 105, 88);
    private static final Color GREEN = new Color(42, 125, 74);

    // =========================================================
    // COMPONENTS
    // =========================================================

    private JPanel foodPanel;
    private JTextField searchField;
    private JLabel resultLabel;

    private String selectedCategory = "All";

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public MenuPage() {

        setTitle("TAMIL KUDIL - Our Menu");

        setSize(1180, 800);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buildInterface();

        loadFood();
    }

    // =========================================================
    // BUILD INTERFACE
    // =========================================================

    private void buildInterface() {

        getContentPane().setBackground(IVORY);

        setLayout(new BorderLayout());

        // =====================================================
        // HEADER
        // =====================================================

        JPanel header = new JPanel(new BorderLayout());

        header.setBackground(COFFEE);

        header.setBorder(
            BorderFactory.createEmptyBorder(
                15,
                28,
                15,
                28
            )
        );

        // Brand

        JPanel brand = new JPanel();

        brand.setOpaque(false);

        brand.setLayout(
            new BoxLayout(
                brand,
                BoxLayout.Y_AXIS
            )
        );

        JLabel title = new JLabel("TAMIL KUDIL");

        title.setFont(
            new Font(
                "Serif",
                Font.BOLD,
                28
            )
        );

        title.setForeground(Color.WHITE);

        JLabel subtitle =
            new JLabel("OUR MENU  •  AUTHENTIC TASTE");

        subtitle.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                10
            )
        );

        subtitle.setForeground(PALE_GOLD);

        brand.add(title);

        brand.add(
            Box.createVerticalStrut(2)
        );

        brand.add(subtitle);

        header.add(
            brand,
            BorderLayout.WEST
        );

        // Cart button

        JButton cartButton =
            createButton(
                "VIEW CART  →",
                PALE_GOLD,
                DEEP_COFFEE
            );

        cartButton.addActionListener(
            e -> openCart()
        );

        header.add(
            cartButton,
            BorderLayout.EAST
        );

        add(
            header,
            BorderLayout.NORTH
        );

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        JPanel content = new JPanel();

        content.setBackground(IVORY);

        content.setLayout(
            new BoxLayout(
                content,
                BoxLayout.Y_AXIS
            )
        );

        content.setBorder(
            BorderFactory.createEmptyBorder(
                18,
                24,
                25,
                24
            )
        );

        // =====================================================
        // INTRO
        // =====================================================

        JPanel intro = new JPanel(
            new BorderLayout()
        );

        intro.setOpaque(false);

        intro.setMaximumSize(
            new Dimension(
                Integer.MAX_VALUE,
                65
            )
        );

        JPanel introText = new JPanel();

        introText.setOpaque(false);

        introText.setLayout(
            new BoxLayout(
                introText,
                BoxLayout.Y_AXIS
            )
        );

        JLabel menuTitle =
            new JLabel("EXPLORE OUR MENU");

        menuTitle.setFont(
            new Font(
                "Serif",
                Font.BOLD,
                26
            )
        );

        menuTitle.setForeground(TEXT);

        JLabel menuSubtitle =
            new JLabel(
                "Choose your favourites and build your order."
            );

        menuSubtitle.setFont(
            new Font(
                "SansSerif",
                Font.PLAIN,
                12
            )
        );

        menuSubtitle.setForeground(MUTED);

        introText.add(menuTitle);

        introText.add(
            Box.createVerticalStrut(2)
        );

        introText.add(menuSubtitle);

        intro.add(
            introText,
            BorderLayout.WEST
        );

        resultLabel =
            new JLabel("74 ITEMS");

        resultLabel.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                12
            )
        );

        resultLabel.setForeground(CARAMEL);

        intro.add(
            resultLabel,
            BorderLayout.EAST
        );

        content.add(intro);

        content.add(
            Box.createVerticalStrut(10)
        );

        // =====================================================
        // SEARCH
        // =====================================================

        JPanel searchPanel =
            new RoundedPanel(
                CARD,
                22
            );

        searchPanel.setLayout(
            new BorderLayout(
                12,
                0
            )
        );

        searchPanel.setBorder(
            BorderFactory.createEmptyBorder(
                9,
                18,
                9,
                18
            )
        );

        searchPanel.setMaximumSize(
            new Dimension(
                Integer.MAX_VALUE,
                55
            )
        );

        JLabel searchLabel =
            new JLabel("SEARCH");

        searchLabel.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                10
            )
        );

        searchLabel.setForeground(CARAMEL);

        searchField = new JTextField();

        searchField.setFont(
            new Font(
                "SansSerif",
                Font.PLAIN,
                14
            )
        );

        searchField.setForeground(TEXT);

        searchField.setBackground(CARD);

        searchField.setBorder(
            BorderFactory.createEmptyBorder(
                5,
                5,
                5,
                5
            )
        );

        searchField
            .getDocument()
            .addDocumentListener(
                new DocumentListener() {

                    public void insertUpdate(
                        DocumentEvent e
                    ) {
                        loadFood();
                    }

                    public void removeUpdate(
                        DocumentEvent e
                    ) {
                        loadFood();
                    }

                    public void changedUpdate(
                        DocumentEvent e
                    ) {
                        loadFood();
                    }
                }
            );

        searchPanel.add(
            searchLabel,
            BorderLayout.WEST
        );

        searchPanel.add(
            searchField,
            BorderLayout.CENTER
        );

        content.add(searchPanel);

        content.add(
            Box.createVerticalStrut(12)
        );

        // =====================================================
        // CATEGORY BUTTONS
        // =====================================================

        JPanel categoryPanel =
            new JPanel(
                new FlowLayout(
                    FlowLayout.LEFT,
                    7,
                    3
                )
            );

        categoryPanel.setOpaque(false);

        categoryPanel.setMaximumSize(
            new Dimension(
                Integer.MAX_VALUE,
                55
            )
        );

        String[] categories = {
            "All",
            "Breakfast",
            "Soup",
            "Starters",
            "Main Course",
            "Lunch",
            "Dinner",
            "Beverages"
        };

        for (
            int i = 0;
            i < categories.length;
            i++
        ) {

            String category =
                categories[i];

            JButton button =
                createCategoryButton(
                    category
                );

            button.addActionListener(
                e -> {

                    selectedCategory =
                        category;

                    loadFood();
                }
            );

            categoryPanel.add(button);
        }

        content.add(categoryPanel);

        content.add(
            Box.createVerticalStrut(8)
        );

        // =====================================================
        // FOOD GRID
        // =====================================================

        foodPanel =
            new JPanel(
                new GridLayout(
                    0,
                    3,
                    16,
                    16
                )
            );

        foodPanel.setBackground(IVORY);

        content.add(foodPanel);

        // =====================================================
        // SCROLL
        // =====================================================

        JScrollPane scrollPane =
            new JScrollPane(content);

        scrollPane.setBorder(
            BorderFactory.createEmptyBorder()
        );

        scrollPane.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        scrollPane
            .getVerticalScrollBar()
            .setUnitIncrement(16);

        add(
            scrollPane,
            BorderLayout.CENTER
        );
    }

    // =========================================================
    // LOAD FOOD
    // =========================================================

    private void loadFood() {

        if (foodPanel == null) {
            return;
        }

        foodPanel.removeAll();

        String search = "";

        if (searchField != null) {

            search =
                searchField
                    .getText()
                    .trim();
        }

        String sql =
            "SELECT food_id, food_name, price, "
            + "category, available "
            + "FROM food "
            + "WHERE available = TRUE ";

        if (
            !selectedCategory.equals("All")
        ) {

            sql =
                sql
                + "AND category = ? ";
        }

        if (
            !search.isEmpty()
        ) {

            sql =
                sql
                + "AND food_name LIKE ? ";
        }

        sql =
            sql
            + "ORDER BY food_id ASC";

        int count = 0;

        try {

            Connection con =
                DBConnection.getConnection();

            if (con == null) {
                return;
            }

            PreparedStatement ps =
                con.prepareStatement(sql);

            int index = 1;

            if (
                !selectedCategory.equals("All")
            ) {

                ps.setString(
                    index,
                    selectedCategory
                );

                index++;
            }

            if (
                !search.isEmpty()
            ) {

                ps.setString(
                    index,
                    "%" + search + "%"
                );
            }

            ResultSet rs =
                ps.executeQuery();

            while (rs.next()) {

                int foodId =
                    rs.getInt("food_id");

                String foodName =
                    rs.getString("food_name");

                double price =
                    rs.getDouble("price");

                String category =
                    rs.getString("category");

                JPanel card =
                    createFoodCard(
                        foodId,
                        foodName,
                        price,
                        category
                    );

                foodPanel.add(card);

                count++;
            }

            rs.close();

            ps.close();

            con.close();

            resultLabel.setText(
                count + " ITEMS"
            );

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                this,
                "Unable to load menu.\n"
                + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
            );
        }

        foodPanel.revalidate();

        foodPanel.repaint();
    }

    // =========================================================
    // FOOD CARD
    // =========================================================

    private JPanel createFoodCard(
        int foodId,
        String foodName,
        double price,
        String category
    ) {

        JPanel card =
            new RoundedPanel(
                CARD,
                25
            );

        card.setLayout(
            new BorderLayout()
        );

        card.setBorder(
            BorderFactory.createEmptyBorder(
                16,
                17,
                16,
                17
            )
        );

        // -----------------------------------------------------
        // TOP
        // -----------------------------------------------------

        JPanel top =
            new JPanel(
                new BorderLayout()
            );

        top.setOpaque(false);

        JLabel categoryLabel =
            new JLabel(
                category.toUpperCase()
            );

        categoryLabel.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                10
            )
        );

        categoryLabel.setForeground(CARAMEL);

        JLabel available =
            new JLabel(
                "● AVAILABLE"
            );

        available.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                9
            )
        );

        available.setForeground(GREEN);

        top.add(
            categoryLabel,
            BorderLayout.WEST
        );

        top.add(
            available,
            BorderLayout.EAST
        );

        // -----------------------------------------------------
        // FOOD NAME
        // -----------------------------------------------------

        JLabel name =
            new JLabel(
                "<html>"
                + "<div style='width:220px'>"
                + foodName
                + "</div>"
                + "</html>"
            );

        name.setFont(
            new Font(
                "Serif",
                Font.BOLD,
                20
            )
        );

        name.setForeground(TEXT);

        // -----------------------------------------------------
        // PRICE
        // -----------------------------------------------------

        JPanel pricePanel =
            new RoundedPanel(
                PALE_GOLD,
                18
            );

        pricePanel.setLayout(
            new FlowLayout(
                FlowLayout.LEFT,
                10,
                5
            )
        );

        JLabel priceLabel =
            new JLabel(
                String.format(
                    "₹%.2f",
                    price
                )
            );

        priceLabel.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                16
            )
        );

        priceLabel.setForeground(DEEP_COFFEE);

        pricePanel.add(priceLabel);

        // -----------------------------------------------------
        // ADD BUTTON
        // -----------------------------------------------------

        JButton addButton =
            createButton(
                "ADD TO CART  +",
                COFFEE,
                Color.WHITE
            );

        addButton.addActionListener(
            e -> {

                CartManager.addItem(
                    foodId,
                    foodName,
                    price
                );

                JOptionPane.showMessageDialog(
                    this,
                    foodName
                    + " added to cart!",
                    "Added to Cart",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        );

        // -----------------------------------------------------
        // CENTER
        // -----------------------------------------------------

        JPanel center =
            new JPanel();

        center.setOpaque(false);

        center.setLayout(
            new BorderLayout()
        );

        JPanel details =
            new JPanel();

        details.setOpaque(false);

        details.setLayout(
            new BoxLayout(
                details,
                BoxLayout.Y_AXIS
            )
        );

        details.add(
            Box.createVerticalStrut(12)
        );

        details.add(name);

        details.add(
            Box.createVerticalStrut(12)
        );

        details.add(pricePanel);

        center.add(
            details,
            BorderLayout.CENTER
        );

        // -----------------------------------------------------
        // CARD ASSEMBLY
        // -----------------------------------------------------

        card.add(
            top,
            BorderLayout.NORTH
        );

        card.add(
            center,
            BorderLayout.CENTER
        );

        card.add(
            addButton,
            BorderLayout.SOUTH
        );

        return card;
    }

    // =========================================================
    // CATEGORY BUTTON
    // =========================================================

    private JButton createCategoryButton(
        String text
    ) {

        JButton button =
            new JButton(text);

        button.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                11
            )
        );

        button.setForeground(COFFEE);

        button.setBackground(PALE_GOLD);

        button.setFocusPainted(false);

        button.setBorder(
            BorderFactory.createEmptyBorder(
                9,
                15,
                9,
                15
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
    // NORMAL BUTTON
    // =========================================================

    private JButton createButton(
        String text,
        Color background,
        Color foreground
    ) {

        JButton button =
            new JButton(text);

        button.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                11
            )
        );

        button.setBackground(background);

        button.setForeground(foreground);

        // Correct Swing method
        button.setFocusPainted(false);

        button.setBorder(
            BorderFactory.createEmptyBorder(
                11,
                18,
                11,
                18
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
    // OPEN CART
    // =========================================================

    private void openCart() {

        CartPage cartPage =
            new CartPage();

        cartPage.setVisible(true);

        dispose();
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

            g2.setColor(color);

            g2.fillRoundRect(
                0,
                0,
                getWidth(),
                getHeight(),
                radius,
                radius
            );

            g2.dispose();

            super.paintComponent(g);
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

                    MenuPage menu =
                        new MenuPage();

                    menu.setVisible(true);
                }
            }
        );
    }
}