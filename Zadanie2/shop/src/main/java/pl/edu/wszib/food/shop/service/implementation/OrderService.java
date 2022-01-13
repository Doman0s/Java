package pl.edu.wszib.food.shop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.food.shop.database.Database;
import pl.edu.wszib.food.shop.model.Order;
import pl.edu.wszib.food.shop.model.OrderPosition;
import pl.edu.wszib.food.shop.model.Product;
import pl.edu.wszib.food.shop.service.IOrderService;
import pl.edu.wszib.food.shop.session.Session;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Resource
    Session session;

    @Autowired
    Database database;

    @Override
    public List<Order> getLoggedUserOrders() {
        return this.database.getOrdersByUserId(this.session.getUser().getId());
    }

    @Override
    public void confirmOrder() {
        Order order = new Order(this.session.getUser(), this.session.getCart().getOrderPositions());
        this.database.addOrder(order);
        for(OrderPosition orderPosition : order.getOrderPositions()) {
            Optional<Product> product = database.getProductById(orderPosition.getProduct().getId());
            if(product.isPresent()) {
                product.get().setQuantity(product.get().getQuantity() - orderPosition.getQuantity());
            }
        }
        this.session.getCart().clearOrders();
    }
}
