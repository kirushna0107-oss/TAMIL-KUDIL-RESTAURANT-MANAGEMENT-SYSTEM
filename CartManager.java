import java.util.ArrayList;

public class CartManager {

    private static ArrayList<CartItem> cart =
        new ArrayList<CartItem>();

    // ==============================
    // ADD ITEM
    // ==============================

    public static void addItem(
        int foodId,
        String foodName,
        double price
    ) {

        for (CartItem item : cart) {

            if (item.foodId == foodId) {

                item.quantity++;

                return;
            }
        }

        cart.add(
            new CartItem(
                foodId,
                foodName,
                price,
                1
            )
        );
    }

    // ==============================
    // GET CART
    // ==============================

    public static ArrayList<CartItem> getCart() {

        return cart;
    }

    // ==============================
    // GET TOTAL
    // ==============================

    public static double getTotal() {

        double total = 0;

        for (CartItem item : cart) {

            total =
                total +
                (item.price * item.quantity);
        }

        return total;
    }

    // ==============================
    // GET ITEM COUNT
    // ==============================

    public static int getItemCount() {

        int count = 0;

        for (CartItem item : cart) {

            count =
                count +
                item.quantity;
        }

        return count;
    }

    // ==============================
    // CLEAR CART
    // ==============================

    public static void clearCart() {

        cart.clear();
    }

    // ==============================
    // CART ITEM
    // ==============================

    public static class CartItem {

        public int foodId;

        public String foodName;

        public double price;

        public int quantity;

        public CartItem(
            int foodId,
            String foodName,
            double price,
            int quantity
        ) {

            this.foodId = foodId;

            this.foodName = foodName;

            this.price = price;

            this.quantity = quantity;
        }
    }
}