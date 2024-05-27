package com.impractice.springbootMySQL.entity.offices;

import com.impractice.springbootMySQL.entity.employees.Employee;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OfficeModelAssembler implements RepresentationModelAssembler<Office, EntityModel<Office>> {

    @Override
    public EntityModel<Office> toModel(Office office) {
        return EntityModel.of(office,
                linkTo(methodOn(OfficeController.class).getOffice(office.getOfficeCode())).withSelfRel(),
                linkTo(methodOn(OfficeController.class).getAllOffice()).withRel("office"));

    }
}
