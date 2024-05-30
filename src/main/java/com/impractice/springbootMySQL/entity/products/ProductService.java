package com.impractice.springbootMySQL.entity.products;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface ProductService {
    public String createProduct(Product product);
    public String updateProduct(Product product);
    public String deleteProduct(String productCode);
    public EntityModel<Product> getProduct(String productCode);
    public CollectionModel<EntityModel<Product>> getAllProduct();
}
