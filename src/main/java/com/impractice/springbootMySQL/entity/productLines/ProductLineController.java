package com.impractice.springbootMySQL.entity.productLines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productline")
public class ProductLineController {
    @Autowired
    private ProductLineService productLineService;

    @PostMapping()
    public String createProductLine(@RequestBody ProductLine productLine){
        productLineService.createProductLine(productLine);
        return "ProductLine created successfully";
    }

    @PutMapping()
    public String updateProductLine(@RequestBody ProductLine productLine) {
        productLineService.updateProductLine(productLine);
        return "ProductLine update successfully";
    }

    @DeleteMapping()
    public String deleteProductLine(@PathVariable String productLine) {
        productLineService.deleteProductLine(productLine);
        return "ProductLine deleted successfully";
    }

    @GetMapping()
    public CollectionModel<EntityModel<ProductLine>> getAllProductLine(){
        return productLineService.getAllProductLine();
    }

    @GetMapping("/{productLine}")
    public EntityModel<ProductLine> getProductLine(@PathVariable String productLine){
        return productLineService.getProductLine(productLine);
    }
}
