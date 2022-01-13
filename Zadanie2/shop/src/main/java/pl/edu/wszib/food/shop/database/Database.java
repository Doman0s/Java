package pl.edu.wszib.food.shop.database;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;
import pl.edu.wszib.food.shop.model.Order;
import pl.edu.wszib.food.shop.model.Product;
import pl.edu.wszib.food.shop.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class Database {
    private List<Product> products = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public Database() {
        this.users.add(new User(1, "Dominik", "Wator", "admin", DigestUtils.md5Hex("admin")));
        this.users.add(new User(2, "Jan", "Kowalski", "user", DigestUtils.md5Hex("user")));

        this.products.add(new Product(1, "jablko", "czerwone", 0.95, 30));
        this.products.add(new Product(2, "dynia", "duza", 29.99, 6));
        this.products.add(new Product(3, "pomarancza", "soczysta", 1.89, 10));
        this.products.add(new Product(4, "mango", "egzotyczne", 2.49, 18));
        this.products.add(new Product(5, "banan", "dojrzaly", 1.39, 12));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public Optional<User> getUserByLogin(String login) {
        for(User user : this.users) {
            if(user.getLogin().equals(login)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public Optional<Product> getProductById(int productId) {
        for(Product product : this.products) {
            if(product.getId() == productId) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public List<Order> getOrdersByUserId(int userId) {
        List<Order> result = new ArrayList<>();
        for(Order order : this.orders) {
            if(order.getUser().getId() == userId) {
                result.add(order);
            }
        }
        return result;
    }
}
