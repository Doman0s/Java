package pl.edu.wszib.food.shop.model;

public class OrderPosition {
    private Product product;
    private int quantity;

    public OrderPosition(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public OrderPosition() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void IncreaseQuantity() {
        this.quantity++;
    }
}
