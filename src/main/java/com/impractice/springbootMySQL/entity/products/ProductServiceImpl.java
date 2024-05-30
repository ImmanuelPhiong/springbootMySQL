package com.impractice.springbootMySQL.entity.products;

import com.impractice.springbootMySQL.entity.products.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductModelAssembler productModelAssembler;

    @Override
    public String createProduct(Product product) {
        productRepository.save(product);
        return "Success";
    }

    @Override
    public String updateProduct(Product product) {
        productRepository.save(product);
        return "Success";
    }

    @Override
    public String deleteProduct(String productCode) {
        productRepository.deleteById(productCode);
        return "Success";
    }

    @Override
    public EntityModel<Product> getProduct(String productCode) {
        if(productRepository.findById(productCode).isEmpty()){
            throw new ProductNotFoundException("Product with productCode: " + productCode + " is not exist");
        }
        Product product = productRepository.findById(productCode).get();
        return productModelAssembler.toModel(product);
    }

    @Override
    public CollectionModel<EntityModel<Product>> getAllProduct() {
        List<EntityModel<Product>> products = productRepository.findAll().stream()
                .map(productModelAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(products, linkTo(methodOn(ProductController.class).getAllProduct()).withSelfRel());
    }
}
