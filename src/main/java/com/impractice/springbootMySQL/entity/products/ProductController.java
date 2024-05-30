package com.impractice.springbootMySQL.entity.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping()
    public String createProduct(@RequestBody Product product){
        productService.createProduct(product);
        return "Product created successfully";
    }

    @PutMapping()
    public String updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return "Product update successfully";
    }

    @DeleteMapping()
    public String deleteProduct(@PathVariable String productCode) {
        productService.deleteProduct(productCode);
        return "Product deleted successfully";
    }

    @GetMapping()
    public CollectionModel<EntityModel<Product>> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/{productCode}")
    public EntityModel<Product> getProduct(@PathVariable String productCode){
        return productService.getProduct(productCode);
    }
}
