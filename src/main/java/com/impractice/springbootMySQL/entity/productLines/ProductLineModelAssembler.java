package com.impractice.springbootMySQL.entity.productLines;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductLineModelAssembler implements RepresentationModelAssembler<ProductLine, EntityModel<ProductLine>> {
    @Override
    public EntityModel<ProductLine> toModel(ProductLine productLine) {
        return EntityModel.of(productLine,
                linkTo(methodOn(ProductLineController.class).getProductLine(productLine.getProductLine())).withSelfRel(),
                linkTo(methodOn(ProductLineController.class).getAllProductLine()).withRel("productLine"));
    }
}
