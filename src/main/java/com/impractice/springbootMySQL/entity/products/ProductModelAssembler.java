package com.impractice.springbootMySQL.entity.products;

import com.impractice.springbootMySQL.entity.productLines.ProductLineController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductModelAssembler implements RepresentationModelAssembler<Product, EntityModel<Product>> {
    @Override
    public EntityModel<Product> toModel(Product product) {
        return EntityModel.of(product,
                linkTo(methodOn(ProductController.class).getProduct(product.getProductCode())).withSelfRel(),
                linkTo(methodOn(ProductController.class).getAllProduct()).withRel("product"),
                linkTo(methodOn(ProductLineController.class).getProductLine(product.getProductLine().getProductLine())).withRel("productLine"));
    }
}
