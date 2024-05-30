package com.impractice.springbootMySQL.entity.productLines;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface ProductLineService {
    public String createProductLine(ProductLine productLine);
    public String updateProductLine(ProductLine productLine);
    public String deleteProductLine(String productLine);
    public EntityModel<ProductLine> getProductLine(String productLine);
    public CollectionModel<EntityModel<ProductLine>> getAllProductLine();
}
