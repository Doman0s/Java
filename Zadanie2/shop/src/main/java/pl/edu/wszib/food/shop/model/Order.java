package pl.edu.wszib.food.shop.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {
    private int id;
    private double price;
    private String date;
    private User user;
    private List<OrderPosition> orderPositions = new ArrayList<>();

    public Order(int id, double price, String date, User user, List<OrderPosition> orderPositions) {
        this.id = id;
        this.price = price;
        this.date = date;
        this.user = user;
        this.orderPositions = orderPositions;
    }

    public Order(User user, List<OrderPosition> orderPositions) {
        this.id = new Random().nextInt(1000000);
        this.user = user;
        this.orderPositions = orderPositions;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy  hh:mm a");
        date = formatter.format(LocalDateTime.now());

        this.price = 0;
        for(OrderPosition orderPosition : orderPositions) {
            this.price += orderPosition.getProduct().getPrice() * orderPosition.getQuantity();
        }
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderPosition> getOrderPositions() {
        return orderPositions;
    }

    public void setOrderPositions(List<OrderPosition> orderPositions) {
        this.orderPositions = orderPositions;
    }
}
