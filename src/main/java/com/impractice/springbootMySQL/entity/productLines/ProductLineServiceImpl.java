package com.impractice.springbootMySQL.entity.productLines;

import com.impractice.springbootMySQL.entity.productLines.exception.ProductLineNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ProductLineServiceImpl implements ProductLineService{
    @Autowired
    private ProductLineRepository productLineRepository;
    @Autowired
    private ProductLineModelAssembler productLineModelAssembler;

    @Override
    public String createProductLine(ProductLine productLine) {
        productLineRepository.save(productLine);
        return "Success";
    }

    @Override
    public String updateProductLine(ProductLine productLine) {
        productLineRepository.save(productLine);
        return "Success";
    }

    @Override
    public String deleteProductLine(String productLine) {
        productLineRepository.deleteById(productLine);
        return "Success";
    }

    @Override
    public EntityModel<ProductLine> getProductLine(String productLine) {
        if(productLineRepository.findById(productLine).isEmpty()){
            throw new ProductLineNotFoundException("ProductLine: " + productLine + " is not exist");
        }
        ProductLine productLine1 = productLineRepository.findById(productLine).get();
        return productLineModelAssembler.toModel(productLine1);
    }

    @Override
    public CollectionModel<EntityModel<ProductLine>> getAllProductLine() {
        List<EntityModel<ProductLine>> productLines = productLineRepository.findAll().stream()
                .map(productLineModelAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(productLines, linkTo(methodOn(ProductLineController.class).getAllProductLine()).withSelfRel());
    }
}
