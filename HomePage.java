import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame {

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


    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public HomePage() {

        setTitle(
            "TAMIL KUDIL - Smart Kitchen Management System"
        );

        setSize(
            1180,
            800
        );

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE
        );

        buildInterface();
    }


    // =========================================================
    // MAIN INTERFACE
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
                10,
                28,
                10,
                28
            )
        );


        // ---------------- BRAND ----------------

        JPanel brand =
            new JPanel(
                new FlowLayout(
                    FlowLayout.LEFT,
                    14,
                    0
                )
            );

        brand.setOpaque(false);


        JLabel brandIcon =
            new JLabel(
                "⌂"
            );

        brandIcon.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                34
            )
        );

        brandIcon.setForeground(
            PALE_GOLD
        );


        JLabel brandText =
            new JLabel(
                "<html>"
                + "<b>TAMIL KUDIL</b>"
                + "<br>"
                + "<font size='3'>"
                + "Smart Kitchen Management System"
                + "</font>"
                + "</html>"
            );

        brandText.setFont(
            new Font(
                "Serif",
                Font.PLAIN,
                15
            )
        );

        brandText.setForeground(
            Color.WHITE
        );


        brand.add(
            brandIcon
        );

        brand.add(
            brandText
        );


        header.add(
            brand,
            BorderLayout.WEST
        );


        // =====================================================
        // NAVIGATION
        // =====================================================

        JPanel navigation =
            new JPanel(
                new FlowLayout(
                    FlowLayout.RIGHT,
                    8,
                    4
                )
            );

        navigation.setOpaque(false);


        JButton homeButton =
            createNavigationButton(
                "HOME",
                true
            );

        JButton menuButton =
            createNavigationButton(
                "MENU",
                false
            );

        JButton kitchenButton =
            createNavigationButton(
                "KITCHEN",
                false
            );

        JButton orderButton =
            createNavigationButton(
                "ORDER NOW",
                false
            );


        orderButton.setBackground(
            PALE_GOLD
        );

        orderButton.setForeground(
            DEEP_COFFEE
        );


        menuButton.addActionListener(
            e -> openMenu()
        );

        kitchenButton.addActionListener(
            e -> openKitchen()
        );

        orderButton.addActionListener(
            e -> openMenu()
        );


        navigation.add(
            homeButton
        );

        navigation.add(
            menuButton
        );

        navigation.add(
            kitchenButton
        );

        navigation.add(
            orderButton
        );


        header.add(
            navigation,
            BorderLayout.EAST
        );


        add(
            header,
            BorderLayout.NORTH
        );


        // =====================================================
        // MAIN CONTENT
        // =====================================================

        JPanel content =
            new JPanel();

        content.setOpaque(false);

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
                20,
                24
            )
        );


        // =====================================================
        // HERO SECTION
        // =====================================================

        GradientPanel hero =
            new GradientPanel(
                DEEP_COFFEE,
                COFFEE,
                30
            );

        hero.setLayout(
            new BorderLayout(
                20,
                0
            )
        );

        hero.setBorder(
            BorderFactory.createEmptyBorder(
                38,
                42,
                38,
                42
            )
        );

        hero.setMaximumSize(
            new Dimension(
                Integer.MAX_VALUE,
                315
            )
        );


        // ---------------- HERO TEXT ----------------

        JPanel heroText =
            new JPanel();

        heroText.setOpaque(false);

        heroText.setLayout(
            new BoxLayout(
                heroText,
                BoxLayout.Y_AXIS
            )
        );


        JLabel welcome =
            createLabel(
                "WELCOME TO TAMIL KUDIL   —   ✦",
                19,
                Font.BOLD,
                PALE_GOLD
            );


        JLabel title1 =
            createLabel(
                "AUTHENTIC TASTE.",
                43,
                Font.BOLD,
                Color.WHITE
            );


        JLabel title2 =
            createLabel(
                "SMARTER ORDERING.",
                43,
                Font.BOLD,
                CARAMEL
            );


        JLabel tagline =
            createLabel(
                "Traditional taste, modern experience.",
                15,
                Font.PLAIN,
                new Color(
                    242,
                    232,
                    216
                )
            );


        // ---------------- HERO BUTTONS ----------------

        JPanel heroButtons =
            new JPanel(
                new FlowLayout(
                    FlowLayout.LEFT,
                    10,
                    0
                )
            );

        heroButtons.setOpaque(false);


        JButton orderHero =
            createPillButton(
                "ORDER NOW  →",
                CARAMEL,
                DEEP_COFFEE
            );


        JButton menuHero =
            createPillButton(
                "VIEW MENU",
                DEEP_COFFEE,
                Color.WHITE
            );


        orderHero.addActionListener(
            e -> openMenu()
        );

        menuHero.addActionListener(
            e -> openMenu()
        );


        heroButtons.add(
            orderHero
        );

        heroButtons.add(
            menuHero
        );


        heroText.add(
            welcome
        );

        heroText.add(
            Box.createVerticalStrut(12)
        );

        heroText.add(
            title1
        );

        heroText.add(
            title2
        );

        heroText.add(
            Box.createVerticalStrut(8)
        );

        heroText.add(
            tagline
        );

        heroText.add(
            Box.createVerticalStrut(20)
        );

        heroText.add(
            heroButtons
        );


        hero.add(
            heroText,
            BorderLayout.CENTER
        );


        // =====================================================
        // 74+ MENU BADGE
        // =====================================================

        JPanel menuBadge =
            new RoundedPanel(
                new Color(
                    248,
                    226,
                    181
                ),
                30
            );

        menuBadge.setPreferredSize(
            new Dimension(
                215,
                220
            )
        );

        menuBadge.setLayout(
            new BoxLayout(
                menuBadge,
                BoxLayout.Y_AXIS
            )
        );


        JLabel badgeIcon =
            createLabel(
                "✦",
                28,
                Font.BOLD,
                COFFEE
            );

        badgeIcon.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );


        JLabel number =
            createLabel(
                "74+",
                52,
                Font.BOLD,
                DEEP_COFFEE
            );

        number.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );


        JLabel menuItems =
            createLabel(
                "MENU ITEMS",
                15,
                Font.BOLD,
                COFFEE
            );

        menuItems.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );


        JLabel explore =
            createLabel(
                "EXPLORE  →",
                11,
                Font.BOLD,
                COFFEE
            );

        explore.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );


        menuBadge.add(
            Box.createVerticalGlue()
        );

        menuBadge.add(
            badgeIcon
        );

        menuBadge.add(
            number
        );

        menuBadge.add(
            Box.createVerticalStrut(2)
        );

        menuBadge.add(
            menuItems
        );

        menuBadge.add(
            Box.createVerticalStrut(15)
        );

        menuBadge.add(
            explore
        );

        menuBadge.add(
            Box.createVerticalGlue()
        );


        hero.add(
            menuBadge,
            BorderLayout.EAST
        );


        content.add(
            hero
        );


        content.add(
            Box.createVerticalStrut(18)
        );


        // =====================================================
        // QUICK INFORMATION STRIP
        // =====================================================

        JPanel informationStrip =
            new RoundedPanel(
                CARD,
                24
            );

        informationStrip.setLayout(
            new GridLayout(
                1,
                3
            )
        );

        informationStrip.setMaximumSize(
            new Dimension(
                Integer.MAX_VALUE,
                112
            )
        );


        informationStrip.add(
            createInfoBlock(
                "◉",
                "74+ MENU",
                "Wide variety of dishes"
            )
        );


        informationStrip.add(
            createInfoBlock(
                "✤",
                "SMART ORDERS",
                "Fast and simple"
            )
        );


        informationStrip.add(
            createInfoBlock(
                "♨",
                "LIVE KITCHEN",
                "Track your order"
            )
        );


        content.add(
            informationStrip
        );


        content.add(
            Box.createVerticalStrut(25)
        );


        // =====================================================
        // WHY TAMIL KUDIL
        // =====================================================

        JPanel whySection =
            new JPanel(
                new FlowLayout(
                    FlowLayout.CENTER,
                    10,
                    0
                )
            );

        whySection.setOpaque(false);

        whySection.setMaximumSize(
            new Dimension(
                Integer.MAX_VALUE,
                50
            )
        );


        whySection.add(
            createLabel(
                "—",
                22,
                Font.BOLD,
                CARAMEL
            )
        );

        whySection.add(
            createLabel(
                "✦",
                17,
                Font.BOLD,
                CARAMEL
            )
        );

        whySection.add(
            createLabel(
                "WHY TAMIL KUDIL?",
                27,
                Font.BOLD,
                TEXT
            )
        );

        whySection.add(
            createLabel(
                "✦",
                17,
                Font.BOLD,
                CARAMEL
            )
        );

        whySection.add(
            createLabel(
                "—",
                22,
                Font.BOLD,
                CARAMEL
            )
        );


        content.add(
            whySection
        );


        content.add(
            Box.createVerticalStrut(10)
        );


        // =====================================================
        // FEATURE CARDS
        // =====================================================

        JPanel features =
            new JPanel(
                new GridLayout(
                    1,
                    3,
                    16,
                    0
                )
            );

        features.setOpaque(false);

        features.setMaximumSize(
            new Dimension(
                Integer.MAX_VALUE,
                150
            )
        );


        features.add(
            createFeatureCard(
                "01",
                "◷",
                "EASY ORDER",
                "Quick & simple ordering process"
            )
        );


        features.add(
            createFeatureCard(
                "02",
                "C",
                "SMART CART",
                "Manage your items with ease"
            )
        );


        features.add(
            createFeatureCard(
                "03",
                "♨",
                "KITCHEN FLOW",
                "Seamless order tracking"
            )
        );


        content.add(
            features
        );


        content.add(
            Box.createVerticalStrut(18)
        );


        // =====================================================
        // FINAL TAGLINE
        // =====================================================

        JPanel finalBanner =
            new RoundedPanel(
                PALE_GOLD,
                30
            );

        finalBanner.setLayout(
            new BorderLayout()
        );

        finalBanner.setMaximumSize(
            new Dimension(
                Integer.MAX_VALUE,
                58
            )
        );

        finalBanner.setBorder(
            BorderFactory.createEmptyBorder(
                8,
                25,
                8,
                25
            )
        );


        JLabel smartManagement =
            createLabel(
                "✦   SMARTER MANAGEMENT",
                14,
                Font.BOLD,
                COFFEE
            );


        JLabel betterDining =
            createLabel(
                "BETTER DINING   →",
                14,
                Font.BOLD,
                COFFEE
            );


        finalBanner.add(
            smartManagement,
            BorderLayout.WEST
        );

        finalBanner.add(
            betterDining,
            BorderLayout.EAST
        );


        content.add(
            finalBanner
        );


        // =====================================================
        // SCROLL PANE
        // =====================================================

        JScrollPane scrollPane =
            new JScrollPane(
                content
            );

        scrollPane.setBorder(
            BorderFactory.createEmptyBorder()
        );

        scrollPane.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        scrollPane.getVerticalScrollBar()
            .setUnitIncrement(16);


        add(
            scrollPane,
            BorderLayout.CENTER
        );
    }


    // =========================================================
    // LABEL CREATOR
    // =========================================================

    private JLabel createLabel(
        String text,
        int size,
        int style,
        Color color
    ) {

        JLabel label =
            new JLabel(
                text
            );

        label.setFont(
            new Font(
                "Serif",
                style,
                size
            )
        );

        label.setForeground(
            color
        );

        return label;
    }


    // =========================================================
    // NAVIGATION BUTTON
    // =========================================================

    private JButton createNavigationButton(
        String text,
        boolean active
    ) {

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
            active
                ? CARAMEL
                : Color.WHITE
        );

        button.setBackground(
            COFFEE
        );

        button.setFocusPainted(
            false
        );

        button.setBorder(
            BorderFactory.createEmptyBorder(
                9,
                13,
                9,
                13
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
    // PILL BUTTON
    // =========================================================

    private JButton createPillButton(
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
                12
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
    // INFORMATION BLOCK
    // =========================================================

    private JPanel createInfoBlock(
        String icon,
        String title,
        String subtitle
    ) {

        JPanel panel =
            new JPanel(
                new BorderLayout(
                    12,
                    0
                )
            );

        panel.setOpaque(false);

        panel.setBorder(
            BorderFactory.createEmptyBorder(
                15,
                22,
                15,
                22
            )
        );


        JLabel iconLabel =
            createLabel(
                icon,
                30,
                Font.BOLD,
                COFFEE
            );


        JLabel text =
            createLabel(
                "<html>"
                + "<b>"
                + title
                + "</b>"
                + "<br>"
                + "<font size='3'>"
                + subtitle
                + "</font>"
                + "</html>",
                15,
                Font.PLAIN,
                TEXT
            );


        panel.add(
            iconLabel,
            BorderLayout.WEST
        );

        panel.add(
            text,
            BorderLayout.CENTER
        );


        return panel;
    }


    // =========================================================
    // FEATURE CARD
    // =========================================================

    private JPanel createFeatureCard(
        String number,
        String icon,
        String title,
        String subtitle
    ) {

        JPanel card =
            new RoundedPanel(
                CARD,
                24
            );

        card.setLayout(
            new BorderLayout(
                12,
                0
            )
        );

        card.setBorder(
            BorderFactory.createEmptyBorder(
                14,
                18,
                14,
                18
            )
        );


        // Number

        JLabel numberLabel =
            createLabel(
                number,
                12,
                Font.BOLD,
                COFFEE
            );


        // Circular-looking icon area

        JPanel iconPanel =
            new RoundedPanel(
                PALE_GOLD,
                70
            );

        iconPanel.setPreferredSize(
            new Dimension(
                68,
                68
            )
        );

        iconPanel.setLayout(
            new GridBagLayout()
        );


        JLabel iconLabel =
            createLabel(
                icon,
                27,
                Font.BOLD,
                COFFEE
            );


        iconPanel.add(
            iconLabel
        );


        // Text

        JPanel textPanel =
            new JPanel();

        textPanel.setOpaque(false);

        textPanel.setLayout(
            new BoxLayout(
                textPanel,
                BoxLayout.Y_AXIS
            )
        );


        textPanel.add(
            numberLabel
        );

        textPanel.add(
            Box.createVerticalStrut(5)
        );

        textPanel.add(
            createLabel(
                title,
                16,
                Font.BOLD,
                TEXT
            )
        );

        textPanel.add(
            Box.createVerticalStrut(5)
        );

        textPanel.add(
            createLabel(
                subtitle,
                11,
                Font.PLAIN,
                MUTED
            )
        );


        card.add(
            iconPanel,
            BorderLayout.WEST
        );

        card.add(
            textPanel,
            BorderLayout.CENTER
        );


        return card;
    }


    // =========================================================
    // OPEN MENU
    // =========================================================

    private void openMenu() {

        MenuPage menu =
            new MenuPage();

        menu.setVisible(
            true
        );

        dispose();
    }


    // =========================================================
    // OPEN KITCHEN
    // =========================================================

    private void openKitchen() {

        KitchenDashboard kitchen =
            new KitchenDashboard();

        kitchen.setVisible(
            true
        );

        dispose();
    }


    // =========================================================
    // ROUNDED PANEL
    // =========================================================

    private static class RoundedPanel
        extends JPanel {

        private final Color color;
        private final int radius;


        RoundedPanel(
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

            super.paintComponent(g);
        }
    }


    // =========================================================
    // GRADIENT HERO PANEL
    // =========================================================

    private static class GradientPanel
        extends RoundedPanel {

        private final Color first;
        private final Color second;


        GradientPanel(
            Color first,
            Color second,
            int radius
        ) {

            super(
                first,
                radius
            );

            this.first =
                first;

            this.second =
                second;
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


            GradientPaint gradient =
                new GradientPaint(
                    0,
                    0,
                    first,
                    getWidth(),
                    getHeight(),
                    second
                );


            g2.setPaint(
                gradient
            );


            g2.fillRoundRect(
                0,
                0,
                getWidth(),
                getHeight(),
                30,
                30
            );


            // Decorative warm glow

            g2.setColor(
                new Color(
                    255,
                    220,
                    150,
                    30
                )
            );

            g2.fillOval(
                getWidth() - 310,
                20,
                250,
                250
            );


            g2.setColor(
                new Color(
                    255,
                    220,
                    150,
                    18
                )
            );

            g2.fillOval(
                getWidth() - 190,
                115,
                180,
                180
            );


            g2.dispose();
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

                    HomePage home =
                        new HomePage();

                    home.setVisible(
                        true
                    );
                }
            }
        );
    }
}