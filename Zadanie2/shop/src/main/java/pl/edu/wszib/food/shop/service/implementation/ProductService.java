package pl.edu.wszib.food.shop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.food.shop.database.Database;
import pl.edu.wszib.food.shop.model.Product;
import pl.edu.wszib.food.shop.service.IProductService;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    Database database;

    public List<Product> getAllProducts() {
        return this.database.getProducts();
    }
}
